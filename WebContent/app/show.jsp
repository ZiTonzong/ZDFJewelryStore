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
<title>ZDF_所有商品</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" type="image/ico" href="<%=basePath %>app/img/favicon.ico"> 
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=basePath %>app/css/fwslider.css" rel="stylesheet" type="text/css" media="all" />

<script src="http://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/megamenu.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>js/fwslider.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easydropdown.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>js/css3-mediaqueries.js" charset="utf-8"></script>

<!--end slider -->
<script src="js/jquery.easydropdown.js"></script>

<style type="text/css">
#div1{
		margin-left: 450px;
		margin-bottom: 10px;
	}
	.cont {
    display: block;
    float: left;
    margin: 0 0;
}
</style>

<script>
$(document).ready(function() {
	$(".megamenu").megamenu();
});
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="main" style="margin: 0">
		<div class="wrap">
			<div class="section group">
				<div class="cont span_2_of_3" style="width: 100%" >
					<h2 class="head">所有商品...</h2>
					<c:forEach items="${pager.data}" var="out" varStatus="outvs">
						<c:if test="${(outvs.count-1)%4==0 }">
							<div class="top-box"> 
							<c:forEach items="${pager.data}" var="a" varStatus="vs" begin="${outvs.count - 1}" end="${outvs.count + 2}" >
							<div class="col_1_of_3 span_1_of_3" style="width: 23%">
									<a href="${pageContext.request.contextPath}/handleProductInfo?productId=${a.productId}" >
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${a.productImagePath}"/>
											</div>
											<div class="sale-box">
												<span class="on_sale title_shop">新品</span>
											</div>
											<div class="price">
												<div class="cart-left">
													<p class="title">${fn:substring(a.productName,0,20)}...</p>
													<br />
													<div class="price1">
														<span class="actual">￥${a.productPrice}</span>
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
					<div id="div1">
					 总共【${pager.totalPage}】页 &nbsp;&nbsp;${pager.pageNo}/${pager.totalPage}&nbsp;&nbsp; 
                <a href="handleAllProducts?method=showAllProducts&pageNo=1">首页</a> 
                <c:choose>
                    <c:when test="${requestScope.pager.pageNo > 1}">
                        <a href="handleAllProducts?method=showAllProducts&pageNo=${pager.pageNo-1}">上一页</a>
                    </c:when>
                    <c:otherwise>
                                                          上一页
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${pager.pageNo < pager.totalPage}">
                        <a href="handleAllProducts?method=showAllProducts&pageNo=${pager.pageNo+1}">下一页</a>
                    </c:when>
                    <c:otherwise>
                                                          下一页
                    </c:otherwise>
                </c:choose>
                  <a href="handleAllProducts?method=showAllProducts&pageNo=${pager.totalPage}">尾页</a></td>
                 
        <form action="handleAllProducts" method="get">
		输入页码：<input type="text" name="pageNo" size=5>
		<input type="submit" name="g" value="确定">
		</form>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
<!-- </div> -->
 <%@ include file="footer.jsp"%>  
</body>
</html>