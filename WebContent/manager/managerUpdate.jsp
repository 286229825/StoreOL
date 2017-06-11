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
	var managerid=$("#hidd").val();
	$("#ff").form("load","/StoreOL/managerjson_getPrevUpdate.action?id="+managerid);
	$("#sub").click(function(){
		var password1=$("#password1").val();
		if(password1 == ""){
			alert("请输入密码！");
			return false;
		}
		var flag2=true;
		$(":text").each(function(){
			if($(this).val() == ""){
				var str=$(this).parent().prev().text();
				alert("请输入"+str);
				flag2=false;
			}
		})
		if(flag2){
			var flag=confirm("确定修改吗？");
			if(!flag){
				return false;
			}
			return true;
		}
		return false;
	});
})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 后台管理员管理 > 修改管理员</font>
</div>
<br>
<br>
<br>
<br>
<br>
<center>
<form id="ff" action="${pageContext.request.contextPath }/manager_updateOne.action" method="get">
	<input type="hidden" id="hidd" name="id" value="${param.id }">
	<table cellpadding="10px">
		<tr>
			<td>昵称</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input id="password1" type="password" name="password"></td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text" name="realName"></td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				<select name="level">
					<option value="super">super</option>
					<option value="simple">simple</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="reset" value="重置"></td>
			<td><input id="sub" type="submit" value="修改"></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>