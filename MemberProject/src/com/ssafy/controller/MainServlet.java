package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

/** front controller */
@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			if(action!=null) {
				if(action.endsWith("memberRegistForm.do")) {
					url = "member/memberRegister.html";
				}else if(action.endsWith("memberRegit.do")) {
					url = memberRegit(request, response);
				}else if(action.endsWith("memberSearch.do")) {
					url = memberSearch(request, response);
				}else if(action.endsWith("loginForm.do")) {
					System.out.println("로그인폼");
					url = "member/Login.jsp";
				}else if(action.endsWith("login.do")) {
					url = login(request, response);
				}else if(action.endsWith("logout.do")) {
					url = logout(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		return "redirect:loginForm.do";
	}
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id 	= request.getParameter("id");
		String password = request.getParameter("password");
		String idSave = request.getParameter("idsave");
		
		Cookie cookie = new Cookie("id",id);
		
		if(idSave!=null) {
			cookie.setMaxAge(1000000);
		}else {
			cookie.setMaxAge(0);
		}
		
		response.addCookie(cookie);
		
		try {
			memberService.login(id, password);
			// 인증됨.
			System.out.println("!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#");
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			// forward로 가면 안됨 세션 만료 이후에도 로그아웃이 안됨.
			System.out.println("gogo");
			return "redirect:loginForm.do";
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "member/Login.jsp";
		}
		
	}
	private String memberSearch(HttpServletRequest request, HttpServletResponse response) {
		String id 	= request.getParameter("id");
		request.setAttribute("member", memberService.search(id));
		return "member/memberSearch.jsp";
	}
	private String memberRegit(HttpServletRequest request, HttpServletResponse response) {
		String id 	= request.getParameter("id");
		String pw 	= request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		//2. 모델 수행		
		
		Member member = new Member(id, pw, name, email, phone, address);
		memberService.add(member);
		
		return "redirect:memberSearch.do?id="+id;
		
	}
	
}











