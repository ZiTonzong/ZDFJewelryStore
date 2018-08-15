<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	$(function() {
		
		$("#resetQuery").click(function(){
			$("input:text").val("");
		});
		//给a连接添加事件 带上查询信息
		$("a").not(".nohref").click(function(){
			var href = this.href;
			var criteriaUser = $(".CriteriaUser").serialize();
			href = href + "&" +criteriaUser;
			window.location.href = href;
			return false;
		});
	});
</script>
</head>
<body>
<form id="queryUserForm" class="form-inline definewidth m20" action="${pageContext.request.contextPath}
/back/User/queryUsers.bg" method="post">    
  &nbsp;&nbsp;&nbsp;&nbsp;  用户名称：
    <input type="text" name="username" id="username" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.username}">&nbsp;&nbsp;  
  真实姓名：
    <input type="text" name="truename" id="truename" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.truename}">&nbsp;&nbsp;  
    电话：
    <input type="text" name="phone" id="phone" class="CriteriaUser abc input-default" 
    placeholder="" value="${requestScope.criteria.phone}">&nbsp;&nbsp;  
    地址：
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
    <c:if test="${empty requestScope.pager.pageDataList }">
		<tbody>
			<tr>
				<td colspan="7">没有数据</td>
			</tr>
		</tbody>
	</c:if>
	<c:if test="${not (empty requestScope.pager.pageDataList)}">
    <tbody>
    	<c:forEach items="${requestScope.pager.pageDataList}" var="user" varStatus="vs">
    	 <tr>
            <td>${vs.count +(requestScope.pager.currPage - 1) * (requestScope.pager.pageSize) }</td>
            <td class="userId">${user.userId}</td>
            <td class="username">${user.username}</td>
            <td>${user.truename}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
            <td>
            	${user.userStatus==0?'<font color="red">已禁用</font>':'启用'}
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/back/User/toEditUser.bg?userId=${user.userId}&currPage=${requestScope.pager.currPage}">修改</a>
            </td>
        </tr>
        </c:forEach>
      </c:if>	
    </tbody>
</table>
	<div class="inline pull-right page">
			${requestScope.pager.dataCount} 条记录${requestScope.pager.currPage}/
			${requestScope.pager.pageCount} 页 
				<c:if test="${requestScope.pager.currPage == 1 }">
					<a class="nohref">首页</a><a class="nohref">上一页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage > 1 }">
					<a href="${pageContext.request.contextPath}/back/User/queryUsers.bg?currPage=1">
					首页</a>
					<a href="${pageContext.request.contextPath}/back/User/queryUsers.bg?
					currPage=${requestScope.pager.currPage - 1 }">上一页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage == requestScope.pager.pageCount }">
					<a class="nohref">下一页</a>
					<a class="nohref">尾页</a>
				</c:if>
				<c:if test="${requestScope.pager.currPage < requestScope.pager.pageCount }">
					<a href="${pageContext.request.contextPath}/back/User/queryUsers.bg?
					currPage=${requestScope.pager.currPage + 1 }">下一页</a>
					<a href="${pageContext.request.contextPath}/back/User/queryUsers.bg?
					currPage=${requestScope.pager.pageCount }">尾页</a>
				</c:if>
		</div>
</body>
</html>