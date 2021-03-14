package ws3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/login2.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String idsave = request.getParameter("idsave");
		
		Cookie cookie = new Cookie("id",id);
		if(idsave != null) {
			cookie.setMaxAge(10000000);
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		 
		try {
			service.login(id, pw);
			HttpSession session = request.getSession();
			session.setAttribute("id", id); // 프로그램에 맞는 인증 정보를 session ex) 권한, 
			response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}
}
