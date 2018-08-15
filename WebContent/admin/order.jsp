<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/ckform.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<style type="text/css">
    	.changeOrderStatus{
			background-color: white;
			border: 0px solid white;
		}
    	div.productName{
    		width: auto;
    		font-size: 16px;
			line-height: 18px;
			text-overflow: ellipsis;
			white-space: nowrap;
			overflow: hidden;
    	}
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
        
    </style>
    <script>
    $(function () {
    	//给a连接添加事件，将查询信息带上
		$("a").not(".nohref").click(function(){
			var href = this.href;
			var criteriaProduct = $("#orderNum").serialize();
			href = href + "&" +criteriaProduct;
			window.location.href = href;
			return false;
		});
		$("#resetQuery").click(function(){
			$("#orderNum").val("");
		});
		//改变订单状态
		$("button.changeOrderStatus").click(function(){
			if($(this).val()==1){
				$(this).html("<font color='blue'>发货成功</font>");
				$(this).val(2);
			}else {
				return;
			}
			var orderStatus = $(this).val();
			var orderNum = $(this).parent("td").siblings(".orderNum").text();
			var json = {"orderStatus":orderStatus,"orderNum":orderNum};
			var url = "changeOrderStatus.bg";
			$.post(url,json,'json');
		});
		//删除某一个订单
		$(".deleteOneOrder").click(function(){
			var href = this.href;
			var criteriaProduct = $("#orderNum").serialize();
			href = href + "&" +criteriaProduct;
			if(confirm("确认删除该订单吗？")){
				window.location.href = href;
			}
			return false;
		});

		//$("body").css({"padding-bottom":"80px"});
    });
    
    $(window).resize(function() {
    	//$("body").css({"padding-bottom":"80px"});
    });
	
</script>
</head>
<body>
<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/back/Order/queryOrders.bg" method="get">
    订单编号：
    <input type="text" name="CriteriaOrderNum" id="orderNum" class="abc input-default" placeholder="" value="${requestScope.CriteriaOrderNum}">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<button type="button" id="resetQuery" class="btn btn-inverse">重置</button>
</form>
<table style="table-layout:fixed;" class="table table-bordered table-hover definewidth m10">
    <c:if test="${empty requestScope.pager.pageDataMap }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${not (empty requestScope.pager.pageDataMap) }">
		<c:forEach items="${requestScope.pager.pageDataMap}" var="dataMap" varStatus="vs">
			  <thead>
				    <tr>
				        <th width="150px">订单编号/备注</th>
				        <th>成交时间</th>
				        <th>会员账户</th>
				        <th width="80px">订单状态</th>
				        <th width="80px">成交总价</th>
				        <th>送货信息</th>
				        <th width="60px">操作</th>
				    </tr>
			    </thead>
			    <tbody>
			        <tr>
				        <td class="orderNum">${dataMap.key.orderNum}</td>
				        <td>
				        	<fmt:formatDate value="${dataMap.key.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
				        </td>
				        <td>${dataMap.key.username==null?"<font color='red'>账户不存在</font>":dataMap.key.username}</td>
				        <td>
				        	<c:if test="${dataMap.key.visible eq 0}">
					        	已删除
					        </c:if>
				        	<c:if test="${dataMap.key.visible eq 1}">
				        	<button class="changeOrderStatus" type="button" 
				        	value="${dataMap.key.orderStatus}">
					        	<c:choose>
					        		<c:when test="${dataMap.key.orderStatus eq 0}"><font color='purple'>已下单</font></c:when>
					        		<c:when test="${dataMap.key.orderStatus eq 1}"><font color='red'>已付款</font></c:when>
					        		<c:when test="${dataMap.key.orderStatus eq 2}"><font color='blue'>发货成功</font></c:when>
					        		<c:when test="${dataMap.key.orderStatus eq 3}">已完成</c:when>
					        	</c:choose>
					        </button>
					        </c:if>
				        </td>
				        <td>${dataMap.key.totalPrice}</td>
				        <td>${dataMap.key.sendPlace }&nbsp;(${dataMap.key.sendMan}&nbsp;收)
				        &nbsp;${dataMap.key.sendPhone }</td>
				        <td><a class="deleteOneOrder nohref" 
				        href="${pageContext.request.contextPath}/back/Order/deleteOrderByNum.bg?orderNum=${dataMap.key.orderNum }&currPage=${requestScope.pager.currPage}">删除</a>
				        </td>
			         </tr>
		            <tr>
		                <td rowspan="100">${dataMap.key.note}</td>
		                <th width="100px">商品名称</th>
		                <th>商品单价</th>
		                <th>购买数量</th>
		                <th>小计</th>
		                <th>评价内容</th>
		                <th>评分</th>
		            </tr>
		          	<c:forEach items="${dataMap.value}" var="orderBody" varStatus="vs">
			            <tr>
			                <td width="100px">
			                <div class="productName">
			                <a class="nohref" target="_blank" href="${pageContext.request.contextPath }/getProduct.do?
					productid=${orderBody.productId}">
					${orderBody.productName}</a>
			                </div>
			                </td>
			                <td>${orderBody.productPrice}</td>
			                <td>${orderBody.saleCount}</td>
			                <td>${orderBody.subtotal}</td>
			                <td style="word-wrap:break-word;">${orderBody.content}</td>
			                <td>${orderBody.level==0?"":orderBody.level}</td>
			            </tr>
		          	</c:forEach>
			   </tbody>
		</c:forEach>
	</c:if>
        </table>

 <div class="inline pull-right page" >
			${requestScope.pager.dataCount}条记录${requestScope.pager.currPage}/
			${requestScope.pager.pageCount} 页 
				<c:if test="${requestScope.pager.currPage == 1 }">
					<a class="nohref">首页</a><a class="nohref">上一页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage > 1 }">
					<a href="${pageContext.request.contextPath}/back/Order/queryOrders.bg?
					currPage=1">首页</a>
					<a href="${pageContext.request.contextPath}/back/Order/queryOrders.bg?
					currPage=${requestScope.pager.currPage - 1 }">上一页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage == requestScope.pager.pageCount }">
					<a class="nohref">下一页</a>
					<a class="nohref">尾页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage < requestScope.pager.pageCount }">
					<a href="${pageContext.request.contextPath}/back/Order/queryOrders.bg?
					currPage=${requestScope.pager.currPage + 1 }">下一页</a>
					<a href="${pageContext.request.contextPath}/back/Order/queryOrders.bg?
					currPage=${requestScope.pager.pageCount }">尾页</a>
				</c:if>
		</div>
</body>
</html>
