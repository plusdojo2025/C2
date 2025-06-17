package dto;

import java.io.Serializable;

public class IdPw extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private String mail;
	private String password;


	//フィールドを使用したコンストラクタ
	public IdPw( String mail, String password) {
		super();
	
		this.mail = mail;
		this.password = password;

	}

	//スーパークラスから生成したコンストラクタ
	public IdPw() {
		this("", "");
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
}

