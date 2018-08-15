<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="oldUser" scope="page" value="${requestScope.user }" ></c:set>
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
<script src="../js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
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
<script type="text/javascript">
	$(function() {
		
		$('#backid').click(function() {
			var url = "${pageContext.request.contextPath}/back/User/queryUsers.bg?"
					+"currPage=${param.currPage}&username=${param.username}&truename=${param.truename}"
					+"&phone=${param.phone}&address=${param.address}";
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
			var url = "${pageContext.request.contextPath}/back/User/editUser.bg";
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
</head>
<body>
<form action="" method="post" class="definewidth m20">
		<input type="hidden" id="userId" name="userId" value="${requestScope.user.userId}" />
		<input type="hidden" id="oldUsername" name="oldUsername" value="${requestScope.user.username}"/>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td>${requestScope.user.username}</td>
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
				<td><input type="text" id="truename" name="truename" value="${requestScope.user.truename}" /></td>
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
</body>
</html>