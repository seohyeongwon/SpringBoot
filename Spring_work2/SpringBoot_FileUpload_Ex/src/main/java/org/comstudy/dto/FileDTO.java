package org.comstudy.dto;

public class FileDTO {
	private String uuid;
	private String fileName;
	private String contentType;

	public FileDTO() {
		// TODO Auto-generated constructor stub
	}

	public FileDTO(String uuid, String fileName, String contentType) {
		this.uuid = uuid;
		this.fileName = fileName;
		this.contentType = contentType;

		System.out.println(">>>>> " + this.toString());
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "FileDTO [uuid=" + uuid + ", fileName=" + fileName + ", contentType=" + contentType + "]";
	}
	
	

}