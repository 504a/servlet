package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberRepository {
	private String db;
	private String user;
	private String pass;

	public MemberRepository(String db, String user, String pass) {
		this.db = db;
		this.user = user;
		this.pass = pass;
	}

	public Connection connect() {
		final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
		String url = "jdbc:mariadb://localhost:3306/" + db + PROPATIES;

		//
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("データベースドライバが読み込めません");
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("データベース接続成功");
		} catch (SQLException sqlEx) {
			System.out.println("データベース接続失敗");
			sqlEx.printStackTrace();
		}
		return conn;
	}
}
