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
			url:'/StoreOL/ordersmanagerjson_getList.action',
			width:1122,
			singleSelect:true,
			pagination:true,
			pageSize:10,
			pageList:[10],
			columns:[[
				{
					field:'id2',
					title:'订单号',
					width:50,
					align:'center',
					formatter:function(value,row){
						return row.id;
					}
				},
				{
					field:'creatTime',
					title:'创建时间',
					width:150,
					align:'center'
				},
				{
					field:'address',
					title:'联系地址',
					width:200,
					align:'center'
				},
				{
					field:'phone',
					title:'联系电话',
					width:100,
					align:'center'
				},
				{
					field:'totalMoney',
					title:'合计金额',
					width:60,
					align:'center'
				},
				{
					field:'payMent',
					title:'付款方式',
					width:100,
					align:'center'
				},
				{
					field:'postMethod',
					title:'运送方式',
					width:100,
					align:'center'
				},
				{
					field:'ifPost',
					title:'是否发货',
					width:60,
					align:'center'
				},
				{
					field:'remarks',
					title:'备注',
					width:200,
					align:'center'
				},
				{
					field:'id',
					title:'操作',
					width:100,
					align:'center',
					formatter:function(value){
						str="<a href='/StoreOL/ordersmanager_toGetDetails.action?id="+value+"'>详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
								"<a href='/StoreOL/ordersmanager_deleteOne.action?id="+value+"' onclick='return confirm(\"确定要删除吗？\")'>删除</a>";
						return str;
					}
				}
			]]
		})
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 订单管理 > 订单列表</font>
</div>
<br>
<br>
<br>
<br>
<br>
<center>
<table id="tt"></table>
</center>
</body>
</html>