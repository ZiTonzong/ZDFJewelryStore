<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ZDF.utils.PageUtil" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.ZDF.beans.Order" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="back/CSS/bootstrap.min.css" rel="stylesheet" />
    <link href="back/CSS/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" />
    <link href="back/CSS/font-awesome.css" rel="stylesheet" />
    
    <link href="back/CSS/adminia.css" rel="stylesheet" /> 
    <link href="back/CSS/adminia-responsive.css" rel="stylesheet" /> 
    
    
    <link href="back/CSS/pages/faq.css" rel="stylesheet" /> 
    
    <link rel="stylesheet" type="text/css" href="back/CSS/style.css" />
    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  </head>

<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="./">ZDFJewelryStore</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					<li>
						<a href="#"><span class="badge badge-warning">7</span></a>
					</li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							罗宾逊 <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="./account.html"><i class="icon-user"></i> 账号设置  </a>
							</li>
							
							<li>
								<a href="./change_password.html"><i class="icon-lock"></i> 修改密码</a>
							</li>
							
							<li class="divider"></li>
							
							<li>
								<a href="./"><i class="icon-off"></i> 退出</a>
							</li>
						</ul>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			
			<div class="span3">
				
				<div class="account-container">
				
					<div class="account-avatar">
						<img src="./img/headshot.png" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">罗宾逊</span>
						
						<span class="account-role">管理员</span>
						
						<span class="account-actions">
							<a href="javascript:;">资料</a> |
							
							<a href="javascript:;">编辑设置</a>
						</span>
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li>
						<a href="${pageContext.request.contextPath}/handleBackUser">
							<i class="icon-pushpin"></i>
							会员管理	
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/listProduct">
							<i class="icon-th-list"></i>
							商品管理		
						</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/handleBackAllOrders">
							<i class="icon-th-large"></i>
							订单管理
						</a>
					</li>
					
					<li>
						<a href="./charts.html">
							<i class="icon-signal"></i>
							修改密码
						</a>
					</li>
					
				</ul>	
				
				<hr />
				
				<div class="sidebar-extra">
					<p>这里是提示信息息文字这里是提示信息文字这里是提示信息文字这里是提示信息文字.</p>
				</div> <!-- .sidebar-extra -->
				
				<br />
		
			</div> <!-- /span3 -->
			
			
			
			<div class="span9">
				
				<h1 class="page-title">
					<i class="icon-pushpin"></i>
					订单管理					
				</h1>
				
				<div class="widget">
														
					<div class="widget-content">
					<form class="form-inline definewidth m20" action="#" method="get">
    订单编号：
    <input type="text" name="CriteriaOrderNum" id="orderNum" class="abc input-default" placeholder="" 
    value="${requestScope.CriteriaOrderNum}">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
	<button type="button" id="resetQuery" class="btn btn-inverse">重置</button>
</form>

<table style="table-layout:fixed;" class="table table-bordered table-hover definewidth m10">
    <c:if test="${empty requestScope.pager.data }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${not (empty requestScope.pager.data) }">
		<c:forEach items="${requestScope.pager.data}" var="dataMap" varStatus="vs">
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
				        <td class="orderNum">${dataMap.orderNum}</td>
				        <td>
				        	<fmt:formatDate value="${dataMap.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
				        </td>
				        <td>${dataMap.userId==null?"<font color='red'>账户不存在</font>":dataMap.userId}</td>
				        <td>
				        	<c:if test="${dataMap.visible eq 0}">
					        	已删除
					        </c:if>
				        	<c:if test="${dataMap.visible eq 1}">
				        	<button class="changeOrderStatus" type="button" 
				        	value="${dataMap.orderStatus}">
					        	<c:choose>
					        		<c:when test="${dataMap.orderStatus eq 0}"><font color='purple'>已下单</font></c:when>
					        		<c:when test="${dataMap.orderStatus eq 1}"><font color='red'>已付款</font></c:when>
					        		<c:when test="${dataMap.orderStatus eq 2}"><font color='blue'>发货成功</font></c:when>
					        		<c:when test="${dataMap.orderStatus eq 3}">已完成</c:when>
					        	</c:choose>
					        </button>
					        </c:if>
				        </td>
				        <td>${dataMap.totalPrice}</td>
				        <td>${dataMap.sendPlace }&nbsp;(${dataMap.sendMan}&nbsp;收)
				        &nbsp;${dataMap.sendPhone }</td>
				        <td><a class="deleteOneOrder nohref" href="#">删除</a>
				        </td>
			         </tr>
		            <tr>
		                <td rowspan="100">${dataMap.note}</td>
		                <th width="100px">商品名称</th>
		                <th>商品单价</th>
		                <th>购买数量</th>
		                <th>小计</th>
		                <th>评价内容</th>
		                <th>评分</th>
		            </tr>
		          	<c:forEach items="${dataMap.orderProducts}" var="orderBody" varStatus="vs">
			            <tr>
			                <td width="100px">
			                <div class="productName">
			                <a class="nohref" target="_blank" href="handleProductInfo?productId=${orderBody.productId}">
					${orderBody.productName}</a>
			                </div>
			                </td>
			                <td>${orderBody.productPrice}</td>
			                <td>${orderBody.saleCount}</td>
			                <td>${orderBody.productSubtotal}</td>
			                <td style="word-wrap:break-word;">${orderBody.content}</td>
			                <td>${orderBody.level==0?"":orderBody.level}</td>
			            </tr>
		          	</c:forEach>
			   </tbody>
		</c:forEach>
	</c:if>
        </table>

 <div class="inline pull-right page" >
			  总共【${pager.totalPage}】页 &nbsp;&nbsp;${pager.pageNo}/${pager.totalPage}&nbsp;&nbsp; 
                <a href="handleBackAllOrders?pageNo=1">首页</a> 
                <c:choose>
                    <c:when test="${requestScope.pager.pageNo > 1}">
                        <a href="handleBackAllOrders?pageNo=${pager.pageNo-1}">上一页</a>
                    </c:when>
                    <c:otherwise>
                                                          上一页
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${pager.pageNo < pager.totalPage}">
                        <a href="handleBackAllOrders?pageNo=${pager.pageNo+1}">下一页</a>
                    </c:when>
                    <c:otherwise>
                                                          下一页
                    </c:otherwise>
                </c:choose>
                  <a href="handleBackAllOrders?pageNo=${pager.totalPage}">尾页</a>
		</div>	
									
						
						
										
					</div> <!-- /widget-content -->
					
				</div> <!-- /widget -->
				
				
				
			</div> <!-- /span9 -->
			
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->
					
	
<div id="footer">
	
	<div class="container">				
		<hr />
		<p>&copy; 2018 ZDFJewelryStore.</p>
	</div> <!-- /container -->
	
</div> <!-- /footer -->


    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="back/js/jquery-1.7.2.min.js"></script>
<script src="back/js/bootstrap.js"></script>
<script src="back/js/faq.js"></script>

<script type="text/javascript" src="back/js/ckform.js"></script>
<script type="text/javascript" src="back/js/common.js"></script>
<script>

$(function () {
	
	$('.faq-list').goFaq ();
	
});

$(function () {
	/* //给a连接添加事件，将查询信息带上
	$("a").not(".nohref").click(function(){
		var href = this.href;
		var criteriaProduct = $("#orderNum").serialize();
		href = href + "&" +criteriaProduct;
		window.location.href = href;
		return false;
	}); */
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
		var url = "EditOrders";
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

  </body>
</html>