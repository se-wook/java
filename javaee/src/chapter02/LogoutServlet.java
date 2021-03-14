package chapter02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout2.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 인증 만료 시키기
		 * 	1. invalidate() 호출하기 
		 * 		- 즉각적으로 새로운 아이디를 부여하여 이전 세션을 만료시킴 (세션을 통으로 버리는거임)
		 * 	2. session에서 인증 정보를 제거하기 (인증정보만 제거 (장바구니 같은건 남아있고))
		 * 
		 */
		
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		response.sendRedirect("Login.jsp");
		
	}
}
