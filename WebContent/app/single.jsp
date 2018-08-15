<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ZDF.utils.PageUtil" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.ZDF.beans.Product" %>
    <%@ page import="com.ZDF.beans.CommentInfo" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE html>
<html lang="en">
<head>
<title>${requestScope.product.productName}</title>
<link rel="shortcut icon" type="image/ico" href="<%=basePath %>app/img/favicon.ico"> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/goods.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
#products .slides_container {
	width: 99.3333%;
	height:295px;
	overflow: hidden;
	float: left;
	position: relative;
	border: 1px solid #F0F0F0;
	display: none;
}

#commentInfo {
	width: 95%;
}

#commentInfo table {
	width: 95%;
	border-left: 1px solid #f5f5f5;
	border-right: 1px solid #f5f5f5;
}

#commentInfo table th {
	background: #f5f5f5;
	height: 30px;
	text-align: center;
	line-height: 30px;
}

#commentInfo table td {
	border-bottom: 1px solid #f5f5f5;
	color: #333;
	height: 30px;
	font-size: 14px;
	text-align: center;
	line-height: 30px;
}

.span_1_of_single ul li a:link,a:visited,a:active {
	text-decoration: none;
}

.span_1_of_single ul li a:hover {
	color: #000;
	text-decoration: none;
}

.span_1_of_single ul li a {
	color: #777;
}

.rer-quantity {
	height: 30px;
	line-height: 30px;
	width: 100%;
}

.decrease {
	border-right: 0 none;
}

.Numinput {
	display: inline;
	float: left;
}

span.numadjust {
	border: 1px solid #e3e2e2;
	float: left;
	height: 22px;
	line-height: 22px;
	text-align: center;
	width: 23px;
	cursor: pointer;
}

.rer-quantity label {
	float: left;
	height: 22px;
	line-height: 22px;
	width: 80px;
}

.Numinput input {
	border: 1px solid #e3e2e2;
	display: inline;
	float: left;
	height: 24px;
	line-height: 24px;
	text-align: center;
}

.nbs-flexisel-item>a img {
	cursor: pointer;
	margin-bottom: 10px;
	margin-top: 10px;
	max-height: 200px;
	max-width: 150px;
}

.button {
	font-family: 'Exo 2', sans-serif;
	cursor: pointer;
	color: #FFF;
	font-size: 1em;
	outline: none;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
	background: #7EB123;
	padding: 10px 20px;
	border: none;
	margin-top: 20px;
	-webkit-appearance: none;
}

.button:HOVER {
	background: #555;
}
div#page{
	float: left;
	margin-left: 50%;
}
div#page button{
	background: #fff;
	border: 0px #fff;
	color: #555;
}
div#page button.active{
	cursor: pointer;
	color: blue;
}
</style>
<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easydropdown.js" charset="utf-8"></script> 
<!-- start menu -->
<link href="<%=basePath %>css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath %>js/megamenu.js" charset="utf-8"></script>

<script type="text/javascript"> 
$(document).ready(function(){$(".megamenu").megamenu();});
</script>

<script type="text/javascript" src="<%=basePath %>js/jquery.jscrollpane.min.js" charset="utf-8"></script>
<script type="text/javascript" id="sourcecode">
	$(function()
	{
		$('.scroll-pane').jScrollPane();
	});
</script>
<!-- start details -->
<script type="text/javascript" src="<%=basePath %>js/slides.min.jquery.js" charset="utf-8"></script>
<script>
$(function(){
	$('#products').slides({
		preload: true,
		preloadImage: 'img/loading.gif',
		effect: 'slide, fade',
		crossfade: true,
		slideSpeed: 350,
		fadeSpeed: 500,
		generateNextPrev: true,
		generatePagination: false
	});
});
</script>
<!-- start zoom -->
<link rel="stylesheet" href="<%=basePath %>css/zoome-min.css" />
<script type="text/javascript" src="<%=basePath %>js/zoome-e.js" charset="utf-8"></script>
</head>
<body>
<%@ include file="header.jsp"%>  

