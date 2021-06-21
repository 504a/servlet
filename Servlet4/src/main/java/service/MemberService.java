package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import repository.MemberRepository;

public class MemberService {
	private MemberRepository repository;

	public MemberService(MemberRepository MemberRepository) {
		this.repository = MemberRepository;
	}

	/**
	 * 全検索 findAll()
	 * 
	 * @return ユーザーの全件リスト List<Member>
	 */
	public List<Member> findAll() {

		// SQLの実行
		String sql = "select * from Members";
		List<Member> list = new ArrayList<>();

		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String zip = rs.getString("zip");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String phone = rs.getString("phone");
				String remarks = rs.getString("remarks");
				list.add(new Member(id, name, zip, address1, address2, phone, remarks));
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
	 * @return 検索されたレコード Member
	 */
	public Member findById(String pk) {

		// SQLの実行
		String sql = "select * from Members where id = ?";
		Member Member = null;

		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, pk);/// 主キーのセット
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String zip = rs.getString("zip");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String phone = rs.getString("phone");
				String remarks = rs.getString("remarks");
				Member = new Member(id, name, zip, address1, address2, phone, remarks);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
		return Member;
	}

	/**
	 * 主キーを指定してレコードを削除
	 * 
	 * @param pk 主キー String
	 */
	public void delete(String pk) {
		String sql = "delete from Members where id = ?";

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
	 */

	public void save(String name, String zip, String address1, String address2, String phone, String remarks) {
		String sql = "insert into Members (name,zip,address1,address2,phone,remarks) values(?,?,?,?,?,?)";
		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, zip);
			ps.setString(3, address1);
			ps.setString(4, address2);
			ps.setString(5, phone);
			ps.setString(6, remarks);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
	}

	/**
	 * 更新処理
	 * 
	 */
	public void save(String id, String name, String zip, String address1, String address2, String phone,
			String remarks) {
		String sql = "UPDATE Members SET name = ?,zip = ?,address1 = ?,address2 = ?,phone = ?,remarks = ? WHERE id = ?";
		try (Connection conn = repository.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, zip);
			ps.setString(3, address1);
			ps.setString(4, address2);
			ps.setString(5, phone);
			ps.setString(6, remarks);
			ps.setString(7, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLエラー");
			e.printStackTrace();
		}
	}
}
