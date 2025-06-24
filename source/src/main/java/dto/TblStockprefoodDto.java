package dto;

import java.io.Serializable;

public class TblStockprefoodDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int prefoodNumber;
	private String prefoodName;
	private java.sql.Date prefoodDate;
	private int prefoodQuantity;
	private int userNumber;
	private boolean checked;
	
	//フィールドを使用したコンストラクタ
	public TblStockprefoodDto(int prefoodNumber, String prefoodName, java.sql.Date prefoodDate, int prefoodQuantity, int userNumber, boolean checked) {
		super();
		this.prefoodNumber = prefoodNumber;
		this.prefoodName = prefoodName;
		this.prefoodDate = prefoodDate;
		this.prefoodQuantity = prefoodQuantity;
		this.userNumber = userNumber;
		this.checked = checked;
	}
	
	//スーパークラスから生成したコンストラクタ
	public TblStockprefoodDto() {
		this(0,"",null,0,0,false);
	}
	public int getPrefoodNumber() {
		return prefoodNumber;
	}
	public void setPrefoodNumber(int prefoodNumber) {
		this.prefoodNumber = prefoodNumber;
	}
	public String getPrefoodName() {
		return prefoodName;
	}
	public void setPrefoodName(String prefoodName) {
		this.prefoodName = prefoodName;
	}
	public java.sql.Date getPrefoodDate() {
		return prefoodDate;
	}
	public void setPrefoodDate(java.sql.Date prefoodDate) {
		this.prefoodDate = prefoodDate;
	}
	public int getPrefoodQuantity() {
		return prefoodQuantity;
	}
	public void setPrefoodQuantity(int prefoodQuantity) {
		this.prefoodQuantity = prefoodQuantity;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

