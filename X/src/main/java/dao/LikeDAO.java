package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/X_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "test";
    private static final String DB_PASSWORD = "dyfkmochi941523";

    // いいね追加
    public static boolean addLike(int userId, int postId) {
        String sql = "INSERT IGNORE INTO likes (user_id, post_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, postId);
            return stmt.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // いいね取り消し
    public static boolean removeLike(int userId, int postId) {
        String sql = "DELETE FROM likes WHERE user_id = ? AND post_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, postId);
            return stmt.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // いいね数を取得
    public static int countLikes(int postId) {
        String sql = "SELECT COUNT(*) FROM likes WHERE post_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, postId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // ユーザーがその投稿にいいねしているかを判定
    public static boolean hasLiked(int userId, int postId) {
        String sql = "SELECT 1 FROM likes WHERE user_id = ? AND post_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, postId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
