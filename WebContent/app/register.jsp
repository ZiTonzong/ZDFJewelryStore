<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>钟大福珠宝</title>
<!--
	作者：1976172204@qq.com
	时间：2018-07-31
	描述：注册界面
-->
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../view/assets/js/jquery1.min.js"></script>
<link rel="stylesheet" href="css/checkpwd.css" />
<script src="js/jquery.animate-colors-min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: '微软雅黑 Light';
}

a {
	text-decoration: none;
}

li {
	list-style: none;
}

body {
	height: 673px;
}
.submit {
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
	.submit:hover{
		background:#4CB1CA;
	}
	p.msg a, p.note a {
		text-decoration: underline;
		color:#555;
	}
	p.msg {
		float: left;
		font-size: 12px;
		padding: 15px 60px 0 15px;
	}

#header {
	width: 100%;
	height: 80px;
	position: fixed;
	top: 0;
	left: 0;
	background: url(img/head.jpg);
	background-size: 100% 46px;
	min-width: 1349px;
	z-index: 99;
}

#header img {
	height: 60px;
	width: 60px;
	position: relative;
	top: 8px;
	left: 620px;
	float: left;
	cursor: pointer;
}

#login {
	position: absolute;
	top: 12px;
	right: 150px;
	color: aliceblue;
	font-size: 14px;
	cursor: pointer;
}

.tt {
	position: absolute;
	top: 22px;
	right: 138px;
}

.triangle {
	display: inline-block;
	width: 0;
	height: 0;
	line-height: 0;
}

.xia {
	border: 4px solid transparent;
	border-top-color: aliceblue;
	border-bottom-width: 0;
}

.shang {
	border: 10px solid transparent;
	border-bottom-color: white;
	border-top-width: 0;
	filter: drop-shadow(.5px -1px 1px lightslategray);
}

.ss {
	position: fixed;
	top: 41px;
	right: 158px;
	z-index: 6;
}

#body {
	width: 800px;
	height: 400px;
	position: relative;
	top: 150px;
	left: 480px;
	z-index: 1;
}

#body p {
	font-size: 26px;
	color: rgba(26, 26, 26, 1.00);
	margin-bottom: 10px;
	z-index: 1;
}

.txt {
	width: 425px;
	height: 38px;
	margin: 15px 0px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 18px;
	color: lightslategray;
	z-index: 1;
	padding: 0 10px;
	font-weight: bold;
}

.dingzhi {
	font-size: 13px;
	color: #666;
	cursor: pointer;
	z-index: 1;
}

.btn {
	width: 425px;
	height: 50px;
	border-radius: 3px;
	border: none;
	background-color: rgba(29, 161, 241, 1.00);
	color: rgba(255, 255, 255, 1.00);
	cursor: pointer;
	box-shadow: 0 1px 0 #fff;
	margin-top: 20px;
	font-size: 20px;
	z-index: 1;
	position: relative;;
	left: -2px;
}

#zhengce {
	width: 400px;
	height: 38px;
	font-size: 12px;
	margin-top: 10px;
	color: gray;
	margin-bottom: 10px;
	z-index: 1;
}

.xuan {
	width: 400px;
	height: 38px;
	font-size: 12px;
	color: rgba(29, 141, 242, 1.00);
}

#xi {
	width: 400px;
	height: 150px;
	display: none;
	margin-top: 5px;
}

.yun {
	color: grey;
	margin-top: 10px;
	font-size: 12px;
}

#signin {
	width: 240px;
	height: 200px;
	position: fixed;
	top: 51px;
	right: 140px;
	border-radius: 10px;
	box-shadow: 0 0 2px lightslategray;
	z-index: auto;
	background-color: white;
	border-bottom: 1px solid gray;
}

#sign {
	display: none;
	width: 240px;
	height: 300px;
	z-index: auto;
}

.tex {
	width: 225px;
	height: 24px;
	margin: 6px 6px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 13px;
	color: lightslategray;
	padding: 0 5px;
}

.tete {
	width: 225px;
	height: 24px;
	font-size: 14px;
	color: lightslategray;
	margin-left: 7px;
	margin-top: 10px;
	margin-bottom: 5px;
}

.bb {
	width: 185px;
	height: 30px;
	border-radius: 3px;
	border: none;
	background-color: rgba(29, 141, 242, 1.00);
	color: rgba(255, 255, 255, 1.00);
	cursor: pointer;
	box-shadow: 0 1px 0 #fff;
	margin: 15px 30px;
	font-size: 15px;
}

