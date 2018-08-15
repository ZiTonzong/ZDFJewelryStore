<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ZDFjewelry_服务协议</title>
<link rel="shortcut icon" type="image/ico" href="img/favicon.ico"> 
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/jquery1.min.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="../js/jquery.easydropdown.js"></script>
</head>
<body>
<!-- 每个页面均以这样的方式包含 header 提交到servlet的地址（即request.getServletPath()获得到的地址） 是以.jsp结尾的 -->
	<jsp:include page='header.jsp' flush="true"></jsp:include>
<!-- 在baseServlet中加判断当请求的地址是以.jsp结尾时 调用方法 responseHeaderInfo;目前没有找到更好的解决方法-->
    <div class="login">
     <div class="wrap">
	    <ul class="breadcrumb breadcrumb__t"><a class="home" href="AboutBlank.jsp">主页</a>  / 服务协议</ul>
		<h5 class="m_6">服务协议</h5>	
		<p class="m_text">甲乙双方就深圳市钟大福珠宝有限公司的“钟大福珠宝”服务协议一事，经友好协商一致同意在公平诚信的原则下同意本合同：</p>
		<ul class="delivery-list">
			<li><a href="#">1.甲方为乙方提供一年的保修服务(时间从产品销售给顾客之日起计算)，不提供退货服务，乙方对消费者附加的承<br>
			诺由乙方自行兑现。</a></li>
			<li><a href="#">2.乙方在收到货物后的七日内，应及时对产品进行验收，发现非运输过程中造成的损坏(不包括包装破损，产品淋湿<br>
			等)或存在质量问题的属开箱不良.开箱不良的产品乙方应先进行维修(维修费用由甲方承担)，维修不了的，经甲方确认，可以申请退货，<br>
			运费由甲方承担。</a></li>
			<li><a href="#">3.乙方将甲方的产品销售给顾客后的十五日内(销售日期以产品回执单和销售发票为准)，产品出现质量问题的，<br>
			属品质不良.品质不良的产品，乙方应先进行维修(维修费用由甲方承担)，维修不了的，经甲方确认，也可以申请退货，运费由甲方承担。</a></li>
			<li><a href="#">4.除上述开箱不良或品质不良的情况外，在保修期内的所有退货或返修货的返回运费、产品翻新配件费均由乙方承担，<br>
			并从乙方专项维修费用中扣除。产品修理完毕后返回乙方的运费由甲方承担。</a></li>
			<li><a href="#">5.乙方在保修期外的所有退货或返修货的往返运费、产品翻新配件费均由乙方承担，并从乙方专项维修费用中扣除。</a></li>
			<li><a href="#">6.乙方遇特殊情况需返修或退货时，乙方应先向甲方书面申请并附上详细清单，经甲方准许后方可。对于未经甲方准<br>
			许的退货(含返修)，甲方可拒收，此退货所造成的损失由乙方自行承担。</a></li>
			<li><a href="#">7.乙方所有返甲方的货物，应包装完整，并保持货物的整洁;对于零乱不堪、配件残缺不全的货物甲方可拒收。乙方<br>
			未提供退货清单或退货清单不详时，退货数量按甲方实收数为准。</a></li>
        </ul>
		<p class="m_text">以上内容钟大福珠宝享有最终解释权！</p>
	</div>	
   </div>
   <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>