<script type="text/javascript">
/*$(function(){
	 //当前页面的商品是否在购物车中
	var hasThisProduct = ("${requestScope.hasThisProduct}"=="true");
	var userId = "${sessionScope.userId}";
	//商品库存
	var storeNum = "${requestScope.product.storeNum}";
	var productName = "${requestScope.product.productName}";
	//alert(storeNum);
	//购物数量手工输入
    $(".Numinput input").keydown(function(event){
    	var kCode = $.browser.msie ? event.keyCode : event.which;
    	//判断键值  
        if (((kCode > 47) && (kCode < 58)) 
            || ((kCode > 95) && (kCode < 106)) 
            || (kCode == 8) || (kCode == 39) 
            || (kCode == 37)) { 
            return true;
        } else{ 
            return false;  
        };
    }).focus(function() {
        this.style.imeMode='disabled';// 禁用输入法,禁止输入中文字符
    }).keyup(function(){
    	var pBuy = $(this).parent();// 获取父节点
		var numObj = pBuy.find("input[name='number']");// 获取当前商品数量
		var num = parseInt(numObj.val());
		if (!isNaN(num)) {
			if (num > storeNum) {
				confirm("很抱歉，仓库中没有足够数量的商品，我们会尽快添加(⊙o⊙)哦！");
				return;
			};
    	};
	});
	$("#buyNow").click(function(){
		if(userId <= 0){
			if(confirm("请先登录，点击确定跳转到登录页面！")){
				window.location.href = "${pageContext.request.contextPath}/login.jsp";
			}
			return false;
		}
		var saleCount = $("#text1").val();
		if(parseInt(saleCount) > storeNum){
			alert("很抱歉！库存不足,请返回修改订购数量");
			return false;
		};
	}); */
/* 		$("#addToCart").click(function(){
		if(userId<=0){
			if(confirm("请先登录，点击确定跳转到登录页面！")){
				window.location.href = "${pageContext.request.contextPath}/login.jsp";
			}
			return false;
		}
		if(hasThisProduct){
			if(confirm("该商品已在购物车中,点击确定去购物车查看")){
				//window.location.href = "leoCart.do";
				window.open("${pageContext.request.contextPath}/leoCart.do");
			}
			return;
		}
		var url="addProductToCart.do";
		var productId = $("#productId").val();
		var saleCount = $("#text1").val();
		if(parseInt(saleCount) > storeNum){
			alert("很抱歉！库存不足,请返回修改订购数量");
			return;
		}
		var sendData={"productId":productId,"saleCount":saleCount};
		$.getJSON(url,sendData,function(backData){
			if(backData[0].cartId > 0){
				//var oldCartCount = parseInt($("#xiaocart li a").text().replace("购物车(","").replace(")",""));
				hasThisProduct = true;
				alert("添加成功^.^");
				$("#xiaocart li a").text("购物车(" + (backData[0].cartCount) + ")");
				$("#emptyCart").remove();
				$("#smallCartList").append("<li id='"+backData[0].cartId+"'><i><a href='getProduct.do?productid="+productId+"'>"+productName+"</a></i></li>");
			};
		});
	}); */
	$("#b2").click(function(){
	var nu1=$("#text1").val();
	var b=Number(nu1);
		b++;
		if (b > storeNum) {
			confirm("很抱歉，仓库中没有足够数量的商品，我们会尽快添加(⊙o⊙)哦！");
			return;
		};
		$("#text1").val(b);
	});
	$("#b3").click(function(){
	var nu1=$("#text1").val();
	var b=Number(nu1);
		if(b==1){
			return;
		}
		b--;
		$("#text1").val(b);
	});
});
</script>		

