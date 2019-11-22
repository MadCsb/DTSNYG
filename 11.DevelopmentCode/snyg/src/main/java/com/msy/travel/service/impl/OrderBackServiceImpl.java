package com.msy.travel.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msy.travel.common.Consts;
import com.msy.travel.common.DateTimeUtil;
import com.msy.travel.common.FileUtil;
import com.msy.travel.common.HttpClientTool;
import com.msy.travel.common.LogicException;
import com.msy.travel.common.PrimaryKeyUtil;
import com.msy.travel.common.Result;
import com.msy.travel.common.SysConsts;
import com.msy.travel.common.config.ConfigParameter;
import com.msy.travel.common.wx.WeixinUtil;
import com.msy.travel.pojo.Destsp;
import com.msy.travel.pojo.Order;
import com.msy.travel.pojo.OrderList;
import com.msy.travel.pojo.OrderLog;
import com.msy.travel.pojo.RsPic;
import com.msy.travel.pojo.ServiceCode;
import com.msy.travel.pojo.User;
import com.msy.travel.service.IRsPicService;
import com.msy.travel.service.IServiceCodeService;
import com.msy.travel.service.OrderListService;
import com.msy.travel.service.OrderLogService;
import com.msy.travel.service.OrderService;
import com.msy.travel.wx.controller.WxOrderController;
import com.msy.travel.wx.pojo.AccessToken;
import com.msy.travel.wx.utils.WeixinService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msy.travel.pojo.OrderBack;
import com.msy.travel.dao.OrderBackDao;
import com.msy.travel.service.OrderBackService;

/**
 * OrderBackService接口实现类
 * 
 * @author wootide
 * 
 */
@Service
@Transactional
public class OrderBackServiceImpl implements OrderBackService
{

    public static final Log log = LogFactory.getLog(OrderBackServiceImpl.class);

	@Resource(name="orderBackDao")
    private OrderBackDao orderBackDao;

    @Resource(name = "orderServiceImpl")
    private OrderService orderService;

    @Resource(name = "orderListServiceImpl")
    private OrderListService orderListService;

    @Resource(name = "orderLogServiceImpl")
    private OrderLogService orderLogService;

    @Resource(name = "rsPicServiceImpl")
    private IRsPicService rsPicService;

    @Resource(name = "serviceCodeServiceImpl")
    private IServiceCodeService serviceCodeService;

    @Resource(name = "configParameter")
    private ConfigParameter configParameter;

