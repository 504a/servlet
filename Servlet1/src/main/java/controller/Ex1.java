package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/ex1/form.html";// �]����URL
		RequestDispatcher rd = request.getRequestDispatcher(view);// �f�B�X�p�b�`���쐬
		rd.forward(request, response);//�t�H���[�h
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// �����R�[�h�̐ݒ�
		response.setContentType("text/html; charset=UTF-8");// �����R�[�h�̐ݒ�

		String name = request.getParameter("name");// ���O�̎擾
		String gender = request.getParameter("gender");// ���ʂ̎擾
		String age = request.getParameter("age");// �N��̎擾

		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);

		String view = "/WEB-INF/view/ex1/result.jsp";// �]����URL
		RequestDispatcher rd = request.getRequestDispatcher(view);// �f�B�X�p�b�`���쐬
		rd.forward(request, response);
	}

}
