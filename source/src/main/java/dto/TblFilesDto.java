package dto;

import java.io.Serializable;

public class TblFilesDto extends CustomTemplateDto implements Serializable {
	
	private int id;
	private String filename;
	private byte[] filedata;
	
	public TblFilesDto(int id, String filename, byte[] filedata) {
		super();
		this.id = id;
		this.filename = filename;
		this.filedata = filedata;
	}

	public TblFilesDto() {
		this(0,"",new byte[0]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	
	
}