    /**
     * 退订订单剩余所有
     * param 参数
     *         orderId 订单ID
     *         wxImgServiceIds 微信上传的图片Ids
     *         backReason 退订原因
     *         backReasonType 退订原因类型
     * opUser 操作人
     */
    public void orderAllBack(Map<String,String> param,User opUser) throws Exception
    {
        Order order = new Order();
        order.setOrderId(param.get("orderId"));
        order = orderService.displayOrder(order);

        OrderList orderList = new OrderList();
        orderList.setOrderId(order.getOrderId());
        orderList.setDelFlag("0");
        orderList.setOrderListType("0"); //下单
        List<OrderList> orderListList = orderListService.queryOrderListList(orderList);
        orderList.setOrderListType("2"); //赠送
        orderListList.addAll(orderListService.queryOrderListList(orderList));

        JSONArray backDataJSONArray = new JSONArray();
        for (int i=0;i<orderListList.size();i++)
        {
            JSONObject backDataJSONObject = new JSONObject();
            backDataJSONObject.put("orderListId",orderListList.get(i).getOrderListId());
            int num = Integer.valueOf(orderListList.get(i).getNum());
            if(orderListList.get(i).getBackNum() != null && !orderListList.get(i).getBackNum().trim().equals(""))
            {
                int backNum = Integer.valueOf(orderListList.get(i).getBackNum()); //已经退订的数量
                num = num - backNum;
            }
            backDataJSONObject.put("backNum",String.valueOf(num));
            backDataJSONArray.add(backDataJSONObject);
        }
        OrderBack orderBack = new OrderBack();
        orderBack.setBackId(PrimaryKeyUtil.generateKey());
        orderBack.setBackCode(PrimaryKeyUtil.getOnlyOrderBackCode());
        orderBack.setStatus("1"); //申请退订
        orderBack.setOrderId(order.getOrderId());
        orderBack.setBackData(backDataJSONArray.toJSONString());

        orderBack.setBackReasonType(param.get("backReasonType"));
        orderBack.setBackReason(param.get("backReason"));

        orderBack.setApplyTime(DateTimeUtil.getDateTime19());
        orderBack.setApplyUID(opUser.getUserId());
        orderBack.setApplyUName(opUser.getUserName());
        //0-未确认 1-已发货2-已收货3-已取消（商户拒绝）4-发货失败5-订单关闭（定时、后台）
        if (order.getStatus().equals("3")) //订单商户拒绝
        {
            orderBack.setIsBackGoods("0"); //退货
            orderBack.setIsBackMoney("1"); //退款
        }else if(order.getStatus().equals("4")) //商户发货失败
        {
            orderBack.setIsBackGoods("0"); //退货
            orderBack.setIsBackMoney("1"); //退款
        }else if(order.getStatus().equals("2")) //用户已收货
        {
            orderBack.setIsBackGoods("1"); //退货
            orderBack.setIsBackMoney("1"); //退款
        }else
        {
            throw new LogicException("该订单状态不支持退订");
        }
        orderBack.setApplyBackMoney(order.getPayMoney());
        orderBack.setSpId(Destsp.currentSpId);
        orderBackDao.insertOrderBack(orderBack);

        OrderLog orderLog = new OrderLog();
        orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
        orderLog.setLinkId(orderBack.getBackId());
        orderLog.setOpTime(orderBack.getApplyTime());
        if(opUser == null)
        {
            orderLog.setOper("平台机器人");
        }else
        {
            orderLog.setOper(opUser.getUserName());
        }

        orderLog.setOpContent("退订申请");
        orderLog.setType("2");
        orderLog.setResult("1");
        orderLogService.createOrderLog(orderLog);

        if(param.containsKey("wxImgServiceIds"))
        {
            String wxImgServiceIds = param.get("wxImgServiceIds");
            if(wxImgServiceIds != null && !wxImgServiceIds.equals(""))
            {
                //保存微信图片
                ServiceCode serviceCode = serviceCodeService.getServiceCodeBySpId(Destsp.currentSpId);
                String dictory = configParameter.getUploadPicUrl()+"orderBack"+File.separator;

                File dictoryFile = new File(dictory);
                if (!dictoryFile.isDirectory()) {
                    dictoryFile.mkdirs();
                }

                AccessToken accessToken = com.msy.travel.wx.utils.WeixinUtil.getAccessToken(serviceCode.getAppId(), serviceCode.getAppSecret());

                RsPic rsPic = new RsPic();
                String[] serviceIds = wxImgServiceIds.split(",");
                for (int i=0;i<serviceIds.length;i++)
                {
                    String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
                    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken.getToken()).replace("MEDIA_ID", serviceIds[i]);
                    URL url = new URL(requestUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(30000);
                    conn.setReadTimeout(30000);
                    String extFileName = FileUtil.getFileexpandedName(conn.getHeaderField("Content-Type"));
                    String fileName = PrimaryKeyUtil.generateKey() + extFileName;
                    BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                    FileOutputStream fos = new FileOutputStream(new File(dictory, fileName));
                    byte[] buff = new byte[1024 * 128];
                    int rc = 0;
                    while ((rc = bis.read(buff, 0, 1024 * 128)) > 0) {
                        fos.write(buff, 0, rc);
                    }
                    fos.close();
                    bis.close();
                    conn.disconnect();

                    rsPic.setPicId(PrimaryKeyUtil.generateKey());
                    rsPic.setRsId(orderBack.getBackId());
                    rsPic.setPicTitle("退订");
                    rsPic.setPicFileName(fileName);
                    rsPic.setPicOrder(i+"");
                    rsPic.setRsType(SysConsts.RSTYPE_ORDERBACKPIC);
                    rsPicService.createRsPic(rsPic);
                }
            }
        }
    }

    /**
     * 查询单个OrderBack
     * 
     * @param orderBack OrderBack对象
     * 
     * @return 成员实体对象
     */
    public OrderBack displayOrderBack(OrderBack orderBack) throws Exception
    {
        return orderBackDao.queryOrderBack(orderBack);
    }

