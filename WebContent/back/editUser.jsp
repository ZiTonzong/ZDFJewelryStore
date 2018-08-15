<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ZDF.utils.PageUtil" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.ZDF.beans.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="back/CSS/bootstrap.min.css" rel="stylesheet" />
    <link href="back/CSS/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" />
    <link href="back/CSS/font-awesome.css" rel="stylesheet" />
    
    <link href="back/CSS/adminia.css" rel="stylesheet" /> 
    <link href="back/CSS/adminia-responsive.css" rel="stylesheet" /> 
    
    
    <link href="back/CSS/pages/faq.css" rel="stylesheet" /> 
    
    <link rel="stylesheet" type="text/css" href="back/CSS/style.css" />
    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style type="text/css">
    	<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

    </style>
  </head>

<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="./">ZDFJewelryStore</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					<li>
						<a href="#"><span class="badge badge-warning">7</span></a>
					</li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							罗宾逊 <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="./account.html"><i class="icon-user"></i> 账号设置  </a>
							</li>
							
							<li>
								<a href="./change_password.html"><i class="icon-lock"></i> 修改密码</a>
							</li>
							
							<li class="divider"></li>
							
							<li>
								<a href="./"><i class="icon-off"></i> 退出</a>
							</li>
						</ul>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			
			<div class="span3">
				
				<div class="account-container">
				
					<div class="account-avatar">
						<img src="./img/headshot.png" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">罗宾逊</span>
						
						<span class="account-role">管理员</span>
						
						<span class="account-actions">
							<a href="javascript:;">资料</a> |
							
							<a href="javascript:;">编辑设置</a>
						</span>
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li>
						<a href="${pageContext.request.contextPath}/handleBackUser">
							<i class="icon-pushpin"></i>
							会员管理	
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/listProduct">
							<i class="icon-th-list"></i>
							商品管理		
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/handleBackAllOrders">
							<i class="icon-th-large"></i>
							订单管理
						</a>
					</li>
					
					<li>
						<a href="./charts.html">
							<i class="icon-signal"></i>
							修改密码
						</a>
					</li>
					
				</ul>	
				
				<hr />
				
				<div class="sidebar-extra">
					<p>这里是提示信息息文字这里是提示信息文字这里是提示信息文字这里是提示信息文字.</p>
				</div> <!-- .sidebar-extra -->
				
				<br />
		
			</div> <!-- /span3 -->
			
			
			
			<div class="span9">
				
				<h1 class="page-title">
					<i class="icon-pushpin"></i>
					会员管理					
				</h1>
				
				<div class="widget">
														
					<div class="widget-content">
<form action="" method="post" class="definewidth m20">
		<input type="hidden" id="userId" name="userId" value="${requestScope.user.userId}" />
		<input type="hidden" id="oldUsername" name="oldUsername" value="${requestScope.user.userName}"/>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td>${requestScope.user.userName}</td>
			</tr>
			<tr>
				<td class="tableleft">账户密码</td>
				<td><input title="密码长度6-18个字符,必须包含字母、数字、下划线等特殊字符." type="password" id="password" name="password" value="${requestScope.user.password}"/></td>
			</tr>
			<tr>
				<td class="tableleft">确认密码</td>
				<td><input type="password" id="repassword" value="${requestScope.user.password}"/></td>
			</tr>
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" id="truename" name="truename" value="${requestScope.user.trueName}" /></td>
			</tr>
			<tr>
				<td class="tableleft">电话</td>
				<td><input type="text" id="phone" name="phone" value="${requestScope.user.phone}" /></td>
			</tr>
			<tr>
				<td class="tableleft">地址</td>
				<td><input type="text" id="address" name="address" value="${requestScope.user.address}" /></td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td>
	            	<input type="radio" name="userStatus" value="1" ${requestScope.user.userStatus==1?'checked':''}/> 启用
					<input type="radio" name="userStatus" value="0" ${requestScope.user.userStatus==0?'checked':''}/> 禁用
				</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="button" id="savebtn" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回</button>
				</td>
			</tr>
		</table>
	</form>
 				
					</div> <!-- /widget-content -->
					
				</div> <!-- /widget -->
				
				
				
			</div> <!-- /span9 -->
			
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->
					
	
<div id="footer">
	
	<div class="container">				
		<hr />
		<p>&copy; 2018 ZDFJewelryStore.</p>
	</div> <!-- /container -->
	
</div> <!-- /footer -->


    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="back/js/jquery-1.7.2.min.js"></script>
<script src="back/js/bootstrap.js"></script>
<script src="back/js/faq.js"></script>

<script type="text/javascript" src="back/js/ckform.js"></script>
<script type="text/javascript" src="back/js/common.js"></script>
<script src="back/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
<script>

$(function () {
	
	$('.faq-list').goFaq ();
	
});
$(function() {
	
	$('#backid').click(function() {
		var url = "/ZDFJewelryStore_Demo/handleBackUser?"
				+"pageNo=${requestScope.pageNo}";
				//+"&phone=${param.phone}&address=${param.address}";
		window.location.href=url;
	});
	var flag = true;
	$("input:password").focus(function(){
		this.style.imeMode = 'disabled';// 禁用输入法,禁止输入中文字符
	});
	$("#password").blur(function(){
		$(this).parent("td").children("font").remove();
		var pass = $(this).val();
		if(!isPassword(pass)){
			$(this).parent("td").append("<font color='red'></br><i>密码长度6-18个字符,必须包含字母、数字、下划线等特殊字符.</i><font>");
			flag = false;
			return;
		}
		flag = true;
	}).tooltip();
	$("#repassword").blur(function(){
		$(this).parent("td").children("font").remove();
		var pass = $("#password").val();
		var repass = $(this).val();
		if(!isPassword(repass)){
			$(this).parent("td").append("<font color='red'></br><i>密码长度6-18个字符,必须包含字母、数字、下划线等特殊字符.</i><font>");
			flag = false;
			return;
		}
		if(pass!=repass){
			$(this).parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
			return;
		}
		flag = true;
	});
	$("#savebtn").click(function() {
		if(!flag){
			return;
		}
		var pass = $("#password").val();
		var repass = $("#repassword").val();
		$("#password").parent("td").children("font").remove();
		if(!isPassword(pass)){
			$("#password").parent("td").append("<font color='red'></br><i>密码长度6-18个字符,必须包含字母、数字、下划线等特殊字符.</i><font>");
			return;
		}
		$("#repassword").parent("td").children("font").remove();
		if(pass!=repass){
			$("#repassword").parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
			return;
		}
		var oldUser = "${pageScope.oldUser}";
		
		var userId = $("#userId").val();
		var password = $("#password").val();
		var truename = $("#truename").val();
		var phone = $("#phone").val();
		var address = $("#address").val();
		var userStatus = $(":radio:checked").val();
		
		if($.trim(password)==""){
			alert("密码不能为空！");
			return;
		};
		/* ------------------------------ */
		var json = {"userStatus":userStatus,"userId":userId,"truename":truename,"phone":phone,"address":address,"password":password};
		var url = "/ZDFJewelryStore_Demo/handleBackDealEditUser";
		$.post(url,json,function(data){
			var editUserStatus = data[0].editUserStatus;
			alert(editUserStatus);
		},"json");
	});
});
function isPassword(pass){
	var reg = new RegExp("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,18}");
	return reg.test(pass);
}
</script>

  </body>
</html>