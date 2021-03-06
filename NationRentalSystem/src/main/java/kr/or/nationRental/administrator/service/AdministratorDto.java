package kr.or.nationRental.administrator.service;
import java.sql.Date;

public class AdministratorDto {
	private String adminId;  //관리자 ID
	private String adminPw; //관리자 PW
	private String functionaryNum; //공무원번호
	private String adminPhone; //관리자 전화번호
	private String adminName; //관리자명
	private Date adminDateJoin; //가입일자
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getFunctionaryNum() {
		return functionaryNum;
	}
	public void setFunctionaryNum(String functionaryNum) {
		this.functionaryNum = functionaryNum;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getAdminDateJoin() {
		return adminDateJoin;
	}
	public void setAdminDateJoin(Date adminDateJoin) {
		this.adminDateJoin = adminDateJoin;
	}
	
	@Override
	public String toString() {
		return "AdministratorDto [adminId=" + adminId + ", adminPw=" + adminPw + ", functionaryNum=" + functionaryNum
				+ ", adminPhone=" + adminPhone + ", adminName=" + adminName + ", adminDateJoin=" + adminDateJoin + "]";
	}


}