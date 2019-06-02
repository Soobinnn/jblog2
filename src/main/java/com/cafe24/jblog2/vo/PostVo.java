package com.cafe24.jblog2.vo;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class PostVo 
{
	private long POST_NO;
	@NotEmpty
	private String TITLE;
	@NotEmpty
	private String CONTENT;
	private Date REG_DATE;
	private long CATEGORY_NO;
	private String ID;
	
	public long getPOST_NO() {
		return POST_NO;
	}
	public void setPOST_NO(long pOST_NO) {
		POST_NO = pOST_NO;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Date getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public long getCATEGORY_NO() {
		return CATEGORY_NO;
	}
	public void setCATEGORY_NO(long cATEGORY_NO) {
		CATEGORY_NO = cATEGORY_NO;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "PostVo [POST_NO=" + POST_NO + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", REG_DATE=" + REG_DATE
				+ ", CATEGORY_NO=" + CATEGORY_NO + "]";
	}
	
	
}
