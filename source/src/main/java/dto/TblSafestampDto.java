package dto;

import java.io.Serializable;

public class TblSafestampDto extends CustomTemplateDto implements Serializable {
	//フィールド生成
	private int safeNumber;
	private String status;
	private String familyId;
	private int userNumber;
	
	//JOINでユーザー名生成（テスト中）
	private String name;

	
	//フィールドを使用したコンストラクタ
	public TblSafestampDto(int safeNumber, String status, String familyId, int userNumber) {
		super();
		this.safeNumber = safeNumber;
		this.status = status;
		this.familyId = familyId;
		this.userNumber = userNumber;
	}
	
	//スーパークラスから生成したコンストラクタ
	public TblSafestampDto() {
		this(0,"","",0);
	}
	
	//ゲッタとセッタ
	public int getSafeNumber() {
		return safeNumber;
	}

	public void setSafeNumber(int safeNumber) {
		this.safeNumber = safeNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	//JOINでユーザー名ゲッタとセッタ（テスト中）
	public String getName() {
	    return name;
	} 
	public void setName(String name) {
	    this.name = name;
	}


	
}
