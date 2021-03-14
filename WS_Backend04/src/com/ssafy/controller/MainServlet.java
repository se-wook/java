package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServiceImp;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService=new MemberServiceImp();
	private ProductService productService = new ProductServiceImp();
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
				if(action.endsWith("productRegit.do")) {
					url = productRegit(request, response);
				}else if(action.endsWith("productList.do")) {
					url = productList(request, response);
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

	private String productList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ArrayList<Product> products = (ArrayList<Product>) productService.searchAll();
		
		session.setAttribute("products", products);
		
		return "redirect:productList.jsp";
	}

	private String productRegit(HttpServletRequest request, HttpServletResponse response) {
		int gno = productService.lastSearch();

		String brand = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("desc");
		
		Cookie cookieGno = new Cookie("no", Integer.toString(gno+1));
		Cookie cookieBrand = new Cookie("brand",brand);
		Cookie cookiePrice = new Cookie("price",price);
		Cookie cookieInfo = new Cookie("info",info);
		
		cookieGno.setMaxAge(10000);
		cookieBrand.setMaxAge(10000);
		cookiePrice.setMaxAge(10000);
		cookiePrice.setMaxAge(10000);
		
		response.addCookie(cookieGno);
		response.addCookie(cookieBrand);
		response.addCookie(cookiePrice);
		response.addCookie(cookieInfo);
		
		Product pd = new Product(brand, price, info);
		
		try {
			//db 저장
			productService.add(pd);
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "redirect:Login.jsp";
	}

}
