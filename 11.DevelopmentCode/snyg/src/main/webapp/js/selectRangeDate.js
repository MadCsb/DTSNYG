/**
 * 下拉选择时间插件
 * 
 * @param selectId：下拉框ID
 *            startDateId：开始日期input框ID endDateId：结束日期input框ID
 * @param startDateId
 * @param endDateId
 * @return
 */
function SelectRangeDate(selectId, startDateId, endDateId) {

	var selectObj = $("#" + selectId);
	//$(selectObj).append("<option value=\"-1\">----请选择----</option>");
	$(selectObj).append("<option value=\"0\">今天</option>");
	$(selectObj).append("<option value=\"1\">昨天</option>");
	$(selectObj).append("<option value=\"2\">最近7天</option>");
	$(selectObj).append("<option value=\"3\">本周</option>");
	$(selectObj).append("<option value=\"4\">上周</option>");
	$(selectObj).append("<option value=\"5\">最近30天</option>");
	$(selectObj).append("<option value=\"6\">本月</option>");
	$(selectObj).append("<option value=\"7\">上月</option>");
	//$(selectObj).append("<option value=\"8\">本年</option>");
	//$(selectObj).append("<option value=\"9\">最近12个月</option>");

	$("#" + selectId).bind('change', function() {
		changeRangeDate(selectId, startDateId, endDateId);
	})
}

/**
 * 需要回调select值时使用
 * @param selectId
 * @param startDateId
 * @param endDateId
 * @param selectedValue   设置需要回调的值
 */
function SelectRangeDateCallBack(selectId, startDateId, endDateId,selectedValue){
	
	SelectRangeDate(selectId, startDateId, endDateId);
	$("#" + selectId).find("option[value='"+selectedValue+"']").attr("selected",true);
}


function getDateStr(Date) {

	dateStr = Date.getFullYear() + "-";
	if ((Date.getMonth() + 1) > 0 && (Date.getMonth() + 1) < 10) {
		dateStr += "0" + (Date.getMonth() + 1);
	} else {
		dateStr += (Date.getMonth() + 1);
	}
	dateStr += "-";
	if (Date.getDate() > 0 && Date.getDate() < 10) {
		dateStr += "0" + Date.getDate();
	} else {
		dateStr += Date.getDate();
	}
	return dateStr;
}

function changeRangeDate(selectId, startDate, endDate) {

	var selectVal = $("#" + selectId).val();
	var currentDate = new Date();
	var sDateStr;
	var eDateStr;
	if (selectVal == 0) { // 今天
		sDateStr = getDateStr(new Date());
		eDateStr = getDateStr(new Date());

	} else if (selectVal == 1) { // 昨天
		currentDate.setDate(currentDate.getDate() - 1);
		sDateStr = getDateStr(currentDate);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 2) { // 最近7天
		currentDate.setDate(currentDate.getDate() - 7);
		sDateStr = getDateStr(currentDate);
		eDateStr = getDateStr(new Date());

	} else if (selectVal == 3) { // 本周

		currentDate.setDate(currentDate.getDate() - currentDate.getDay() + 1);
		sDateStr = getDateStr(currentDate);
		currentDate.setDate(currentDate.getDate() + 6);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 4) { // 上周
		currentDate.setDate(currentDate.getDate() - currentDate.getDay() + 1
				- 7);
		sDateStr = getDateStr(currentDate);
		currentDate.setDate(currentDate.getDate() + 6);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 5) { // 最近30天
		currentDate.setDate(currentDate.getDate() - 30);
		sDateStr = getDateStr(currentDate);
		eDateStr = getDateStr(new Date());

	} else if (selectVal == 6) { // 本月
		currentDate.setDate(1);
		sDateStr = getDateStr(currentDate);

		currentDate.setMonth(currentDate.getMonth() + 1);
		currentDate.setDate(currentDate.getDate() - 1);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 7) { // 上月

		currentDate.setMonth(currentDate.getMonth() - 1);
		currentDate.setDate(1);
		sDateStr = getDateStr(currentDate);

		currentDate.setMonth(currentDate.getMonth() + 1);
		currentDate.setDate(currentDate.getDate() - 1);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 8) { // 本年

		currentDate.setMonth(0);
		currentDate.setDate(1);
		sDateStr = getDateStr(currentDate);

		currentDate.setFullYear(currentDate.getFullYear() + 1);
		currentDate.setDate(currentDate.getDate() - 1);
		eDateStr = getDateStr(currentDate);

	} else if (selectVal == 9) { // 最近12个月
		currentDate.setMonth(currentDate.getMonth() - 12);
		sDateStr = getDateStr(currentDate);
		eDateStr = getDateStr(new Date());

	} else if (selectVal == -1) {

		sDateStr = "";
		eDateStr = "";
		
	} else{
		
		sDateStr = "";
		eDateStr = "";
	}

	$("#" + startDate).val(sDateStr);
	$("#" + endDate).val(eDateStr);
	
	
	if( typeof customChange === 'function' ){
		customChange();
	}
}