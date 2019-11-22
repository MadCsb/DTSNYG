package com.msy.travel.common;

import java.io.File;

public class UploadFilePojo {
	
	private String realName;
	private File file;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
