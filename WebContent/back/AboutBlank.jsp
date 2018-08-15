<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ZDF.beans.Product" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link href="view/dist/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
    	request.getRequestDispatcher("/handleBackIndex").forward(request, response);
    %>
</body>
</html>