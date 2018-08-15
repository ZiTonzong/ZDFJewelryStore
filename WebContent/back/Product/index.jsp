<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ZDF.utils.PageUtil" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.ZDF.beans.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
 
     <link href="${pageContext.request.contextPath }/back/CSS/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/back/CSS/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/back/CSS/font-awesome.css" rel="stylesheet" />
    
    <link href="${pageContext.request.contextPath }/back/CSS/adminia.css" rel="stylesheet" /> 
    <link href="${pageContext.request.contextPath }/back/CSS/adminia-responsive.css" rel="stylesheet" /> 
    
    
    <link href="${pageContext.request.contextPath }/back/CSS/pages/faq.css" rel="stylesheet" /> 
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/back/CSS/style.css" />
    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style type="text/css">
    	table{
	overflow: auto;
	overflow-x:auto;
}
table tbody tr td.checkedtd{
	min-width: 5px;
}
table tbody tr td.PRODUCT_NAME a:link, a:visited, a:active {
    text-decoration: none;
}
table tbody tr td.PRODUCT_NAME a:hover { color: #D93600; text-decoration: none;}
table tbody tr td.PRODUCT_NAME a {
    outline: medium none;
    text-decoration: none;
	display: block;
	color: #333;
	font-size: 16px;
	line-height: 18px;
	margin-left: 5px;
	text-overflow: ellipsis;
	width: 200px;
	height: 36px;
	overflow: hidden;
}


#checkedAllProduct {
    display: block;
    float: left;
    margin: 4px 0 5px 33px;
    width: 0;
}
.changePRODUCT_STATUS{
	background-color: white;
	border: 0px solid white;
}


body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
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
					商品管理					
				</h1>
				
				<div class="widget">
														
					<div class="widget-content">
					<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/listProduct?
		findPRODUCT_NAME = findPRODUCT_NAME & findCATEGORY_ID = findCATEGORY_ID" method="post">
	<!-- 名称输入 -->
		商品名称关键字： <input type="text" name="findPRODUCT_NAME" id="findNAME"
			class="abc input-default" value="${findPRODUCT_NAME}">&nbsp;&nbsp;
	<!-- 分类选择 -->
		<select id="findCATEGORY_ID" name="findCATEGORY_ID">
			<option value=${findCATEGORY_ID}>
				<c:choose>  
   					<c:when test="${findCATEGORY_ID==1}">玉石</c:when>
   					<c:when test="${findCATEGORY_ID==2}">白银</c:when>  
   					<c:when test="${findCATEGORY_ID==3}">黄金</c:when>  
   					<c:when test="${findCATEGORY_ID==4}">白金</c:when>  
   					<c:when test="${findCATEGORY_ID==5}">钻石</c:when>  
   					<c:otherwise>--请选择查看类别--</c:otherwise>
				</c:choose> 
			</option>
			<option value="1">黑铁</option>
			<option value="2">白银</option>
			<option value="3">黄金</option>
			<option value="4">白金</option>
			<option value="5">钻石</option>
		</select>&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
			&nbsp;&nbsp;
		<button type="button" id="resetQuery" class="btn btn-inverse">重置</button>
			&nbsp;&nbsp;
		<button type="button"class="btn btn-success" id="addproducts">添加商品</button>
	</form>

	<form action="" method="post">
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<!-- <th></th> -->
				<th>序号</th>
				<th>商品代码</th>
				<th>商品图片</th>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>库存</th>
				<th>销量</th>
				<th>销售额</th>
				<th>综合评分</th>
				<th>状态(点击修改状态)</th>
				<th style="min-width: 70px">编辑</th>
			</tr>
		</thead>
		<c:if test="${empty listss }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
		</c:if>
		<c:if test="${not (empty listss)}">
		<tbody>
			<c:forEach items="${listss}" var="product" varStatus="vs">
				<tr>
					<!-- 递增的序号 -->
					<td style="min-width: 30px">
						${vs.count +(requestScope.pager.currPage - 1) * (requestScope.pager.pageSize) }
					</td>
					<!-- 商品id -->
					<td class="checkedtd">
						<input class="checkedProduct" type="hidden" name="productId" 
						value="${product.productId}">
						${product.productId}
					</td>
					<!-- 商品图片 -->
					<td>
						<a class="nohref" target="_blank" href="/ZDFJewelryStore_Demo/${product.productImagePath }?PRODUCT_ID=${product.productId }">
							<img src="/ZDFJewelryStore_Demo/${product.productImagePath }" style="cursor: pointer;height: 40px;width: 40px" >
						</a>
					</td>
					<!-- 商品名称 -->
					<td class="productName">
						<a class="nohref" target="_blank" href="${pageContext.request.contextPath }/edit?PRODUCT_ID=${product.productId}">
							${product.productName}
						</a>
					</td>
					<!-- 商品单价 -->
					<td>
						${product.productPrice}
					</td>
					<!-- 库存 -->
					<td>
						${product.storeNum}
					</td>				
					
