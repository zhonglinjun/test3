package com.yr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 113L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(1);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		if("admin".equals(userName) && "123456".equals(passWord))
		{
			req.setAttribute("aa", "123123123");
			
			
			req.getSession().setAttribute("username", userName);
			
			//转发是同一个请求，ＵＲＬ不会改变
			req.getRequestDispatcher("/jsp/list.jsp").forward(req, resp);;;;;
			
			//转向(重定向),是多个请求，会改变
			//resp.sendRedirect("jsp/list.jsp");
		}
	}
}
