package dto;

import java.io.Serializable;

public class TblRegistuserDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int userNumber;
	private String mail;
	private String password;
	private String name;
	private String familyId;

	//フィールドを使用したコンストラクタ
	public TblRegistuserDto(int userNumber, String mail, String password, String name, String familyId) {
		super();
		this.userNumber = userNumber;
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.familyId = familyId;
	}

	//スーパークラスから生成したコンストラクタ
	public TblRegistuserDto() {
		this(0, "", "", "", "");
	}

	//ゲッタとセッタ
	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

}