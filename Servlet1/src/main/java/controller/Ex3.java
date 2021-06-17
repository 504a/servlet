package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex3() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ex3/form.html");// �f�B�X�p�b�`���쐬
		rd.forward(request, response);//�t�H���[�h
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// �����R�[�h�̐ݒ�

		//�t�H�[������̎擾
		String name = request.getParameter("name");// ���O�̎擾
		String cl = request.getParameter("cl");// �N���X�̎擾
		String jap = request.getParameter("jap");// ����̎擾
		String math = request.getParameter("math");// ���w�̎擾
		String eng = request.getParameter("eng");// �p��̎擾

		//���N�G�X�g�ɃZ�b�g
		request.setAttribute("name", name);
		request.setAttribute("cl", cl);
		request.setAttribute("jap", jap);
		request.setAttribute("math", math);
		request.setAttribute("eng", eng);

		//�t�H���[�h
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

}
