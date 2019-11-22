( function($) {
	$.fn.validationEngineLanguage = function() {
	};
	$.validationEngineLanguage = {
		newLang : function() {
			$.validationEngineLanguage.allRules = {
				"required" : { // Add your regex rules here, you can take
					// telephone as an example
					"regex" : "none",
					"alertText" : "* 此处不可空白",
					"alertTextCheckboxMultiple" : "* 请选择一个项目",
					"alertTextCheckboxe" : "* 您必须钩选此栏",
					"alertTextDateRange" : "* 日期范围不可空白"
				},
				"dateRange" : {
					"regex" : "none",
					"alertText" : "* 无效的 ",
					"alertText2" : " 日期范围"
				},
				"dateTimeRange" : {
					"regex" : "none",
					"alertText" : "* 无效的 ",
					"alertText2" : " 时间范围"
				},
				"minSize" : {
					"regex" : "none",
					"alertText" : "* 最少 ",
					"alertText2" : " 位字符(汉字算两位)"
				},
				"maxSize" : {
					"regex" : "none",
					"alertText" : "* 最多 ",
					"alertText2" : " 位字符(汉字算两位)"
				},
				"groupRequired" : {
					"regex" : "none",
					"alertText" : "* 你必需选填其中一个栏位"
				},
				"min" : {
					"regex" : "none",
					"alertText" : "* 最小值為 "
				},
				"max" : {
					"regex" : "none",
					"alertText" : "* 最大值为 "
				},
				"past" : {
					"regex" : "none",
					"alertText" : "* 日期必需早于 "
				},
				"future" : {
					"regex" : "none",
					"alertText" : "* 日期必需晚于 "
				},
				"maxCheckbox" : {
					"regex" : "none",
					"alertText" : "* 最多选取 ",
					"alertText2" : " 个项目"
				},
				"minCheckbox" : {
					"regex" : "none",
					"alertText" : "* 请选择 ",
					"alertText2" : " 个项目"
				},
				"equals" : {
					"regex" : "none",
					"alertText" : "* 请输入与上面相同的密码"
				},
				"morethan" : {
					"regex" : "none",
					"alertText" : "* 请输入大于",
					"alertText2" : "的值"
				},
				"lessthan" : {
					"regex" : "none",
					"alertText" : "* 请输入小于",
					"alertText2" : "的值"
				},
				"phone" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^([\(]{1}[0-9]{2,6}[\)])?([0-9]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/,
					"alertText" : "* 电话号码格式不正确"
				},
				"mobile" : {
					"regex" : /^((1[0-9]{10})|([0-9]{3}1[0-9]{10}))?$/,
					"alertText" : "* 无效的手机号码"
				},
				"IDcard" : {
					"regex" : /^([0-9]{17}(x|X|[0-9]))?$/,
					"alertText" : "* 无效的身份证号"
				},
				"IDcard2" : {
					"regex" : /^((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91){1}[0-9]{4}(18|19|20){1}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[0-9]{3}([0-9]|[xX]))?$/,
					"alertText" : "* 无效的身份证号"
				},
				"temp" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[-+]?[0-9]{1,3}(\.[0-9]{0,1})?$/,
					"alertText" : "* 温度必须为数字,且整数位最多三位数，且只能保留小数点后一位"
				},
				"alarmsec" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[-+]?[0-9]{1,8}(\.[0-9]{0,2})?$/,
					"alertText" : "*请输入正确的金额，且整数位最多八位数,且只能保留小数点后二位"
				},
				"num8point1" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,8}(\.[0-9]{0,1})?$/,
					"alertText" : "*请输入正确的金额，保留小数点后一位"
				},
				"num6point2" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,6}(\.[0-9]{0,2})?$/,
					"alertText" : "*请输入正确的金额，且整数位最多六位数,且只能保留小数点后二位"
				},
				"num10point2" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,10}(\.[0-9]{0,2})?$/,
					"alertText" : "*请输入正确的金额，且整数位最多十位数,且只能保留小数点后二位"
				},
				"num8point2" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,8}(\.[0-9]{0,2})?$/,
					"alertText" : "*请输入正确的金额，且整数位最多八位数,且只能保留小数点后二位"
				},
				"num3point2" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,3}(\.[0-9]{0,2})?$/,
					"alertText" : "*请输入正确的金额，且整数位最多三位数,且只能保留小数点后二位"
				},
				"tempsix" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,4}(\.[0-9]{0,2})?$/,
					"alertText" : "* 必须为数字，且保留小数点前四位和小数点后两位"
				},
				"tempfour" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,2}(\.[0-9]{0,2})?$/,
					"alertText" : "* 必须为数字，数字在1-100之间,且保留小数点前两位和小数点后两位"
				},
				"tempthree" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,2}(\.[0-9]{0,1})?$/,
					"alertText" : "* 必须为数字，且保留小数点前两位和小数点后一位"
				},
				"tempeleven" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^[0-9]{1,9}(\.[0-9]{0,2})?$/,
					"alertText" : "* 必须为数字，且保留小数点前九位和小数点后两位"
				},
				"humidity" : {
					// credit: jquery.h5validate.js / orefalo
					"regex" : /^(?:0|[1-9][0-9]?|100)$/,
					"alertText" : "* 请输入0-100的正整数"
				},
				"integer1-9999" : {
					"regex" : /^[1-9][0-9]{0,3}$/,
					"alertText" : "* 请输入1-9999的正整数"
				},
				"integer1-9999999999" : {
					"regex" : /^[1-9][0-9]{0,9}$/,
					"alertText" : "* 请输入1-9999999999的正整数"
				},
				"integer1-99999999" : {
					"regex" : /^[1-9][0-9]{0,7}$/,
					"alertText" : "* 请输入1-99999999的正整数"
				},
				"integer1-100000" : {
					"regex" : /^([1-9]\d{0,4}|100000)$/,
					"alertText" : "* 请输入1-100000的正整数"
				},
				"integer1-999999" : {
					"regex" : /^[1-9][0-9]{0,5}$/,
					"alertText" : "* 请输入1-999999的正整数"
				},
				"qq":{
					"regex" :/^[1-9]\d{4,8}$/,
					"alertText" : "* QQ格式不正确"
				},
				"msn":{
					"regex" :/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/,
					"alertText" : "* MSN格式不正确"
				},
				"email" : {
					// Shamelessly lifted from Scott Gonzalez via the
					// Bassistance Validation plugin
					// http://projects.scottsplayground.com/email_address_validation/
					"regex" : /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
					"alertText" : "* 邮件地址格式不正确"
				},
				"integer" : {
					"regex" : /^[\-\+]?\d+$/,
					"alertText" : "* 不是有效的整数"
				},
				"fax" : {
					"regex" : /^[\-\+]?\d+$/,
					"alertText" : "* 只能是数字格式"
				},

				"code" : {
					"regex" : /^[0-9]{6}$/,
					"alertText" : "* 邮政编码格式不正确"
				},
				"number" : {
					// Number, including positive, negative, and floating
					// decimal. credit: orefalo
					"regex" : /^[\-\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
					"alertText" : "* 无效的数字"
				},
				"date" : {
					"regex" : /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
					"alertText" : "* 无效的日期，格式必需为 YYYY-MM-DD"
				},
				"ipv4" : {
					"regex" : /^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
					"alertText" : "* 无效的 IP 地址"
				},
				"url" : {
					"regex" : /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
					"alertText" : "* 不合法的URL"
				},
				"onlyNumberSp" : {
					"regex" : /^[\-\+]?[1-9]+[0-9]*$/,
					"alertText" : "* 只能填数字,且不能为0"
				},
				"onlyLetterSp" : {
					"regex" : /^[a-zA-Z\ \']+$/,
					"alertText" : "* 只接受英文字母大小写"
				},
				"onlyLetterNumber" : {
					"regex" : /^[0-9a-zA-Z]+$/,
					"alertText" : "* 不接受特殊字符"
				},
				"onlyLetterNumber2" : {
					"regex" : /^[a-zA-Z0-9\u4E00-\u9FA5]+$/,
					"alertText" : "* 不接受特殊字符"
				},
				"onlyLetterNumber3" : {
					"regex" : /^[a-zA-Z0-9\u4E00-\u9FA5\（\）\(\)\-\—\_\+]+$/,
					"alertText" : "* 不接受特殊字符"
				},
				"onlyLetterNumber4" : {
					"regex" : /^[a-zA-Z0-9\u4E00-\u9FA5\（\）\(\)\-\—\_\,\，\.\。\[\]\【\】\+]+$/,
					"alertText" : "* 不接受特殊字符"
				},
				"memberName" : {
					"regex" : /^(\S*[\u4E00-\u9FA5]*\S*[\u4E00-\u9FA5]*\S*)+$|^([^\u4E00-\u9FA5\s]+\s*[^\u4E00-\u9FA5\s]+)+$/,
					"alertText" : "* 无效的格式"
				},
				//"pwdformat" : {
				//	"regex" : /^(?![0-9]+$)(?![a-zA-Z]+$)(?![^\w\s]+$)([0-9A-Za-z]|[^\w\s]){8,16}$/,
				//	"alertText" : "* 密码长度为8~16字符，至少包含两种不同字符"
				//},
				"pwdformat" : {
					"regex" : /^([0-9A-Za-z]|[^\w\s]){8,16}$/,
					"alertText" : "* 密码长度为8~16字符"
				},
				"memberBirthdate" : {
					"regex" : /^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$/,
					"alertText" : "* 无效的日期"
				},
				// --- CUSTOM RULES -- Those are specific to the demos, they can
				// be removed or changed to your likings
				"ajaxUserCall" : {
					"url" : "ajaxValidateFieldUser",
					// you may want to pass extra data on the ajax call
					"extraData" : "name=eric",
					"alertText" : "* 此名称已被其他人使用",
					"alertTextLoad" : "* 正在确认名称是否有其他人使用，请稍等。"
				},
				"ajaxUserCallPhp" : {
					"url" : "phpajax/ajaxValidateFieldUser.php",
					// you may want to pass extra data on the ajax call
					"extraData" : "name=eric",
					// if you provide an "alertTextOk", it will show as a green
					// prompt when the field validates
					"alertTextOk" : "* 此帐号名称可以使用",
					"alertText" : "* 此名称已被其他人使用",
					"alertTextLoad" : "* 正在确认帐号名称是否有其他人使用，请稍等。"
				},
				"ajaxNameCall" : {
					// remote json service location
					"url" : "ajaxValidateFieldName",
					// error
					"alertText" : "* 此名称可以使用",
					// if you provide an "alertTextOk", it will show as a green
					// prompt when the field validates
					"alertTextOk" : "* 此名称已被其他人使用",
					// speaks by itself
					"alertTextLoad" : "* 正在确认名称是否有其他人使用，请稍等。"
				},
				"ajaxNameCallPhp" : {
					// remote json service location
					"url" : "phpajax/ajaxValidateFieldName.php",
					// error
					"alertText" : "* 此名称已被其他人使用",
					// speaks by itself
					"alertTextLoad" : "* 正在确认名称是否有其他人使用，请稍等。"
				},
				"validate2fields" : {
					"alertText" : "* 请输入 HELLO"
				},
				// tls warning:homegrown not fielded
				"dateFormat" : {
					"regex" : /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/,
					"alertText" : "* 无效的日期格式"
				},
				// tls warning:homegrown not fielded
				"dateTimeFormat" : {
					"regex" : /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/,
					"alertText" : "* 无效的日期或时间格式",
					"alertText2" : "可接受的格式： ",
					"alertText3" : "mm/dd/yyyy hh:mm:ss AM|PM 或 ",
					"alertText4" : "yyyy-mm-dd hh:mm:ss AM|PM"
				}
			};

		}
	};

})(jQuery);

$(document).ready( function() {

	$.validationEngineLanguage.newLang();
	if ($.fnValidationExend != null) {
		$.fnValidationExend();
	}
});
