package dto;

import java.io.Serializable;

public class TblLifehacklistDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int lifehackNumber;
	private String title;
	private String photo;
	private String textline;
	
	//フィールドを使用したコンストラクタ
	public TblLifehacklistDto(int lifehackNumber, String title, String photo, String textline) {
		super();
		this.lifehackNumber = lifehackNumber;
		this.title = title;
		this.photo = photo;
		this.textline = textline;
	}

	//スーパークラスから生成したコンストラクタ
	public TblLifehacklistDto() {
		this(0,"","","");
	}
	
	//ゲッタとセッタ
	public int getLifehackNumber() {
		return lifehackNumber;
	}

	public void setLifehackNumber(int lifehackNumber) {
		this.lifehackNumber = lifehackNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTextline() {
		return textline;
	}

	public void setTextline(String textline) {
		this.textline = textline;
	}
	
}
