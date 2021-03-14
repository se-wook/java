package chapter02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
@WebServlet("/mime2.do")
public class MimeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		String path = "c:/ssafy/logo.png";
		
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(path);
			os = response.getOutputStream();
			
			byte[] buf = new byte[1024]; // 많은양의 데이터에서 
			int len = 0;
			while((len=fis.read(buf)) != -1) {
				os.write(buf, 0,len);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			os.close();
			fis.close();
		}
	}
}