<%-- 				<td>${product.sales==0?"":product.sales}</td>
					<td>${product.salesAmount==0.0?"":product.salesAmount}</td>
					<td>${product.levelStatistic==null?'5.0':product.levelStatistic}</td>
		 --%>
		 			<td>${"12" }</td>
		 			<td>${"888" }</td>
		 			<td>${"5" }</td>
		 			<!-- 状态 -->
					<td>
						<button class="changePRODUCT_STATUS" type="button" value="${product.productStatus}">
							${product.productStatus==0?'<font color="red">已下架</font>':'<font color="blue">在售</font>'}
						</button>
					</td>
					<!-- 编辑  -->
					<td>
						<a href="${pageContext.request.contextPath}/editProduct?PRODUCT_ID=${product.productId}&pageNos=${pageNos}">编辑</a>&nbsp;/&nbsp;
						<a class="deleteOneProduct nohref" id="shanchu" href="${pageContext.request.contextPath}/deleteProduct?PRODUCT_ID=${product.productId}&pageNos=${pageNos}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
	</form>

	<div align="center">
		<br>
		<c:if test="${pageNos>1 }">
			<a href="listProduct?pageNos=1&findCATEGORY_ID=${findCATEGORY_ID}" >首页</a>
			<a href="listProduct?pageNos=${pageNos-1 }&findCATEGORY_ID=${findCATEGORY_ID}">上一页</a>
		</c:if>
		<c:if test="${pageNos <recordCount }">
			<a href="listProduct?pageNos=${pageNos+1 }&findCATEGORY_ID=${findCATEGORY_ID}">下一页</a>
			<a href="listProduct?pageNos=${recordCount }&findCATEGORY_ID=${findCATEGORY_ID}">末页</a>
		</c:if>
		
		<form method="post" action="${pageContext.request.contextPath}/listProduct?
		findPRODUCT_NAME=${findPRODUCT_NAME}&findCATEGORY_ID=${findCATEGORY_ID}">
		<h4 align="center">共${recordCount}页  
			<input type="text" value="${pageNos}" name="pageNos" size="1">页
			<input class="btn" type="submit" value="跳转">
		</h4>
		</form>
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
<script src="${pageContext.request.contextPath }/back/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath }/back/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/back/js/faq.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/ckform.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/common.js"></script>
<script>

$(function () {
	
	$('.faq-list').goFaq ();
	
});

$(function() {
		 //为checkbox添加事件
	$(".checkedProduct").click(function(){
		var cbl = $(".checkedProduct").length;//.checkedProduct的长度
		$("#checkedAllProduct").prop("checked",$(".checkedProduct:checked").length==cbl);
	});
	$("#checkedAllProduct").click(function(){
		$(".checkedProduct").prop("checked",this.checked);
	});
	$("#resetQuery").click(function(){
		window.location.href = "${pageContext.request.contextPath}/listProduct";
	});
	$("#deleteCheckedProduct").click(function(){
		var cbl = $(".checkedProduct:checked").length;
		if(cbl <= 0){
			alert("请选择要操作的商品！");
			return false;
		}
		if(!confirm("确认删除选中的商品吗？")){
			return false;
		}
		var href = this.href;
		var Product = $(".checkedProduct").serialize();
		href = href + "&" +checkedProduct;
		var Product = $("#PRODUCT_NAME").serialize();
		href = href + "&" +criteriaProduct;
		window.location.href = href;
		//alert(href);
		return false;
	});   
	//删除某一件商品
	$("#shanchu").click(function (){
		var href = this.href;
		if(confirm("确认删除该商品吗？")){
			window.location.href = href;
		} 
		return false; 
	});
	 $('#addproducts').click(function() {
		var Product = $("#PRODUCT_NAME").serialize();
		var pageNos = 2;
		window.location.href = "${pageContext.request.contextPath}/back/Product/addproducts.jsp";
	}); 
		//给a连接添加事件，将查询信息带上
	$("a").not(".nohref").click(function(){
		var href = this.href;
		var Product = $("#PRODUCT_NAME").serialize();
		if(Product!=null){
			//href = href + "&" +Product;
		}
		window.location.href = href;
		return false;
	});
	$("button.changePRODUCT_STATUS").click(function(){
		if($(this).val()==1){
			$(this).html("<font color='red'>已下架</font>");
			$(this).val(0);
		}else {
			$(this).html("<font color='blue'>在售</font>");
			$(this).val(1);
		}
		var PRODUCT_STATUS = $(this).val();
		var PRODUCT_ID = $(this).parent("td").siblings().children(".checkedProduct").val();
		var json = {"PRODUCT_STATUS":PRODUCT_STATUS,"PRODUCT_ID":PRODUCT_ID};
		var url = "changePRODUCT_STATUS";
		$.post(url,json,'json');
	});
});

</script>

  </body>
</html>