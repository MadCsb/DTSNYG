<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/open-api.js"></script>
  </head>
  
  <body>
  </body>
  
  <script type="text/javascript">
    var openApi = new OpenApi();
    openApi.resetDefaultPageType();

    if (openApi.pageType == openApi.WX)
    {
      detailUrl = "${pageContext.request.contextPath}/wx?method=wxIndex";
    }else if (openApi.pageType == openApi.WEB)
    {
      detailUrl = "${pageContext.request.contextPath}/webIndex?method=webIndex";
    }else if (openApi.pageType == openApi.WAP)
    {
      detailUrl ="${pageContext.request.contextPath}/wapIndex?method=wxIndex";
    }
    location.href = detailUrl;

//  	 location.href="webIndex?method=webIndex";
//    location.href="http://www.3nong1gou.com/web/index.html";
  </script>
</html>
