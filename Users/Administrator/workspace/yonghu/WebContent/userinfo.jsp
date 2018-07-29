<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
		
		<table border="1px" align="center" style="width:800px">
			<caption>${requestScope.user.username}的个人信息情况</caption>
			<tr>
				<td>用户名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>个人简历信息</td>
			</tr>
			<tr>
				<td>${requestScope.user.username }</td>
				<td>${requestScope.user.age }</td>
				<td>${requestScope.user.sex }</td>
				<td>${requestScope.user.info}</td>
				<td>${requestScope.user.power==1?'管理员':'普通职员' }</td>
			</tr>
			
		</table>
</body>
</html>