package com.cafe24.jblog2.vo;

public class BlogVo 
{
	private String ID;
	private String TITLE;
	private String LOGO;
	

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getLOGO() {
		return LOGO;
	}
	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}
	
	public void DefaultBlogSetting(String ID)
	{
		this.ID = ID;
		TITLE = ID + "님의 블로그";
		LOGO = "/assets/images/spring-LOGO.jpg";
	}
	
	@Override
	public String toString() {
		return "BlogVo [ID=" + ID + ", TITLE=" + TITLE + ", LOGO=" + LOGO + "]";
	}
	
	
}
