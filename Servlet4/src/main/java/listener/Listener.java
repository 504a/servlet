package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * Default constructor. 
	 */
	public Listener() {
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		sc.log("セッションが作成されました");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		sc.log("セッションが破棄されました");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		ServletContext sc = event.getSession().getServletContext();
		String name = event.getName();
		Object value = event.getValue();
		sc.log("追加：" + name + ":" + value.toString());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		ServletContext sc = event.getSession().getServletContext();
		String name = event.getName();
		Object value = event.getValue();
		sc.log("削除：" + name + ":" + value.toString());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		ServletContext sc = event.getSession().getServletContext();
		String name = event.getName();
		Object value = event.getValue();
		sc.log("変更：" + name + ":" + value.toString());
	}

}
