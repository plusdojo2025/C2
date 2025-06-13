package dto;

import java.io.Serializable;

public class TblRegistfamilyDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private String familyId;
	
	//フィールドを使用したコンストラクタ
	public TblRegistfamilyDto(String familyId) {
		super();
		this.familyId = familyId;
		
	}
	//スーパークラスから生成したコンストラクタ
	public TblRegistfamilyDto() {
		this("");
	}

	//ゲッタとセッタ
	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
	

}
