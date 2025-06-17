package dto;

import java.io.Serializable;

public class TblLifehackfavoriteDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int lifehackfavoriteNumber;
	private String familyId;
	private int lifehackNumber;
	private TblLifehacklistDto lifehack;

	
	//フィールドを使用したコンストラクタ
	public TblLifehackfavoriteDto(int lifehackfavoriteNumber, String familyId, int lifehackNumber) {
		super();
		this.lifehackfavoriteNumber = lifehackfavoriteNumber;
		this.familyId = familyId;
		this.lifehackNumber = lifehackNumber;
		this.lifehack = new TblLifehacklistDto();
		this.lifehack.setLifehackNumber(lifehackNumber);
		
	}
	
	//スーパークラスから生成したコンストラクタ
	public TblLifehackfavoriteDto() {
		this(0,"", 0);
	}
	
	//ゲッタとセッタ
	public int getLifehackfavoriteNumber() {
		return lifehackfavoriteNumber;
	}

	public void setLifehackfavoriteNumber(int lifehackfavoriteNumber) {
		this.lifehackfavoriteNumber = lifehackfavoriteNumber;
	}
	
	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	
	
	public int getLifehackNumber() {
		return lifehackNumber;
	}

	public void setLifehackNumber(int lifehackNumber) {
		this.lifehackNumber = lifehackNumber;
	}

	public TblLifehacklistDto getLifehack() {
		return lifehack;
	}

	public void setLifehack(TblLifehacklistDto lifehack) {
		this.lifehack = lifehack;
	}
	
}
