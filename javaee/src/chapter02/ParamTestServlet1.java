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
@WebServlet("/param1.do")
public class ParamTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청데이터에 대한 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*
		 * String getParameter(String name)
		 *  - 요청 데이터 중에 name 해당하는 값 하나를 추출해서 문자열로 리턴
		 *  -  name에 해당하는 값이 없으면 null이 리턴됨.
		 */
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		/*
		 * String[] getParameterValues("name")
		 * - 요청 데이터 중에 name 해당하는 모든 값을 추출해서 String[]로 리턴
		 * - name에 해당하는 값이 없는 경우 null 리턴 
		 */
		
		String[] hobby = request.getParameterValues("habby");
		String job = request.getParameter("job");
		String content = request.getParameter("content");
		String page = request.getParameter("page");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'/></head>");
		out.println("<body>");
		out.println("아이디: "+id);
		out.println("</br>비밀번호: "+pw);
		if(hobby != null) {
			for(String h:hobby) {
				out.println("<br/>취미: "+h);
			}
		}
		out.println("</br>직업: "+job);
		out.println("</br>내용:"+content);
		out.println("</br>페이지번호:"+page);
		out.println("</br>");
		out.println("</body></html>");
	}

}
