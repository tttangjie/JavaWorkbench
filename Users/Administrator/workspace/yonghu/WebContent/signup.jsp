<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
		<form action="${request.contextPath }/signupservlet" method="get">
			<table  border="1">
				<h1>用户注册</h1>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" checked="checked" value="1"/>男
					<input type="radio" name="sex"  value="0"/>女
				</td>
			</tr>
			<tr>
			    <td>权限</td>
			    <td>
			        <input type="radio"  name="power"  checked="checked"  value="0"/>用户
			        <input type="radio"  name="power"   value="1"/>管理员
			    </td>
			 </tr>			
			<tr>
				<td>个人简历信息</td>
				<td><textarea name="info" rows="10"  cols="30"/></textarea></td>
			</tr>			
			<tr>
				<td><input type="submit" value="提交"/></td>
			    <td><input type="reset"  value="重置"/></td>
			</tr>
			</table>
		</form>
</body>
</html>