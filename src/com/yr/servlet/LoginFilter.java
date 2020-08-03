package com.yr.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 *
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		System.out.println("我是过滤器");
		
		String username = (String) request.getSession().getAttribute("username");
		
		//登陆页面，登录请求都不需要认证
		
		
		
		//获取我们的请求路径
		String url = request.getRequestURI();
		
		//判断是否为登录页面
		if(url.endsWith("login.jsp") || url.endsWith("login"))
		{
			filterChain.doFilter(req, resp);
		}
		else
		{
			if(username != null && !username.equals(""))
			{
				//继续向下执行请求
				filterChain.doFilter(req, resp);
			}
			else
			{
				String path = request.getContextPath();
				System.out.println(path);
				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			}
		}
		
		//判断如果ｓｅｓｓｉｏｎ有username值，表示用户已经登录过．可以继续向下执行
		//如果没有值，表示用户没有登录，需要跳到登录页面
		
		
		
		
	}

}
