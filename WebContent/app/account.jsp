<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_账户</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#account_msg {
		width:90%;
		height: 35px;
		margin-bottom: 20px;
	}
	#account_msg_menu li{
		list-style: none;
		float: left;
		margin-left: 2%; 
		font-size: 1em;
		text-align: center;
		color: black;
		line-height: 35px;
	}
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
	#main{
		/* height: 700px; */
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="register_account">
<div class="wrap" align="center" id="main">
			<h4 class="title" align="left">我的账户</h4>
			<div id="account_msg" align="left">
				<ul id="account_msg_menu">
	    			<li id="msg"><a id="default" href="/ZDFJewelryStore_Demo/UserServlet?method=getUserById" target="main">个人信息</a></li>
	   				<li id="dir"><a href="/ZDFJewelryStore_Demo/AddressServlet?method=getAddressPager" target="main">地址管理</a></li>
	   				<li id="ord"><a href="/ZDFJewelryStore_Demo/OrderServlet?method=getOrderMsgs" target="main">我的订单</a></li>
	    		</ul>
			</div>
			<iframe id="iframeMain" align="middle" frameborder="0" width="100%" name="main" onload="Javascript:iframeAutoFit(this)" scrolling="no"></iframe>
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
		<Br>
		<Br>
		<Br>
		<Br>
		<Br>
		<Br>
		<Br>
		<Br>
		<Br>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>