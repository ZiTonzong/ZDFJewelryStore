<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_增加地址</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<script type="text/javascript" src="<%=basePath%>js/jquery1.min.js"></script>
<style type="text/css">
		.form{
			width:40%;
			height:250px;
			margin-left: 30%;
		}
		.table {
			width:100%;
		}
		.form form input[type="text"], .form form select, .form form input[type="password"] {
			font-size:0.95em;
			color:#777;
			padding: 8px;
			outline: none;
			margin:10px 0;
			width:80%;
			font-family: 'Exo 2', sans-serif;
			border:1px solid #aaa;
			box-shadow:0 0 2px #aaa;
			-webkit-box-shadow:0 0 2px #aaa;
			-moz-box-shadow:0 0 2px #aaa;
			-o-box-shadow:0 0 2px #aaa;
		}
		.form form label {
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
			var flag = false;
			$("#sendphone").blur(function(){
				var scellphone = /^1{1}[0-9]{10}$/;
				if (!scellphone.test($("#sendphone").val())) {
					$("#sendphone").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×手机号码格式不正确×");
					flag = false;
				} else {
					$("#sendphone").css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					flag = true;
				}
			});
			
			$("#usb").click( function () {
				var scellphone = /^1{1}[0-9]{10}$/;
				if (!scellphone.test($("#sendphone").val())) {
					$("#sendphone").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×手机号码格式不正确×");
					flag = false;
				} else {
					$("#sendphone").css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					flag = true;
				} 
				if(flag){
					alert("修改成功");
					$("#updateform").submit();
				}
			});
			$("#asb").click( function () { 
				var scellphone = /^1{1}[0-9]{10}$/;
				if (!scellphone.test($("#sendphone").val())) {
					$("#sendphone").focus().css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$("#la").html("×手机号码格式不正确×");
					flag = false;
				} else {
					$("#sendphone").css({
						border:"1px solid #aaa",
						boxShadow:"0 0 2px #aaa"
					});
					$("#la").html("<br/>");
					flag = true;
				}
				if(flag){
					alert("添加成功");
					$("#addform").submit();
				}
			});
			
		});
	</script>
</head>
<body>
<c:choose>
  		<c:when test="${empty address}">
	  		<div class="form">
				<form id="addform" action="<%=basePath %>AddressServlet?method=addAddr" method="post">
		   			<table class="table">
						<tr>
							<td width="15%">收货地址</td>
							<td width="85%"><input type="text" name="sendplace"></td>
						</tr>
						<tr>
							<td>收货人</td>
							<td><input type="text" name="sendman"></td>
						</tr>
						<tr>
							<td>手机号码</td>
							<td><input type="text" name="sendphone" id="sendphone"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><label style="font-size: 1em" id="la"><br/></label></td>
						</tr>
		   			</table>
		   			<div align="center"><br/>
					<input type="reset" value="重置" class="btn">
					<input type="button" value="确定" class="btn" id="asb"></div>
				</form>
			</div>
  		</c:when>
  		<c:otherwise>
	  		<div class="form">
				<form id="updateform" action="<%=basePath %>AddressServlet?method=updateAddressById&addId=${address.addressId}" method="post">
		   			<table class="table">
		   				<tr>
							<td width="15%">收货地址</td>
							<td width="85%"><input type="text" name="sendplace" value="${address.sendPlace}"></td>
						</tr>
						<tr>
							<td>收货人</td>
							<td><input type="text" name="sendman" value="${address.sendMan}"></td>
						</tr>
						<tr>
							<td>手机号码</td>
							<td><input type="text" name="sendphone" value="${address.sendPhone}" id="sendphone"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><label style="font-size: 1em" id="la"><br/></label></td>
						</tr>
		   			</table>
		   			<div align="center"><br/>
					<input type="reset" value="重置" class="btn">
					<input type="button" value="修改" class="btn" id="usb"></div>
				</form>
			</div>
  		</c:otherwise>
  	</c:choose>
  	<br/><br/><br/><br/>
</body>
</html>