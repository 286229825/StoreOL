<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("input").change(function(){
			var str = this.value;
			if(Number(str)<1){
				alert("请输入比0大的数字！");
				return false;
			}
			var reg=/^\d+$/g;
			var flag=reg.test(str);
			if(!flag){
				alert("请输入数字!");
				return false;
			}
			var goodsid=this.name;
			var args={"goodsid":goodsid,"number":str}
			$.ajax({
				url:'/StoreOL/ordersjson_carChange.action',
				data:args,
				dataType:'json',
				type:'post',
				success:function(data){
					var money = data.money;
					var goodsid=data.goodsid;
					var totalMoney=data.totalMoney;
					$("#input"+goodsid).parent().next().text(money+"元");
					$("#span1").text(totalMoney);
				}
			});
		});
	});
</script>
</head>
<body>
<br>
<br>
<c:choose>
	<c:when test="${!empty sessionScope.shoppingCar }">
<center>
	<table cellspacing="0px" cellpadding="15px">
		<tr style="font-weight:bold">
			<td align="center">商品信息</td>
			<td align="center">商品价格</td>
			<td align="center">商品数量</td>
			<td align="center">总金额</td>
			<td align="center">操作</td>
		</tr>
		<c:forEach items="${sessionScope.shoppingCar }" var="ordersDetails">
			<tr>
				<td style="font-size:15px">
					<div style="float:left"><img src="image/${ordersDetails.value.goods.pictrue }" style="width:70px;height:70px"></div>
					<div style="float:left;margin-top:2px">
						商品名称：${ordersDetails.value.goods.name }<br>
						商品类型：${ordersDetails.value.goods.goodsType.type }<br>
						商品简介：${ordersDetails.value.goods.introduce }
					</div>
				</td>
				<c:choose>
					<c:when test="${ordersDetails.value.goods.ifSale==1 }">
						<td align="center"><font color="red">特价：￥${ordersDetails.value.goods.salePrice }</font></td>
					</c:when>
					<c:otherwise>
						<td align="center">原价：￥${ordersDetails.value.goods.nowPrice }</td>
					</c:otherwise>
				</c:choose>
				<td align="center">
					<input style="width:20px" name="${ordersDetails.value.goods.id }" type="text" id="input${ordersDetails.value.goods.id }" value="${ordersDetails.value.number }">
				<td align="center"><span id="span2">${ordersDetails.value.money }</span>元</td>
				<td align="center"><a href="${pageContext.request.contextPath }/orders_deleteCar.action?goodsid=${ordersDetails.value.goods.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">合计：<span id="span1">${sessionScope.totalMoney }</span>元</td>
		</tr>
	</table>
	<br>
	<div>
		<a href="${pageContext.request.contextPath }/index.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/orders_toAccounts.action">结账</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/orders_emptyShoppingCar.action">清空购物车</a>
	</div>
	<br>
	<br>
</center>
	</c:when>
	<c:otherwise>
		<div style="font-size:50px;margin-top:15%;text-align:center">
			<font color="red">抱 歉 ！ 您 的 购 物 车 为 空 ！</font><br><br>
			<a href="${pageContext.request.contextPath }/index.jsp">继续购物</a>
		</div>
	</c:otherwise>
</c:choose>
</body>
</html>