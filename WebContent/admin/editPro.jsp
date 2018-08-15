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
<form action="${pageContext.request.contextPath}/back/Product/editProduct.bg" method="post"
 enctype="multipart/form-data" class="definewidth m20">
<!-- <input type="hidden" name="id" value="{$menu.id}" /> -->
<input type="hidden" name="currPage" value="${param.currPage}" />
<input type="hidden" name="criteriaProductName" value="${param.criteriaProductName}" />
<input type="hidden" name="productId1" value="${requestScope.product.productId}" />
<table class="table table-bordered table-hover m10">
    <tr>
        <td class="tableleft">名称</td>
        <td><input type="text" name="productName1" value="${requestScope.product.productName}" /></td>
    </tr>
    <tr>
        <td class="tableleft">商品单价</td>
        <td><input class="productPrice" type="text" name="productPrice1" 
        value="${requestScope.product.productPrice}" /></td>
    </tr>
    <tr>
        <td class="tableleft">库存</td>
        <td><input class="storeNum" type="text" name="storeNum1" 
        value="${requestScope.product.storeNum}" /></td>
    </tr>
    <tr>
        <td class="tableleft">商品图片</td>
        <td>
        <input type="file" name="productImagePath1" value="" />
        <input type="hidden" name="oldProductImagePath" 
        value="${requestScope.product.productImagePath }">
        </td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td >
        	<c:if test="${requestScope.product.productStatus==1 }">
	            <input type="radio" name="productStatus1" value="1" checked/> 上架
	           <input type="radio" name="productStatus1" value="0" /> 下架
        	</c:if>
        	<c:if test="${requestScope.product.productStatus==0 }">
	            <input type="radio" name="productStatus1" value="1" /> 上架
	           <input type="radio" name="productStatus1" value="0" checked /> 下架
        	</c:if>
        </td>
    </tr>
     <tr>
        <td class="tableleft">描述</td>
        <td >
            <textarea rows="5" name="productDesc1">${requestScope.product.productDesc }</textarea>
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" id="editProductSubmit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/back/Product/queryProducts.bg?"
				+"currPage=${param.currPage}&criteriaProductName=${param.criteriaProductName}";
		 });
		//验证输入的价格格式
		$("body").on({
			keydown:function(event) {
				var kCode = event.which;
				// 判断键值
				if (((kCode > 47) && (kCode < 58))
						|| ((kCode > 95) && (kCode < 106)) || (kCode == 8)
						|| (kCode == 39) || (kCode == 37) ||(kCode == 190)) {
					return true;
				} else {
					return false;
				}
			},
			blur:function() {
				var reg = /^([1-9]\d*|0)(\.\d{1,2})?$/;
				var bool = reg.test($(this).val());
				$(this).parent("td").children("font").remove();
				if(!bool){
					$(this).parent("td").append(
							"<font color='red'></br><i>请输入正确的商品价格,小数点后最多两位</i><font>")
				}
			}
		},".productPrice");
		//验证输入的库存数量格式
		$("body").on({
			keydown:function(event) {
				var kCode = event.which;
				// 判断键值
				if (((kCode > 47) && (kCode < 58))
						|| ((kCode > 95) && (kCode < 106)) || (kCode == 8)
						|| (kCode == 39) || (kCode == 37)) {
					return true;
				} else {
					return false;
				}
			},
			blur:function() {
				var reg = /^\d+$/;
				var bool = reg.test($(this).val());
				$(this).parent("td").children("font").remove();
				if(!bool){
					$(this).parent("td").append("<font color='red'></br><i>商品库存只能为非负的整数</i><font>")
				}
			}
		},".storeNum");

    });
</script>