/**
 * Created by cheng on 2019/10/29.
 * snyg项目特有属性
 */

var currentSpId = "da14b98e-cb26-4169-9b58-babe98b98047";

/**
 * 判断当前用户是否是snyg的山东移动用户
 * @returns {boolean}
 */
function checkIsSdUser() {
  var isSdUser = false;
  var url = "checkIsSdUser";
  $.ajax({
    async: true,
    type : "POST",
    url : url,
    success : function(data) {
      if(data == "true"){
        isSdUser = true;
      }
    }
  });
  return true;
}