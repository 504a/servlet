package controller.update;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lib.Csrf;
import model.User;

/**
 * Servlet implementation class CreateConfirm
 */
@WebServlet("/UpdateConfirm")
public class UpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateConfirm() {
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
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));

			// 性別マップ作成
			Map<String, Boolean> genderMap = new HashMap<>();
			if ("男".equals(gender)) {
				genderMap.put("male", true);
			} else {
				genderMap.put("female", true);
			}

			// セッションへ保存
			// トークンの作成
			String token = Csrf.getCsrfToken();// トークンの生成
			session.setAttribute("token", token);// セッションへの保存
			User user = new User(id, name, gender, age);
			session.setAttribute("user", user);
			session.setAttribute("genderMap", genderMap);

			String view = "/WEB-INF/view/update/confirm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("./");
		}

	}

}
