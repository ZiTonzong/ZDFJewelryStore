<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_付款成功</title>
<link rel="shortcut icon" type="image/ico" href="<%=basePath%>app/img/favicon.ico"> 
<script type="text/javascript" src="<%=basePath%>js/jquery-3.2.1.min.js"></script>
<%--gz --%>
<link rel="stylesheet" href="<%=basePath%>app/css/cart.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>app/css/buyleo.css" type="text/css">
<%--gz --%>
<link href="<%=basePath%>app/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start menu -->
<link href="<%=basePath%>app/css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="<%=basePath%>app/js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="encircle">
		<div class="checkout_order_right">
			<h1>
				恭喜，付款成功！
			</h1>
			<div class="checkout_order_summary">
			</div>
			<div class="checkout_order_intro">
				<div class="checkout_order_same">
				</div>
				<div class="checkout_order_same">
				</div>
				<div class="checkout_order_tools ">
					 <a href="app/AboutBlank.jsp" class="go_continue">继续购物</a>
				</div>
			</div>
		</div>
	</div>

	<!--正文结束-->
	<br /><br /><br /><br /><br /><br /><br /><br />
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>