package kr.or.nationRental.functionary.service;
import java.sql.Date;

public class FunctionaryDto {
	private String functionaryId; //공무원가입 아이디
	private int adminagencyCode; //공무원등록 행정구역코드
	private String adminagencyName; //공무원등록 행정구역명
	private int functionaryNum; //공무원번호
	private String functionaryPw; //공무원가입 비밀번호
	private String functionaryName; //공무원명
	private int functionaryPhone; //공무원 전화번호
	private String functionaryEmail; //공무원 이메일
	private Date functionaryDateJoin; //공무원 가입 날짜
	
	public String getFunctionaryId() {
		return functionaryId;
	}
	public void setFunctionaryId(String functionaryId) {
		this.functionaryId = functionaryId;
	}
	public int getAdminagencyCode() {
		return adminagencyCode;
	}
	public void setAdminagencyCode(int adminagencyCode) {
		this.adminagencyCode = adminagencyCode;
	}
	public String getAdminagencyName() {
		return adminagencyName;
	}
	public void setAdminagencyName(String adminagencyName) {
		this.adminagencyName = adminagencyName;
	}
	public int getFunctionaryNum() {
		return functionaryNum;
	}
	public void setFunctionaryNum(int functionaryNum) {
		this.functionaryNum = functionaryNum;
	}
	public String getFunctionaryPw() {
		return functionaryPw;
	}
	public void setFunctionaryPw(String functionaryPw) {
		this.functionaryPw = functionaryPw;
	}
	public String getFunctionaryName() {
		return functionaryName;
	}
	public void setFunctionaryName(String functionaryName) {
		this.functionaryName = functionaryName;
	}
	public int getFunctionaryPhone() {
		return functionaryPhone;
	}
	public void setFunctionaryPhone(int functionaryPhone) {
		this.functionaryPhone = functionaryPhone;
	}
	public String getFunctionaryEmail() {
		return functionaryEmail;
	}
	public void setFunctionaryEmail(String functionaryEmail) {
		this.functionaryEmail = functionaryEmail;
	}
	public Date getFunctionaryDateJoin() {
		return functionaryDateJoin;
	}
	public void setFunctionaryDateJoin(Date functionaryDateJoin) {
		this.functionaryDateJoin = functionaryDateJoin;
	}
	@Override
	public String toString() {
		return "functionary [functionaryId=" + functionaryId + ", adminagencyCode=" + adminagencyCode
				+ ", adminagencyName=" + adminagencyName + ", functionaryNum=" + functionaryNum + ", functionaryPw="
				+ functionaryPw + ", functionaryName=" + functionaryName + ", functionaryPhone=" + functionaryPhone
				+ ", functionaryEmail=" + functionaryEmail + ", functionaryDateJoin=" + functionaryDateJoin + "]";
	}
	
	
}
