package dto;

import java.io.Serializable;

public class TblLifehackfavoriteDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private String familyId;
	private int lifehackNumber;
	
	//フィールドを使用したコンストラクタ
	public TblLifehackfavoriteDto(String familyId, int lifehackNumber) {
		super();
		this.familyId = familyId;
		this.lifehackNumber = lifehackNumber;
	}
	
	//スーパークラスから生成したコンストラクタ
	public TblLifehackfavoriteDto() {
		this("",0);
	}
	
	//ゲッタとセッタ
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
	
}
