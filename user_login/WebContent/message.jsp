<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.lxy.User" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>提示信息</title>
	<link rel="stylesheet" type="text/css" href="images/style.css">
</head>
<body>
	<div align="center">
		<div class="div1">
			<div class="top">提示信息</div>
			<div class="bottom">
				<div class="div2">
					<ul>
						<li> <a href="reg.jsp">用户注册</a></li>
						<li> <a href="login.jsp">用户登录</a></li>
						<li> <a href="message.jsp">当前用户</a></li>
						<li> <a href="ExitServlet">用户退出</a></li>
					</ul>
				</div>
				<div class="div3">
				<%
					//获取提示信息
					String info = (String)request.getAttribute("info");
					if(info != null){
						out.println(info);
					}
					//获取登录的用户信息
					User user = (User)session.getAttribute("user");
					if(user != null){
				%>
				<table align="center" width="350" border="1" height="200" border="#E8F4CC">
					<tr>
						<td align="center" colspan="2">
							<span stype="font-weight:bold; font-size:18px;"><%=user.getUsername() %>></span>
							登录成功！
						</td>
					</tr>
					<tr>
						<td align="right" width="30%">头 像：</td>
						<td>
							<img src="<%=user.getPhoto() %>">
						</td>
					</tr>
					
					<tr>
						<td align="right">性 别：</td>
						<td><%=user.getSex() %></td>
					</tr>
					
					<tr>
						<td align="right">联系电话：</td>
						<td><%=user.getTel()%></td>
					</tr>
					<tr>
						<td align="right">电子邮箱：</td>
						<td><%=user.getEmail() %></td>
					</tr>
					</table>
					<%
					}esle{
						out.println("<br>对不起，您还没有登录！");
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>