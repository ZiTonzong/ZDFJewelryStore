<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>buyzb</title>
<jsp:include page="header.jsp"></jsp:include>
<link rel="shortcut icon" type="image/ico" href="<%=basePath %>app/img/favicon.ico"> 
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--gz --%>
<link rel="stylesheet" href="<%=basePath %>app/css/cart2.css" type="text/css">
<link rel="stylesheet" href="<%=basePath %>app/css/buyleo2.css" type="text/css">
 <link href="<%=basePath %>app/css/mystyle.css" rel="stylesheet" type="text/css" media="all" /> 
<style type="text/css">
.cart_name p i a:link, a:visited, a:active {
    text-decoration: none;
}
.cart_name p i a:hover { color: #D93600; text-decoration: none;}
.cart_name p i a{
color: #333;
    outline: medium none;
    text-decoration: none;
	display: block;
	color: #333;
	font-size: 16px;
	line-height: 18px;
	margin-left: 15px;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 700px;
	margin-left:20px;
	overflow: hidden;
	text-align: left;
}
/* #footer_buy{
	height: 20%;
} */
.register_account{

height: 1000px;
}
</style>
<%--gz --%>
<script type="text/javascript" src="<%=basePath %>app/js/jquery1.min.js"></script>
<!-- start menu -->
<link href="<%=basePath %>app/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<%=basePath %>app/js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
	
</script>
<!-- dropdown -->
<script src="<%=basePath %>app/js/jquery.easydropdown.js"></script>
<script type="text/javascript">
	$(function(){
		 setTotalPrice();
		 $("[name='addressId']").first().prop("checked", true);
		 $("#createBtn").click(function(){
			var radioLength = $("[name='addressId']:checked").length;
			if(radioLength < 1){
				alert("请添加或选择收货信息！");
				return;
			}
			if($(".itemTotal").length == 0){
				alert("请挑选要购买的商品再提交订单！");
				return;
			}
			$("#multiFormSubmit").submit();
		 });
		// $("#createAddress").click(function(){
		 //	openDialogByIframe("600", "350", "新增地址", "createAddress.jsp");
		 //});
	});
	//设置总计价格
	function setTotalPrice(){
		var total = 0;
		$(".itemTotal").each(function() {
			total += parseFloat($(this).text());
		});
		var mark = $(".total ul li p").text().trim().substring(0,1);//获取格式化的金额符号
		$(".total ul li p").html(mark + formatCurrency(total));
	}
	//格式化金额
	function formatCurrency(num) {    
	    num = num.toString().replace(/\$|\,/g,'');    
	    if(isNaN(num))    
	    num = "0";    
	    sign = (num == (num = Math.abs(num)));    
	    num = Math.floor(num*100+0.50000000001);    
	    cents = num%100;    
	    num = Math.floor(num/100).toString();    
	    if(cents<10)    
	    cents = "0" + cents;    
	    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)    
	    num = num.substring(0,num.length-(4*i+3))+','+    
	    num.substring(num.length-(4*i+3));    
	    return (((sign)?'':'-') + num + '.' + cents);    
	}
	/** 
 * iframe弹出层 例子：openDialogByIframe(550,450,'新建单位','add.do'); 
 *  
 * @param width 
 *            宽 
 * @param height 
 *            高 
 * @param tit 
 *            标题 
 * @param url 
 *            iframe的URL地址 
 */  
	function openDialogByIframe(width, height, tit, url) {  
    var winWinth = $(window).width(), winHeight = $(document).height(); 
    $("body").append("<div class='yz_popIframeDiv'></div>");  
    $("body")  
            .append(  
                    "<div class='yz_popTanChu'><div class='yz_popTanChutit'><span class='yz_popTanChuTxt'>"  
                            + tit  
                            + "</span><span class='yz_popTanChuClose'>关闭</span></div><iframe class='winIframe' scrolling='no' frameborder='0' hspace='0' src="  
                            + url + "></iframe></div>");  
    $(".yz_popIframeDiv").css({  
        width : winWinth,  
        height : winHeight,  
        background : "#000",  
        position : "absolute",  
        left : "0",  
        top : "0"  
    });  
    $(".yz_popIframeDiv").fadeTo(0, 0.5);  
    var yz_popTanChuLeft = $(window).width()/2 - width / 2;
    var yz_popTanChuTop = "300px";
   /*  var yz_popTanChuTop = $(window).height() / 2 - height / 2  
            + $(window).scrollTop();  */
    $(".yz_popTanChu").css({  
        width : width,  
        height : height,  
        border : "3px #ccc solid",  
        left : yz_popTanChuLeft,  
        top : yz_popTanChuTop,  
        background : "#fff",  
        position : "absolute"  
    });  
    $(".yz_popTanChutit").css({  
        width : width,  
        height : "25px",  
        "border-bottom" : "1px #ccc solid",  
        background : "#eee",  
        "line-height" : "25px"  
    });  
    $(".yz_popTanChuTxt").css({  
        "text-indent" : "5px",  
        "float" : "left",  
        "font-size" : "14px"  
    });  
    $(".yz_popTanChuClose").css({  
        "width" : "40px",  
        "float" : "right",  
        "font-size" : "12px",  
        "color" : "#667",  
        "cursor" : "pointer"  
    });  
    var winIframeHeight = height - 26;  
    $(".winIframe").css({  
        width : width,  
        height : winIframeHeight,  
        "border-bottom" : "1px #ccc solid",  
        background : "#ffffff"  
    });  
    $(".yz_popTanChuClose").hover(function() {  
        $(this).css("color", "#334");  
    }, function() {  
        $(this).css("color", "#667");  
    });  
    $(".yz_popTanChuClose").click(function() {  
        $(".yz_popIframeDiv").remove();  
        $(".yz_popTanChu").remove();  
    });  
} 
</script>
<%--layer弹层--%>
<script type="text/javascript" src="<%=basePath %>app/js/layer/layer.js"></script>
<script>
;!function(){
	
	//放入ready是为了layer所需配件（css、扩展模块）加载完毕
	layer.ready(function(){ 
		$('#createAddress').on('click', function(){
			layer.open({
		        type: 2,
		        offset: '180px',
		        //skin: 'layui-layer-lan',
		        title: '新增地址',
		        fix: true,
		        shadeClose: false,
		        maxmin: false,
		        area: ['600px', '400px'],
		        content: 'app/createAddress.jsp',
		    });
		});
	});

}();
</script>
</head>
<body>


	<div class="clear"></div>
	<div class="register_account">
		<form action="/ZDFJewelryStore_Demo/OrderServlet?method=saveOrder" method="post" id="multiFormSubmit">
			<c:set scope="page" var="tokenValue" value="<%=UUID.randomUUID().toString()%>"></c:set>
			<c:set scope="session" var="token" value="${pageScope.tokenValue }"></c:set>
			<input type="hidden" name="token" value="${pageScope.tokenValue }">
			<div class="wrap">
				<h4 class="title">确认收货地址</h4>
				<c:forEach items="${requestScope.addresses }" var="address">
					<input name="addressId" type="radio" value="${address.addressId }">
					<label> ${address.sendPlace }&nbsp;(${address.sendMan
						}&nbsp;收)&nbsp;${address.sendPhone }</label><br/>
				</c:forEach>
				<div id="createAddressDiv" class="button-wrapper">
					<span class="btn">
						<button id="createAddress" type="button" class="grey"><font size="2px">新增收货地址</font></button>
					</span>
				</div>
				<br/>
			</div>
			<div class="wrap">
				<h4 class="title">&nbsp;
				</h4>
			</div>
			<br/>
			<div class="wrap">
				<h4 class="title">商品清单<a href="app/checkout.jsp">[返回购物车修改]</a></h4>
			</div>
			<div class="mycar-index">
			<!-- 商品信息 -->
			<div class="goods_wrapper">
				<table cellspacing="0" cellpadding="3" width="100%">
					<thead>
						<tr>
							<th style="width:100px;">图片</th>
							<th style="width:500px;">商品名称</th>
							<th style="width:120px;">商品单价</th> 
							<th style="width:100px;">数量</th>
							<th style="width:120px;">小计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cart.cartItems}" var="cartProduct">
						<tr>
							<td style="width:100px;">
								<a target="_blank" href="getProduct.do?productid=${cartProduct.product.productId }">
									<span class="cart-product-img">
										<img src="${cartProduct.product.productImagePath }" height="50" style="cursor: pointer;">
									</span>
								</a>				
							</td>
							<td >
								<div class="cart_name" ><p>
								<i><a target="_blank" href="${pageContext.request.contextPath}/handleProductInfo?productId=${cartProduct.product.productId}">
								${cartProduct.product.productName }</a></i></p></div>							
							</td>
							<!-- <td>0</td> -->
							<td class="mktprice1" style="width:120px;">
							<div class="cart_pricenumber" ><p>${cartProduct.product.productPrice }</p></div></td>
							<td style="width:100px;" class="productquantity">
								<div class="cart_number" ><p>${cartProduct.sale_count}</p></div>
								<input type="hidden" value="${cartProduct.product.storeNum }">
							</td>
							<td class="itemTotal" style="width:120px;">
								<div class="cart_pricenumber" ><p>
								${cartProduct.total_money}</p></div>
								<!--
                                	作者：1976172204@qq.com
                                	时间：2018-07-30
                                	描述：计算商品总价
                                -->
							</td>
							
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="total_box">
				<!-- 备注 -->
				<div class="remark">
					备注:
					<input type="text" class="remark_intro" name="ordernote" maxlength="30">
				</div>
				<!-- 使用余额支付 -->
				<!-- 价格 -->
				<div class="total">
				<ul>
					<li>
						<p><fmt:formatNumber value="${cart.allMoney }" type="currency"></fmt:formatNumber></p>
						<h2>订单总价：</h2>
					</li>
				</ul></div>
			</div>
			<div class="order_total btn">
				<input type="button" id="createBtn" class="enable green-btn" value="提交订单">
			</div>
</div>
<!-- 确认订单 -->
			
		</form>
	</div>
	
	<br />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>