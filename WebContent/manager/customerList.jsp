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
			url:'/StoreOL/customerjson_getCustomerList.action',
			width:802,
			singleSelect:true,
			pagination:true,
			fitColumns:true,
			pageList:[10],
			pageSize:10,
			columns:[[
				{
					field:'name',
					title:'昵称',
					width:100,
					align:'center',
				},
				{
					field:'realName',
					title:'真实姓名',
					width:100,
					align:'center',
				},
				{
					field:'sex',
					title:'性别',
					width:100,
					align:'center',
				},
				{
					field:'birthday',
					title:'生日',
					width:200,
					align:'center',
				},
				{
					field:'vocation',
					title:'职业',
					width:100,
					align:'center',
				},
				{
					field:'email',
					title:'邮箱',
					width:200,
					align:'center',
				},
			]]
		})
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 顾客管理 > 顾客列表</font>
</div>
<br>
<br>
<br>
<center>
<table id="tt"></table>
</center>
</body>
</html>