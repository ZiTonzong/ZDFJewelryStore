<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>服务器异常</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/jquery1.min.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="../js/jquery.easydropdown.js"></script>
</head>
<body>
	<jsp:include page='header.jsp' flush="true"></jsp:include>
    <div class="login">
       <div class="wrap">
	      <div class="page-not-found">
			<h1>系统维护中</h1>
		  </div>
        </div> 
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>