<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.ZDF.beans.Sort" %>
   <%@ page import="com.ZDF.beans.User" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%
String path2 = request.getContextPath();
String basePath2 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
%> 

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<link href="<%=basePath2 %>css/style.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">

body{
margin: 0;
padding: 0;
}
.header-top{
width: 100%;
height: 40px;
background-color:#444444;
}
.cssmenu{
margin-right:80px;
float: right;
align-items: center;
}
.ul_category li{
float: left;
margin-left: 30px;
list-style-type: none;
} 
a{
text-decoration: none;
text-align: center;
}
.header-bottom{
width: 100%;
height: 150px;
}
.header-bottom-left{
height:60px;
line-height:60px;
float:left;
margin-left: 40px;
text-align: center;
}
/* .header-bottom-right{
height:60px;
line-height:60px;
float: right;
margin-right: 100px;
text-align: center;
} */
hr{
font-size:0px; line-height:0px; padding:0px; margin:0px;
}
/* .search{
width: 200px;
height: 40px;
} */  
.nav{
/* width: 30px;
height: 20px; */
}
.l1,.l2{
float: left;
}
</style>
<script type="text/javascript">
$(function() {
	$(".goLeoCart").click(function(){
		var userId = "${sessionScope.userId}";
		if(userId > 0){
			return true;
		}
		if(confirm("请先登录，点击确定跳转到登录页面！")){
			window.location.href = "${pageContext.request.contextPath}/login.jsp";
		}
		return false;
	});
	$("#logout").click(function(){
		return confirm('确认退出当前账户？');
	});
	$("body").keydown(function(event) {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $("#serchSubmit").click();
        }
    });
	
	$(".nav").hide();
	var timer;
	$(".nav1").mouseover(function() {
		clearTimeout(timer);
		$(".nav").show();
	});
	$(".nav1").mouseout(function () {
        timer = setTimeout(function () {
            $(".nav").hide();
        }, 500);
    });
	$(".nav").mouseover(function () {
        clearTimeout(timer);
    });
    $(".nav").mouseout(function () {
    	timer = setTimeout(function () {
            $(".nav").hide();
        }, 500);
    });
})
</script>
</head>
<body>
<div class="header-top">
<div class="cssmenu">
<ul class="my_index_menu">
<c:if test="${sessionScope.userId eq null}">
<li><a href="${pageContext.request.contextPath}/app/login.jsp">登录</a></li>
<li><a href="${pageContext.request.contextPath}/app/register.jsp">注册</a></li>
</c:if>
<c:if test="${not(sessionScope.userId eq null)}"><li><a href="<%=basePath2%>app/account.jsp">
						<dir id="test1">${sessionScope.userHeader.userName}</dir>
						</a></li>
						<li><a class="goLeoCart" href="<%=basePath2%>app/checkout.jsp">购物车</a></li>
						<li><a id="logout" href="${pageContext.request.contextPath}/UserServlet?method=out">退出</a></li>
						</c:if>
</ul>
</div>
<div class="clear"></div>
</div>
<div class="header-bottom">
<div class="wrap">
<div class="header-bottom-left">
<div class="l1">
<ul class="megamenu-skyblue">
<li class="active-grid"><a href="<%=basePath2%>app/AboutBlank.jsp"><img alt="" src="<%=basePath2 %>images/logo5.png" width="80px" height="80px"></a></li>
<%-- <li class="active-grid"><a href="<%=basePath2%>app/AboutBlank.jsp">主页</a> --%>
</li></ul></div>
<div class="l2">
<ul class="ul_category">
<li class="nav1"><a href="${pageContext.request.contextPath }/handleAllProducts">所有商品</a></li>
						<li class="nav"><a href="${pageContext.request.contextPath}/handleSortProducts?sortId=5">钻石</a>
						</li>
						<li class="nav"><a href="${pageContext.request.contextPath}/handleSortProducts?sortId=1">玉石</a>
						</li>
						<li class="nav"><a href="${pageContext.request.contextPath}/handleSortProducts?sortId=4">白金</a>
						</li>
						<li class="nav"><a href="${pageContext.request.contextPath}/handleSortProducts?sortId=3">黄金</a>
						</li>
						<li class="nav"><a href="${pageContext.request.contextPath}/handleSortProducts?sortId=2">白银</a>
						</li>
</ul>

</div>
</div>
<div class="header-bottom-right">

<div class="search">
					<form id="serchSubmit" action="${pageContext.request.contextPath}/handleSearchProducts" method="get">
						<input type="text" id="searchProductName" 
						name="searchProductName"  class="textbox" value="${requestScope.criteriaProductName==null?'搜索':requestScope.criteriaProductName}"
							onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '${requestScope.criteriaProductName==null?'搜索':requestScope.criteriaProductName}';}"> 
						<input type="submit" id="submit">
					</form>
					<div id="response"></div>
				</div>
				<div class="tag-list">
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c2" href="#"> </a>
							<ul id="smallCartList" class="subCartList sub-icon1 list">
							<c:if test="${empty requestScope.cartProductMap}">
								<li><h3>商品列表</h3><a></a></li>
								<li id="emptyCart" ><p>请点击<a href='AboutBlank.jsp'>这里</a>选择产品</p></li>
							</c:if>
							<c:if test="${not empty requestScope.cartProductMap}">
									 <li><h3>商品列表</h3><a></a></li>
								<c:forEach items="${sessionScope.cart.cartItems}" var="cartProduct">
									 <c:if test="${cartProduct.product.productId==param.productid}">
									 	<c:set var="hasThisProduct" scope="request" value="${true }"></c:set>
									 </c:if>
									 <li id="${cartProduct.product.productId }">
										<i><a href="${pageContext.request.contextPath}/handleProductInfo?productId=${cartProduct.product.productId }">
										${cartProduct.product.productName}</a></i>
									 </li>
								</c:forEach>
							</c:if>
							</ul>
						</li>
					</ul>
					<ul id="xiaocart" class="last">
						<li><a class="goLeoCart" href="<%=basePath2%>app/checkout.jsp">购物车(${fn:length(sessionScope.cart.cartItems)})</a>
						</li>
					</ul>
				</div>
	
</div>
<div class="clear"></div>
</div>
</div>
<hr>
</body>
</html>