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
	$("#tt").datagrid({
		url:'/StoreOL/managerjson_getList.action',
		width:552,
		singleSelect:true,
		pagination:true,
		pageSize:10,
		pageList:[10],
		columns:[[
			{
				field:'name',
				title:'昵称',
				width:100,
				align:'center'
			},
			{
				field:'password',
				title:'密码',
				width:100,
				align:'center'
			},
			{
				field:'realName',
				title:'真实姓名',
				width:100,
				align:'center'
			},
			{
				field:'level',
				title:'类型',
				width:100,
				align:'center'
			},
			{
				field:'id',
				title:'操作',
				width:150,
				align:'center',
				formatter:function(value){
					str="<a href='/StoreOL/manager_deleteOne.action?id="+value+"' onclick='return confirm(\"确定要删除吗？\")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
					"<a href='/StoreOL/manager_toUpdateOne.action?id="+value+"'>修改</a>";
					return str;
				}
			}
		]]
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 后台管理员管理 > 管理员列表</font>
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