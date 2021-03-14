package ws3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dao.ProductDAO;
import com.ssafy.model.dao.ProductDAOImp;
import com.ssafy.model.dto.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO product = new ProductDAOImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		int gno = 0;
		try {
			gno = product.lastSearch();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String brand = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("desc");
		
		Cookie cookieGno = new Cookie("no", Integer.toString(gno+1));
		Cookie cookieBrand = new Cookie("brand",brand);
		Cookie cookiePrice = new Cookie("price",price);
		Cookie cookieInfo = new Cookie("info",info);
		
		cookieGno.setMaxAge(10000);
		cookieBrand.setMaxAge(10000);
		cookiePrice.setMaxAge(10000);
		cookiePrice.setMaxAge(10000);
		
		response.addCookie(cookieGno);
		response.addCookie(cookieBrand);
		response.addCookie(cookiePrice);
		response.addCookie(cookieInfo);
		
		Product pd = new Product(brand, price, info);
		
		try {
			//db 저장
			product.add(pd);
			
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		response.sendRedirect("Login.jsp");
	}


}
