<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$("#cc").combobox({
			url:'/StoreOL/goodsmanagerjson_getAllTypes.action',
			textField:'type',
			valueField:'id',
		});
		
        $("#fileInput").change(function () {
            var filepath = $("input[name='upload']").val();
            var extStart = filepath.lastIndexOf(".");
            var ext = filepath.substring(extStart, filepath.length).toUpperCase();
            if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
                alert("图片限于bmp,png,gif,jpeg,jpg格式");
                $("#fileInput").val("");
                return false;
            }
            var file_size = this.files[0].size;
            var size = file_size / 1024 / 1024;
            if (size > 2) {
                alert("上传的图片大小不能超过 2MB！");
                $("#fileInput").val("");
                return false;
            }
            return true;
        });
        $("#price").change(function(){
        	var price = $(this).val();
        	var reg=/^\d+\.?\d*$/g;
        	var flag=reg.test(price);
        	if(!flag){
        		alert("请输入正确格式的价格");
        		$(this).val("");
        		return false;
        	}
        	return true;
        })
          $("#salePrice").change(function(){
        	var price = $(this).val();
        	var reg=/^\d+\.?\d*$/g;
        	var flag=reg.test(price);
        	if(!flag){
        		alert("请输入正确格式的价格");
        		$(this).val("");
        		return false;
        	}
        	return true;
        })
	})
</script>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 商品管理 > 添加商品</font>
</div>
<div style="margin-top:5%">
<center>
	<form action="${pageContext.request.contextPath }/goodsmanager_addGoods.action" method="post" enctype="multipart/form-data">
		<table cellpadding="5px">
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name"></td>
			<tr>
			<tr>
				<td>商品产地：</td>
				<td><input type="text" name="goodFrom"></td>
			<tr>
			<tr>
				<td>商品简介：</td>
				<td><input type="text" name="introduce"></td>
			<tr>
			<tr>
				<td>商品类别：</td>
				<td><input id="cc" name="goodsType.id"></td>
			<tr>
			<tr>
				<td>商品价格：</td>
				<td><input id="price" type="text" name="nowPrice"></td>
			<tr>
			<tr>
				<td>促销价格：</td>
				<td><input id="salePrice" type="text" name="salePrice"></td>
			<tr>
			<tr>
				<td>上传图片：</td>
				<td><input id="fileInput" type="file" name="upload"></td>
			<tr>
			<tr>
				<td align="right"><input type="submit" value="添加"></td>
				<td align="center"><input type="reset" value="重置"></td>
			<tr>
		</table>
	</form>
</center>
</div>
</body>
</html>