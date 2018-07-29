<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form  action="Loginservlet1" method="get">
			<table  border="2">
			<input style="display:none" type="text" name="login" value="0" />
				<h1>用户登录界面</h1>	
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"/></td>
				</tr>	
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"/></td>
				</tr>			
				<tr>
				    <td>选择类型：</td>
					<td>
						<input type="radio" name="power" value="1"/>管理员						
						<input type="radio" name="power" value="0" checked="checked"/>用户
					</td>						
				</tr>		
				<tr>
					<td>
					<input type="submit" value="登录"/>
					</td>
					<td>
					<input type="reset" value="重置"/>
					</td>
				</tr>		
			</table>
		</form>
</body>
</html>