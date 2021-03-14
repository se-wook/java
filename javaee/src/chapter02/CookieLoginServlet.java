package chapter02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/cookielogin.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String idsave = request.getParameter("idsave");
		
		Cookie cookie = new Cookie("id",id);
		if(idsave != null) {
			cookie.setMaxAge(10000000);
		}else {
			cookie.setMaxAge(0);
		}

		response.addCookie(cookie);
		response.sendRedirect("CookieLogin.jsp");
	}

}
