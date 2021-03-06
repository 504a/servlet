package controller.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// データベースの接続
		MemberRepository repository = new MemberRepository("sample", "root", "1234");
		MemberService service = new MemberService(repository);

		// 更新の実行
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id = Integer.toString(member.getId());
		String name = member.getName();
		String zip = member.getZip();
		String address1 = member.getAddress1();
		String address2 = member.getAddress2();
		String phone = member.getPhone();
		String remarks = member.getRemarks();

		//更新の実行
		service.save(id, name, zip, address1, address2, phone, remarks);

		response.sendRedirect("./");

	}

}
