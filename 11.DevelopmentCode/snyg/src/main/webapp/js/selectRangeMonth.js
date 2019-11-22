/**
 * 下拉选择时间插件
 * 
 * @param selectId：下拉框ID
 *            startDateId：开始日期input框ID endDateId：结束日期input框ID
 * @param startDateId
 * @param endDateId
 * @return
 */
function SelectRangeMonth(selectId, startDateId, endDateId) {

	var selectObj = $("#" + selectId);
	$(selectObj).append("<option value=\"-1\">----请选择----</option>");
	$(selectObj).append("<option value=\"0\">本月</option>");
	$(selectObj).append("<option value=\"1\">上月</option>");
	$(selectObj).append("<option value=\"2\">最近6个月</option>");
	$(selectObj).append("<option value=\"3\">本年</option>");
	$(selectObj).append("<option value=\"4\">最近12个月</option>");

	$("#" + selectId).bind('change', function() {
		changeRangeMonth(selectId, startDateId, endDateId);
	})
}

/**
 * 需要回调select值时使用
 * @param selectId
 * @param startDateId
 * @param endDateId
 * @param selectedValue   设置需要回调的值
 */
function SelectRangeMonthCallBack(selectId, startDateId, endDateId,selectedValue){
	
	SelectRangeMonth(selectId, startDateId, endDateId);
	$("#" + selectId).find("option[value='"+selectedValue+"']").attr("selected",true);
}


function getMonthStr(Date) {

	dateStr = Date.getFullYear() + "-";
	if ((Date.getMonth() + 1) > 0 && (Date.getMonth() + 1) < 10) {
		dateStr += "0" + (Date.getMonth() + 1);
	} else {
		dateStr += (Date.getMonth() + 1);
	}
	return dateStr;
}

function changeRangeMonth(selectId, startDate, endDate) {

	var selectVal = $("#" + selectId).val();
	var currentDate = new Date();
	var sDateStr;
	var eDateStr;
	if (selectVal == 0) { // 本月
		sDateStr = getMonthStr(new Date());
		eDateStr = getMonthStr(new Date());

	} else if (selectVal == 1) { // 上月
		currentDate.setMonth(currentDate.getMonth()-1);
		sDateStr = getMonthStr(currentDate);
		eDateStr = getMonthStr(currentDate);

	} else if (selectVal == 2) { // 最近6个月
		currentDate.setMonth(currentDate.getMonth() - 6);
		sDateStr = getMonthStr(currentDate);
		eDateStr = getMonthStr(new Date());

	} else if (selectVal == 3) { // 本年

		currentDate.setMonth(0, 1);
		sDateStr = getMonthStr(currentDate);
		eDateStr = getMonthStr(new Date());

	} else if (selectVal == 4) { // 最近12个月
		currentDate.setMonth(currentDate.getMonth() -12);
		sDateStr = getMonthStr(currentDate);
		eDateStr = getMonthStr(new Date());

	} else if (selectVal == -1) {

		sDateStr = "";
		eDateStr = "";
	}

	$("#" + startDate).val(sDateStr);
	$("#" + endDate).val(eDateStr);
}