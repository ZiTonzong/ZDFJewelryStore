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
 
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
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
      table tbody tr td.productName a:link, a:visited, a:active {
    text-decoration: none;
	}
	table tbody tr td.productName a:hover { color: #D93600; text-decoration: none;}
	table tbody tr td.productName a {
	    color: #333;
	    outline: medium none;
	    text-decoration: none;
		display: block;
		color: #333;
		font-size: 16px;
		line-height: 18px;
		margin-left: 0px;
		text-overflow: ellipsis;
		white-space: nowrap;
		width: 450px;
		overflow: hidden;
		text-align: left;
	}
        body {
            padding-bottom: 40px;
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
					商品管理					
				</h1>
				
				<div class="widget">
														
					<div class="widget-content">
					<form action="/listProduct" method="post" class="definewidth m20">
<!-- <input type="hidden" name="id" value="{$menu.id}" /> -->
<table class="table table-bordered table-hover m10">
    <%-- <c:forEach items="${product}" var="product" varStatus="vs"> --%>
    <tr>
    	<td rowspan="7" width="10px" class="tableleft">${vs.count}</td>
        <td class="tableleft">名称</td>
        <td class="productName"><a target="_blank" href="${pageContext.request.contextPath }/getProduct.do?
					productid=${product.productId}">
					${product.productName}</a></td>
    </tr>
    <tr>
        <td class="tableleft">商品分类</td>
		<td>
			<c:if test="${product.categoryId==1}">黑金</c:if>
			<c:if test="${product.categoryId==2}">白银</c:if>
			<c:if test="${product.categoryId==3}">黄金</c:if>
			<c:if test="${product.categoryId==4}">白金</c:if>
			<c:if test="${product.categoryId==5}">钻石</c:if>
		</td>
    </tr>
    <tr>
        <td class="tableleft">商品单价</td>
        <td>${product.productPrice}</td>
    </tr>
    <tr>
        <td class="tableleft">库存</td>
        <td>${product.storeNum}</td>
    </tr>
    <tr>
        <td class="tableleft">商品图片</td>
        <td><a target="_blank" href="../${product.productImagePath }?
					productid=${product.productId }">
					<img src="${product.productImagePath }" 
					style="cursor: pointer;" 
					height="100" width="100"></a>
        </td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td >
        	${product.productStatus==1?'在售':'已下架'}
        </td>
    </tr>
     <tr>
        <td class="tableleft">描述</td>
        <td >
            ${product.productDesc}
        </td>
    </tr>
    <%-- </c:forEach> --%>
    <tr>
        <td class="tableleft"></td>
        <td colspan="2">
            <button type="button" class="btn btn-success" name="backid" id="backid">返回商品列表</button>
        </td>
    </tr>
</table>
</form>

	
									
						
						
										
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
	$('#backid').click(function(){
		window.location.href="${pageContext.request.contextPath}/listProduct";
	 });
});
		

</script>

  </body>
</html>