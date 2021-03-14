package chapter02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookietest.do")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = request.getParameter("cookiename");
		String cookieValue = request.getParameter("cookievalue");
		/*
		 * 쿠키생성
		 * Cookie(String name, String value)
		 * - 쿠키이름은 영문으로만, value는 한글도 작성가능 (인코딩 설정해야한다 URIEncoder.encode(""))
		 */
		Cookie cookie = new Cookie(cookieName, cookieValue);
		/*
		 * 쿠키의 유효기간
		 * setMaxAge(int second);
		 * - 음수(-1)	: 메모리에만 저장, 브라우저 종료시 삭제됨
		 * - 0		: 기존에 발행한 쿠키를 삭제한다.
		 * - 양수		: 지정한 second 만큼 메모리에 유지
		 * 			: 단, 지정한 second 전에 부라우저가 종료되면 파일 형태로 저장됨.
		 * - F12 로 볼 수있다고함.
		 */
		cookie.setMaxAge(-1);
		
		// 쿠키 발행
		response.addCookie(cookie);
		response.sendRedirect("CookieTest.jsp");
	}
}
