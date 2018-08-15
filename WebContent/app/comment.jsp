
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>LeoShop_商品评价</title>
<jsp:include page="header.jsp"></jsp:include>
<link rel="shortcut icon" type="image/ico" href="<%=basePath%>app/img/favicon.ico"> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="<%=basePath%>app/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath%>js/jquery1.min.js"></script>
<!-- start menu -->
<link href="<%=basePath%>app/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath%>js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<style type="text/css">
	#account_msg_menu a:LINK{
		color: #555;
	}
	#account_msg_menu a:HOVER{
		color: #555;
		cursor: pointer;
	}
	#account_msg_menu a:VISITED{
		color: #555;
	}
</style>
<!-- dropdown -->
<script src="<%=basePath%>js/jquery.easydropdown.js"></script>
</head>
<body>

	<div class="register_account">
		<div class="wrap" align="center">
			<h4 class="title" align="left">商品评价</h4>
			<%
				pageContext.setAttribute("orderNum", request.getParameter("orderNum"));
			%>
			<iframe src="/ZDFJewelryStore_Demo/OrderServlet?method=getCommentMsg&orderNum=${orderNum}" align="middle" frameborder="0" width="100%" name="main" onload="Javascript:iframeAutoFit(this)" scrolling="no"></iframe>
<script type="text/javascript">
	function iframeAutoFit(iframeObj){ 
		setTimeout(function(){
			if(!iframeObj)
			return;
			iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight);
		},200);
	}
</script>
		</div>
	</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>