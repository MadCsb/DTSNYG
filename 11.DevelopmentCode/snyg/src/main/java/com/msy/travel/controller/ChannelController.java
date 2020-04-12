package com.msy.travel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.pojo.Channel;
import com.msy.travel.service.ChannelService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/channel")
public class ChannelController extends BaseController {
	public static final Log log = LogFactory.getLog(ChannelController.class);

	@Resource(name = "channelServiceImpl")
	private ChannelService channelService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddchannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("channel/addChannel");
		return view;
	}

	/**
	 * 新增channel
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addchannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			channel.setIsSys("0");
			channel.setSpId(getLoginUser(request).getAccId());
			channel.setChannelId(PrimaryKeyUtil.generateKey());
			channelService.createchannel(channel);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 跳转到修改页面
	 */
	@RequestMapping(params = "method=toUpdate")
	public ModelAndView toUpdatechannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Channel objchannel = channelService.displaychannel(channel);
			view = new ModelAndView("channel/updateChannel");
			view.addObject("channel", objchannel);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改channel
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updatechannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			channelService.updatechannel(channel);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除channel
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deletechannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			channelService.deletechannel(channel);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping(params = "method=deleteBatch")
	public ModelAndView deleteBatchchannel(Channel channel, String checkedchannelIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] channelIds = checkedchannelIds.split(",");
		List<String> channelIdList = new ArrayList<String>();
		Collections.addAll(channelIdList, channelIds);
		try {
			channel.setChannelIdList(channelIdList);
			channelService.deleteBatchchannel(channel);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping(params = "method=query")
	public ModelAndView querychannelList(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (channel.getEntityPage() == null) {
				channel.setEntityPage(new EntityPage());
			}
			channel.setSpId(getLoginUser(request).getAccId());
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(channel.getEntityPage()), super.getPageSize(channel.getEntityPage()));
			List<Channel> channellist = channelService.querychannelList(channel);
			PageInfo<Channel> pageInfo = new PageInfo<Channel>(channellist);

			view = new ModelAndView("channel/queryChannel");
			view.addObject("channellist", channellist);
			view.addObject("entityPage", channel.getEntityPage());
			view.addObject("pageInfo", pageInfo);
			view.addObject("channel", channel);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 导出excel
	 */
	@RequestMapping(params = "method=export")
	public void exportchannel(Channel channel, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "channel-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (channel.getEntityPage() == null) {
				channel.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(channel.getEntityPage()), super.getPageSize(channel.getEntityPage()));
			List<Channel> exportlist = channelService.querychannelList(channel);

			PoiWriteExcel<Channel> pwe = new PoiWriteExcel<Channel>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(channel.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 验证key
	 * 
	 * @author wzd
	 * @date 2020年3月31日 上午11:14:36
	 * @param channel
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=checkChannelKey")
	public void checkChannelKey(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			channel.setSpId(getLoginUser(request).getAccId());
			int checkCount = channelService.checkChannelKeyExis(channel);

			if (checkCount > 0) {
				result.setResultCode("1");
				result.setResultMsg("该渠道标识已经存在");
			} else {
				result.setResultCode("0");
			}

		} catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("程序出错，请稍后再试");
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.toJSON(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	/**
	 * 更改渠道状态
	 * 
	 * @author wzd
	 * @date 2020年3月31日 上午11:20:42
	 * @param channel
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(params = "method=updateChannelStatus")
	public void updateSaleTypeStatus(Channel channel, HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			String status = channel.getStatus();
			channel = channelService.displaychannel(channel);
			channel.setStatus(status);

			channelService.updatechannel(channel);

			result.setResultCode("0");
			result.setResultMsg("操作成功");

		} catch (Exception e) {
			result.setResultCode("1");
			result.setResultMsg("程序出错，请稍后再试");
			log.error(e, e);
		}
		try {
			response.getWriter().print(JSONObject.toJSON(result).toString());
		} catch (Exception e) {
			log.error(e, e);
		}
	}

}
