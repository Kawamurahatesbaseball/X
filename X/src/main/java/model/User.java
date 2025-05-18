package model;

public class User {
	private int id;
	private String name;
	private String passwordHash;
	private String iconUrl;
	private String bio;

	// 新規登録時のコンストラクタ（IDなし）
	public User(String name, String passwordHash) {
		this.name = name;
		this.passwordHash = passwordHash;
	}

	// データベース取得時のコンストラクタ（IDあり）
	public User(int id, String name, String passwordHash, String bio) {
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
		this.bio = bio;
	}

	// ゲッター
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
