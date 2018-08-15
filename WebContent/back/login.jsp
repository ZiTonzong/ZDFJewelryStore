<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF珠宝商城后台管理</title>
<link rel="stylesheet" type="text/css" href="CSS/login.css" />
<script type="text/javascript" src="../view/assets/js/jquery1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#managerName").focus();
		$("body").keydown(function(event) {
            if (event.keyCode == "13") {//keyCode=13是回车键
                $("#loginSubmit").click();
            }
        });
		$("#loginSubmit").click(function(){
			var managerName = $("#managerName").val();
			var managerPassword = $("#managerPassword").val();
			if($.trim(managerName)=="" || $.trim(managerPassword)==""){
				alert("请输入用户名和密码！");
				return;
			}
			var json = {"managerName":managerName,"managerPassword":managerPassword};
			$.post("/ZDFJewelryStore_Demo/handleBackLogin",json,function(data){
				var logStatus = (data[0].logStatus=="true");
				if(logStatus){
					if(confirm("登录成功,点击确定跳转到系统管理页面")){
						window.location.href = "AboutBlank.jsp";
					}
				}else {
					alert("用户名或密码错误！");
				}
			},"json");
		});
	});
</script>
</head>
<body>
<div id="loginpanelwrap">
		<div class="loginheader">
			<div class="logintitle">
				<a>ZDF欢迎您！</a>
			</div>
		</div>
		<div class="loginform">
			<div class="loginform_row">
				<label>管理账户:</label> <input id="managerName" name="managerName" type="text" class="loginform_input"
					/>
			</div>
			<div class="loginform_row">
				<label>密码:</label> <input id="managerPassword" name="managerPassword" type="password" class="loginform_input"
					/>
			</div>
			<div class="loginform_row">
				<input id="loginSubmit" type="submit" class="loginform_submit" value="登录" />
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>