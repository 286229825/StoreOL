<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城-管理员登录</title>
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
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:100px;background:#D1E9E9"></div>
	<div data-options="region:'south'" style="height:100px;background:#D1E9E9"></div>
	<div data-options="region:'west'" style="width:150px;background:#F0F0F0"></div>
	<div data-options="region:'east'" style="width:150px;background:#F0F0F0"></div>
	<div data-options="region:'center'" style="padding:5px;background-image:url('image/background.jpg');background-size:cover">
		<div style="font-size:40px;margin-top:10%;margin-left:30%">
			<font color="black">管 理 员 M a n a g e r 登 录 </font>
		</div>
		<div style="margin-left:40%;margin-top:6%">
			<form action="${pageContext.request.contextPath }/managertoken_login.action" method="post">
			<table cellpadding="10px" style="font-size:20px">
				<tr>
					<td>登录帐号：</td>
					<td><input name="name" class="easyui-textbox" data-options="iconCls:'icon-man'" type="text"></td>
				</tr>
				<tr>
					<td>登录密码：</td>
					<td><input name="password" class="easyui-textbox" data-options="iconCls:'icon-lock'" type="password"></td>
				</tr>
				<tr>
					<s:token></s:token>
					<td align="right"><input type="submit" value="登录"></td>
					<td align="left"><input type="reset" value="重置"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><font color="yellow">${requestScope.error }</font></td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>