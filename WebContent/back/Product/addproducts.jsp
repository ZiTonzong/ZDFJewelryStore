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
					<form id="addProductsForm" action="${pageContext.request.contextPath}/addproductservlet"
 method="post" enctype="multipart/form-data" class="definewidth m20">
<%-- 
<input type="hidden" name="currPage" value="${param.currPage}" />
<input type="hidden" name="criteriaProductName" value="${param.criteriaProductName}" /> 
--%>
<table class="table table-bordered table-hover m10">
    <tr>
        <td rowspan="7" class="tableleft" width="10px" align="center">1</td>
        <td class="tableleft">名称</td>
        <td><input type="text" name="PRODUCT_NAME" value="" /></td>
    </tr>
     <tr>
    	<td class="tableleft">类别</td>
    	<td>
	        <input type="radio" name="CATEGORY_ID" value="1" checked/> 黑金
	        <input type="radio" name="CATEGORY_ID" value="2" /> 白银
	        <input type="radio" name="CATEGORY_ID" value="3" /> 黄金
	        <input type="radio" name="CATEGORY_ID" value="4" /> 白金
	        <input type="radio" name="CATEGORY_ID" value="5" /> 钻石
        </td> 
    </tr>
    <tr>
        <td class="tableleft">商品单价</td>
        <td><input onfocus="this.style.imeMode='disabled'" class='productPrice' type="text" name="PRODUCT_PRICE" value="" /></td>
    </tr>
    <tr>
        <td class="tableleft">库存</td>
        <td><input onfocus="this.style.imeMode='disabled'" class="storeNum" type="text" name="STORE_NUM" value="" /></td>
    </tr>
    <tr>
        <td class="tableleft">商品图片</td>
        <td><input type="file" name="PRODUCT_IMAGE_PATH" value="浏览"/></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td >
	        <input type="radio" name="PRODUCT_STATUS" value="1" checked/> 在售
	        <input type="radio" name="PRODUCT_STATUS" value="0" /> 下架
        </td>
    </tr>
    <tr>
        <td class="tableleft">描述</td>
        <td >
            <textarea rows="5" name="PRODUCT_DESC"></textarea>
        </td>
    </tr>
</table>
	<div align="center" id="btn">
        <button type="button" id="addProduct" class="btn btn-primary" type="button">新增附件</button> &nbsp;&nbsp;
        <button type="button" id="addProducts" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
</form>
        <a href="${pageContext.request.contextPath}/listProduct"><button type="button" class="btn btn-success" name="backid" id="backid">返回</button></a>
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
var i = 2;
var imgArr = [ "bmp", "jpg", "gif", "png" ];
$(function() {
	$("#backid").click(function(){
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
				$(this).parent("td").append("<font color='red'></br><i>请输入正确的商品价格,小数点后最多两位</i><font>")
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
	
	//保存商品添加事件
	$("#addProducts").click(function(){
		var flag = true;
		$("input").not(":hidden").each(function(){
			if($.trim($(this).val())==""){
				alert(this.class);
				alert("请完善商品信息");
				flag = false;
			}
		});
		if(flag){
			$("#addProductsForm").submit();
		}
	});
	//验证图片格式是否正确
	$("input:file").on("change",function() {
		if ($(this).val() == "") {
			alert("请选择商品图片");
		} else {
			var file = $(this).val();
			var len = file.length;
			var ext = file.substring(len - 3, len).toLowerCase();
			if ($.inArray(ext, imgArr) == -1) {
				alert("请选择图片格式的文件");
			} else {
				//alert("扩展名是：" + ext);
			}
		}
	});
	//新增加一个商品附件
	$("#addProduct").on("click",function(){
		$("#delAdjunctbtn"+(i-1)).hide();
		$("div#btn").before(
"<table class='adjunctTable table table-bordered table-hover m10'>"
	+"<tr>"
	+"<td rowspan='7' class='tableleft' width='10px' align='center'>"+i+"</td>"
	+"<td class='tableleft'>名称</td>"
	+"<td><input type='text' name='PRODUCT_NAME"+i+"'/></td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>类别</td>"
	+"<td >"
	+"<input type='radio' name='CATEGORY_ID"+i+"' value='1' checked='checked'/> 黑金"
	+"<input type='radio' name='CATEGORY_ID"+i+"' value='2' /> 白银"
	+"<input type='radio' name='CATEGORY_ID"+i+"' value='3' /> 黄金"
	+"<input type='radio' name='CATEGORY_ID"+i+"' value='4' /> 白金"
	+"<input type='radio' name='CATEGORY_ID"+i+"' value='5' /> 钻石"
	+"</td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>商品单价</td>"
	+"<td><input onfocus=\" this.style.imeMode='disabled' \" class='productPrice' type='text' name='PRODUCT_PRICE"+i+"'/></td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>库存</td>"
	+"<td><input onfocus=\" this.style.imeMode='disabled' \" class='storeNum' type='text' name='STORE_NUM"+i+"' /></td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>商品图片</td>"
	+"<td><input type='file' name='PRODUCT_IMAGE_PATH"+i+"'/></td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>状态</td>"
	+"<td >"
	+"<input type='radio' name='PRODUCT_STATUS"+i+"' value='1' checked='checked'/> 上架"
	+"<input type='radio' name='PRODUCT_STATUS"+i+"' value='0' /> 下架"
	+"</td>"
	+"</tr>"
	+"<tr>"
	+"<td class='tableleft'>描述</td>"
	+"<td >"
	+"<textarea rows='5' name='PRODUCT_DESC"+i+"'></textarea>"
	+"</td>"
	+"</tr>"
	+"<tr id='delAdjunctbtn"+i+"'>"
	+"<td class='tableleft'></td>"
	+"<td >"
	+"<button type='button' onclick='deleteAdjunct(this)' class='deleteAdjunct btn btn-success'>删除附件</button>"
	+"</td>"
	+"</tr>"
	+"</table>");
	i++;
		//if(i > 9){
			//$("#addProduct").hide();
		//}
	});
});
//删除一个商品附件的方法
function deleteAdjunct(obj){
	if(!confirm("确认删除此商品附件？")){
		return;
	}
	i--;
	//if(i <= 9){
	//	$("#addProduct").show();
	//}
	$(obj).parent("td").parent("tr").parent().parent("table.adjunctTable").remove();
	$("#delAdjunctbtn"+(i-1)).show();
	
}

		

</script>

  </body>
</html>