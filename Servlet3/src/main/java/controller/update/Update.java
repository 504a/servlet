package controller.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lib.Csrf;
import model.Member;
import repository.MemberRepository;
import service.MemberService;

/**
 * Servlet implementation class Create
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// トークンチェック
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String formToken = request.getParameter("token");

		if (Csrf.checkToken(session, formToken)) {
			// データベースの接続
			MemberRepository repository = new MemberRepository("sample", "root", "1234");
			MemberService service = new MemberService(repository);

			// 更新の実行
			Member member = (Member) session.getAttribute("member");
			String id = Integer.toString(member.getId());
			String name = member.getName();
			String zip = member.getZip();
			String address1 = member.getAddress1();
			String address2 = member.getAddress2();
			String phone = member.getPhone();
			String remarks = member.getRemarks();
			System.out.println(address2);
			service.save(id, name, zip, address1, address2, phone, remarks);

			response.sendRedirect("./");
		} else {
			response.sendRedirect("./");
		}

	}

}
