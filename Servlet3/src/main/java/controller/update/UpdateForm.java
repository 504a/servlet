package controller.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateForm() {
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
		// データベースからの読み込み
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		MemberRepository repository = new MemberRepository("sample", "root", "1234");
		MemberService service = new MemberService(repository);

		Member member = service.findById(id);
		request.setAttribute("member", member);

		// トークンの作成
		HttpSession session = request.getSession();
		String token = Csrf.getCsrfToken();// トークンの生成
		session.setAttribute("token", token);// セッションへの保存

		// 転送
		String view = "/WEB-INF/view/update/form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
