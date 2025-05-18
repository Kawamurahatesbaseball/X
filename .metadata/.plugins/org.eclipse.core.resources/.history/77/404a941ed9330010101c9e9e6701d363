package model;

public class User {
	private int id;
	private String name;
	private String passwordHash;
	private String iconUrl;

	// 新規登録時のコンストラクタ（IDなし）
	public User(String name, String passwordHash) {
		this.name = name;
		this.passwordHash = passwordHash;
	}

	// データベース取得時のコンストラクタ（IDあり）
	public User(int id, String name, String passwordHash) {
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
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
}
