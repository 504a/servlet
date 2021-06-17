package controller;

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

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Ex5")
public class Ex5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex5() {
		super();
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

		String view = "/WEB-INF/view/ex5/form.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");// 文字コードの設定

		// フォームからの値の取得
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String blood = request.getParameter("blood");
		String remarks = request.getParameter("remarks");

		// 表示用の趣味を結合
		String hobbyList = "";
		if (hobbys != null) {
			hobbyList = String.join(",", hobbys);
		}

		// 表示用の備考を作成（改行コードを<br/>に置き換える
		// jspの<c:out>を使用できないため手動のタグエスケープを実施
		String viewRemarks = remarks.replaceAll("<", "&lt;");
		viewRemarks = viewRemarks.replaceAll(">", "&gt;");
		viewRemarks = viewRemarks.replaceAll("\r\n", "<br/>");// windows以外は\n
		System.out.println(viewRemarks);

		// 結果表示のJSPへ転送する値のセット
		request.setAttribute("userName", userName);
		request.setAttribute("pass", pass);
		request.setAttribute("gender", gender);
		request.setAttribute("hobbyList", hobbyList);
		request.setAttribute("blood", blood);
		request.setAttribute("remarks", viewRemarks);

		// 性別Mapを作成
		Map<String, Boolean> genderMap = new HashMap<>();
		switch (gender) {
		case "male":
			genderMap.put("male", true);
			break;
		case "female":
			genderMap.put("female", true);
			break;
		default:
			genderMap.put("male", true);
		}

		// 趣味Mapを作成
		Map<String, Boolean> hobbyMap = new HashMap<>();
		if (hobbys != null) {
			for (String hobby : hobbys) {
				hobbyMap.put(hobby, true);
			}
		}

		// 趣味Mapを確認表示
		for (Map.Entry<String, Boolean> entry : hobbyMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		// 血液型Mapを作成
		Map<String, Boolean> bloodMap = new HashMap<>();
		switch (blood) {
		case "A":
			bloodMap.put("TypeA", true);
			break;
		case "B":
			bloodMap.put("TypeB", true);
			break;
		case "O":
			bloodMap.put("TypeO", true);
			break;
		case "AB":
			bloodMap.put("TypeAB", true);
			break;
		default:
			bloodMap.put("TypeA", true);// 仮に不明ならAとしている
		}

		// セッションに保存
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("pass", pass);
		session.setAttribute("genderMap", genderMap);
		session.setAttribute("bloodMap", bloodMap);
		session.setAttribute("hobbyMap", hobbyMap);
		session.setAttribute("remarks", remarks);

		String view = "/WEB-INF/view/ex5/view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
