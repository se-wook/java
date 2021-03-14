package chapter02;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.domain.Goods;

/**
 * Servlet implementation class InsertCartServlet
 */
@WebServlet("/insertcart.do")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String proname = request.getParameter("proname");
		int proprice = Integer.parseInt(request.getParameter("proprice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		HttpSession session = request.getSession();
		HashMap<Integer, Goods> cart = (HashMap<Integer,Goods>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		
		Goods goods = cart.get(no);
		
		if(goods == null) {
			cart.put(no, new Goods(no, proname, proprice, quantity));
		}else {
			goods.setQuantity(goods.getQuantity()+quantity);
		}
		System.out.println(cart);
		// -------
		
//		response.sendRedirect("book.html");
//		
//		Goods good = new Goods(no, proname, proprice, quantity);
//		map.put(no, good);
//		
		try {
			session.setAttribute("cart", cart);
			response.sendRedirect("cart1/OrderPreview.jsp");
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
	}

}