.ji {
	font-size: 12px;
	color: #666;
	cursor: pointer;
}

.check {
	width: auto;
	position: relative;
	left: 10px;
	top: -5px;
}

.link {
	color: rgba(29, 141, 242, 1.00);
}
.submit:hover{
		background:#4CB1CA;
	}
	p.msg a, p.note a {
		text-decoration: underline;
		color:#555;
	}
	p.msg {
		float: right;
		font-size: 12px;
		padding: 15px 60px 0 15px;
	}


</style>
</head>

<body>

	<div>
		<div id="header">
			<img src="img/logo.jpg" /> <span id="login">已有账号？登录</span><span
				class="triangle tt xia"></span>
			<div id="sign">
				<div class="triangle shang ss"></div>
				<div id="signin">
					<div class="tete">已有账号？</div>
					<form action= "login.do" method="post"> 
						<!--
                        	作者：1976172204@qq.com
                        	时间：2018-07-25
                        	描述：登录响应
                        -->
						<input class="tex" type="text" name="username" placeholder="用户名"
							autofocus id="uname" /><br> <input class="tex"
							type="password" name="password" placeholder="密码" id="pwd" /><br>
						<input style="margin-left: 7px" type="checkbox" checked="checked" />
						<span class="ji">记住我·<a href="#" style="color: dodgerblue">忘记密码？</a></span><br>
						<button class="bb">登录</button>
					</form>
				</div>
			</div>
		</div>
		<div id="body">
			<p style="font-weight: bold">现在注册享新人优惠！！</p>
			<form action="#" method="post">
				
				<input class="txt" id="username" type="text" placeholder="用户名"
					name="name" maxlength="20" /><span class="check"></span><br>
				
				<input class="txt" id="password" type="password" placeholder="密码"
					name="pwd" maxlength="18" /><span class="check"></span><br>
				<div id="level" class="pw-strength">
					<div class="pw-bar"></div>
					<div class="pw-bar-on"></div>
					<div class="pw-txt"></div>
				</div>	
				<input class="txt" id="confirmpass" type="password" placeholder="确认密码"
					name="confirmpass" maxlength="18" onkeyup="validate()" /><span class="check"></span><br />
				
				
				<span>点击同意<a target="_blank" href="delivery.jsp">《条款和条件》</a>并“创建帐户”.<span><br>
		    
				<button class="btn" name="signup" id="signup">创建用户</button>
			</form>
			
			<div id="zhengce">
				<span>注册意味着你同意<a href="" style="color:rgba(29,141,242,1.00)"
					class="a">服务条款</a>与<a href="" style="color:rgba(29,141,242,1.00)"
					class="a">隐私政策</a>，包括 <a href="" class="a"
					style="color:rgba(29,141,242,1.00)">Cookie 使用条款</a>。其他用户将可以通过你所提供的昵称或手机号码联系到你。
				</span>
			</div>
			<div>
				<a class="xuan a" href="javascript:void(0)">高级选项</a>
				<div id="xi">
					<hr style="color: gainsboro">
					<div class="yun">
						<input type="checkbox" checked="checked">允许查看我的浏览记录
					</div>
					<div class="yun">
						<input type="checkbox" checked="checked">允许其他人通过我的手机号码找到我
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
<script>


	window.onload = function() {
		$(".txt").val("");
		$(".tex").val("");
		
		$("#username").val("${name}");
		$("#password").val("${pwd}");
		$("#confirmpass").val("${con}");
		
		$("#username").focus();
		if ($("#username").val() != "")
			checkname();
		if ($("#password").val() != "")
			checkpwd();
		if ($("#confirmpass").val() != "")
			checkcon();
	}
	
	function checkname(){
		if ($("#username").val().trim() == "" || $("#username").val() == null) {
			$("#username").css("color", "gray");
			$(".check:eq(0)").html("<img src='img/error.png'/><span style='color:tomato;font-size:14px'>你的名字是什么？</span>");
		} else {
			$("#username").css("color", "black");
			$(".check:eq(0)").html("<img src='img/icon_tick_blue.png'/>");
		}
	}
	
	function checkpwd() {
		var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
		var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
		var enoughRegex = new RegExp("(?=.{6,}).*", "g");

		if ($("#password").val() == "") {
			$("#password").css("color", "gray");
		} else {
			$("#password").css("color", "black");
		}
		if (false == enoughRegex.test($("#password").val())) {
			$('#level').removeClass('pw-weak');
			$('#level').removeClass('pw-medium');
			$('#level').removeClass('pw-strong');
			$('#level').addClass(' pw-defule');
			$(".check:eq(1)").html("<img src='img/error.png'/><span style='color:tomato;font-size:14px'>密码长度应在6~18位之间</span>");

		//密码小于六位的时候，密码强度图片都为灰色 
		} else if (strongRegex.test($("#password").val())) {
			$('#level').removeClass('pw-weak');
			$('#level').removeClass('pw-medium');
			$('#level').removeClass('pw-strong');
			$('#level').addClass(' pw-strong');
			$(".check:eq(1)").html("<img src='img/icon_tick_blue.png'/>");

		//密码为八位及以上并且字母数字特殊字符三项都包括,强度最强 
		} else if (mediumRegex.test($("#password").val())) {
			$('#level').removeClass('pw-weak');
			$('#level').removeClass('pw-medium');
			$('#level').removeClass('pw-strong');
			$('#level').addClass(' pw-medium');
			$(".check:eq(1)").html("<img src='img/icon_tick_blue.png'/>");

		//密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等 
		} else {
			$('#level').removeClass('pw-weak');
			$('#level').removeClass('pw-medium');
			$('#level').removeClass('pw-strong');
			$('#level').addClass('pw-weak');
			$(".check:eq(1)").html("<img src='img/icon_tick_blue.png'/>");

		//如果密码为6位及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的 
		}
		return true;
	}
	
	
