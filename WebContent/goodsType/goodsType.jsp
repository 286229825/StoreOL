<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
$(function(){
	var page = $("#font1").text();
	myajax(page);
	$("#a2").click(function(){
		var totalPage=$("#font2").text();
		if(Number(page) >= Number(totalPage)){
			alert("当前已经是最后一页了！");
			return false;
		};
		$(this).attr("href","/StoreOL/goods_toNextTypePage.action?page="+page);
		return true;
	});
	$("#a1").click(function(){
		if(page=="1"){
			alert("当前已经是第一页！");
			return false;
		}
		$(this).attr("href","/StoreOL/goods_toPrevTypePage.action?page="+page);
		return true;
	});
});

function myajax(page){
	var typeId=$("#hid1").val();
	if(typeId == "1"){
		$("#span1").text("书籍");
	}else if(typeId == "2"){
		$("#span1").text("服装");
	}else if(typeId == "3"){
		$("#span1").text("家具");
	}else if(typeId == "4"){
		$("#span1").text("家电");
	}else if(typeId == "5"){
		$("#span1").text("手机");
	}else{
		$("#span1").text("电脑");
	}
	var args={"page":page,"typeId":typeId};
	$.ajax({
		url:'/StoreOL/goodsjson_getAllByLimit.action',
		type:'post',
		data:args,
		dataType:'json',
		success:function(data){
			$("#font2").text(data.totalPage);
			$.each(data.rows.reverse(),function(index,content){
				if(content.salePrice > 0){
					var str="<div style='float:left;margin:10px;width:200px;height:350px'>"+
						"<a href='#' onclick='buyIt("+content.id+")'><img src='image/"+content.pictrue+"'></a>"+
						"<br><br><div>商品名称："+content.name+"</div>"+
						"<div>商品产地："+content.goodFrom+"</div>"+
						"<div>商品简介："+content.introduce+"</div>"+
						"<div>商品销量："+content.buyTimes+"</div>"+
						"<div>商品价格："+content.nowPrice+"</div>"+
						"<div><font color='red'>商品特价："+content.salePrice+"</font></div>"+
						"</div>"+"&nbsp;&nbsp;";
					$("#p").after(str);
				}else{
					var str="<div style='float:left;margin:10px;width:200px;height:350px'>"+
						"<a href='#' onclick='buyIt("+content.id+")'><img src='image/"+content.pictrue+"'></a>"+
						"<br><br><div>商品名称："+content.name+"</div>"+
						"<div>商品产地："+content.goodFrom+"</div>"+
						"<div>商品简介："+content.introduce+"</div>"+
						"<div>商品销量："+content.buyTimes+"</div>"+
						"<div>商品售价："+content.nowPrice+"</div>"+
						"<div></div>"+
						"</div>"+"&nbsp;&nbsp;";
					$("#p").after(str);
				}
			});
		}
	});
};

function buyIt(goodsid){
	var str=$("#myhid").val();
	if(str == ""){
		alert("您还没有登录！请先登录！");
		return false;
	}
	var flag=confirm("是否加入购物车？");
	if(flag){
		var args={"goodsid":goodsid};
		$.ajax({
			url:'/StoreOL/ordersjson_addToshoppingCar.action',
			data:args,
			dataType:'json',
			type:'post',
			success:function(data){
				if(data){
					var flag2=confirm("操作成功，是否立即查看购物车？");
					if(flag2){
						window.open("/StoreOL/orders_toShopingCar.action");
					}
				}
			},
		})
	};
	return false;
};

function toWhichPage(){
	var page = $("#input1").val();
	var totalPage=$("#font2").text();
	if(Number(page)>Number(totalPage) || Number(page)<1){
		alert("请输入合理的页数！");
		return false;
	}
	window.open("/StoreOL/goods_toWhichTypePage.action?page="+page,"_self");
};
</script>
<input type="hidden" id="myhid" value="${sessionScope.customerName }">
<div style="margin-top:1%;float:left">
	<font color="blue" size="3" style="font-weight:bold">当前位置 ： <span id="span1"></span></font>
	<br id="p">
	<br>
	<br>
</div>
<div style="float:left;margin-left:35%">
	<input id="hid1" type="hidden" value="${param.typeId }">
	<br>
	<a id="a1" href="" style="text-decoration:none">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	当前第&nbsp;<font id="font1" color="red">${param.page }</font>&nbsp;页，共&nbsp;<font id="font2" color="red"></font>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
	<a id="a2" href="" style="text-decoration:none">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	到第&nbsp;<input id="input1" style="width:20px" type="text">&nbsp;页
	<button id="btn1" type="button" onclick="toWhichPage()">确定</button>
</div>
</body>
</html>