<div class="mens">    
  <div class="main">
     <div class="wrap">
     	<ul class="breadcrumb breadcrumb__t"><a class="home" href="AboutBlank.jsp">主页</a> / ${requestScope.product.productName}</ul>
		<div class="cont span_2_of_3">
		  	<div class="grid images_3_of_2">
						<div id="container">
							<div id="products_example">
								<div id="products">
									<!-- <div class="slides_container"> -->
									<div>
									        <a href="#"><img class="a" id="img1" src="${requestScope.product.productImagePath}" alt="" rel="images/s-img.jpg" /></a>
									</div>
								</div>
							</div>
						</div>
	            </div>
		         <div class="desc1 span_3_of_2">
		         	<h3 class="m_3">${requestScope.product.productName}</h3>
		             <p class="m_5">￥${requestScope.product.productPrice} </p>
		         	 <div class="btn_form">
		         	 <em><font color="#878787">库存${requestScope.product.storeNum}件</font></em><br/><br/>
						<form id="buyForm" method="post" action="${pageContext.request.contextPath}/CartServlet?method=addCartItemToCart"">
							<!-- 商品的id(value值应当从点击商品详情的product传入) -->
							<input id="productId" type="hidden" name="productId" value="${requestScope.product.productId}">
							<div style="margin-top:5px;margin-bottom:0" class="rer-quantity">
							<label>订购数量：</label>
								<div class="Numinput">
									<span class="numadjust decrease" id="b3">-</span>
									<!-- 商品的数量 -->
									<input id="text1" type="text" autocomplete="off" name="productNumber" size="5" oldvalue="3" value="1">
									<span class="numadjust increase" id="b2">+</span>
								</div>
							</div>
								
							<br/><br/>
							<input type="submit" value="立即购买" id="buyNow" >&nbsp;&nbsp;
							<input type="button" value="添加到购物车" id="addToCart" class="button">
						</form>
					 </div>
			     </div>
			   <div class="clear"></div>	
	    <div class="clients">
	    <h3 class="m_3">热销商品</h3>
		 <ul id="flexiselDemo3">
		 	<c:forEach items="${pager.data}" var="product">
			<li>
				<a target="_blank" href="${pageContext.request.contextPath}/handleProductInfo?productId=${product.productId}">
					<img src="${product.productImagePath}" /><br/>${fn:substring(product.productName,0,8)}...
				</a>
				<p>
				<fmt:formatNumber value="${product.productPrice}" type="currency"></fmt:formatNumber>
				</p>
			</li>
		 	</c:forEach>
			
		 </ul>
<script type="text/javascript">
	$(window).load(function() {
		$("#flexiselDemo1").flexisel();
		$("#flexiselDemo2").flexisel({
			enableResponsiveBreakpoints: true,
	    	responsiveBreakpoints: { 
	    		portrait: { 
	    			changePoint:480,
	    			visibleItems: 1
	    		}, 
	    		landscape: { 
	    			changePoint:640,
	    			visibleItems: 2
	    		},
	    		tablet: { 
	    			changePoint:768,
	    			visibleItems: 3
	    		}
	    	}
	    });
	
		$("#flexiselDemo3").flexisel({
			visibleItems: 5,
			animationSpeed: 1000,
			autoPlay: true,
			autoPlaySpeed: 3000,    		
			pauseOnHover: true,
			enableResponsiveBreakpoints: true,
	    	responsiveBreakpoints: { 
	    		portrait: { 
	    			changePoint:480,
	    			visibleItems: 1
	    		}, 
	    		landscape: { 
	    			changePoint:640,
	    			visibleItems: 2
	    		},
	    		tablet: { 
	    			changePoint:768,
	    			visibleItems: 3
	    		}
	    	}
	    });
	    
	});
</script>
<script type="text/javascript" src="<%=basePath %>js/jquery.flexisel.js" charset="utf-8"></script>
     </div>
     <div class="toogle">
     	<h3 class="m_3">描述</h3>
     	<p class="m_text">${requestScope.product.productDesc}</p>
     	<h3 class="m_3">综合评分：${requestScope.product.levelStatistic==null?'5.0':requestScope.product.levelStatistic}</h3>
     	<h3 class="m_3">商品销量：${requestScope.product.sales==null?'0':requestScope.product.sales} 件</h3>
     </div>
     <div class="toogle">
     	<h3 class="m_3">评论</h3>
