package dto;

import java.io.Serializable;

public class TblCheckbagDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int bagNumber;
	private boolean bagCheck;
	private String bagName;
	private int bagStock;
	private String bagLink;
	private int userNumber;
	
	//フィールドを使用したコンストラクタ
	public TblCheckbagDto(int bagNumber, boolean bagCheck, String bagName, int bagStock, String bagLink,
			int userNumber) {
		super();
		this.bagNumber = bagNumber;
		this.bagCheck = bagCheck;
		this.bagName = bagName;
		this.bagStock = bagStock;
		this.bagLink = bagLink;
		this.userNumber = userNumber;
	}

	//スーパークラスから生成したコンストラクタ
	public TblCheckbagDto() {
		this(0,false,"",0,"",0);
	}

	//ゲッタとセッタ
	public int getBagNumber() {
		return bagNumber;
	}


	public void setBagNumber(int bagNumber) {
		this.bagNumber = bagNumber;
	}


	public boolean getBagCheck() {
		return bagCheck;
	}


	public void setBagCheck(boolean bagCheck) {
		this.bagCheck = bagCheck;
	}


	public String getBagName() {
		return bagName;
	}


	public void setBagName(String bagName) {
		this.bagName = bagName;
	}


	public int getBagStock() {
		return bagStock;
	}


	public void setBagStock(int bagStock) {
		this.bagStock = bagStock;
	}


	public String getBagLink() {
		return bagLink;
	}


	public void setBagLink(String bagLink) {
		this.bagLink = bagLink;
	}


	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

}
