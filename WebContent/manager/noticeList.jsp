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
			url:'/StoreOL/noticejson_getList.action',
			width:852,
			singleSelect:true,
			pagination:true,
			pageSize:10,
			pageList:[10],
			columns:[[
				{
					field:'id2',
					title:'公告编号',
					width:100,
					align:'center',
					formatter:function(value,row){
						return row.id;
					}
				},
				{
					field:'notice',
					title:'公告内容',
					width:600,
					align:'center',
				},
				{
					field:'id',
					title:'操作',
					width:150,
					align:'center',
					formatter:function(value){
						var str="<a href='/StoreOL/notice_toUpdateOne.action?id="+value+"'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
						"<a href='/StoreOL/notice_deleteOne.action?id="+value+"' onclick='return confirm(\"确定要删除吗？\")'>删除</a>";
						return str;
					}
				}
			]]
		})
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 公告管理 > 公告列表</font>
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