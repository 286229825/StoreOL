<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="${pageContext.request.contextPath }/orders_accounts.action" method="post">
	<table cellpadding="20px">
		<tr>
			<td>联系地址：</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>付款方式：</td>
			<td><select name="payMent">
					<option value="支付宝">支付宝</option>
					<option value="微信">微信</option>
					<option value="银行卡">银行卡</option>
				</select></td>
		</tr>
		<tr>
			<td>运送方式：</td>
			<td>
				<input type="text" name="postMethod">
			</td>
		</tr>
		<tr>
			<td>备注信息：</td>
			<td><input type="text" name="remarks"></td>
		</tr>
		<tr>
			<td align="right"><input type="submit" value="确定结账"></td>
			<td align="center"><input type="reset" value="清空"></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>