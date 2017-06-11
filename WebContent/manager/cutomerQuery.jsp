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
		$(".easyui-datebox").datebox({
			editable:false,
		});
		$("#butn").click(function(){
			var name=$("#name").val();
			var sex=$("#sex").val();
			var vocation=$("#vocation").val();
			var birthday1=$("#birthday1").val();
			var birthday2=$("#birthday2").val();
			if(birthday1 > birthday2){
				alert("请输入正确顺序的出生日期！");
				return false;
			}
			if(birthday1 !="" && birthday2 == ""){
				alert("请输入结束日期！");
				return false;
			}
			if(birthday1 =="" && birthday2 != ""){
				alert("请输入开始日期！");
				return false;
			}
			$("#tt").datagrid({
				url:'/StoreOL/customerjson_getQueryResult.action',
				queryParams:{
					myname:name,
					mysex:sex,
					myvocation:vocation,
					birthday1:birthday1,
					birthday2:birthday2,
				},
				width:802,
				singleSelect:true,
				pagination:true,
				pageSize:9,
				pageList:[9],
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
			});
		});
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 顾客管理 > 顾客查询</font>
</div>
<br>
<br>
<br>
<center>
<form>
	<table cellpadding="5px">
		<tr>
			<td>昵称：<input type="text" id="name"></td>
			<td>性别：
				<select id="sex">
					<option value=""></option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</td>
			<td>职业：<input type="text" id="vocation"></td>
		</tr>
		<tr>
			<td colspan="2">出生日期：从：<input type="text" id="birthday1" class="easyui-datebox">
			到：<input type="text" id="birthday2" class="easyui-datebox"></td>
			<td><input type="reset" value="重置"></td>
			<td><button type="button" id="butn" style="width:60px;height:40px;background:yellow;font-size:20px">查询</button></td>
		</tr>
	</table>
</form>
<table id="tt"></table>
</center>
</body>
</html>