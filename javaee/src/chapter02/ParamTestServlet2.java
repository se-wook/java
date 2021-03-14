package chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamTestServlet1
 */
@WebServlet("/param2.do")
public class ParamTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청데이터에 대한 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		//응답데이터에 대한 인코딩 설정
		response.setCharacterEncoding("UTF-8");
		/*
		 * String getQueryString()
		 *  - get방식 전용
		 *  - ? 뒤의 querystring 을 한번에 추출해줌
		 */
		String query= request.getQueryString();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'/></head>");
		out.println("<body>");
		out.println("쿼리스트링 : " + query);
		out.println("</body></html>");
	}

}
