package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    // パスワードをSHA-256でハッシュ化するメソッド
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // 安全なハッシュ関数
            byte[] hashedBytes = md.digest(password.getBytes());

            // バイト列を16進数の文字列に変換
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("ハッシュ化に失敗しました", e);
        }
    }
}
