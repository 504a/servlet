package lib;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

public class Csrf {
	private static int TOKEN_LENGTH = 16;// 16*2=32バイト

	// 32バイトのCSRFトークンを作成
	public static String getCsrfToken() {
		byte token[] = new byte[TOKEN_LENGTH];
		StringBuffer buf = new StringBuffer();
		SecureRandom random = null;

		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			random.nextBytes(token);

			for (int i = 0; i < token.length; i++) {
				buf.append(String.format("%02x", token[i]));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return buf.toString();
	}

	public static boolean checkToken(HttpSession session, String formToken) {
		String token = (String) session.getAttribute("token");
		if (token != null) {
			if (token.equals(formToken))
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
}
