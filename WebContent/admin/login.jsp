<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<script language="JavaScript">
	if(window != top){
		top.location.href=location.href;
	}
</script>
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
			$.post("logcheck.bg",json,function(data){
				var check = data[0].check;
				if(check == "checkin"){
					if(confirm("登录成功,点击确定跳转到系统管理页面")){
						window.location.href = "login.bg";
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
				<a>钟大福欢迎您！</a>
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