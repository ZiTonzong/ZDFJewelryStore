<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_后台管理</title>
<link href="../css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../css/main-min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.main-left{
width: 200px;
height: 800px;
float: left;
}
.dropdown-toggle{
width: 200px;
}
.dropdown-menu{
width: 200px;
height: 800px;
}
.main-right{
height: 800px;
float: left;
}
.content-main{
width: 100%;
height: 800px;
}
</style>
</head>
<body>
<div class="header">

		<div class="dl-title">
			<img width="100px" height="20px" src="../images/img3.jpg">
		</div>

		<div class="dl-log">
			欢迎您，<span class="dl-log-user">${sessionScope.manager.managerName }</span><a
				href="logout.bg" title="退出系统"
				class="dl-log-quit" onclick="return confirm('您确定退出吗？');">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			
			<ul id="J_Nav" class="nav-list ks-clear">
						<li class="nav-item dl-selected">
						<div class="nav-item-inner nav-home">业务管理</div>
						</li>
			</ul>
		</div>
		<div class="content-main">
		<div class="main-left">
		<ul class="nav navbar-nav">
		<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					业务管理 
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">会员管理</a></li>
					<li><a href="#">商品管理</a></li>
					<li><a href="#">订单管理</a></li>
					<li><a href="#">修改密码</a></li>
					
				</ul>
			</li>
			</ul>
		</div>
		
		<div class="main-right"></div>
		</div>
	</div>
	
	<div style="text-align: center;"></div>
</body>
</html>