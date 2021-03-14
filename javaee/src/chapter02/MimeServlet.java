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
 * Servlet implementation class MimeServlet
 */
@WebServlet("/mime.do")
public class MimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
//		response.setContentType("text/xml");
		response.setContentType("application/vnd.ms-excels");
		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html><head><meta charset='UTF-8'/></head>");
//		out.println("<body>");
//		out.println("<h1>helloworld</h1>");
//		Date toDate = new Date();
//		out.println("<p>현재시간: ");
//		out.println(toDate.toLocaleString());
//		out.println("</p></body></html>");
		
		out.print("300\t500\t200");
		
	}
}