<%--商品评论开始--%>
<script type="text/javascript">
var productid = "${requestScope.product.productId}";
$(function(){
	var currPage = parseInt("${requestScope.commentPager.pageNo}");
	var pageCount = parseInt("${requestScope.commentPager.totalPage}");
	toggleClassToButton(currPage,pageCount);
	$("#firstPage").click(function(){
		currPage = 1;
		getResultAndAppend(currPage);
	});
	$("#prevPage").click(function(){
		if(currPage > 1){
			currPage -= 1;
			getResultAndAppend(currPage);
		}
	});
	$("#nextPage").click(function(){
		if(currPage < pageCount){
			currPage += 1;
			getResultAndAppend(currPage);
		}
	});
	$("#lastPage").click(function(){
		currPage = pageCount;
		getResultAndAppend(currPage);
	});
	
});
function getResultAndAppend(currPage){
	var json = {"productId":productid,"pageNo":currPage};
	$.post("handleProductInfo",json,function(data){
		var dataCount = data[0].totalCount;
		var currPage1 = data[0].pageNo;
		var pageCount = data[0].totalPage;
		var pageDataList = data[0].data;
		$("ul#gradeListUL").empty();
		$.each(pageDataList,function(){
			$("ul#gradeListUL").append(
			"<li><div class='problem_pic'><span class='name'>"+this.username+"</span>"+
         	"<h2><span class='lv'>会员</span></h2></div><div class='problem_right'>"+
			"<div class='problem_time'><p>我的评分："+this.level+"分</p>"+
			"<span>"+timeStamp2String(this.orderTime.time)+"</span></div><p>"+this.content+"</p><div class='clear'>"+
			"</div></div></li>");
		});
		$("div#page label").text(dataCount + "条记录"+currPage1+"/"+pageCount+"页 ");
		toggleClassToButton(currPage1,pageCount);
	},"json");
}
function toggleClassToButton(currPage,pageCount){
	if(currPage==pageCount){
		$("#lastPage").removeClass("active");
		$("#nextPage").removeClass("active");
	}
	if(currPage==1){
		$("#firstPage").removeClass("active");
		$("#prevPage").removeClass("active");
	}
	if(currPage>1){
		$("#firstPage").addClass("active");
		$("#prevPage").addClass("active");
	}
	if(currPage < pageCount){
		$("#lastPage").addClass("active");
		$("#nextPage").addClass("active");
	}
}
//时间格式化
function timeStamp2String(time){
var datetime = new Date();
datetime.setTime(time);
var year = datetime.getFullYear();
var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
//return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
return year + "-" + month + "-" + date+" "+hour+":"+minute;
}

</script>
<div id="discuss_list_wrapper">
	<div class="grade">
		<div>
		</div>	
	</div>
	<div class="grade_list">
		<ul id="gradeListUL">
		<c:if test="${(empty requestScope.commentPager.data)}">
			<li>尚无数据！</li>
		</c:if>
		<c:forEach items="${requestScope.commentPager.data}"
						var="commentInfo">
			<li>
					<div class="problem_pic">
						<span class="name"> 
				            	${commentInfo.username }
				         </span>
         				<h2>
							<span class="lv">
         							会员
           					</span>
        				</h2>
					</div>
					<div class="problem_right">
						<div class="problem_time">
							<p>我的评分：${commentInfo.level}分</p>
							<span><fmt:formatDate value="${commentInfo.orderTime }"
									pattern="yyyy-MM-dd HH:mm" /></span>
						</div>
						<p>${commentInfo.content}</p>
						<div class="clear"></div>
					</div>
				</li>
		</c:forEach>
				
		</ul>
	</div>
	<div class="clear"></div>
</div>
	<div id="page">
		<button id="firstPage" type="button" value="">首页</button>
		<button id="prevPage" type="button" value="">上一页</button>
		<button id="nextPage" type="button" value="">下一页</button>
		<button id="lastPage" type="button" value="">尾页</button>
		<label>${requestScope.commentPager.totalCount}条记录${requestScope.commentPager.pageNo}/
		${requestScope.commentPager.totalPage} 页 </label>
	</div>
<%--商品评论结束--%>
</div>
</div>
			<div class="rsingle span_1_of_single">
				<h5 class="m_1">推荐商品</h5>
			<ul>
		 	<c:forEach items="${pager.data}" var="product">
			<li>
				<a target="_blank" href="${pageContext.request.contextPath}/handleProductInfo?productId=${product.productId}">
					<img src="${product.productImagePath}" /><br/>
					${fn:substring(product.productName,0,8)}...
					&nbsp;&nbsp;
					<fmt:formatNumber value="${product.productPrice}" type="currency"></fmt:formatNumber>
				</a>
			</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
		 	</c:forEach>
			
		 </ul>
		      </div>
		      <div class="clear"></div>
			</div>
		   </div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ************************************************ -->
<script type="text/javascript">
$(function() {
	$("#addToCart").click(function() {
		
		var formObj=document.getElementById("buyForm");
		formObj.submit();
	})
})
</script>
<!-- ************************************************ -->
</body>
</html>