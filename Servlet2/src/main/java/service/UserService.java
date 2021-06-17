package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import repository.UserRepository;

public class UserService {
	private UserRepository repository;

	public UserService(UserRepository userRepository) {
		this.repository = userRepository;
	}

	/**
	 * 全検索 findAll()
	 * 
	 * @return ユーザーの全件リスト List<User>
	 */
	public List<User> findAll() {

		// SQLの実行
		String sql = "select * from users";
		List<User> list = new ArrayList<>();

		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				list.add(new User(id, name, gender, age));
			}

			rs.close();
			list.forEach(System.out::println);
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 主キーを指定して検索
	 * 
	 * @param pk 主キー String
	 * @return 検索されたレコード User
	 */
	public User findById(String pk) {

		// SQLの実行
		String sql = "select * from users where id = ?";
		User user = null;

		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, pk);/// 主キーのセット
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				user = new User(id, name, gender, age);
				System.out.println(user);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 主キーを指定してレコードを削除
	 * 
	 * @param pk 主キー String
	 */
	public void delete(String pk) {
		String sql = "delete from users where id = ?";

		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, pk);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
	}

	/**
	 * 新規作成
	 * 
	 * @param name 名前 String
	 * @param gender 性別 String
	 * @param age 年齢 String
	 */

	public void save(String name, String gender, String age) {
		String sql = "insert into users (name,gender,age) values(?,?,?)";
		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, age);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
	}

	/**
	 * 更新処理
	 * 
	 * @param id id String
	 * @param name 名前 String
	 * @param gender 性別 String
	 * @param age 年齢 String
	 */
	public void save(String id, String name, String gender, String age) {
		String sql = "UPDATE users SET name = ?,gender = ?,age = ? WHERE id = ?";
		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, age);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
	}
}
