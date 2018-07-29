<%@page import="com.jit.po.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
   <table><tr><th>用户名</th><th>密码</th></tr>
   <%
     ArrayList<User> list=(ArrayList<User>)session.getAttribute("users");
      for(int i=0;i<list.size();i++)
      {
        User user=(User)list.get(i);
   %>
      <tr><td><%=user.getUserName() %></td><td><%=user.getPwd() %></td></tr>
     <%} %>
     </table>
</body>
</html>