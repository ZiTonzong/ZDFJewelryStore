<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.10.0.custom.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script> 
    <script src="../assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
<style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
<script>
    $(function () {
    	var flag = false;
		$("input:password").focus(function(){
			this.style.imeMode = 'disabled';// 禁用输入法,禁止输入中文字符
		});
		$("#managerPassword").blur(function(){
			$(this).parent("td").children("font").remove();
			var pass = $(this).val();
			if(!isPassword(pass)){
				$(this).parent("td").append("<font color='red'></br><i>密码为6-18位的字母、数字、下划线组合</i><font>");
				return;
			}
			flag = true;
		}).tooltip();
		$("#repassword").blur(function(){
			$(this).parent("td").children("font").remove();
			var pass = $("#managerPassword").val();
			var repass = $(this).val();
			if(!isPassword(repass)){
				$(this).parent("td").append("<font color='red'></br><i>密码为6-18位的字母、数字、下划线组合</i><font>");
				return;
			}
			if(pass!=repass){
				$(this).parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
				return;
			}
			flag = true;
		});
		$("#editsubmit").click(function() {
			var pass = $("#managerPassword").val();
			var repass = $("#repassword").val();
			$("#repassword").parent("td").children("font").remove();
			if(pass!=repass){
				$("#repassword").parent("td").append("<font color='red'></br><i>两次输入的密码不相同</i><font>");
				return;
			}
			var managerId = $("#managerId").val();
			var managerPassword = $("#managerPassword").val();
			if($.trim(managerPassword)==""){
				alert("密码不能为空！");
				return;
			};
			if(!flag){
				return;
			}
			var json = {"managerId":managerId,"managerPassword":managerPassword};
			var url = "editPassword.bg";
			$.post(url,json,function(data){
				var addManagerStatus = data[0].addManagerStatus;
				if(addManagerStatus == "noPromission"){
					alert("很抱歉您没有相应的权限！");
					return;
				}
				alert(addManagerStatus);
			},"json");
		});

    });
    function isPassword(pass){
    	var reg = /^[a-zA-Z0-9_]{6,18}$/;
    	return reg.test(pass);
    }
</script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
<input type="hidden" name="id" value="" />
<table class="table table-bordered table-hover ">
    <tr>
        <td width="10%" class="tableleft">账户名称</td>
        <td>${sessionScope.manager.managerName }</td>
    </tr>
    <tr>
        <td class="tableleft">账户密码</td>
        <td ><input title="密码为6-18位的字母、数字、下划线组合"  id="managerPassword" type="password" name="managerPassword" value="${sessionScope.manager.managerPassword }"/></td>
    </tr> 
    <tr>
		<td class="tableleft">确认密码</td>
		<td><input type="password" id="repassword" value="${sessionScope.manager.managerPassword }"></td>
	</tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button id="editsubmit" type="button" class="btn btn-primary" type="button">保存</button> 
        </td>
    </tr>
</table>
<input type="hidden" id="managerId" name="managerId" value="${sessionScope.manager.managerId }"/>
</form>
</body>
</html>