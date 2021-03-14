package com.ssafy.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginCheckFillter
 */
@WebFilter("*.log") // 
public class LoginCheckFillter implements Filter {

	public LoginCheckFillter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			request.setAttribute("referer", req.getServletPath()); //요청 url을 referer에 붙여서 보내줌, 인증이 잘되면 referer로감
																	// 받는 쪽에서 referer가 없으면 메인으로 간다.
			request.setAttribute("msg", "로그인 하세요");
			request.getRequestDispatcher(req.getContextPath() + "/loginform.do").forward(req, res);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
