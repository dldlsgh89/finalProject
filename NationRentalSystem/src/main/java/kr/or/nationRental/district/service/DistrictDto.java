package kr.or.nationRental.district.service;

public class DistrictDto {
	private long sidoCode; //시도코드
	private String sidoName; //시도명
	private long sigunguCode; //시군구코드
	private long sigunguMiddleCode; //시군구 중분류코드
	private String sigunguName; //시군구명
	private long eupmyeonCode; //읍면동코드
	private long eupmyeonMiddleCode; //읍면동 중분류코드
	private String eupmyeonName; //읍면동명
	
	
	public long getSidoCode() {
		return sidoCode;
	}


	public void setSidoCode(long sidoCode) {
		this.sidoCode = sidoCode;
	}


	public String getSidoName() {
		return sidoName;
	}


	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}


	public long getSigunguCode() {
		return sigunguCode;
	}


	public void setSigunguCode(long sigunguCode) {
		this.sigunguCode = sigunguCode;
	}


	public long getSigunguMiddleCode() {
		return sigunguMiddleCode;
	}


	public void setSigunguMiddleCode(long sigunguMiddleCode) {
		this.sigunguMiddleCode = sigunguMiddleCode;
	}


	public String getSigunguName() {
		return sigunguName;
	}


	public void setSigunguName(String sigunguName) {
		this.sigunguName = sigunguName;
	}


	public long getEupmyeonCode() {
		return eupmyeonCode;
	}


	public void setEupmyeonCode(long eupmyeonCode) {
		this.eupmyeonCode = eupmyeonCode;
	}


	public long getEupmyeonMiddleCode() {
		return eupmyeonMiddleCode;
	}


	public void setEupmyeonMiddleCode(long eupmyeonMiddleCode) {
		this.eupmyeonMiddleCode = eupmyeonMiddleCode;
	}


	public String getEupmyeonName() {
		return eupmyeonName;
	}


	public void setEupmyeonName(String eupmyeonName) {
		this.eupmyeonName = eupmyeonName;
	}


	@Override
	public String toString() {
		return "DistrictDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", sigunguCode=" + sigunguCode
				+ ", sigunguMiddleCode=" + sigunguMiddleCode + ", sigunguName=" + sigunguName + ", eupmyeonCode="
				+ eupmyeonCode + ", eupmyeonMiddleCode=" + eupmyeonMiddleCode + ", eupmyeonName=" + eupmyeonName + "]";
	}
	
	
}
