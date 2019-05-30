package com.cafe24.jblog2.vo;

import java.util.Date;

public class CategoryVo 
{
	private long CATEGORY_NO;
	private String CATEGORY_NAME;
	private String DESCRIPTION;
	private Date REG_DATE;
	private String ID;
	private long postCount;
	
	public long getCATEGORY_NO() {
		return CATEGORY_NO;
	}
	public void setCATEGORY_NO(long cATEGORY_NO) {
		CATEGORY_NO = cATEGORY_NO;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Date getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}
	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
	}
	
	public long getPostCount() {
		return postCount;
	}
	public void setPostCount(long postCount) {
		this.postCount = postCount;
	}
	@Override
	public String toString() {
		return "CategoryVo [CATEGORY_NO=" + CATEGORY_NO + ", CATEGORY_NAME=" + CATEGORY_NAME + ", DESCRIPTION="
				+ DESCRIPTION + ", REG_DATE=" + REG_DATE + ", ID=" + ID + "]";
	}

}
