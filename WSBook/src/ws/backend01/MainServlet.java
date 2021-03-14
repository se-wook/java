package ws.backend01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/sessionlogin.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'/></head>");
		out.println("<body>");
		if(id != null && pw != null && id.equals("ssafy") && pw.equals("1111")) {
			out.println("로그인 성공");
			out.println("<a href='book.html'>도서 등록</a>");
		}else {
			response.sendRedirect("Login.jsp");
//			out.println(id);
//			out.println(pw);
//			out.println("로그인 실패");
		}
		out.println("</body></html>");
	}

}
