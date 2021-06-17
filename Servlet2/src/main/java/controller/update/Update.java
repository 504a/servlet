package controller.update;

import java.io.IOException;

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
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
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
		UserRepository repository = new UserRepository("sample", "root", "1234");
		UserService service = new UserService(repository);

		// 更新の実行
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String id = Integer.toString(user.getId());
		String name = user.getName();
		String gender = user.getGender();
		String age = Integer.toString(user.getAge());

		service.save(id, name, gender, age);

		response.sendRedirect("./");
	}

}
