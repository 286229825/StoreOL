<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吾家商城-后台管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
$(function(){
	var managerName = $("#managerName").text();
	if(managerName != ""){
		$("#aaa").show();
	}else{
		$("#aaa").hide();
	}
})
</script>
</head>
<body class="easyui-layout">
<input type="hidden" id="hidd1" value="${sessionScope.managerLevel }">
	<div data-options="region:'north'" style="height:80px">
		<div style="font-weight:bold;font-size:40px;margin-top:1%;margin-left:2%">
			<font color="blue" face="仿宋">吾 家 商 城 - 后 台 管 理</font>
		</div>
		<font style="margin-left:80%">欢迎您：<font id="managerName" color="red">${sessionScope.managerName }</font>
		&nbsp;&nbsp;&nbsp;&nbsp;<a id="aaa" href="${pageContext.request.contextPath }/manager_logout.action">退出登录</a></font>
	</div>
	
	<div data-options="region:'south'" style="height:40px">
		<center style="margin-top:1%">
    		<font>CopyRight : www.xiaowu.com</font><br><br>
    	</center>
	</div>
	
	<div data-options="region:'west',title:'后台管理菜单栏',split:true"  style="width:200px">
		<div id="aa" class="easyui-accordion"  data-options="border:false,fit:true">   
    		<div align="center" title="商品管理" style="padding:10px;">   
        		<a href="${pageContext.request.contextPath }/goodsmanager_toAddGoods.action">添加商品</a><br><br>
        		<a href="${pageContext.request.contextPath }/goodsmanager_toGoodsList.action">商品列表</a><br><br>
        		<a href="${pageContext.request.contextPath }/goodsmanager_toQueryList.action">商品查询</a>
    		</div>   
   			<div align="center" title="顾客管理" style="padding:10px;">   
        		<a href="${pageContext.request.contextPath }/customer_toList.action">顾客列表</a><br><br>
        		<a href="${pageContext.request.contextPath }/customer_toQuery.action">顾客查询</a>
    		</div>   
    		<div id="manager" align="center" title="后台管理员管理" style="padding:10px;">   
        		<a href="${pageContext.request.contextPath }/manager_toAdd.action">添加管理员</a><br><br>
        		<a href="${pageContext.request.contextPath }/manager_toList.action">管理员列表</a><br><br>
    		</div>   
    		<div align="center" title="订单管理" style="padding:10px;">   
        		<a href="${pageContext.request.contextPath }/ordersmanager_toList.action">订单列表</a><br><br>
    		</div>   
    		<div align="center" title="公告管理" style="padding:10px;">   
        		<a href="${pageContext.request.contextPath }/notice_toAdd.action">添加公告</a><br><br>
        		<a href="${pageContext.request.contextPath }/notice_toList.action">公告列表</a>
    		</div>   
		</div> 
	</div>
	
	<div data-options="region:'center',href:'${requestScope.myurl }'" style="padding:5px;background:#eee"></div>
</body>
</html>