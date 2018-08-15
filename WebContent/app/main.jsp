<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ZDF.beans.Product" %>
    <%@ page import="java.util.List" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fmt" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_主页</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=basePath %>app/css/nivo-slider.css" rel="stylesheet" type="text/css" media="all">
<link href="<%=basePath %>app/css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
	<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/app/js/jquery-3.2.1.min.js"></script> --%>
<style type="text/css">
.border{
background-color:#FDF6E6;
height: 400px;
}
    .cont{
    background-color:#FDF6E6;
    }
    .wrap{
    
    }
.main{
margin:0 0;
background-color:#FDF6E6;
height: 2100px;
}
.main1{
/* height: 1500px; */
background-color:#FDF6E6;
}
#main_top{
margin:0;
padding:0;
width: 100%;
height: 600px;
}
#main_top img {
	width: 100%;
	height: 600px;	
}
.foot_t1,.foot_t2,.foot_t3,.foot_t4{
text-align: center;
width: 300px;
float: left;
border:1px solid gray;
margin-left: 50px;
background-color: #F6FDF8;
border-radius: 10px;
}
.img1,.img2,.img3,.img4{
 width:250px;
 height:250px;
 margin-top:20px;
}
.foot_f1,.foot_f2,.foot_f3,.foot_f4{
text-align: center;
width: 300px;
float: left;
border:1px solid gray;
margin-left: 50px;
margin-top: 20px;
background-color: #EEE9E9;
border-radius: 10px;
}
</style>

<script>
$(function(){
    $("#t1").mouseenter(function(){
        $("#t1").css("background-color","#7FFFD4");
        $("#p1").css("color","white");
        $("#r1").css("color","white");
    });
        $("#t1").mouseleave(function(){
            $("#t1").css("background-color","#EEE9E9");
            $("#p1").css("color","black");
            $("#r1").css("color","blue");
        });
        $("#t2").mouseenter(function(){
            $("#t2").css("background-color","#7FFFD4");
            $("#p2").css("color","white");
            $("#r2").css("color","white");
        });
        $("#t2").mouseleave(function(){
            $("#t2").css("background-color","#EEE9E9");
            $("#p2").css("color","black");
            $("#r2").css("color","blue");
        });
        $("#t3").mouseenter(function(){
            $("#t3").css("background-color","#7FFFD4");
            $("#p3").css("color","white");
            $("#r3").css("color","white");
        });
        $("#t3").mouseleave(function(){
            $("#t3").css("background-color","#EEE9E9");
            $("#p3").css("color","black");
            $("#r3").css("color","blue");
        });
        $("#t4").mouseenter(function(){
            $("#t4").css("background-color","#7FFFD4");
            $("#p4").css("color","white");
            $("#r4").css("color","white");
        });
        $("#t4").mouseleave(function(){
            $("#t4").css("background-color","#EEE9E9");
            $("#p4").css("color","black");
            $("#r4").css("color","blue");
        });
        $("#f1").mouseenter(function(){
            $("#f1").css("background-color","#7FFFD4");
            $("#p5").css("color","white");
            $("#r5").css("color","white");
        });
            $("#f1").mouseleave(function(){
                $("#f1").css("background-color","#EEE9E9");
                $("#p5").css("color","black");
                $("#r5").css("color","blue");
            });
            $("#f2").mouseenter(function(){
                $("#f2").css("background-color","#7FFFD4");
                $("#p6").css("color","white");
                $("#r6").css("color","white");
            });
            $("#f2").mouseleave(function(){
                $("#f2").css("background-color","#EEE9E9");
                $("#p6").css("color","black");
                $("#r6").css("color","blue");
            });
            $("#f3").mouseenter(function(){
                $("#f3").css("background-color","#7FFFD4");
                $("#p7").css("color","white");
                $("#r7").css("color","white");
            });
            $("#f3").mouseleave(function(){
                $("#f3").css("background-color","#EEE9E9");
                $("#p7").css("color","black");
                $("#r7").css("color","blue");
            });
            $("#f4").mouseenter(function(){
                $("#f4").css("background-color","#7FFFD4");
                $("#p8").css("color","white");
                $("#r8").css("color","white");
            });
            $("#f4").mouseleave(function(){
                $("#f4").css("background-color","#EEE9E9");
                $("#p8").css("color","black");
                $("#r8").css("color","blue");
            });
    });
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="main1">
<div id="main_top">
<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
  	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol> 
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="<%=basePath %>images/banner.jpg" >
		</div>
		<div class="item">
			<img src="<%=basePath %>images/banner1.jpg" >
		</div>
		<div class="item">
			<img src="<%=basePath %>images/img.jpg" >
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div> 
</div>
    </div>
<!-- <div class="main_foot" > -->
		<!--/slider -->
	<div class="main">
		<div class="wrap">
			<div class="section group">
				<div class="cont span_2_of_3">
					<h2 class="head">热卖商品</h2>
					<c:forEach items="${products}" var="out" varStatus="outvs">
						<c:if test="${(outvs.count-1)%3==0 }">
							<div class="top-box"> 
							<c:forEach items="${products}" var="a" varStatus="vs" begin="${outvs.count - 1}" end="${outvs.count + 1}" >
							<div class="col_1_of_3 span_1_of_3">
									<a href="${pageContext.request.contextPath}/handleProductInfo?productId=${a.productId}">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${pageContext.request.contextPath}/${a.productImagePath}"/>
											</div>
											<div class="sale-box">
												<span class="on_sale title_shop">热卖</span>
											</div>
											<div class="price">
												<div class="cart-left">
													<p class="title">${a.productDesc}</p>
													<br />
													<div class="price1">
														<span class="actual">
														￥${a.productPrice}
														</span>
													</div>
												</div>
												<div class="cart-right"></div>
												<div class="clear"></div>
											</div>
										</div>
									 </a>
									</div>
								</c:forEach>
								<div class="clear"></div>
							</div> 
						</c:if>
				</c:forEach>
				<br/><br/><br/>
				</div>
				<div class="rsidebar span_1_of_left">
					<div class="top-border"></div>
					<div class="border">
						
						<script src="<%=basePath %>app/js/jquery.nivo.slider.js"></script>
						<script type="text/javascript">
							$(window).load(function() {
								$('#slider').nivoSlider();
							});
						</script>
						<div class="slider-wrapper theme-default">
							<div id="slider" class="nivoSlider">
								<img src="<%=basePath %>images/t-img1.jpg" height="300px" alt="" />
				               	<img src="<%=basePath %>images/t-img2.jpg" height="300px" alt="" />
				                <img src="<%=basePath %>images/t-img3.jpg" height="300px" alt="" />
							</div>
						</div>
					</div>
			
                </div>
</div>
</div>
</div>


<!-- </div> -->
 <%@ include file="footer.jsp"%>  
</body>
</html>