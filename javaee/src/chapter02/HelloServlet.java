package chapter02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

// @WebServlet("/요청 url") : 웹에서 요청할 url을 web.xml에 등록
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * doGet
	 * - 서비스 메서드의 한 종류
	 * - get방식으로 요청이 들어오면 호출되는 서비스 메서드
	 * - 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 출력 스트림에 대한 인코딩을 UTF-8로 변경해줘야됨 // 기본 : ISO-8859-1
		// response.setCharacterEncoding("UTF-8");
		// client에게 응답할 수 있는 출력 스트림을 추출해옴
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("<h1>helloworld</h1>");
		Date toDate = new Date();
		out.println("<p>현재시간: ");
		out.println(toDate.toLocaleString());
		out.println("</p></body></html>");

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
