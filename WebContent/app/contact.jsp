<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>zdfjewelryt_联系我们</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/jquery1.min.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="../js/jquery.easydropdown.js"></script>
</head>
<body>
	<jsp:include page='header.jsp' flush="true"></jsp:include>
	<!-- 页面请求加载head.jsp -->
	<div class="login">
		<div class="wrap">
			<ul class="breadcrumb breadcrumb__t">
				<a class="home" href="AboutBlank.jsp">主页</a> / 联系方式
			</ul>
			<div class="content-top">
				<form method="post" action="contact-post.jsp">
					<div class="to">
						<input type="text" class="text" value="姓名"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '姓名';}"> <input
							type="text" class="text" value="Email" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Email';}"
							style="margin-left: 10px">
					</div>
					<div class="to">
						<input type="text" class="text" value="联系电话"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '联系电话';}"> <input
							type="text" class="text" value="标题" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '标题';}"
							style="margin-left: 10px">
					</div>
					<div class="text">
						<textarea value="内容:" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '内容';}">内容:</textarea>
					</div>
					<div class="submit">
						<input type="submit" value="提交">
					</div>
				</form>
				<div class="map">
					<iframe width="100%" height="175" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src=""></iframe>
					<br> 
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>