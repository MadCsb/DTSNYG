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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.travel.common.BaseController;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.EntityPage;
import com.msy.travel.common.PoiWriteExcel;
import com.msy.travel.pojo.Subject;
import com.msy.travel.service.SubjectService;

@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/subject")
public class SubjectController extends BaseController {
	public static final Log log = LogFactory.getLog(SubjectController.class);

	@Resource(name = "subjectServiceImpl")
	private SubjectService subjectService;

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(params = "method=toAdd")
	public ModelAndView toAddSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		view = new ModelAndView("subject/addSubject");
		return view;
	}

	/**
	 * 新增Subject
	 */
	@RequestMapping(params = "method=add")
	public ModelAndView addSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			subjectService.createSubject(subject);
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
	public ModelAndView toUpdateSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			Subject objSubject = subjectService.displaySubject(subject);
			view = new ModelAndView("subject/updateSubject");
			view.addObject("subject", objSubject);

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 修改Subject
	 */
	@RequestMapping(params = "method=update")
	public ModelAndView updateSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			subjectService.updateSubject(subject);
			view = new ModelAndView("success");

		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("e", getExceptionInfo(e));
			log.error(e, e);
		}
		return view;
	}

	/**
	 * 删除Subject
	 */
	@RequestMapping(params = "method=delete")
	public ModelAndView deleteSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			subjectService.deleteSubject(subject);
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
	public ModelAndView deleteBatchSubject(Subject subject, String checkedSubjectIds, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String[] subjectIds = checkedSubjectIds.split(",");
		List<String> subjectIdList = new ArrayList<String>();
		Collections.addAll(subjectIdList, subjectIds);
		try {
			subject.setSubjectIdList(subjectIdList);
			subjectService.deleteBatchSubject(subject);
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
	public ModelAndView querySubjectList(Subject subject, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		try {
			if (subject.getEntityPage() == null) {
				subject.setEntityPage(new EntityPage());
			}
			super.saveBackUrl(request);
			// 设置分页
			PageHelper.startPage(super.getPageNum(subject.getEntityPage()), super.getPageSize(subject.getEntityPage()));
			List<Subject> subjectlist = subjectService.querySubjectList(subject);
			PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjectlist);

			view = new ModelAndView("subject/querySubject");
			view.addObject("subjectlist", subjectlist);
			view.addObject("entityPage", subject.getEntityPage());
			view.addObject("pageInfo", pageInfo);
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
	public void exportSubject(Subject subject, HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = request.getSession().getServletContext().getRealPath("");
			File fileFolder = new File(path);
			if (!fileFolder.isDirectory()) {
				fileFolder.mkdir();
			}
			String tempName = "Subject-" + DateTimeUtil.getDateTime14() + ".xls";
			path = path + File.separator + tempName;

			if (subject.getEntityPage() == null) {
				subject.setEntityPage(new EntityPage());
			}
			// 设置分页
			PageHelper.startPage(super.getPageNum(subject.getEntityPage()), super.getPageSize(subject.getEntityPage()));
			List<Subject> exportlist = subjectService.querySubjectList(subject);

			PoiWriteExcel<Subject> pwe = new PoiWriteExcel<Subject>();

			// 设置标题
			pwe.setFileTitle("");
			// 设置生成文件路径
			pwe.setExportFileName(path);

			pwe.setHeaders(subject.EXPORT_HEADERS);

			pwe.setDataset(exportlist);

			if (pwe.export()) {
				downloadFile(request, response, path, tempName);
			}

		} catch (Exception e) {
			log.error(e, e);
		}
	}

}
