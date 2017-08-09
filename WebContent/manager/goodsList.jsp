<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$("#tt").datagrid({
			width:1100,
			singleSelect:true,
			pagination:true,
			pageList:[5],
			pageSize:5,
			fitColumns:true,
			url:'/StoreOL/goodsmanagerjson_getGoodsList.action',
			columns:[[
				{
					field:'name',
					title:'商品名称',
					align:'center',
					width:128,
				},
				{
					field:'goodFrom',
					title:'商品产地',
					align:'center',
					width:140,
				},
				{
					field:'introduce',
					title:'商品简介',
					align:'center',
					width:200,
				},
				{
					field:'creatTime',
					title:'创建时间',
					align:'center',
					width:150,
				},
				{
					field:'nowPrice',
					title:'商品价格',
					align:'center',
					width:70,
				},
				{
					field:'salePrice',
					title:'促销价格',
					align:'center',
					width:70,
				},
				{
					field:'buyTimes',
					title:'购买次数',
					align:'center',
					width:70,
				},
				{
					field:'goodsType',
					title:'商品类型',
					align:'center',
					width:70,
					formatter:function(value){
						return value.type;
					}
				},
				{
					field:'pictrue',
					title:'商品图片',
					align:'center',
					width:100,
					formatter:function(value){
						var str="<img src='image/"+value+"' width='50px' height='50px'>";
						return str;
					}
				},
				{
					field:'id',
					title:'操作',
					align:'center',
					width:100,
					formatter:function(value){
						var str="<a href='/StoreOL/goodsmanager_deleteOne.action?id="+value+"' onclick='return confirm(\"确定要删除吗？\")'>删除</a>"
						+"&nbsp;&nbsp;<a href='/StoreOL/goodsmanager_toUpdateOne.action?id="+value+"'>修改</a>";
						return str;
					}
				},
			]],
		});
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 商品管理 > 商品列表</font>
</div>
<center style="margin-top:5%">
<table id="tt"></table>
</center>
</body>
</html>