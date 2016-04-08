package com.lxy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxy.User;

/**
 * Servlet implementation class ExitServlet
 * 用户退出
 */
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user != null){
			session.removeAttribute("user");
			request.setAttribute("info", user.getUsername()+"已成功退出！");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
}
