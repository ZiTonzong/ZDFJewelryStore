<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>库存不足-ZDF</title>
<link rel="shortcut icon" type="image/ico" href="<%=basePath%>app/img/favicon.ico"> 
<!--
	作者：1976172204@qq.com
	时间：2018-07-31
	描述：库存不足提示
-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--gz --%>
<link rel="stylesheet" href="<%=basePath%>app/css/cart.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>app/css/buyleo.css" type="text/css">
<style type="text/css">

a:link, a:visited, a:active {
    text-decoration: none;
}
a:hover { color: #D93600; text-decoration: none;}
a {
    color: #555;
}

</style>
<%--gz --%>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath%>js/jquery1.min.js"></script>
<!-- start menu -->
<link href="<%=basePath%>css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="<%=basePath%>js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- dropdown -->
<script src="<%=basePath%>js/jquery.easydropdown.js"></script>
</head>
<body>
<!-- 每个页面均以这样的方式包含 header 提交到servlet的地址（即request.getServletPath()获得到的地址） 是以.jsp结尾的 -->
	<jsp:include page='header.jsp' flush="true"></jsp:include>
<!-- 在baseServlet中加判断当请求的地址是以.jsp结尾时 调用方法 responseHeaderInfo;目前没有找到更好的解决方法-->
	<br /><br /><br />
	<div class="encircle">
		<img src="images/jstjsb.jpg">
		<div class="checkout_order_right">
			<h1>
				很抱歉，您提交的订单中有库存不足的商品，请重新下单或返回<a href="app/checkout.jsp">购物车</a>修改商品数量^^
			</h1>
			</div>
	</div>

	<!--正文结束-->
	<br /><br /><br /><br /><br /><br /><br />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>