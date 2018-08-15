<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车</title>
<jsp:include page="header.jsp"></jsp:include>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<%--gz --%>
<link rel="stylesheet" href="css/cart2.css" type="text/css">
<script type="text/javascript" src="js/checkout.js"></script>
<%--gz --%>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
	<div class="clear"></div>
	<div class="mycar-index">
		<h1>购物车</h1>

		<div id="cart-wrapper">
			<c:if test="${empty cart.cartItems }">
				<div class="cart-blank">
					您的购物车中暂无商品，赶快<a href="AboutBlank.jsp">挑选心爱的商品</a>吧！
				</div>
			</c:if>
			<c:if test="${not empty cart.cartItems}">
				<form action="javascript.void()" method="get" id="cartFormSubmit">
					<table>
						<thead>
							<tr>
								<th style=" width: 50px;"></th>
								<th style="text-align: center;">商品图片</th>
								<th style="width: 300px;">商品名称</th>
								<!-- <th>商品积分</th> -->
								<th>商品单价</th>
								<th>数量</th>
								<th style="width: 100px;">小计</th>
								<th class="cart_last" style="width: 100px;">删除</th>
							</tr>
						</thead>
						<tbody id="cartbody">
							<c:forEach items="${cart.cartItems}" var="cartItem">
								<tr>
									<!-- 勾选框 -->
									<td class="checkboxtd">
											<input checked="checked" name="cartId" value="<%-- ${cartProduct.key.cartId} --%>" class="checkbox" type="checkbox" >
									</td>
									<!-- 图片 -->
									<td>
										<span >
											<img src="${pageContext.request.contextPath}/${cartItem.product.productImagePath}"
													
													style="cursor: pointer; padding-left: 70px; height:100px; width:100px;"/>
										</span>
									</td>
									<!-- 商品名称 -->
									<td style="width: 300px; ">
										<span>
											<a target="_blank" href="${pageContext.request.contextPath}/handleProductInfo?productId=${cartItem.product.productId}">
								${cartItem.product.productName }</a>
										</span>
									</td>
									<!-- <td style="font-weight:bold; font-size:14px;">0</td> -->
									<!-- 商品的单价 -->
									<td class="mktprice1" style="font-weight: bold; font-size: 14px;">
										<b>${cartItem.product.productPrice }</b>
									</td>
									<!-- 购买商品的数量 -->
									<td class="cart-quantity" style="text-align: center;">
										<div class="Numinput">
										<!-- 如果商品状态是上架的则显示购买数量 -->
										<c:if test="${cartItem.product.productStatus==1}">
											<span class="numadjust decrease">-</span>
											<%-- <c:if test="${cartProduct.key.saleCount<=cartProduct.value.storeNum}"> --%>
											<!-- 想要购买的数量 -->
											<input name="num" size="5" value="${cartItem.sale_count}" type="text">
											<%-- </c:if>  --%>
											<%-- <c:if test="${cartProduct.key.saleCount>cartProduct.value.storeNum}">
											<input class="outOfStoreNum" name="num" size="5" value="${cartProduct.key.saleCount}" type="text">
											</c:if>  --%>
											<span class="numadjust increase">+</span>
										</c:if>
										<!-- 如果商品状态是下架的则不显示数量，则显示已下架 -->
										<c:if test="${cartItem.product.productStatus==0}">
											<font class="productSaleOut" color="red">已下架</font>
										</c:if>
										</div>
									</td>
									<!-- 单项商品总金额 -->
									<td class="itemTotal" style="color: #ff6700; font-size: 14px; font-weight: bold; width: 100px;">
										<b>
										<span>${cartItem.total_money }</span>
										</b>
									</td>
									<!-- 删除单个商品项按钮 -->
									<td class="cart_last" style="width: 100px;">
										<a href="javascript:;"	id="${cartItem.product.productId}" class="delete"></a>
									</td>
									<%-- <td class="storeNum">
										<input type="hidden" value="${cartProduct.value.storeNum }">
									</td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 总价 -->
					<div class="cart-wrapper">
						<div class="yes_bonded">
							<p align="left">&nbsp;&nbsp;
								<input checked="checked" id="checkAll" type="checkbox">
									全选&nbsp;&nbsp;
								<a id="deleteChecked" href="#">
									删除
								</a>
							</p>
							<span class="c08"> 商品总价: <span class="color03" id="total">
								<span>${cart.allMoney }</span>	
							<!-- <fmt:formatNumber value="1" type="currency"></fmt:formatNumber> -->
							</span>
							</span>
						</div>
						<div class="cart_tools">
							<div class="btn">
								<input id="clearCart" class="clean_btn white-btn" value="清空购物车" type="button">
							</div>
							
							<div class="btn">
								<input id="continueBuy" class="returnbuy_btn yellow-btn" value="继续购物" type="button">
							</div>

							<div class="btn">
								<input id="goToOrder" class="checkout-btn green-btn" value="去结算" type="button">
							</div>
						</div>
					</div>
					<!-- 总价结束 -->
				</form>
			</c:if>
		</div>
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
<!-- ************************************************ -->	
<script type="text/javascript">
//删除单个购物项
$(function() {
	$(".delete").click(function() {
		if(confirm("确认删除该商品吗？")){
			var productId = this.id;
			window.location.href="/ZDFJewelryStore_Demo/CartServlet?method=removeCartItem&id="+productId;
		}
	});
});
//清空购物车
$(function() {
	$("#clearCart").click(function () {
		if(confirm("确定清空购物车吗？")){
			window.location.href="/ZDFJewelryStore_Demo/CartServlet?method=clearCart";
		}
	});
	
});
$(function() {
	$("#goToOrder").click(function () {
		//alert("去结算");
		window.location.href="/ZDFJewelryStore_Demo/OrderServlet?method=goToBuy";
	});
});
$(function() {
	$("#continueBuy").click(function () {
		//alert("去结算");
		window.location.href="/ZDFJewelryStore_Demo/app/AboutBlank.jsp";
	});
});
</script>	
<!-- ************************************************ -->	
	
	
</body>
</html>