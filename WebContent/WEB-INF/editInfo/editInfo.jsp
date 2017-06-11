<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
		$(".input1").change(function(){
			var name = $("input:first").val();
			var args={"name":name};
			$.ajax({
				url:'/StoreOL/customerjson_checkName.action',
				data:args,
				dataType:'json',
				type:'post',
				success:function(data){
					if(data == false){
						$("#font1").text("登录名已经存在，请更换！");
					}else{
						$("#font1").text("");
					}
				}
			});
		})
		
		$("#su").click(function(){
			var flag=true;
			if(flag){
				$("input[id='each']").each(function(){
					if($(this).val()==""){
						alert($(this).parent().prev().text()+"不能为空");
						flag=false;
						return false;
					};
				});
			}
			if(flag){
				var str1=$("#date").val();
				var pattern1=/\d{4}\-\d{2}\-\d{2}/;
				var flag1=pattern1.test(str1);
				if(!flag1){
					alert("请输入正确的日期格式！");
					return false;
				};
				var str2=$("#em").val();
				var pattern2=/\d{5,11}\@qq.com$/;
				var flag2=pattern2.test(str2);
				if(!flag2){
					alert("请输入正确格式的QQ邮箱！");
					return false;
				};
				var str3=$(".pa1").val();
				var str4=$(".pa2").val();
				if(str3 != str4){
					alert("两次输入的密码不一致！");
					return false;
				};
				var font1=$("#font1").text();
				if(font1 != ""){
					alert("登录名已经存在，请更换！");
					return false;
				}
				return true;
			};
			return false;
		});
	})
</script>
</head>
<body>
<div style="font-size:20px;margin-left:10%;margin-top:2%"><font color="blue">请输入您的详细信息：</font></div>
<br>
<center>
	<form action="${pageContext.request.contextPath}/customer_editInfo.action" method="post">
		<table cellpadding="10">
			<tr>
				<td>登录名</td>
				<td><input class="input1" name="name" id="each" type="text" style="width:175px"></td>
				<td><font color="red">*必选项</font>&nbsp;&nbsp;<font id="font1" color="red"></font></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input class="pa1" name="password" id="each" type="password" style="width:175px"></td>
				<td><font color="red">*必选项</font></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input class="pa2" id="each" type="password" style="width:175px"></td>
				<td><font color="red">*必选项</font></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input name="realName" id="each" type="text" class="easyui-textbox" style="width:175px"></td>
				<td><font color="red">*必选项</font></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input name="sex" id="each" class="easyui-combobox" data-options="
					limitToList:true,
					panelHeight:50,
					valueField:'value',
					textField:'text',
					data:[{
						text:'男',
						value:'男',
						},{
						text:'女',
						value:'女',
					}]"></td>
				<td><font color="red">*必选项</font></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input name="birthday" id="date" type="text" class="easyui-datebox"></td>
				<td><font color="red">*格式：2017-04-10</font></td>
			</tr>
			<tr>
				<td>职业</td>
				<td>
					<input name="vocation" id="each" class="easyui-combobox" data-options="
						limitToList:true,
						panelHeight:150,
						valueField:'value',
						textField:'text',
						data: [{
							text: '学生',
							value: '学生'
							},{
							text: '老师',
							value: '老师'
							},{
							text: '公务员',
							value: '公务员'
							},{
							text: '设计师',
							value: '设计师'
							},{
							text: '程序员',
							value: '程序员'
							},{
							text: '金融人士',
							value: '金融人士'
							}]" />
				</td>
				<td><font color="red">*必选项</font></td>
			</tr>
			<tr>
				<td>QQ邮箱</td>
				<td><input name="email" id="em" type="text" class="easyui-textbox" style="width:175px"></td>
				<td><font color="red">*由5-11位数字和@qq.com组成</font></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input id="su" type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>