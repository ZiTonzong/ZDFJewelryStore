<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>收货地址表格</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>app/js/jquery1.min.js"></script>
<style type="text/css">
.form {
	width: 500px;
	height: 250px;
	padding-left: 10%;
}

.table {
	width: 500px;
}

.form form input[type="text"] {
	font-size: 0.95em;
	color: #777;
	padding: 8px;
	outline: none;
	margin: 10px 0;
	width: 300px;
	font-family: 'Exo 2', sans-serif;
	border: 1px solid #aaa;
	box-shadow: 0 0 2px #aaa;
	-webkit-box-shadow: 0 0 2px #aaa;
	-moz-box-shadow: 0 0 2px #aaa;
	-o-box-shadow: 0 0 2px #aaa;
}
.form form label {
	font-size: 0.8em;
	color: red;
	line-height: 2.5em;
}
.btn {
	padding: 10px 30px;
	color: #FFF;
	cursor: pointer;
	background: #555;
	border: none;
	outline: none;
	font-family: 'Exo 2', sans-serif;
	font-size: 1em;
	margin-left: 90px;
}

.btn:hover {
	background: #4CB1CA;
}

i {
	color: red;
	font-size: 0.85em;
}
.table tr{
	width: 360px;
}
.table tr td.textTd{
	width: 60px;
}
.table tr td.inputTd{
	width: 300px;
}
</style>
<script type="text/javascript" src="<%=basePath%>app/js/layer/layer.js"></script>
<script type="text/javascript">
	$(function() {
		var flag = false;
		$("#phone").blur(function(){
			var phone = $("#phone").val();
			if (!isPhoneNo(phone)) {
				$("#phone").focus().css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$("#la").html("×手机号码格式不正确×");
				flag = false;
			} else {
				$("#phone").css({
					border:"1px solid #aaa",
					boxShadow:"0 0 2px #aaa"
				});
				$("#la").html("<br/>");
				flag = true;
			}
		});
		
		$("#asb").click( function () { 
			var phone = $("#phone").val();
			var sendplace = $("#sendplace").val();
			var sendman = $("#sendman").val();
			if($.trim(sendplace) == "" || $.trim(sendman) == ""){
				alert("请完善地址信息！");
				return;
			}
			if (!isPhoneNo(phone)) {
				$("#phone").focus().css({
					border: "1px solid red",
					boxShadow: "0 0 2px red"
				});
				$("#la").html("×手机号码格式不正确×");
				flag = false;
			} else {
				$("#phone").css({
					border:"1px solid #aaa",
					boxShadow:"0 0 2px #aaa"
				});
				$("#la").html("<br/>");
				flag = true;
			}
			if(flag){
				var json = {"sendphone":phone,"sendplace":sendplace,"sendman":sendman};
				$.post("/ZDFJewelryStore_Demo/AddressServlet?method=addAddress", json,function(data){
					if(data[0].addressId != 0){
						//parent.window.location.reload();
						$("#createAddressDiv",window.parent.document).before("<input name='addressId' "
						+"checked='checked' type='radio' value='"+data[0].addressId+"'>"
					+"<label>"+json.sendplace+"&nbsp;("+json.sendman+"&nbsp;收)"
					+"&nbsp;"+json.sendphone+"</label><br/>");
						alert("添加成功");
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭 
						//$(".yz_popIframeDiv",window.parent.document).remove();  
				        //$(".yz_popTanChu",window.parent.document).remove();
					}
				},"json" );
			}
		});
	});
	function isPhoneNo(phone) {
		var pattern = /^1[34578]\d{9}$/;
		return pattern.test(phone);
	};
</script>
</head>

<body>
	<div class="form">
		<form id="addform" action="/ZDFJewelryStore_Demo/AddressServlet?method=addAddress" method="post">
			<table class="table">
				<tr>
					<td class="textTd">收货地址</td>
					<td class="inputTd"><input type="text" name="sendplace" id="sendplace">
					</td>
				</tr>
				<tr>
					<td>收货人</td>
					<td><input type="text" name="sendman" id="sendman">
					</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="sendphone" id="phone">
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><label style="font-size: 1em" id="la"><br/></label></td>
				</tr>
			</table>
			<div align="center">
				<br />
			</div>
			<input type="reset" value="重置" class="btn"> <input
				type="button" value="确定" class="btn" id="asb">
		</form>
	</div>
</body>
</html>
