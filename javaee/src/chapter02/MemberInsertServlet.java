package chapter02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/memberinsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService service = new MemberServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. 요청 정보 추출
		
		String id 	= request.getParameter("id");
		String pw 	= request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		//2. 모델 수행
		
		try {
			Member member = new Member(id, pw, name, email, phone, address);
			service.add(member);
			// insert, update, delete 를 수행한 후에는 redirect로 이동
			response.sendRedirect("memberSearch.do?id="+id);
			//3. 수행 결과를 request에 저장
//			request.setAttribute("member", member);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("MemberInsertResult.jsp").forward(request, response);;
		}
				
		//4. page 이동
		// dispatcher 객체를 이용해서 include 하거나 forward 할 수 잇음. (같은 컨텍스트 내)
		
	}

}
