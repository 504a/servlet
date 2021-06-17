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

import model.User;
import repository.UserRepository;
import service.UserService;

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

		UserRepository repository = new UserRepository("sample", "root", "1234");
		UserService service = new UserService(repository);

		User user = service.findById(id);
		request.setAttribute("user", user);

		// 性別マップの作成
		HttpSession session = request.getSession();

		if (session.getAttribute("genderMap") == null) {
			Map<String, Boolean> genderMap = new HashMap<>();
			if ("男".equals(user.getGender())) {
				genderMap.put("male", true);
			} else {
				genderMap.put("female", true);
			}
			request.setAttribute("genderMap", genderMap);
		}

		// 転送
		String view = "/WEB-INF/view/update/form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
