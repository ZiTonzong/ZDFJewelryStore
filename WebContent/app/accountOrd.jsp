<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zdfjewelry_订单</title>
<link rel="shortcut icon" type="image/ico" href="<%=basePath%>app/img/favicon.ico"> 
<link href="<%=basePath %>app/css/style.css" rel="stylesheet" type="text/css" media="all" /> 
<style type="text/css">
	#accountOrd_table{
		border:1px solid gray;
	}
	.mycar-index{
		margin: 0 auto;
		width: 1200px;
	}
	#cart-wrapper{
		width: 1200px;
		/* height:330px; */
	}
	#cart-wrapper table{
		width: 1200px;
		border-left:1px solid #f5f5f5;
		border-right:1px solid #f5f5f5;
	}
	#cart-wrapper table th{
		background: #f5f5f5;
		height: 30px;
		text-align:center;
	}
	#cart-wrapper table td{
		border-bottom: 1px solid #f5f5f5;
		color: #333;
		height: 70px;
		font-size: 14px;
	}
	#page{
		color: #333;
		font-size: 14px;
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
		margin-left:10px;
		text-algin: left;
    }
</style>
</head>
<body>
<div class="mycar-index" id="cart-wrapper">
	<table  style="table-layout:fixed;" class="table table-bordered table-hover definewidth m10">
	 <thead>
				    <tr>
								<th width="100px">订单编号</th>
								<th width="400px">商品名称</th>
								<th width="125px">商品单价</th> 
								<th width="125px">数量</th>
								<th width="125px">订单合计</th>
								<th width="150px">备注</th>
								<th width="175px">操作</th>
					</tr>
			    </thead>
		
    <c:if test="${empty requestScope.pager.data }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${not (empty requestScope.pager.data) }">
	 <tbody>
		<c:forEach items="${requestScope.pager.data}" var="dataMap" varStatus="vs">
			 
			   
			    <c:if test="${fn:length(dataMap.orderProducts)==1}">
			        <tr>
				        <td align="center">${dataMap.orderNum}</td>
				       
				     <c:forEach items="${dataMap.orderProducts}" var="orderBody" varStatus="vs">
			            <td align="left">
			            
			            <a target="_blank" href="handleProductInfo?productId=${orderBody.productId}">
							<img src="${orderBody.productImagePath }"></a>
							<div class="pname"><a target="_blank" href="handleProductInfo?productId=${orderBody.productId}"> ${orderBody.productName}</a></div>
						</td>
						<td align="center">
						￥<fmt:formatNumber value="${orderBody.productPrice}" maxFractionDigits="2"></fmt:formatNumber>
						</td>
					    <td align="center">
						${orderBody.saleCount}
						</td>
						<td align="center">
						￥<fmt:formatNumber value="${orderBody.productPrice*orderBody.saleCount}" maxFractionDigits="2"></fmt:formatNumber>
						</td>
		          	</c:forEach>
		          	
		          	<td align="center">
							<c:if test="${!(empty dataMap.note)}">${dateMap.note}</c:if>
							<c:if test="${empty dateMap.note}">无</c:if>
					</td>
		          	<td align="center"><a href="OrderServlet?method=deleteOrderById&orderNum=${dataMap.orderNum}" onclick="return confirm('您确定删除吗？');">删除订单</a><br/>
							<c:if test="${dataMap.orderStatus==0}"><a target="_blank" href="OrderServlet?method=payment&orderNum=${dataMap.orderNum}"><font color="red">去付款</font></a></c:if>
							<c:if test="${dataMap.orderStatus==1}">待发货</c:if>
							<c:if test="${dataMap.orderStatus==2}"><a href="OrderServlet?method=receiveProduct&orderNum=${dataMap.orderNum}"><font color="red">确认收货</font></a></c:if>
							<c:if test="${dataMap.orderStatus==3}">
							 <c:forEach items="${dataMap.orderProducts}" var="product" begin="0" end="1">
							<c:if test="${product.level==0}"><a onclick="window.parent.location.href='app/comment.jsp?orderNum=${dataMap.orderNum}'"><font color="red">去评价</font></a></c:if>
							<c:if test="${product.level!=0}">已完成<br/><a onclick="window.parent.location.href='app/comment.jsp?orderNum=${dataMap.orderNum}'"><font color="red">查看评价</font></a></c:if>
							</c:forEach>
				         
				           </c:if>
				           </td>
				           </tr>
				      </c:if>
				           
						
						 <c:if test="${fn:length(dataMap.orderProducts)!=1}">
			        <tr>
				        <td align="center" rowspan="${fn:length(dataMap.orderProducts)}">
											${dataMap.orderNum}
						</td>
				       
				       <c:forEach items="${dataMap.orderProducts}" var="orderBody" varStatus="vs" begin="0" end="0">
			            
			            <td align="left">
			            <a target="_blank" href="handleProductInfo?productId=${orderBody.productId}">
							<img src="${orderBody.productImagePath }"></a>
							<div class="pname"><a target="_blank" href="handleProductInfo?productId=${orderBody.productId}"> ${orderBody.productName}</a></div>
						</td>
						<td align="center">
						￥<fmt:formatNumber value="${orderBody.productPrice}" maxFractionDigits="2"></fmt:formatNumber>
						</td>
					    <td align="center">
						${orderBody.saleCount}
						</td>
						<td align="center">
						￥<fmt:formatNumber value="${orderBody.productPrice*orderBody.saleCount}" maxFractionDigits="2"></fmt:formatNumber>
						</td>
						
		          	
		          	
		          	<td align="center">
							<c:if test="${!(empty dataMap.note)}">${dateMap.note}</c:if>
							<c:if test="${empty dateMap.note}">无</c:if>
					</td>
		          	<td align="center"><a href="OrderServlet?method=deleteOrderById&orderNum=${dataMap.orderNum}" onclick="return confirm('您确定删除吗？');">删除订单</a><br/>
							<c:if test="${dataMap.orderStatus==0}"><a target="_blank" href="OrderServlet?method=payment&orderNum=${dataMap.orderNum}"><font color="red">去付款</font></a></c:if>
							<c:if test="${dataMap.orderStatus==1}">待发货</c:if>
							<c:if test="${dataMap.orderStatus==2}"><a href="OrderServlet?method=receiveProduct&orderNum=${dataMap.orderNum}"><font color="red">确认收货</font></a></c:if>
							<c:if test="${dataMap.orderStatus==3}">
							
							 <c:forEach items="${dataMap.orderProducts}" var="product" begin="1" end="1">
							<c:if test="${product.level==0}"><a onclick="window.parent.location.href='app/comment.jsp?orderNum=${dataMap.orderNum}'"><font color="red">去评价</font></a></c:if>
							<c:if test="${product.level!=0}">已完成<br/><a onclick="window.parent.location.href='app/comment.jsp?orderNum=${dataMap.orderNum}'"><font color="red">查看评价</font></a></c:if>
							</c:forEach>
						</c:if>
					</td>
					</c:forEach>
			         </tr>
		            <c:forEach items="${dataMap.orderProducts}" var="product" begin="1" end="${fn:length(dataMap.orderProducts)-1}">
										<tr>
											<td align="left">
												<a target="_blank" href="handleProductInfo?productId=${product.productId}">
													<img src="${product.productImagePath }"></a>
												<div class="pname"><a target="_blank" href="handleProductInfo?productId=${product.productId}">${product.productName}</a></div>
											</td>
											<td align="center">
												￥<fmt:formatNumber value="${product.productPrice}" maxFractionDigits="2"></fmt:formatNumber>
											</td>
											<td align="center">
												${product.saleCount}
											</td>
											<td align="center">
												￥<fmt:formatNumber value="${product.productPrice*product.saleCount}" maxFractionDigits="2"></fmt:formatNumber>
											</td>
										</tr>
						</c:forEach>
		            
		          	</c:if>
		</c:forEach>
		 </tbody>
	</c:if>
        </table>

 <div class="inline page" align="center">
			<Br>
			<Br>
			<Br>
			  总共【${pager.totalPage}】页 &nbsp;&nbsp;${pager.pageNo}/${pager.totalPage}&nbsp;&nbsp; 
                <a href="OrderServlet?method=getOrderMsgs&pageNo=1">首页</a> 
                <c:choose>
                    <c:when test="${requestScope.pager.pageNo > 1}">
                        <a href="OrderServlet?method=getOrderMsgs&pageNo=${pager.pageNo-1}">上一页</a>
                    </c:when>
                    <c:otherwise>
                                                          上一页&nbsp;
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${pager.pageNo < pager.totalPage}">
                        <a href="OrderServlet?method=getOrderMsgs&pageNo=${pager.pageNo+1}">下一页</a>
                    </c:when>
                    <c:otherwise>
                                                          下一页
                    </c:otherwise>
                </c:choose>
                  <a href="OrderServlet?method=getOrderMsgs&pageNo=${pager.totalPage}">尾页</a>
		</div>	
		
	</div>
	<br/>
</body>
</html>