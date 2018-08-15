<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>LeoShop_评价列表</title>
<link rel="shortcut icon" type="image/ico" href="<%=basePath%>app/img/favicon.ico"> 
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath%>js/jquery1.min.js"></script>
<style type="text/css">
	.mycar-index{
		margin: 0 auto;
		width: 950px;
	}
	#cart-wrapper{
		width: 950px;
		/* height:330px; */
	}
	#cart-wrapper table{
		width: 950px;
		border-left:1px solid #f5f5f5;
		border-top:1px solid #f5f5f5;
	}
	#cart-wrapper table th{
		/* background: #f5f5f5; */
		border-bottom: 1px solid #f5f5f5;
		border-right: 1px solid #f5f5f5;
		height: 70px;
		text-align:center;
		font-size: 15px;
	}
	#cart-wrapper table td{
		border-bottom: 1px solid #f5f5f5;
		border-right: 1px solid #f5f5f5;
		color: #333;
		height: 50px;
		font-size: 14px;
	}
	#cart-wrapper table thead th,#cart-wrapper table thead td{
		background: #f5f5f5;
	}
	a:LINK{
		text-decoration: none;
		color: #555;
	}
	a:hover{
		text-decoration: none;
		cursor:pointer;
		background:#4CB1CA;
	}
	a:VISITED{
		text-decoration: none;
		color: #555;
	}
	.order-blank{  
	    height:100px;
	    line-height:100px;
	    font-size:16px;
	    text-align:center;
	   	width:100%;
	    margin:30px 0px;
    }
    img{
		float: left;
		display: block;
		width: 60px;
		height: 60px;
		cursor: pointer;
		margin-top:2px;
		margin-left: 10px;
	}
    .pname{
		float: left;
		width: 310px;
		margin-top:20px;
		margin-left:20px;
		text-algin: left;
    }
    textarea{
    	width: 700px;
    	height: 72px;
    	resize: none;
    	border: 0;
    	overflow: hidden;
    	background-color: white;
    }
    .btn {
		padding:3px 5px;
		color: #FFF;
		cursor: pointer;
		background:#555;
		border:none;
		outline:none;
		font-family: 'Exo 2', sans-serif;
		font-size:1em;
		margin-left: 600;
	}
	.btn:hover{
		background:#4CB1CA;
	}
