/* 27기 koogle 이인호 */
package kr.or.nationRental.functionary.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.nationRental.agency.service.AgencyDto;
import kr.or.nationRental.annualfeePakage.service.AnnualfeePakageDto;
import kr.or.nationRental.goodsFacility.service.GoodsFacilityDto;
import kr.or.nationRental.login.service.MemberDto;
import kr.or.nationRental.returnGoodsfacilityInfo.service.ReturnGoodsfacilityInfoDto;
import kr.or.nationRental.unitedAfterserviceRequest.service.UnitedAfterserviceRequestDto;

@Repository
public class FunctionaryDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="kr.or.nationRental.functionary.service.FunctionaryMapper.";
	private static final Logger logger = LoggerFactory.getLogger(FunctionaryDao.class);
	
	//공무원 기본정보 insert
	public int insertFunctionary(FunctionaryDto functionaryDto) {	
		logger.debug("FunctionaryDao - insertFunctionary - functionaryDto : " + functionaryDto);
		int row = sqlSession.insert(NS+"insertFunctionary", functionaryDto);	
		return row;
	}
	
	//공무원 전출이력정보 insert
	public int insertFunctionaryMoveInout(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryDao - insertFunctionaryMoveInout - functionaryDto : " + functionaryDto);
		int row = sqlSession.insert(NS+"insertFunctionaryMoveInout", functionaryDto);
		return row;
	}
	
	//공무원 조회리스트
	public List<FunctionaryDto> selectListFunctionary(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionary - map : " + map.toString());
		return sqlSession.selectList(NS+"selectListFunctionary", map);
	}
	
	//공무원 조회리스트의 총 데이터 갯수
	public int totalCountFunctionary(Map<String, Object> map) {
		logger.debug("FunctionaryDao - totalCountFunctionary - map : " + map);
		return sqlSession.selectOne(NS+"totalCountFunctionary", map);
	}
	
	//공무원 기본정보조회
	public FunctionaryDto viewFunctionaryInfo(String functionaryId) {
		logger.debug("FunctionaryDao - viewFunctionaryInfo - functionaryId : " + functionaryId);
		return sqlSession.selectOne(NS+"viewFunctionaryInfo", functionaryId);
	}
	
	////공무원 기본정보 수정
	public int updateFunctionnary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryDao - updateFunctionnary - functionaryDto : " + functionaryDto);
		return sqlSession.update(NS+"updateFunctionnary", functionaryDto);
	}	
	
	////아이디로 이력관리테이블 조회	
	public FunctionaryDto selectFunctionaryMoveInout(String fuctionaryId) {
		logger.debug("FunctionaryDao - selectFunctionaryMoveInout - fuctionaryId : " + fuctionaryId);
		return sqlSession.selectOne(NS+"selectFunctionaryMoveInout", fuctionaryId);
	}
	
	////공무원 이전 전출이력정보 수정
	public void updateFuctionaryMoveInout(FunctionaryDto returnfunctionaryMoveInoutCode) {
		logger.debug("FunctionaryDao - updateFuctionaryMoveInout - returnfunctionaryMoveInoutCode : " + returnfunctionaryMoveInoutCode);
		sqlSession.update(NS+"updateFuctionaryMoveInout", returnfunctionaryMoveInoutCode);
	}
	
	//행정기관 검색
	public List<FunctionaryDto> selectAdminagency(String checkAdminagency) {
		logger.debug("FunctionaryDao - selectAdminagency - checkAdminagency : " + checkAdminagency);
		return sqlSession.selectList(NS+"selectAdminagency", checkAdminagency);		
	}
	
	//공무원 탈퇴
	public void deleteFunctionnary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryDao - deleteFunctionnary - functionaryDto : " + functionaryDto);
		sqlSession.delete(NS+"deleteFunctionnary", functionaryDto);
	}
	
	//탈퇴공무원정보 등록
	public void insertStorageFunctionary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryDao - insertStorageFunctionary - functionaryDto : " + functionaryDto);
		sqlSession.insert(NS+"insertStorageFunctionary", functionaryDto);
	}	
	
	//공무원 대여물품/시설등록한 업무조회
	public List<GoodsFacilityDto> selectListFunctionaryWorkGoodsfacility(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionaryWorkGoodsfacility - map : " + map.toString());
		return sqlSession.selectList(NS+"selectListFunctionaryWorkGoodsfacility", map);
	}
	//공무원 대여물품/시설등록한 업무조회 카운트
	public int totalCountFunctionaryWorkGoodsfacility(Map<String, Object> map) {
		logger.debug("FunctionaryDao - totalCountFunctionaryWorkGoodsfacility - map : " + map);
		return sqlSession.selectOne(NS+"totalCountFunctionaryWorkGoodsfacility", map);
	}
	
	//공무원 반납등록 업무조회
	public List<ReturnGoodsfacilityInfoDto> selectListFunctionaryWorkReturnGoodsfacilityInfo(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionaryWorkReturnGoodsfacilityInfo - map : " + map);
		return sqlSession.selectList(NS+"selectListFunctionaryWorkReturnGoodsfacilityInfo", map);
	}
	
	//공무원 반납등록 업무조회 카운트
		public int totalCountFunctionaryWorkReturnGoodsfacilityInfo(Map<String, Object> map) {
			logger.debug("FunctionaryDao - totalCountFunctionaryWorkReturnGoodsfacilityInfo - map : " + map);
			return sqlSession.selectOne(NS+"totalCountFunctionaryWorkReturnGoodsfacilityInfo", map);
	}
		
	//공무원 AS의뢰신청업무조회
	public List<UnitedAfterserviceRequestDto> selectListFunctionaryWorkUnitedAfterserviceRequest(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionaryWorkUnitedAfterserviceRequest - map : " + map);
		return sqlSession.selectList(NS+"selectListFunctionaryWorkUnitedAfterserviceRequest", map);
	}
		
	//공무원 AS의뢰신청 업무조회 카운트
	public int totalCountFunctionaryWorkUnitedAfterserviceRequest(Map<String, Object> map) {
		logger.debug("FunctionaryDao - totalCountFunctionaryWorkUnitedAfterserviceRequest - map : " + map);
		return sqlSession.selectOne(NS+"totalCountFunctionaryWorkUnitedAfterserviceRequest", map);
	}	
		
	//공무원 대행업체 등록 조회
	public List<AgencyDto> selectListFunctionaryWorkAgency(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionaryWorkAgency - map : " + map);
		return sqlSession.selectList(NS+"selectListFunctionaryWorkAgency", map);
	}
	
	//공무원 대행업체등록 업무조회 카운트
	public int totalCountFunctionaryWorkAgency(Map<String, Object> map) {
		logger.debug("FunctionaryDao - totalCountFunctionaryWorkAgency - map : " + map);
		return sqlSession.selectOne(NS+"totalCountFunctionaryWorkAgency", map);
	}
	
	//공무원 연회비/패키지 등록 조회
	public List<AnnualfeePakageDto> selectListFunctionaryWorkAnnualfeePakage(Map<String, Object> map) {
		logger.debug("FunctionaryDao - selectListFunctionaryWorkAnnualfeePakage - map : " + map);
		return sqlSession.selectList(NS+"selectListFunctionaryWorkAnnualfeePakage", map);
	}
	
	//공무원 연회비/패키지등록 업무조회 카운트
	public int totalCountFunctionaryWorkAnnualfeePakage(Map<String, Object> map) {
		logger.debug("FunctionaryDao - totalCountFunctionaryWorkAnnualfeePakage - map : " + map);
		return sqlSession.selectOne(NS+"totalCountFunctionaryWorkAnnualfeePakage", map);
	}
	
	

	
	
	

	/*public FunctionaryDto selectForStorageFunctionary(String fuctionaryId) {
		logger.debug("FunctionaryDao - selectForStorageFunctionary - fuctionaryId : " + fuctionaryId);
		return sqlSession.selectOne(NS+"selectForStorageFunctionary", fuctionaryId);
	}*/
}
