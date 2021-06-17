package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Ex4")
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex4() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ex4/form.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String blood = request.getParameter("blood");
		String remarks = request.getParameter("remarks");

		//System.out.println(userName);

		String hobbyList = String.join(",", hobbys);

		request.setAttribute("userName", userName);
		request.setAttribute("pass", pass);
		request.setAttribute("gender", gender);
		request.setAttribute("hobbyList", hobbyList);
		request.setAttribute("blood", blood);
		request.setAttribute("remarks", remarks);

		String view = "/WEB-INF/view/ex4/view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