    /**
     * 查询OrderBack列表
     * 
     * @param orderBack OrderBack对象
     * 
     * @return OrderBack列表
     */
    public List<OrderBack> queryOrderBackList(OrderBack orderBack) throws Exception
    {
        return orderBackDao.queryOrderBackList(orderBack);
    }

    /**
     * 查询OrderBack统计信息
     *
     * @param orderBack OrderBack对象
     *
     * @return OrderBack列表
     */
    public OrderBack queryOrderBackListStatic(OrderBack orderBack) throws Exception
    {
        return orderBackDao.queryOrderBackListStatic(orderBack);
    }

    /**
     * 修改退订status
     * @param backId 退订ID
     * @param status 计划修改退订单的状态
     * @param opUser 操作人
     */
    public Result changeOrderBackStatus(String backId, String status, User opUser) throws Exception {
        Result result = new Result();
        result.setResultCode("0");
        result.setResultMsg("操作成功");
        OrderBack orderBack = new OrderBack();
        orderBack.setBackId(backId);
        orderBack = orderBackDao.queryOrderBack(orderBack);
        if (orderBack.getStatus().equals(status)) {
            return result;
        }
        //"status:退订状态：1-申请退订2-受理3-不受理4-退货5-退款6-关闭"
        //isBackGoods是否退货 1是，0否"
        //backGoodsStatus 退货状态 0待发货，1已发货，2已收货
        //isBackMoney 是否退款 1是，0否
        //backMoneyStatus 退款状态 0待退款，1已退款
        if ("2".equals(status)) //受理
        {
            //如果退订申请不是（1申请）
            if (!"1".equals(orderBack.getStatus())) {
                result.setResultCode("1");
                result.setResultMsg("退订单不是申请状态，无法设置2");
            }
        } else if ("3".equals(status)) //不受理
        {
            //如果退订申请不是，（1申请）
            if (!"1".equals(orderBack.getStatus())) {
                result.setResultCode("1");
                result.setResultMsg("退订单不是申请状态，无法设置3");
            }
        } else if ("4".equals(status)) //退货
        {
            //如果退订申请不是（2受理）
            if (!"2".equals(orderBack.getStatus())) {
                result.setResultCode("1");
                result.setResultMsg("退订单不是已受理状态，无法设置4");
            }
            if ("0".equals(orderBack.getIsBackGoods())) {
                result.setResultCode("1");
                result.setResultMsg("退订单无需退货，无法设置4");
            }
        } else if ("5".equals(status)) //退款
        {
            //不是（已受理，不需要退货 || 退货中，已收货 ）则不能设置退款中
            if (!("2".equals(orderBack.getStatus()) && "0".equals(orderBack.getIsBackGoods()))
                && !("4".equals(orderBack.getStatus()) && "2"
                .equals(orderBack.getBackGoodsStatus())))
                //如果退订申请不是（2受理）
                if (!"2".equals(orderBack.getStatus())) {
                    result.setResultCode("1");
                    result.setResultMsg("退订单不是【已受理不需要退货】或【退货中已收货】，无法设置5");
                }
        } else if ("6".equals(status)) //关闭
        {
            //不是（退款中，已退款 ）则不能设置关闭
            if (!"5".equals(orderBack.getStatus()) || !"1".equals(orderBack.getBackMoneyStatus())) {
                result.setResultCode("1");
                result.setResultMsg("退订单不是【退款中已退款】，无法设置6");
            }
        }

        if ("0".equals(result.getResultCode()))
        {
            OrderLog orderLog = new OrderLog();
            orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
            orderLog.setLinkId(orderBack.getBackId());
            orderLog.setOpTime(DateTimeUtil.getDateTime19());

            orderBack.setStatus(status);
            if(opUser == null)
            {
                orderLog.setOper("平台机器人");
            }else
            {
                orderLog.setOper(opUser.getUserName());
            }

            if ("2".equals(status)) //受理
            {
                orderLog.setOpContent("退订已受理");
            } else if ("3".equals(status)) //不受理
            {
                orderLog.setOpContent("退订已拒绝");
            } else if ("4".equals(status)) //退货
            {
                orderLog.setOpContent("退订退货开始");
                orderBack.setBackGoodsStatus("0"); //待发货
            } else if ("5".equals(status)) //退款
            {
                orderLog.setOpContent("退订退款开始");
                orderBack.setBackMoneyStatus("0"); //待退款
            } else if ("6".equals(status)) //关闭
            {
                orderLog.setOpContent("退订已关闭");
            }

            orderLog.setType("2");
            orderLog.setResult("1");
            orderLogService.createOrderLog(orderLog);

            orderBackDao.updateOrderBack(orderBack);

            if("6".equals(status)) //关闭,需要更新订单
            {
                Map<String,String> orderParam = new HashMap<>();
                orderParam.put("backId",orderBack.getBackId());
                result = orderService.orderBackSuccess(orderParam,opUser);
            }
        }
        return result;
    }