function validate() {
              var pwd1 = document.getElementById("password").value;
              var pwd2 = document.getElementById("confirmpass").value;
		/* <!-- 对比两次输入的密码 --> */
              if(pwd1 != pwd2) {
                  $("#username").css("color", "gray");
				  $(".check:eq(2)").html("<img src='img/error.png'/><span style='color:tomato;font-size:14px'>密码不一致</span>");
                  document.getElementById("submit").disabled = true;
              }
              else {
                  $("#username").css("color", "black");
			      $(".check:eq(2)").html("<img src='img/icon_tick_blue.png'/>");
                  document.getElementById("submit").disabled = flase;
              }
          }  

	$(".btn").on({
		mouseover : function() {
			$(this).css("backgroundColor", "rgb(0, 109, 191 ,1.00)");
		},
		mouseout : function() {
			$(this).css("backgroundColor", " rgba(29, 161, 241, 1.00)");
		},
		click : function() {
			if ($("#username").val() == "" || $(".check:eq(0)").html().indexOf("img/icon_tick_blue.png") < 0) {
				$(this).animate({
					marginLeft : "-4px"
				}, 50);
				$(this).animate({
					marginLeft : "8px"
				}, 50);
				$(this).animate({
					marginLeft : "4px"
				}, 50)
				$("#username").focus();
				return false;
			}
			if ($("#password").val() == "" || $(".check:eq(1)").html().indexOf("img/icon_tick_blue.png") < 0) {
				$(this).animate({
					marginLeft : "-4px"
				}, 50);
				$(this).animate({
					marginLeft : "8px"
				}, 50);
				$(this).animate({
					marginLeft : "4px"
				}, 50)
				$("#password").focus();
				return false;
			}
			if ($("#confirmpass").val() == "" || $(".check:eq(2)").html().indexOf("img/icon_tick_blue.png") < 0) {
				$(this).animate({
					marginLeft : "-3px"
				}, 50);
				$(this).animate({
					marginLeft : "6px"
				}, 50);
				$(this).animate({
					marginLeft : "3px"
				}, 50)
				$("#confirmpass").focus();
				return false;
			}
		}
	});

	$(".bb").on({
		mouseover : function() {
			$(this).css("backgroundColor", "rgb(0, 109, 191 ,1.00)");
		},
		mouseout : function() {
			$(this).css("backgroundColor", " rgba(29, 161, 241, 1.00)");
		}
	});

	$("#header img").on({
		click : function() {
			location = "login.jsp"; //登录
		}
	});

	$("#login").on({
		mouseover : function() {
			$(this).css("borderBottom", "1px solid rgba(29,141,242,1.00)");
			$(this).css("color", "rgba(29,141,242,1.00)");
		},
		mouseout : function() {
			$(this).css("borderBottom", "");
			$(this).css("color", "aliceblue");
		}
	});

	$(".a").on({
		mouseover : function() {
			$(this).css("textDecoration", "underline");
		},
		mouseout : function() {
			$(this).css("textDecoration", "none");
		}
	});

	$(".xuan").click(function() {
		$("#xi").fadeToggle(10);
	});

	$("#login").click(function() {
		$("#sign").fadeToggle(10);
		$(".tex:eq(0)").focus();
	});

	$(".txt").on({
		focus : function() {
			$(this).css("border", "1px solid rgba(29,141,242,1.00)");
		},
		blur : function() {
			$(this).css("border", "1px solid  #ccc");
		}
	});

	$(".tex").on({
		focus : function() {
			$(this).css("border", "1px solid rgba(29,141,242,1.00)");
		},
		blur : function() {
			$(this).css("border", "1px solid  #ccc");
		}
	});


	$(document).click(function(e) {
		e = window.event || e; // 兼容IE
		obj = $(e.srcElement || e.target);
		if ($(obj).is("#login") || ((e.pageX >= 970 && e.pageX <= 1210) && (e.pageY >= 50 && e.pageY <= 251))) {

		} else {
			$("#sign").fadeOut(10);
		}
	});

	$("#username").bind('input propertychange change', function() {
		checkname();
	});
	$("#password").bind('input propertychange change', function() {
		checkpwd();
	});

	$('#confirmpass').bind('input propertychange change', function() {
		checkcon();
	});
	$("#name").bind('input propertychange change', function() {
		if ($(this).val().trim() != "") {
			$(this).css("color", "black");
		} else {
			$(this).css("color", "gray");
		}
	});
	$("#pwd").bind('input propertychange change', function() {
		if ($(this).val().trim() != "") {
			$(this).css("color", "black");
		} else {
			$(this).css("color", "gray");
		}
	});
	$("#con").bind('input propertychange change', function() {
		if ($(this).val().trim() != "") {
			$(this).css("color", "black");
		} else {
			$(this).css("color", "gray");
		}
	});
	$(function(){
		//alert(regStatus);
		var flag = false;//标记验证是否通过
		   var $username = $("#username");
		   var $password = $("#password");
		   var $confirmpass = $("#confirmpass");
		   var $username_msg = $("#errorAccount");
		   var $password_msg = $("#errorPassword");
		   var $confirmpass_msg = $("#confirmpass_msg");
		   var url = "/ZDFJewelryStore_Demo/handleRegister";
		   
		   $username.focus(function(){
			   this.style.imeMode = 'disabled';// 禁用输入法,禁止输入中文字符
			   $username_msg.html("<br/>");
		   }).blur(function(){
			   var username = $username.val();
			   /* if(!isUsername(username)){
				   $username_msg.text("长度8-16个字符,以字母开头,可包含数字和下划线,不能含有特殊字符.");
				   return;
			   } */
			   var json = {"loginName":username};
			   $.post(url,json,function(data){
				   var regStatus = data[0].regStatus;
				   if(regStatus=="hasThisUser"){
						$(".check:eq(0)").html("<img src='img/error.png'/><span style='color:tomato;font-size:14px'>用户名已存在！</span>");
				   }
				   else
				   {
					   $(".check:eq(0)").html("<img src='img/icon_tick_blue.png'/>");
					   flag = true;
				   }
				   if(regStatus=="regSuccess"){
					   flag = true;
				   }
			   },"json");
			   
		   });
		   
		   $("#signup").click(function(){
			   var username = $username.val();
			   var password = $password.val();
			   var confirmpass = $confirmpass.val();
			   if(!flag){
				   return false;
			   }
			   var json = {"loginName":username,"password":password};
			   $.post(url,json,function(data){
				   var regStatus = data[0].regStatus;
				   if(regStatus=="hasThisUser"){
					   //$username_msg.text("用户名已存在！");
						$(".check:eq(0)").html("<img src='img/error.png'/><span style='color:tomato;font-size:14px'>用户名已存在！</span>");

				   }
				  
				   if(regStatus=="regSuccess"){
					   if(confirm("注册成功，点击确定进入主页")){
						   window.location.href = "AboutBlank.jsp";	
						 //return true;
					   }
				   }
				   console.log(regStatus);
				   if(regStatus=="regFail"){
					   alert("服务器异常，注册失败");
				   }
			   },"json");
			   return false;
		   });
		   
	   });
</script>
				
</html>
