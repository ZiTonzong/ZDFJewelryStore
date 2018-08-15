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
<title>会员管理</title>
 
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
    	#checkedAllUser {
		    display: block;
		    float: left;
		    margin: 4px 0 5px 33px;
		    width: 0;
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
					会员管理					
				</h1>
				
				<div class="widget">
														
					<div class="widget-content">
					<form id="queryUserForm" class="form-inline definewidth m20" action="${pageContext.request.contextPath}
/back/User/queryUsers.bg" method="post">    
  &nbsp;&nbsp;&nbsp;&nbsp;  用户名称：
    <input type="text" name="username" id="username" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.username}">&nbsp;&nbsp;  
  真实姓名：
    <input type="text" name="truename" id="truename" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.truename}"><br>&nbsp;&nbsp;&nbsp;&nbsp;  
    电&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; 话：
    <input type="text" name="phone" id="phone" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.phone}">&nbsp;&nbsp;  
    地&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; 址：
    <input type="text" name="address" id="address" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.address}">&nbsp;&nbsp;  
    <br/>
    <div class="inline pull-right page">
	    <button type="submit" id="queryUser" class="btn btn-primary">查询</button>&nbsp;&nbsp;
		<button type="button" id="resetQuery" class="btn btn-inverse">重置</button>&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div class="inline pull-left page"><br/>&nbsp;&nbsp;</div>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>用户id</th>
        <th>用户名称</th>
        <th>真实姓名</th>
        <th>电话</th>
        <th>地址</th>
        <th>状态</th>
        <th>编辑</th>
    </tr>
    </thead>
    <c:if test="${empty requestScope.pager.data }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${not (empty requestScope.pager.data)}">
    <tbody>
    	<c:forEach items="${requestScope.pager.data}" var="user" varStatus="vs">
    	 <tr>
            <td>${vs.count +(requestScope.pager.pageNo - 1) * (requestScope.pager.pageSize) }</td>
            <td class="userId">${user.userId}</td>
            <td class="username">${user.userName}</td>
            <td>${user.trueName}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
            <td>
            	${user.userStatus==0?'<font color="red">已禁用</font>':'启用'}
            </td>
            <td>
                <a href="/ZDFJewelryStore_Demo/handleBackEditUser?userId=${user.userId}&pageNo=${requestScope.pager.pageNo}">修改</a>
            </td>
        </tr>
        </c:forEach>
      </c:if>	
    </tbody>
</table>
 <div class="inline pull-right page" >
			  总共【${pager.totalPage}】页 &nbsp;&nbsp;${pager.pageNo}/${pager.totalPage}&nbsp;&nbsp; 
                <a href="handleBackUser?pageNo=1">首页</a> 
                <c:choose>
                    <c:when test="${requestScope.pager.pageNo > 1}">
                        <a href="handleBackUser?pageNo=${pager.pageNo-1}">上一页</a>
                    </c:when>
                    <c:otherwise>
                                                          上一页
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${pager.pageNo < pager.totalPage}">
                        <a href="handleBackUser?pageNo=${pager.pageNo+1}">下一页</a>
                    </c:when>
                    <c:otherwise>
                                                          下一页
                    </c:otherwise>
                </c:choose>
                  <a href="handleBackUser?pageNo=${pager.totalPage}">尾页</a>
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

</script>

  </body>
</html>