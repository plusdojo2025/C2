package dto;

import java.io.Serializable;

public class TblLifehackrequestDto extends CustomTemplateDto implements Serializable {
	private int registNumber;
	private String title;
	private String photo;
	private String textline;

	public TblLifehackrequestDto(int registNumber, String title, String photo, String textline) {
		super();
		this.registNumber = registNumber;
		this.title = title;
		this.photo = photo;
		this.textline = textline;
	}

	public TblLifehackrequestDto() {
		this(0,"","","");
	}

	public int getRegistNumber() {
		return registNumber;
	}

	public void setRegistNumber(int registNumber) {
		this.registNumber = registNumber;
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
	