    /**
     * 拒绝退订申请
     * @param param
     *          backId 退订记录ID
     *          refuseReason 不受理原因
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result refuseOrderBack(Map<String,String> param,User opUser) throws Exception
    {
        Result result = changeOrderBackStatus(param.get("backId"),"3",opUser);
        if("0".equals(result.getResultCode()))
        {
            OrderBack orderBack = new OrderBack();
            orderBack.setBackId(param.get("backId"));
            orderBack.setRefuseReason(param.get("refuseReason"));
            orderBack.setOpTime(DateTimeUtil.getDateTime19());
            orderBack.setOpUID(opUser.getUserId());
            orderBack.setOpUName(opUser.getUserName());
            orderBackDao.updateOrderBack(orderBack);
        }
        return result;
    }

    /**
     * 受理退订申请
     * @param param
     *          backId 退订记录ID
     *          backGoodsName 退货快递接收人
     *          backGoodsPhone 退货快递接收人电话
     *          backGoodsAddr 退货快递接收地址
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result agressOrderBack(Map<String,String> param,User opUser) throws Exception
    {
        //受理
        Result result = changeOrderBackStatus(param.get("backId"),"2",opUser);
        if("0".equals(result.getResultCode()))
        {
            OrderBack orderBackDb = new OrderBack();
            orderBackDb.setBackId(param.get("backId"));
            orderBackDb = orderBackDao.queryOrderBack(orderBackDb);

            OrderBack orderBack = new OrderBack();
            orderBack.setBackId(param.get("backId"));
            orderBack.setOpTime(DateTimeUtil.getDateTime19());
            orderBack.setOpUID(opUser.getUserId());
            orderBack.setOpUName(opUser.getUserName());
            if("1".equals(orderBackDb.getIsBackGoods()))
            {
                //开始退货
                result = changeOrderBackStatus(param.get("backId"),"4",opUser);
                orderBack.setBackGoodsStatus("0");
                orderBack.setBackGoodsName(param.get("backGoodsName")); //退货快递接收人
                orderBack.setBackGoodsPhone(param.get("backGoodsPhone")); //退货快递接收人电话
                orderBack.setBackGoodsAddr(param.get("backGoodsAddr")); //退货快递接收地址

            }else if("1".equals(orderBackDb.getIsBackMoney()))
            {
                //开始退款
                result = changeOrderBackStatus(param.get("backId"),"5",opUser);
            }else
            {
                //开始关闭
                result = changeOrderBackStatus(param.get("backId"),"6",opUser);
            }

            if ("0".equals(result.getResultCode()))
            {
                orderBackDao.updateOrderBack(orderBack);
            }
        }
        return result;
    }

    /**
     * 发送退货
     * @param param
     *          backId
     *          backGoodsEpmeCompany
     *          backGoodsEpmeOrdCode
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result sendGoods(Map<String,String> param,User opUser) throws Exception
    {
        Result result = new Result();
        OrderBack orderBackDb = new OrderBack();
        orderBackDb.setBackId(param.get("backId"));
        orderBackDb = orderBackDao.queryOrderBack(orderBackDb);
        if(!"0".equals(orderBackDb.getBackGoodsStatus()) )
        {
            result.setResultCode("1");
            result.setResultMsg("当前退单不能发货");
            return result;
        }
        //退货成功
        OrderBack orderBack = new OrderBack();
        orderBack.setBackId(orderBackDb.getBackId());
        orderBack.setBackGoodsStatus("1");
        orderBack.setBackGoodsEpmeCompany(param.get("backGoodsEpmeCompany"));
        orderBack.setBackGoodsEpmeOrdCode(param.get("backGoodsEpmeOrdCode"));
        orderBackDao.updateOrderBack(orderBack);

        OrderLog orderLog = new OrderLog();
        orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
        orderLog.setLinkId(orderBackDb.getBackId());
        if(opUser == null)
        {
            orderLog.setOper("平台机器人");
        }else
        {
            orderLog.setOper(opUser.getUserName());
        }
        orderLog.setOpTime(DateTimeUtil.getDateTime19());
        orderLog.setOpContent("退货已发货");
        orderLog.setType("2");
        orderLog.setResult("1");
        orderLogService.createOrderLog(orderLog);
        return result;
    }

    /**
     * 接收退货
     * @param param
     *          backId 退单ID
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result receiveGoods(Map<String,String> param,User opUser) throws Exception
    {
        Result result = new Result();
        OrderBack orderBackDb = new OrderBack();
        orderBackDb.setBackId(param.get("backId"));
        orderBackDb = orderBackDao.queryOrderBack(orderBackDb);
        if(!"4".equals(orderBackDb.getStatus()) || !"1".equals(orderBackDb.getBackGoodsStatus()))
        {
            result.setResultCode("1");
            result.setResultMsg("当前退单不能退货");
            return result;
        }
        //退货成功
        OrderBack orderBack = new OrderBack();
        orderBack.setBackId(orderBackDb.getBackId());
        orderBack.setBackGoodsStatus("2");
        orderBack.setBackGoodsReceiveTime(DateTimeUtil.getDateTime19());
        orderBackDao.updateOrderBack(orderBack);

        OrderLog orderLog = new OrderLog();
        orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
        orderLog.setLinkId(orderBackDb.getBackId());
        if(opUser == null)
        {
            orderLog.setOper("平台机器人");
        }else
        {
            orderLog.setOper(opUser.getUserName());
        }
        orderLog.setOpTime(orderBack.getBackGoodsReceiveTime());
        orderLog.setOpContent("收到退货");
        orderLog.setType("2");
        orderLog.setResult("1");
        orderLogService.createOrderLog(orderLog);

        //如果需要退钱
        if ("1".equals(orderBackDb.getIsBackMoney()))
        {
            result = changeOrderBackStatus(orderBackDb.getBackId(),"5",opUser);
        }else //如果不需要退钱则关闭
        {
            result = changeOrderBackStatus(orderBackDb.getBackId(),"6",opUser);
        }
        return result;
    }

    /**
     * 接收退款
     * @param param
     * @param opUser 操作人
     * @return Result
     * @throws Exception
     */
    public Result receiveMoney(Map<String,String> param,User opUser) throws Exception
    {
        Result result = new Result();
        OrderBack orderBackDb = new OrderBack();
        orderBackDb.setBackId(param.get("backId"));
        orderBackDb = orderBackDao.queryOrderBack(orderBackDb);
        if(!"5".equals(orderBackDb.getStatus()) || !"0".equals(orderBackDb.getBackMoneyStatus()))
        {
            result.setResultCode("1");
            result.setResultMsg("当前退单不能退款");
            return result;
        }
        //退款成功
        OrderBack orderBack = new OrderBack();
        orderBack.setBackId(orderBackDb.getBackId());
        orderBack.setBackMoneyStatus("1");
        orderBack.setBackMoneyReceiveTime(DateTimeUtil.getDateTime19());
        orderBack.setBackMoney(param.get("backMoney"));
        orderBackDao.updateOrderBack(orderBack);

        OrderLog orderLog = new OrderLog();
        orderLog.setOrderLogId(PrimaryKeyUtil.generateKey());
        orderLog.setLinkId(orderBackDb.getBackId());
        if(opUser == null)
        {
            orderLog.setOper("平台机器人");
        }else
        {
            orderLog.setOper(opUser.getUserName());
        }
        orderLog.setOpTime(DateTimeUtil.getDateTime19());
        orderLog.setOpContent("收到退款");
        orderLog.setType("2");
        orderLog.setResult("1");
        orderLogService.createOrderLog(orderLog);

        //退款完成自动关闭
        result = changeOrderBackStatus(orderBackDb.getBackId(),"6",opUser);
        if("1".equals(result.getResultCode()))
        {
            throw new LogicException(result.getResultMsg());
        }
        return result;
    }
}
