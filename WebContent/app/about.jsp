<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>zdfjewelry关于我们</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/jquery1.min.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- dropdown -->
<script src="../js/jquery.easydropdown.js"></script>
</head>
<body>
	<jsp:include page='header.jsp' flush="true"></jsp:include> <!-- 引号填写responseHeaderInfo.do -->
	<div class="login">
		<div class="wrap">
			<ul class="breadcrumb breadcrumb__t">
				<a class="home" href="AboutBlank.jsp">主页</a> / 关于
			</ul>
			<div class="section group">
				<div class="labout span_1_of_about">
					<h3>授权鉴定书</h3>
					<div class="testimonials ">
						<div class="testi-item">
							<blockquote class="testi-item_blockquote">
								<a href="#"> 1、请求办理的条件：

									专利证书证明只向专利权人出具。对处于年费滞纳期、恢复期或者已经终止的专利，国家知识产权局不再出具专利证书证明。

									2、请求办理所需材料： (1)需提交专权利人或其本案代理机构签章的《办理证明文件请求书》。

									(2)专利权人当面、邮寄方式办理的，需提供专利权人的身份证明。专利权人委托他人来办理的，需要提交委托书原件、经办人身份证明、专利权人身份证明复印件。

									3、请求方式： (1)面交请求可以通过专利局受理大厅专利申请流程服务窗口办理。 (2)邮寄请求

									请求书邮寄地址：江西省南昌市青山湖区华东交通大学

									收件人名称：国家知识产权局专利局初审及流程管理部业务发文管理处(专利局初审部发文处) 邮政编码：34000 </a>
								<div class="clear"></div>
							</blockquote>
							<small class="testi-meta"><span class="user">我们的网址</span>,
								<span class="info">钟大福官方网站</span><br> <a href="#">www.zdfjewelry.com</a>
							</small>
						</div>
					</div>
					<div class="testimonials ">
						<div class="testi-item"></div>
					</div>
				</div>
				<div class="cont span_2_of_about">
					<h3>我们的团队</h3>
					<p>五大股东</p>
					<p>交大第一大五人组</p>
					<h5 class="m_6">开发团队</h5>
					<div class="section group">
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img src="images/a-img.jpg"
								title="continue" alt="" /> </a>
							<div id="small-dialog3" class="mfp-hide">
								<div class="pop_up2">
									<h2>隐藏信息</h2>
									<p>莫愁前路无知己，天下谁人不识君！</p>
								</div>
							</div>
							<h4 class="m_7">
								<a href="#">程大康</a>
							</h4>
							<p>钟大康同学在项目中担任项目经理一职，负责项目分工，以及攻关项目的重点难点！</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img src="images/a-img1.jpg"
								title="continue" alt="" /> </a>
							<h4 class="m_7">
								<a href="#">张辉国</a>
							</h4>
							<p>负责数据库设计，登录注册，前端页面设计，页面优化，布局，美化。以及后台对用户管理</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img src="images/a-img2.jpg"
								title="continue" alt="" /> </a>
							<h4 class="m_7">
								<a href="#">钟海林</a>
							</h4>
							<p>负责数据库设计，登录注册，前端页面设计，页面优化，布局，美化。以及后台对用户管理</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img src="images/a-img4.jpg"
								title="continue" alt="" /> </a>
							<h4 class="m_7">
								<a href="#">吴世亮</a>
							</h4>
							<p>负责实现后台商品管理</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img src="images/a-img5.jpg"
								title="continue" alt="" /> </a>
							<h4 class="m_7">
								<a href="#">宋健</a>
							</h4>
							<p>负责购物车设计与实现</p>
						</div>
						<div class="clear"></div>

					</div>
					<!-- Add fancyBox main JS and CSS files -->
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<link href="css/magnific-popup.css" rel="stylesheet"
						type="text/css">
					<script>
						$(document).ready(function() {
							$('.popup-with-zoom-anim').magnificPopup({
								type : 'inline',
								fixedContentPos : false,
								fixedBgPos : true,
								overflowY : 'auto',
								closeBtnInside : true,
								preloader : false,
								midClick : true,
								removalDelay : 300,
								mainClass : 'my-mfp-zoom-in'
							});
						});
					</script>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>