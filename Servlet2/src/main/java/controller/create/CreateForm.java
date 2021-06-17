package controller.create;

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

/**
 * Servlet implementation class Create
 */
@WebServlet("/CreateForm")
public class CreateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 性別の初回アクセス用初期化
		HttpSession session = request.getSession();
		if (session.getAttribute("genderMap") == null) {
			Map<String, Boolean> genderMap = new HashMap<>();
			genderMap.put("male", true);
			session.setAttribute("genderMap", genderMap);
		}

		// トークンの作成
		String token = Csrf.getCsrfToken();// トークンの生成
		session.setAttribute("token", token);// セッションへの保存

		// 転送
		String view = "/WEB-INF/view/create/form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
