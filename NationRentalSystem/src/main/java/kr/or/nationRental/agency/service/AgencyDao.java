/* 27기 koogle 이인호 */
package kr.or.nationRental.agency.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.nationRental.agencyEmployee.service.AgencyEmployeeDto;


@Repository
public class AgencyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS ="kr.or.nationRental.agency.service.AgencyMapper.";
	private static final Logger logger = LoggerFactory.getLogger(AgencyDao.class);
	
	//대행업체등록
	public int insertAgency(AgencyDto agencyDto) {
		logger.debug("AgencyDao - insertAgency - agencyDto : " + agencyDto.toString());		
		int row = sqlSession.insert(NS + "insertAgency", agencyDto);		
		return row;
	}
	
	//계약된 대행업체 조회
	public List<AgencyDto> selectListContractAgency(int adminagencyCode) {
		logger.debug("AgencyDao - selectListContractAgency - adminagencyCode : " + adminagencyCode);		
		return sqlSession.selectList(NS + "selectListContractAgency", adminagencyCode);
	}
	
	//계약해지된 대행업체
	public List<AgencyDto> selectListContractClosedAgency(int adminagencyCode) {
		logger.debug("AgencyDao - selectListContractClosedAgency - adminagencyCode : " + adminagencyCode);	
		return sqlSession.selectList(NS + "selectListContractClosedAgency", adminagencyCode);
	}
	
	//계약되었던 대행업체를 계약해지 상태로 변경
	public int updateAgencyContractClosed(AgencyDto agencyDto) {
		logger.debug("AgencyDao - updateAgencyContractClosed - agencyDto : " + agencyDto.toString());
		int row = sqlSession.update(NS + "updateAgencyContractClosed", agencyDto);
		return row;
	}
	
	//계약된 대행업체에 속해있던 아이디들 삭제
	public void deleteAgencyNakchalEmployee(AgencyDto agencyDto) {
		logger.debug("AgencyDao - deleteAgencyNakchalEmployee - agencyDto : " + agencyDto.toString());		
		sqlSession.delete(NS + "deleteAgencyNakchalEmployee", agencyDto);
	}
	
	//해지후 계약된 대행업체가 없는 대행업체 직원을 select
	public List<AgencyEmployeeDto> selectNullAgencyNakchalEmployee() {
		logger.debug("AgencyDao - selectNullAgencyNakchalEmployee - ");
		return sqlSession.selectList(NS + "selectNullAgencyNakchalEmployee");
	}
	
	//낙찰된 대행업체에 속해있는 ID들을 select
	public List<String> selectAgencyNakchalEmployeeId(AgencyDto agencyDto) {
		logger.debug("AgencyDao - selectAgencyNakchalEmployeeId - agencyDto : " + agencyDto.toString());
		
		return sqlSession.selectList(NS + "selectAgencyNakchalEmployeeId", agencyDto);
	}
	
	//낙찰된 대행업체에 속해있는 ID들로 해당 ID를 가지고 있는 데이터들을 select
	public AgencyEmployeeDto selectAgencyEmployee(String agencyEmployeeDtoId) {
		logger.debug("AgencyDao - selectAgencyEmployee - agencyEmployeeDtoId : " + agencyEmployeeDtoId.toString());
		
		return sqlSession.selectOne(NS + "selectAgencyEmployee2", agencyEmployeeDtoId);
	}

}
