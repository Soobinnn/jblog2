package com.cafe24.jblog2.vo;

import java.sql.Date;

public class UserVo 
{
	private String ID;
	private String NAME;
	private String PASSWORD;
	private Date REG_DATE;
	
	public UserVo()
	{
		
	}
	public UserVo(String ID, String PASSWORD)
	{
		this.ID = ID;
		this.PASSWORD = PASSWORD;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Date getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	
	@Override
	public String toString() {
		return "UserVo [ID=" + ID + ", NAME=" + NAME + ", PASSWORD=" + PASSWORD + ", REG_DATE=" + REG_DATE + "]";
	}
	
	
}
