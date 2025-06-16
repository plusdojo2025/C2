package dto;

import java.io.Serializable;

public class TblStockprefoodDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int prefoodNumber;
	private String prefoodName;
	private java.sql.Date prefoodDate;
	private int userNumber;
	
	//フィールドを使用したコンストラクタ
	public TblStockprefoodDto(int prefoodNumber, String prefoodName, java.sql.Date prefoodDate, int userNumber) {
		super();
		this.prefoodNumber = prefoodNumber;
		this.prefoodName = prefoodName;
		this.prefoodDate = prefoodDate;
		this.userNumber = userNumber;
	}
	//スーパークラスから生成したコンストラクタ
	public TblStockprefoodDto() {
		this(0,"",null,0);
	}

	//ゲッタとセッタ
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

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
}

