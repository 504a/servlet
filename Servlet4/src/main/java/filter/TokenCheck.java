package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lib.Csrf;

/**
 * Servlet Filter implementation class TokenCheck
 */
@WebFilter(urlPatterns = { "/CreateConfirm", "/Create", "/Delete", "/UpdateConfirm", "/Update" })
public class TokenCheck implements Filter {

	/**
	 * Default constructor.
	 */
	public TokenCheck() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// トークンチェック
		HttpSession session = ((HttpServletRequest) request).getSession();
		String formToken = request.getParameter("token");

		if (!Csrf.checkToken(session, formToken))
			((HttpServletResponse) response).sendRedirect("./");

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}
}
