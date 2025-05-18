package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AuthTokenDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/X_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "test";
    private static final String DB_PASSWORD = "dyfkmochi941523";

    // トークンを保存する（ログイン時）
    public static void saveToken(int userId, String token) {
        String sql = "INSERT INTO auth_tokens (user_id, token, expires_at) VALUES (?, ?, ?)";
        try (
            Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, token);
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now().plusDays(7))); // 7日間有効
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // トークンからユーザーIDを取得
    public static Integer findUserIdByToken(String token) {
        String sql = "SELECT user_id FROM auth_tokens WHERE token = ? AND expires_at > NOW()";
        try (
            Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // トークンを削除（ログアウト時）
    public static void deleteToken(String token) {
        String sql = "DELETE FROM auth_tokens WHERE token = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
