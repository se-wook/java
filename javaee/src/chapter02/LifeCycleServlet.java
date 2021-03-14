package chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/lifecycle.do")
public class LifeCycleServlet extends HttpServlet {
	int cnt = 1;
	private static final long serialVersionUID = 1L;
       
	/**
	 * init()
	 * - 서블릿 객체 생성후 자동으로 호출되는 LifeCycle 메서드
	 * - 한번 수행됨
	 * - 서블릿에 대한 초기화
	 */
	public void init() throws ServletException {
		System.out.println("init method 호출");
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출됨");
		PrintWriter out = response.getWriter();
		for(int i=0;i<100;i++) {
			out.print(cnt++);
			out.flush();
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				
			}
		}
	}
	
	/**
	 * destroy()
	 * - 서블릿이 메모리에서 unload 될 때 호출되는 LifeCycle 메서드
	 * - 한번 수행됨
	 * - 서블릿에서 사용한 자원이 있다면 반납하는 코드 작성
	 */
	public void destroy() {
		
		System.out.println("destroy 호출됨");
	}


}
