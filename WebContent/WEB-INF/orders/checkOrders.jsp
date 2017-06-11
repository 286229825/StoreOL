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
<center>
<c:forEach items="${requestScope.ordersList }" var="orders">
	<table cellpadding="10px">
		<tr bgcolor="#B9B9FF">
			<td align="center">订单创建日期：${orders.creatTime }</td>
			<td align="center" colspan="2">合计金额：${orders.totalMoney }元</td>
			<td align="center">是否发货：<c:if test="${orders.ifPost ==1 }">已发货</c:if>未发货</td>
		</tr>
		<tr style="font-weight:bold">
			<td align="center">商品信息</td>
			<td align="center">商品价格</td>
			<td align="center">商品数量</td>
			<td align="center">总金额</td>
		</tr>
		<c:forEach items="${orders.setOrdersDetail }" var="ordersDetail">
			<tr>
				<td>
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
	</table>
	<br>
	<br>
</c:forEach>
</center>
</body>
</html>