</style>
</head>
<body>
	<div class="mycar-index">
		<c:forEach items="${commentMsgs}" var="commentMsg">
			<c:choose>
				<c:when test="${commentMsg.level>0}">
					<div id="cart-wrapper">
						<form>
							<table cellspacing="1.5">
								<thead>
								<tr>
									<th width="100px">订单编号</th>
									<td width="150px" align="center">${orderNum}</td>
									<th width="75px">商品名称</th>
									<td width="425px" align="left">
										<a target="_blank" href="getProduct.do?productid=${commentMsg.productId}">
											<img src="${commentMsg.productImagePath }"></a>
										<div class="pname"><a target="_blank" href="handleProductInfo?productId=${commentMsg.productId}">${commentMsg.productName}</a></div>
									</td>
									<th width="75px">商品单价</th> 
									<td width="125px" align="center">
										￥<fmt:formatNumber value="${commentMsg.productPrice}" maxFractionDigits="2"></fmt:formatNumber>
									</td>
								</tr>
								</thead>
								<tbody>
								<tr>
									<th colspan="2"><p>您的评价等级：</p></th>
									<td colspan="4">
										<c:if test="${commentMsg.level==1}">
											<input type="radio" value="1" name="level" disabled="disabled" checked="checked">1星（极差）
											<input type="radio" value="2" name="level" disabled="disabled">2星（差）
											<input type="radio" value="3" name="level" disabled="disabled">3星（一般）
											<input type="radio" value="4" name="level" disabled="disabled">4星（好）
											<input type="radio" value="5" name="level" disabled="disabled">5星（极好）
										</c:if>
										<c:if test="${commentMsg.level==2}">
											<input type="radio" value="1" name="level" disabled="disabled">1星（极差）
											<input type="radio" value="2" name="level" disabled="disabled" checked="checked">2星（差）
											<input type="radio" value="3" name="level" disabled="disabled">3星（一般）
											<input type="radio" value="4" name="level" disabled="disabled">4星（好）
											<input type="radio" value="5" name="level" disabled="disabled">5星（极好）
										</c:if>
										<c:if test="${commentMsg.level==3}">
											<input type="radio" value="1" name="level" disabled="disabled">1星（极差）
											<input type="radio" value="2" name="level" disabled="disabled">2星（差）
											<input type="radio" value="3" name="level" disabled="disabled" checked="checked">3星（一般）
											<input type="radio" value="4" name="level" disabled="disabled">4星（好）
											<input type="radio" value="5" name="level" disabled="disabled">5星（极好）
										</c:if>
										<c:if test="${commentMsg.level==4}">
											<input type="radio" value="1" name="level" disabled="disabled">1星（极差）
											<input type="radio" value="2" name="level" disabled="disabled">2星（差）
											<input type="radio" value="3" name="level" disabled="disabled">3星（一般）
											<input type="radio" value="4" name="level" disabled="disabled" checked="checked">4星（好）
											<input type="radio" value="5" name="level" disabled="disabled">5星（极好）
										</c:if>
										<c:if test="${commentMsg.level==5}">
											<input type="radio" value="1" name="level" disabled="disabled">1星（极差）
											<input type="radio" value="2" name="level" disabled="disabled">2星（差）
											<input type="radio" value="3" name="level" disabled="disabled">3星（一般）
											<input type="radio" value="4" name="level" disabled="disabled">4星（好）
											<input type="radio" value="5" name="level" disabled="disabled" checked="checked">5星（极好）
										</c:if>
									</td>
								</tr>
								<tr>
									<th colspan="2"><p>您的意见及建议(170字以内)：</p></th>
									<td colspan="5">
										<textarea value="好评！" onfocus="this.value = '';" disabled="disabled"
											onblur="if (this.value == '') {this.value = '好评！';}" id="content" name="content">${commentMsg.content}</textarea>
									</td>
								</tr>
								</tbody>
							</table>
						</form>
					</div>
					<br/>
				</c:when>
				<c:otherwise>
					<div id="cart-wrapper">
						<form action="OrderServlet?method=submitComment" method="post">
							<table cellspacing="1.5">
								<thead>
								<tr>
									<th width="100px">订单编号</th>
									<td width="150px" align="center">${orderNum}</td>
									<th width="75px">商品名称</th>
									<td width="425px" align="left">
										<a target="_blank" href="getProduct.do?productid=${commentMsg.productId}">
											<img src="${commentMsg.productImagePath }"></a>
										<div class="pname"><a target="_blank" href="handleProductInfo?productId=${commentMsg.productId}">${commentMsg.productName}</a></div>
									</td>
									<th width="75px">商品单价</th> 
									<td width="125px" align="center">
										￥<fmt:formatNumber value="${commentMsg.productPrice}" maxFractionDigits="2"></fmt:formatNumber>
									</td>
								</tr>
								</thead>
								<tbody>
								<tr>
									<th colspan="2"><p>您的评价等级：</p></th>
									<td colspan="4">
										<input type="radio" value="1" name="level">1星（极差）
										<input type="radio" value="2" name="level">2星（差）
										<input type="radio" value="3" name="level">3星（一般）
										<input type="radio" value="4" name="level">4星（好）
										<input type="radio" value="5" name="level">5星（极好）
									</td>
								</tr>
								<tr>
									<th colspan="2"><p>您的意见及建议(170字以内)：</p></th>
									<td colspan="5">
										<textarea value="好评！" maxlength="170"
											onblur="if (this.value == '') {this.value = '好评！';}" id="content" name="content">好评！</textarea>
									<input type="submit" value="点击提交" class="btn">
									</td>
								</tr>
								</tbody>
							</table>
							<input type="hidden" value="${commentMsg.orderId}" name="orderId">
							<input type="hidden" value="${orderNum}" name="orderNum">
						</form>
					</div>
					<br/>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</body>
</html>