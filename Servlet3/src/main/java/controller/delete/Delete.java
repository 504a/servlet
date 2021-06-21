package controller.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lib.Csrf;
import repository.MemberRepository;
import service.MemberService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
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
			// リクエストパラメーターの受取
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			System.out.println(id);
			// データベースの接続
			MemberRepository repository = new MemberRepository("sample", "root", "1234");
			MemberService service = new MemberService(repository);

			service.delete(id);

			response.sendRedirect("./");
		} else {
			response.sendRedirect("./");
		}

	}

}
