package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FollowDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/X_db?useSSL=false&serverTimezone=UTC";
	private static final String DB_USER = "test";
	private static final String DB_PASSWORD = "dyfkmochi941523";

	// フォローする
	public static boolean follow(int followerId, int followeeId) {
		String sql = "INSERT INTO follows (follower_id, followee_id) VALUES (?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, followerId);
			stmt.setInt(2, followeeId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// フォロー解除
	public static boolean unfollow(int followerId, int followeeId) {
		String sql = "DELETE FROM follows WHERE follower_id = ? AND followee_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, followerId);
			stmt.setInt(2, followeeId);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// フォローしているかどうか確認
	public static boolean isFollowing(int followerId, int followeeId) {
		String sql = "SELECT 1 FROM follows WHERE follower_id = ? AND followee_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, followerId);
			stmt.setInt(2, followeeId);
			ResultSet rs = stmt.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// フォロワー数取得
	public static int getFollowerCount(int userId) {
		String sql = "SELECT COUNT(*) FROM follows WHERE followee_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// フォロー中の人数取得
	public static int countFollowing(int userId) {
		String sql = "SELECT COUNT(*) FROM follows WHERE follower_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
