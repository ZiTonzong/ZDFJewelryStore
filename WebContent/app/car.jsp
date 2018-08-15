<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_购物车</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
.btn{
float: left;
margin-right: 20px;
}
.cart-wrapper{
float: right;
}
.main{
width: 100%;
height: 300px;
}
h1{
margin-left: 200px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="main">
<h1>购物车</h1>
<center>
<div style="width: 1200px; height: 1px; overflow: hidden; clear: both;"></div>
<div id="blackcart">
<div class="cart-blank">
您的购物车中暂无商品，赶快<a href="main.jsp">挑选心爱的商品</a>吧！
</div>
</div>
<div id="cart-wrapper">
<c:if test="${(empty requestScope.cartProductMap) }">
<div class="cart-blank">
您的购物车中暂无商品，赶快<a href="main.jsp">挑选心爱的商品</a>吧！
</div>
</c:if>
<c:if test="${not (empty requestScope.cartProductMap) }">
<form action="" method="get" id="cartFormSubmit">
<table>
<thead>
<tr style="background-color: gray;">
<th></th>
<th style="width: 600px;">商品名称</th>
<th>商品单价</th>
<th>数量</th>
<th style="width: 100px;">小计</th>
<th class="cart_last" style="width: 100px;">删除</th>
</tr>
</thead>
<tbody id="cartbody">
<c:forEach items="${requestScope.cartProductMap}" var="cartProduct">
								<tr>
									<td class="checkboxtd">
											<input checked="checked" name="cartId" value="${cartProduct.key.cartId}" class="checkbox" type="checkbox" >
									</td>
									<td style="width: 600px;"><a target="_blank"
										href="getProduct.do?productid=${cartProduct.value.productId }"
										class="cart_list_img"><img
											src="${cartProduct.value.productImagePath }"
											style="cursor: pointer;" height="50" width="36"></a>
										<p>
											<a target="_blank"
												href="getProduct.do?productid=${cartProduct.value.productId }">${cartProduct.value.productName }</a>
										</p></td>
									<!-- <td style="font-weight:bold; font-size:14px;">0</td> -->
									<td class="mktprice1" style="font-weight: bold; font-size: 14px;">
										<b>${cartProduct.value.productPrice }</b>
									</td>
									<td class="cart-quantity" style="text-align: center;">
										<div class="Numinput">
										<c:if test="${cartProduct.value.productStatus==1}">
											<span class="numadjust decrease">-</span>
											<c:if test="${cartProduct.key.saleCount<=cartProduct.value.storeNum}">
											<input name="num" size="5" value="${cartProduct.key.saleCount}" type="text">
											</c:if> 
											<c:if test="${cartProduct.key.saleCount>cartProduct.value.storeNum}">
											<input class="outOfStoreNum" name="num" size="5" value="${cartProduct.key.saleCount}" type="text">
											</c:if> 
											<span class="numadjust increase">+</span>
										</c:if>
										<c:if test="${cartProduct.value.productStatus==0}">
											<font class="productSaleOut" color="red">已下架</font>
										</c:if>
										</div>
									</td>
									<td class="itemTotal"
										style="color: #ff6700; font-size: 14px; font-weight: bold; width: 100px;">
										<b>
										<fmt:formatNumber type="number" value="${cartProduct.key.saleCount*cartProduct.value.productPrice}" maxFractionDigits="2"/>
										</b>
										</td>
									<td class="cart_last" style="width: 100px;"><a href="#"
										class="delete"></a></td>
									<td class="cartId"><input type="hidden"
										value="${cartProduct.key.cartId }"></td>
									<td class="storeNum"><input type="hidden"
										value="${cartProduct.value.storeNum }"></td>
								</tr>
							</c:forEach>
</tbody>
</table>
<div class="cart-wrapper">
						<div class="yes_bonded">
							<p align="left">&nbsp;&nbsp;<input checked="checked" id="checkAll" type="checkbox">全选
							&nbsp;&nbsp;<a id="deleteChecked" href="#">删除</a> </p>
							<span class="c08"> 商品总价: <span class="color03" id="total">
							<fmt:formatNumber value="1" type="currency"></fmt:formatNumber>
							</span>
							</span>
						</div>
						<div class="cart_tools">
							<div class="btn">
								<input class="clean_btn white-btn" value="清空购物车" type="button" style="background-color: #EE6911;">
							</div>
							<div class="btn">
								<input class="returnbuy_btn yellow-btn" value="继续购物" type="button" style="background-color: 00ff00;">
							</div>

							<div class="btn">
								<input id="goToBuyleo" class="checkout-btn green-btn" value="去结算" type="button" style="background-color: 00cccc;">
							</div>
						</div>
					</div>
</form>
</c:if>
</div>
</center>		
</div>
<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>