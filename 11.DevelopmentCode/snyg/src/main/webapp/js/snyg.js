/**
 * Created by cheng on 2019/10/29.
 * snyg项目特有属性
 */

var currentSpId = "da14b98e-cb26-4169-9b58-babe98b98047";

/**
 * 严恒用户是否是山东用户
 * @param userId 如果是监测当前登录用户，则不需要传递userId
 * @returns {boolean}
 */
function checkIsSdUser(userId) {
  var userIdParam = null;
  if(typeof(userId) != "undefined")
  {
    userIdParam = userId;
  }
  var isSdUser = false;
  var url = "checkIsSdUser";
  $.ajax({
    async: false,
    type : "POST",
    data: {
      userId: userIdParam
    },
    url : url,
    success : function(data) {
      if(data == "true"){
        isSdUser = true;
      }
    }
  });
  return isSdUser;
}

