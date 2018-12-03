package com.vienmv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;import com.sun.corba.se.impl.ior.GenericTaggedComponent;
import com.vienmv.model.User;
@WebFilter(urlPatterns= {"/admin/*"})
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resq= (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object obj=session.getAttribute("username");
		User user=(User) obj;
		if(obj!=null ) {
			chain.doFilter(request, response);
			return; //
		}else {
			resq.sendRedirect("/login");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}
	

}
