<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script type="text/javascript">
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
		+"<td><input type='text' name='productName"+i+"'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td class='tableleft'>商品单价</td>"
		+"<td><input onfocus=\" this.style.imeMode='disabled' \" class='productPrice' type='text' name='productPrice"+i+"'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td class='tableleft'>库存</td>"
		+"<td><input onfocus=\" this.style.imeMode='disabled' \" class='storeNum' type='text' name='storeNum"+i+"' /></td>"
		+"</tr>"
		+"<tr>"
		+"<td class='tableleft'>商品图片</td>"
		+"<td><input type='file' name='productImagePath"+i+"'/></td>"
		+"</tr>"
		+"<tr>"
		+"<td class='tableleft'>状态</td>"
		+"<td >"
		+"<input type='radio' name='productStatus"+i+"' value='1' checked='checked'/> 上架"
		+"<input type='radio' name='productStatus"+i+"' value='0' /> 下架"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td class='tableleft'>描述</td>"
		+"<td >"
		+"<textarea rows='5' name='productDesc"+i+"'></textarea>"
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
</head>
<body>
<form id="addProductsForm" action="${pageContext.request.contextPath}/back/Product/addProducts.bg"
 method="post" enctype="multipart/form-data" class="definewidth m20">
<input type="hidden" name="currPage" value="${param.currPage}" />
<input type="hidden" name="criteriaProductName" value="${param.criteriaProductName}" />
<table class="table table-bordered table-hover m10">
    <tr>
        <td rowspan="6" class="tableleft" width="10px" align="center">1</td>
        <td class="tableleft">名称</td>
        <td><input type="text" name="productName1" value="" /></td>
    </tr>
    <tr>
        <td class="tableleft">商品单价</td>
        <td><input onfocus="this.style.imeMode='disabled'" class='productPrice' type="text" name="productPrice1" value="" /></td>
    </tr>
    <tr>
        <td class="tableleft">库存</td>
        <td><input onfocus="this.style.imeMode='disabled'" class="storeNum" type="text" name="storeNum1" value="" /></td>
    </tr>
    <tr>
        <td class="tableleft">商品图片</td>
        <td><input type="file" name="productImagePath1" value="浏览"/></td>
    </tr>
    <tr>
        <td class="tableleft">状态</td>
        <td >
	        <input type="radio" name="productStatus1" value="1" checked/> 上架
	        <input type="radio" name="productStatus1" value="0" /> 下架
        </td>
    </tr>
     <tr>
        <td class="tableleft">描述</td>
        <td >
            <textarea rows="5" name="productDesc1"></textarea>
        </td>
    </tr>
</table>
	<div align="center" id="btn">
        <button type="button" id="addProducts" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
        <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
	</div>
</form>
</body>
</html>