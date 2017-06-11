<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
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
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:'/StoreOL/noticejson_getNoticeList.action',
			type:'post',
			success:function(data){
				$.each(data,function(content,index){
					var str="<p style='font-family:宋体;' align='center'>"+index.notice+"</p>";
					$("#mymarquee").append(str);
				})
			}
		})
		var myurl=$("#hid2").val();
		if(myurl == ""){
			$("#pp").panel({
				href:'/StoreOL/indexGoods/allGoods.jsp?page=1',
			})
		}
		var str=$("#hid").val();
		if(str != ""){
			alert(str);
		}
		var str2 = $("#font3").text();
		if(str2 != ""){
			$("#p3").hide();
		}
		$("#btn8").click(function(){
			if(str2 != ""){
				var flag = confirm("确定要退出吗？");
				if(flag){
					return true;
				}
				return false;
			}
			alert("您还未登录，无法退出！");
			return false;
		});
		$("#btn6").click(function(){
			if(str2 == ""){
				alert("您还未登录，请先登录！");
				return false;
			}
			return true;
		});
		$("#btn5").click(function(){
			if(str2 == ""){
				alert("您还未登录，请先登录！");
				return false;
			}
			return true;
		});
		$("#btn7").click(function(){
			if(str2 == ""){
				alert("您还未登录，请先登录！");
				return false;
			}
			return true;
		});
	})
</script>
</head>
<body class="easyui-layout"> 
	<input id="hid" type="hidden" value="${requestScope.islogin }">   
	<input id="hid2" type="hidden" value="${request.myurl }">   
    <div data-options="region:'north'" style="height:140px;">  
    	<div style="background:#ECF5FF;height:96px;">
    		<br>
    		<font face="仿宋" color="blue" size="60px" style="font-weight:bold;font-style:italic;margin-left:5%;">网 上 商 城 Store OnLine</font>
    		<br>
    		<font style="margin-left:85%" size="2">欢迎您，亲爱的</font>
    		<font id="font3" size="2" color="red">${sessionScope.customerName }</font>
    	</div>
    	<div style="background:black;text-align:center;">
    		<a style="background:black" id="btn1" href="${pageContext.request.contextPath }/goods_toAllGoodsPage.action" class="easyui-linkbutton" data-options="width:60,size:'large'"><font color="white" size="3px">首页</font>
    		</a><a style="background:black" id="btn2" href="${pageContext.request.contextPath }/goods_toRankPage.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">销售排行</font>
    		</a><a style="background:black" id="btn3" href="${pageContext.request.contextPath }/goods_toNewGoods.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">新品上架</font>
    		</a><a style="background:black" id="btn4" href="${pageContext.request.contextPath }/goods_toSalePage.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">特价商品</font>
    		</a><a style="background:black" id="btn5" href="${pageContext.request.contextPath }/orders_toCheckOrders.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">查看订单</font>
    		</a><a style="background:black" id="btn6" href="${pageContext.request.contextPath }/orders_toShopingCar.action" target="_blank" class="easyui-linkbutton" data-options="width:150,size:'large'"><font color="white" size="3px">查看购物车</font>
    		</a><a style="background:black" id="btn7" href="${pageContext.request.contextPath }/customer_toeditInfo.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">资料修改</font>
    		</a><a style="background:black" id="btn8" href="${pageContext.request.contextPath }/customer_logout.action" class="easyui-linkbutton" data-options="width:120,size:'large'"><font color="white" size="3px">退出登录</font></a>
    	</div>
    </div> 
    
    <div data-options="region:'south'" style="height:80px;background:#ECF5FF;">
    	<center style="margin-top:1%">
    	<font>CopyRight : www.xiaowu.com</font><br><br>
    	<font>本站使用技术  : struts2、spring4、hibernate5</font>
    	</center>
    </div>
       
    <div data-options="region:'west'" style="width:200px;background:#CECEFF">
    	<div id="p1" class="easyui-panel" style="width:197px;height:442px;background:#CECEFF;"   
        data-options="">   
   	 		<div style="background:#484891;font-size:20px;text-align:center"><font color="white">商品分类</font></div> 
			<ul style="margin-left:20%;">
				<li style="margin-top:5%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=1" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">书 籍</font></a></li>
				<li style="margin-top:3%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=2" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">服 装</font></a></li>
				<li style="margin-top:3%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=3" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">家 具</font></a></li>
				<li style="margin-top:3%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=4" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">家 电</font></a></li>
				<li style="margin-top:3%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=5" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">手 机</font></a></li>
				<li style="margin-top:3%"><a href="${pageContext.request.contextPath }/goods_toTypePage.action?typeId=6" style="text-decoration:none;"><font size="4" color="black" style="font-weight:bold" face="仿宋">电 脑</font></a></li>
			</ul>
			<div style="margin-top:90%;text-align:center">
				<a href="${pageContext.request.contextPath }/manager_toLogin.action">管理员入口</a>
			</div>
		</div> 
    </div>
    
    <div data-options="region:'east'" style="width:200px;background:#CECEFF">
    	<div id="p3" class="easyui-panel" style="height:220px;width:198px;background:#CECEFF;"
    	data-options="">
    		<div style="background:#484891;font-size:20px;text-align:center"><font color="white">顾客登录</font></div>
    		<form action="${pageContext.request.contextPath }/customertoken_login.action" method="post" style="margin-left:10%;margin-top:10%">
				帐号：<input name="name" type="text" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:100px"><br><br>
				密码：<input name="password" type="password" class="easyui-textbox" data-options="iconCls:'icon-lock'" style="width:100px"><br><br>
				<input id="sign" type="button" onclick="window.open('${pageContext.request.contextPath}/signIn.jsp')" style="margin-left:10%" value="注册">
				<input id="login" type="submit" style="margin-left:10%" value="登录"><br>
				<s:token></s:token>
				<font color="red">${requestScope.message }</font>
			</form>
    	</div>
    	<div id="p4" class="easyui-panel" style="height:222px;width:198px;background:#CECEFF;"
    	data-options="">
    		<div style="background:#484891;font-size:20px;text-align:center"><font color="white">公告栏</font></div>
    		<div style="margin-top:10%;margin-buttom:10%">
    			<marquee id="mymarquee" onmouseout="this.start()" onmouseover="this.stop()" height="150px" direction="up" scrollamount="5">
    			</marquee>
    		</div>
    	</div>
    </div>
      
    <div id="pp" data-options="region:'center',href:'${request.myurl }'" style="padding:5px;background:#eee;">
    </div>
</body>  
</html>