<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){
		$("#sub").click(function(){
			var flag=confirm("确定要添加吗？");
			if(!flag){
				return false;
			}
			return true;
		})
	})
</script>
<body>
<div style="margin-top:1%;font-weight:bold;float:left">
	<font size="3">当前位置 ： 公告管理 > 添加公告</font>
</div>
<br>
<br>
<br>
<br>
<br>
<center>
	<form action="${pageContext.request.contextPath }/notice_addOne.action" method="post">
		请输入一条公告信息：<input type="text" style="width:600px" name="notice"><br><br>
		<input id="sub" type="submit" value="添加" style="width:60px;height:40px;background:yellow"> 
	</form>
</center>
</body>
</html>