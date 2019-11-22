/* 本js已加入INC_HEAD.html
 * 通用数据查询,限制显示数目50条
 * 根据单位类型弹出展示对应的单位名称列表（输入0，展示所有旅行社的列表），支持名称模糊查询，
        选择一条数据确定后自动将ID、名称回写到输入框。
 * 输入参数：this  button
      unitType 单位类型：
                旅行社：0    旅游局支撑商：1    所有景区（F_UNITTYPE=0）：2    保险公司：3      车队：4
                餐馆：5      旅游购物：6        文化演艺（F_UNITTYPE=1）：7    
                景区行程点（F_UNITTYPE=0 && F_TRIPTYPE=0）：8    
                景区（F_UNITTYPE=0 && F_TRIPTYPE=1）：9    
                景区公司（F_UNITTYPE=0 && F_TRIPTYPE=2）：10
  
 * 应用示例：必须是两个input排列，在第二个input添加点击事件onclick="toSelectCompany(this,2)"
<input id="test" type="text"><input type="button" onclick="toSelectCompany(this,2)" value="选择">
 * 输出结果：单位名称存放在第一个input的value属性，单位ID存放在第一个input的unitId属性 
 * 取值方法：var unitName = $("#test").val(); var unitId = $("#test").attr("unitId");
*/
function toSelectCompany(obj,unitType){
		art.dialog.data("unitType", unitType);
		art.dialog.open("common.do?method=queryCompanyInfoList&unitType=" + unitType, {
			lock: true,
			resize: false,
			drag: false,
			width: 500,
			height: 500,
			close: function() {
				var unitId = art.dialog.data("unitId");
				var unitName = art.dialog.data("unitName");
				var isFromMakeSure = art.dialog.data('isFromMakeSure');
				if (isFromMakeSure == "yes"){
					$(obj).prev().val(unitName);
					$(obj).prev().attr("unitId", unitId);
				}
			}
		});
	}