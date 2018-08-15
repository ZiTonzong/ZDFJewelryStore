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
<title>ZDFjewelry_订单</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<script type="text/javascript" src="<%=basePath %>js/jquery1.min.js"></script>
<style type="text/css">
		#form{
			width:40%;
			height:250px;
			margin-left: 30%;
		}
		#table {
			width:100%;
		}
		#form form input[type="text"], #form form select, #form form input[type="password"] {
			font-size:0.95em;
			color:#777;
			padding: 8px;
			outline: none;
			margin:5px 0;
			width:80%;
			font-family: 'Exo 2', sans-serif;
			border:1px solid #aaa;
			box-shadow:0 0 2px #aaa;
			-webkit-box-shadow:0 0 2px #aaa;
			-moz-box-shadow:0 0 2px #aaa;
			-o-box-shadow:0 0 2px #aaa;
		}
		#form form label {
			font-size: 0.8em;
			color: red;
			line-height: 2.5em;
		}
		.btn {
			padding:10px 30px;
			color: #FFF;
			cursor: pointer;
			background:#555;
			border:none;
			outline:none;
			font-family: 'Exo 2', sans-serif;
			font-size:1em;
			margin-left: 80;
		}
		.btn:hover{
			background:#4CB1CA;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			var passflag = false;
			var phoneflag = false;
			
			$("#password").blur(function(){
				if($("#password").val()!=$("#repassword").val()){
					$("#password").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#repassword").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×两次密码输入不一致×");
					passflag = false;
				} else {
					$("#password").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#repassword").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					passflag = true;
				}
			});
			
			$("#repassword").blur(function(){
				if($("#password").val()!=$("#repassword").val()){
					$("#password").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#repassword").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×两次密码输入不一致×");
					passflag = false;
				} else {
					$("#password").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#repassword").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					passflag = true;
				}
			});
			
			$("#phone").blur(function(){
				var scellphone = /^1{1}[0-9]{10}$/;
				if (!scellphone.test($("#phone").val())) {
					$("#phone").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×手机号码格式不正确×");
					phoneflag = false;
				} else {
					$("#phone").css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					phoneflag = true;
				}
			});
			
			$("#sb").click( function () { 
				if($("#password").val()!=$("#repassword").val()){
					$("#password").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#repassword").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×两次密码输入不一致×");
					passflag = false;
				} else {
					$("#password").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#repassword").focus().css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					passflag = true;
				}
				var scellphone = /^1{1}[0-9]{10}$/;
				if (!scellphone.test($("#phone").val())) {
					$("#phone").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×手机号码格式不正确×");
					phoneflag = false;
				} else {
					$("#phone").css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					phoneflag = true;
				}
				if(passflag&&phoneflag){
					alert("修改成功");
					$("#subform").submit();
				}
			});
		});
	</script>
</head>
<body>
<div id="form">
		<form id="subform" action="<%=basePath%>UserServlet?method=updateUserById" method="post">
   			<table id="table">
   				<tr height="40px">
					<td width="15%">用户名</td>
					<td width="85%">${user.userName}</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" id="password" value="${user.password}" name="password"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" id="repassword" value="${user.password}"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input type="text" name="truename" value="${user.trueName}"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" value="${user.phone}" id="phone"></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input type="text" name="address" value="${user.address}"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label style="font-size: 1em" id="la"><br/></label></td>
				</tr>
   			</table>
   			<div align="center"><br/></div>
			<input type="reset" value="重置" class="btn" id="res">
			<input type="button" value="修改" class="btn" id="sb">
		</form>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>