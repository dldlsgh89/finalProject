package kr.or.nationRental.returnGoodsfacilityInfo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.nationRental.goodsFacility.service.GoodsFacilityDto;

@Repository
public class ReturnGoodsfacilityInfoDao {
	
	@Autowired private SqlSessionTemplate sqlsession;
	
	final String NS = "kr.or.nationRental.returnGoodsfacilityInfo.service.ReturnGoodsfacilityInfoMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(ReturnGoodsfacilityInfoDao.class);
	
	//대여/예약정보 셋팅, 반납등록품목 물품인지 시설인지 셋팅
	//해당 물품/시설코드로 가장 최근에 대여된 데이터를 찾는다
	public ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoCheck(GoodsFacilityDto goodsFacilityDto) {
		logger.debug("ReturnGoodsfacilityInfoDao - returnGoodsfacilityInfoCheck - goodsFacilityDto : " + goodsFacilityDto.toString());
		return sqlsession.selectOne(NS + "returnGoodsfacilityInfoCheck", goodsFacilityDto);
	}
	
	//배달반납 신청유무를 구하기 위한 코드
	public int selectOneGoodsfacilityRentalIsOrderedDelivery(int goodsfacilityRentalCode) {
		logger.debug("ReturnGoodsfacilityInfoDao - selectOneGoodsfacilityRentalIsOrderedDelivery - goodsfacilityRentalCode : " + goodsfacilityRentalCode);
		return sqlsession.selectOne(NS+"selectOneGoodsfacilityRentalIsOrderedDelivery", goodsfacilityRentalCode);
	}
	
	//선택할 수 있는 반납 상태 리스트
	public List<StateGoodsDto> stateGoodsCode() {
		logger.debug("ReturnGoodsfacilityInfoDao - stateGoodsCode : ");
		return sqlsession.selectList(NS + "stateGoodsCode");
	}
	
	//반납등록
	public void insertReturnGoodsfacilityInfo(ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto) {
		logger.debug("ReturnGoodsfacilityInfoDao - insertReturnGoodsfacilityInfo - returnGoodsfacilityInfoDto : " + returnGoodsfacilityInfoDto.toString());
		sqlsession.insert(NS+"insertReturnGoodsfacilityInfo", returnGoodsfacilityInfoDto);
	}
	
	//배달신청 취소
	public void updateIsCanceledDelivery(ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto) {
		logger.debug("ReturnGoodsfacilityInfoDao - updateIsCanceledDelivery - returnGoodsfacilityInfoDto : " + returnGoodsfacilityInfoDto.toString());
		sqlsession.update(NS+"updateIsCanceledDelivery", returnGoodsfacilityInfoDto);			
	}
	
	//이미 반납된 물품인지 확인하기 위해 대여/예약코드로 반납 데이터베이스에 등록된 정보가 있는지 확인
	public int checkReturnGoodsfacilityInfo(ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto) {
		return sqlsession.selectOne(NS+"checkReturnGoodsfacilityInfo", returnGoodsfacilityInfoDto);		
	}
	
	//반납정보 조회	
	public List<ReturnGoodsfacilityInfoDto> selectReturnGoodsfacilityInfo(Map<String, Object> map) {
		return sqlsession.selectList(NS+"selectReturnGoodsfacilityInfo", map);	
	}
	
	//반납정보 조회 카운트
	public int totalCountSelectReturnGoodsfacilityInfo(Map<String, Object> map) {		
		return sqlsession.selectOne(NS+"totalCountSelectReturnGoodsfacilityInfo", map);	
	}
}
