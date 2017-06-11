<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-left:10%;margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 订单号为 ${orders.id } 的详细信息：</font>
</div>
<br>
<br>
<br>
<br>
<br>
<center>
	<table cellpadding="10px">
		<tr bgcolor="#B9B9FF">
			<td colspan="3" align="center">订单创建日期：${orders.creatTime }</td>
			<td align="center" colspan="2">合计金额：${orders.totalMoney }元</td>
			<td align="center">是否发货：<c:if test="${orders.ifPost ==1 }">已发货</c:if>未发货</td>
		</tr>
		<tr style="font-weight:bold">
			<td colspan="3" align="center">商品信息</td>
			<td align="center">商品价格</td>
			<td align="center">商品数量</td>
			<td align="center">总金额</td>
		</tr>
		<c:forEach items="${orders.setOrdersDetail }" var="ordersDetail">
			<tr>
				<td colspan="3">
					<div style="float:left"><img width="70px" height="70px" src="image/${ordersDetail.goods.pictrue }"></div>
					<div style="float:left">
						商品名称：${ordersDetail.goods.name }<br>
						商品类型：${ordersDetail.goods.goodsType.type }<br>
						商品简介：${ordersDetail.goods.introduce }
					</div>
				</td>
				<c:choose>
					<c:when test="${ordersDetail.goods.ifSale==1 }">
						<td align="center"><font color="red">特价：￥${ordersDetail.goods.salePrice }</font></td>
					</c:when>
					<c:otherwise>
						<td align="center">原价：￥${ordersDetail.goods.nowPrice }</td>
					</c:otherwise>
				</c:choose>
				<td align="center">${ordersDetail.number }</td>
				<td align="center">${ordersDetail.money }</td>
			</tr>
		</c:forEach>
		<tr bgcolor="#B9B9FF">
			<td align="center" colspan="6">顾客信息：</td>
		</tr>
		<tr style="font-weight:bold">
			<td align="center">昵称</td>
			<td align="center">真实姓名</td>
			<td align="center">性别</td>
			<td align="center">出生日期</td>
			<td align="center">职业</td>
			<td align="center">邮箱</td>
		</tr>
		<tr>
			<td align="center">${orders.customer.name }</td>
			<td align="center">${orders.customer.realName }</td>
			<td align="center">${orders.customer.sex }</td>
			<td align="center">${orders.customer.birthday }</td>
			<td align="center">${orders.customer.vocation }</td>
			<td align="center">${orders.customer.email }</td>
		</tr>
		
	</table>
	<br>
	<br>
	<a href="${pageContext.request.contextPath }/ordersmanager_toList.action">返回订单列表</a>
	<br>
	<br>
</center>
</body>
</html>