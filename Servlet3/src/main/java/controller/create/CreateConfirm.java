package controller.create;

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

/**
 * Servlet implementation class CreateConfirm
 */
@WebServlet("/CreateConfirm")
public class CreateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateConfirm() {
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
			// リクエストの取得
			String name = request.getParameter("name");
			String zip = request.getParameter("zip");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String phone = request.getParameter("phone");
			String remarks = request.getParameter("remarks");

			// セッションへ保存
			String token = Csrf.getCsrfToken();// トークンの生成
			session.setAttribute("token", token);// セッションへの保存
			Member member = new Member(0, name, zip, address1, address2, phone, remarks);
			session.setAttribute("member", member);

			String view = "/WEB-INF/view/create/confirm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("./");
		}
	}

}
