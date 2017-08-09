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
		$("#goodstype").combobox({
			url:'/StoreOL/goodsmanagerjson_getAllTypes.action',
			textField:'type',
			valueField:'id',
			panelHeight:'auto',
			width:60
		});
		
		$("#begindate").datebox({    
			editable:false,  
		}); 
		$("#lastdate").datebox({    
			editable:false,  
		}); 
		$("#butn").click(function(){
			var begindate=$("#begindate").val();
			var lastdate=$("#lastdate").val();
			if(begindate !="" && lastdate==""){
				alert("请输入结束日期！");
				return false;
			}
			if(begindate =="" && lastdate !=""){
				alert("请输入开始日期！");
				return false;
			}
			if(begindate>lastdate){
				alert("请输入正确顺序的起始日期");
				return false;
			}
			var price1=$("#price1").val();
			var price2=$("#price2").val();
			if(price1 !="" && price2==""){
				alert("请输入结束价格！");
				return false;
			}
			if(price1 =="" && price2 !=""){
				alert("请输入开始价格！");
				return false;
			}
			if(price1 != "" && price2 != ""){
	        	var price = $("#price1").val();
	        	var reg=/^\d+\.?\d*$/g;
	        	var flag=reg.test(price);
	        	if(!flag){
	        		alert("请输入正确格式的价格");
	        		$(this).val("");
	        		return false;
	        	}
	        	var price = $("#price2").val();
	        	var reg=/^\d+\.?\d*$/g;
	        	var flag=reg.test(price);
	        	if(!flag){
	        		alert("请输入正确格式的价格");
	        		$(this).val("");
	        		return false;
	        	}
			}
			if(price1 > price2){
				alert("请输入正确顺序的价格！");
				return false;
			}
			var goodsname=$("#goodsname").val();
			var goodsfrom=$("#goodsfrom").val();
			var goodstypeid=$("#goodstype").val();
			var price1=$("#price1").val();
			var price2=$("#price2").val();
			var begindate=$("#begindate").val();
			var lastdate=$("#lastdate").val();
			$("#tt").datagrid({
				width:1100,
				singleSelect:true,
				pagination:true,
				pageList:[5],
				pageSize:5,
				url:'/StoreOL/goodsmanagerjson_queryGoodsList.action',
				queryParams:{
					goodsname:goodsname,
					goodsfrom:goodsfrom,
					goodstypeid:goodstypeid,
					price1:price1,
					price2:price2,
					begindate:begindate,
					lastdate:lastdate,
				},
				columns:[[
					{
						field:'name',
						title:'商品名称',
						align:'center',
						width:178,
					},
					{
						field:'goodFrom',
						title:'商品产地',
						align:'center',
						width:140,
					},
					{
						field:'introduce',
						title:'商品简介',
						align:'center',
						width:250,
					},
					{
						field:'creatTime',
						title:'创建时间',
						align:'center',
						width:150,
					},
					{
						field:'nowPrice',
						title:'商品价格',
						align:'center',
						width:70,
					},
					{
						field:'salePrice',
						title:'促销价格',
						align:'center',
						width:70,
					},
					{
						field:'buyTimes',
						title:'购买次数',
						align:'center',
						width:70,
					},
					{
						field:'goodsType',
						title:'商品类型',
						align:'center',
						width:70,
						formatter:function(value){
							return value.type;
						}
					},
					{
						field:'pictrue',
						title:'商品图片',
						align:'center',
						width:100,
						formatter:function(value){
							var str="<img src='image/"+value+"' width='50px' height='50px'>";
							return str;
						}
					},
				]],
			});
		});
	})
</script>
<div style="margin-top:1%;font-weight:bold">
	<font size="3">当前位置 ： 商品管理 > 商品查询</font>
</div>
<div style="margin-top:1%">
<table>
	<tr>
		<td align="center">商品名称：<input id="goodsname" type="text" name="name" style="width:60px"></td>
		<td align="center">商品产地：<input id="goodsfrom" type="text" name="goodFrom" style="width:60px"></td>
		<td align="center">商品类型：<input id="goodstype" name="goodsType.id"></td>
		<td align="center">商品价格：<input id="price1" style="width:40px" type="text" name="nowPrice">
		--<input id="price2" style="width:40px" type="text" name="nowPrice"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">创建时间：从<input id="begindate" type="text" class="easyui-datebox"></input>
		-到<input id="lastdate" type="text" class="easyui-datebox"></input>
		</td>
		<td align="center"><input type="reset" value="重置"></td>
		<td align="center"><button id="butn" type="button" style="background:yellow;width:60px;height:40px;font-size:20px">查询</button></td>
	</tr>
</table>
</div>
<table id="tt"></table>
</body>
</html>