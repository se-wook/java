package ws.backend01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String title=request.getParameter("title");
		String isbn=request.getParameter("isbn");
		String catalogue=request.getParameter("catalogue");
		String nation=request.getParameter("nation");
		String publisheDate=request.getParameter("publisheDate");
		String publisher=request.getParameter("publisher");
		String author=request.getParameter("author");
		String price=request.getParameter("price");
		String currency=request.getParameter("currency");
		String description=request.getParameter("description");
		
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("<center><h2>입력된 도서 정보</h2></center>");
		out.println("<table cellpadding=\"0\" cellspacing=\"1\" border=\"1\" width=\"650\" bgcolor=\"#EAEAEA\" align=\"center\">\r\n" + 
				"");
		out.println("<tr><td width=\"650\"  height=\"35\"  valign=\"middle\" align=\"right\" colspan=\"2\"><center>도서 정보</center>	</td></tr>	");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서명</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+title);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서번호</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+isbn);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서제목</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+catalogue);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서국가</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+nation);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">출판일</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+publisheDate);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">출판사</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+publisher);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">저자</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+author);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서가격</td>");
		out.println("<td bgcolor=\"#FFFFFF\" height=\"35\">"+price+""+currency);
		out.println("</td></tr>");
		out.println("<tr><td  height=\"35\" width=\"120\" valign=\"middle\">도서설명</td>");
		out.println("<td bgcolor=\"#FFFFFF\" >"+description);
		out.println("</td></tr>");
		out.println("</table>");
		out.println("<br><center><a href='book.html'>도서 등록</a></center>");
		out.println("</body></html>");
		
	}

}
