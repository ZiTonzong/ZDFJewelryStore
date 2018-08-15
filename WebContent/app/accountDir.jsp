<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ZDF_我的地址</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	.mycar-index{
		margin: 0 auto;
		width: 800px;
	}
	#cart-wrapper{
		width: 800px;
		height:330px;
	}
	#cart-wrapper table{
		width: 800px;
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
		padding-bottom:15px;
		padding-left: 2px;
	}
	.btn {
		padding:10px 30px;
		color: #FFF;
		cursor: pointer;
		background:#555;
		border:none;
		outline:none;
		font-family: 'Exo 2', sans-serif;
		font-size:1em;
		margin-left: 75%;
	}
	.btn:hover{
		background:#4CB1CA;
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
</style>
</head>
<body>
<div class="mycar-index">
<c:choose>
			<c:when test="${!(empty pager.data)}">
				<div id="cart-wrapper">
					<form action="app/accountDirTab.jsp">
						<table cellspacing="1.5">
							<thead>
								<tr>
									<th width="100px">序号</th>
									<th width="550px">收货地址</th>
									<th width="150px">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pager.data}" var="add" varStatus="statu">
									<tr>
										<td align="center">${statu.count+(pager.pageNo-1)*pager.pageSize}</td>
										<td>${add.sendPlace}&nbsp;&nbsp;(&nbsp;${add.sendMan}&nbsp;&nbsp;&nbsp;收&nbsp;)&nbsp;&nbsp;${add.sendPhone}</td>
										<td align="center"><a href="AddressServlet?method=deleteAddressById&addId=${add.addressId}" onclick="return confirm('您确定删除吗？');">删除</a>
											&nbsp;&nbsp;&nbsp;&nbsp;<a href="AddressServlet?method=getAddressById&addId=${add.addressId}">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div><br/></div>
						<%-- <c:if test="${pager.pageNo==pager.totalPage"> --%>
							<input type="submit" class="btn" value="添加收货地址">
						<%-- </c:if>  --%>
					</form>
				</div>
				<div><br/><br/><br/></div>
				<div align="center" id="page">
					 总共【${pager.totalPage}】页 &nbsp;&nbsp;${pager.pageNo}/${pager.totalPage}&nbsp;&nbsp; 
                <a href="AddressServlet?method=getAddressPager&pageNo=1">首页</a> 
                <c:choose>
                    <c:when test="${requestScope.pager.pageNo > 1}">
                        <a href="AddressServlet?method=getAddressPager&pageNo=${pager.pageNo-1}">上一页</a>
                    </c:when>
                    <c:otherwise>
                                                          上一页
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${pager.pageNo < pager.totalPage}">
                        <a href="AddressServlet?method=getAddressPager&pageNo=${pager.pageNo+1}">下一页</a>
                    </c:when>
                    <c:otherwise>
                                                          下一页
                    </c:otherwise>
                </c:choose>
                  <a href="AddressServlet?method=getAddressPager&pageNo=${pager.totalPage}">尾页</a></td>
				</div>
			</c:when>
			<c:otherwise>
				<div class="order-blank">
					您还没有填写收货地址信息，赶快<a href="app/accountDirTab.jsp"><font color="#555">点击添加</font></a>吧！
				</div>
			</c:otherwise>
		</c:choose>
</div>
</body>
</html>