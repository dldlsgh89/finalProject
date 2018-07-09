/* 27기 koogle 이인호 */
package kr.or.nationRental.agency.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.nationRental.agencyEmployee.service.AgencyEmployeeDao;
import kr.or.nationRental.agencyEmployee.service.AgencyEmployeeDto;


@Service
public class AgencyService {
	
	@Autowired
	private AgencyDao agencyDao;
	
	@Autowired
	private AgencyEmployeeDao agencyEmployeeDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AgencyService.class);
	
	//대행업체등록
	public void insertAgency(AgencyDto agencyDto, String memberName, int adminagencyCode) {
		logger.debug("AgencyService - insertAgency - adminagencyCode : " + adminagencyCode);
		logger.debug("AgencyService - insertAgency - memberName : " + memberName.toString());
		logger.debug("AgencyService - insertAgency - agencyDto : " + agencyDto.toString());
		agencyDto.setFunctionaryName(memberName);
		agencyDto.setAdminagencyCode(adminagencyCode);
		
		agencyDao.insertAgency(agencyDto);
	}
	
	//계약된 대행업체 조회
	public List<AgencyDto> selectListContractAgency(int adminagencyCode) {
		logger.debug("AgencyService - selectListContractAgency - adminagencyCode : " + adminagencyCode);
		List<AgencyDto> agencyDto = agencyDao.selectListContractAgency(adminagencyCode);
		logger.debug("AgencyService - selectListContractAgency - agencyDto : " + agencyDto);
			
		return agencyDto;
	}
	
	//계약해지된 대행업체
	public List<AgencyDto> selectListContractClosedAgency(int adminagencyCode) {
		logger.debug("AgencyService - selectListContractClosedAgency - adminagencyCode : " + adminagencyCode);
		List<AgencyDto> agencyDto = agencyDao.selectListContractClosedAgency(adminagencyCode);
		logger.debug("AgencyService - selectListContractClosedAgency - agencyDto : " + agencyDto);
			
		return agencyDto;
	}
	
	//대행업체 계약해지
	@Transactional
	public void updateAgencyContractClosed(AgencyDto agencyDto) {
		logger.debug("AgencyService - updateAgencyContractClosed - agencyDto : " + agencyDto.toString());
		
		//계약되었던 대행업체를 계약해지 상태로 변경
		agencyDao.updateAgencyContractClosed(agencyDto);
		
		//계약된 대행업체에 속해있던 직원id 권한삭제
		agencyDao.deleteAgencyNakchalEmployee(agencyDto);
		
		//해지후 계약된 대행업체가 없는 대행업체 직원을 select(계약된 대행업체가 아직 있다면 계정이 존재해야하므로)
		List<AgencyEmployeeDto> agencyEmployeeDto = agencyDao.selectNullAgencyNakchalEmployee();
		logger.debug("AgencyService - updateAgencyContractClosed - agencyEmployeeDto : " + agencyEmployeeDto.toString());
		
		//대행업체 직원 탈퇴처리는 춘림이형이 만든 탈퇴 기능 끌어다가 반복
		for(int i = 0; i<agencyEmployeeDto.size(); i++) {
			agencyEmployeeDao.deleteAgencyEmployee(agencyEmployeeDto.get(i));
		}		
	}

	//계약된 대행업체직원 조회
	public List<AgencyEmployeeDto> selectContractAgencyEmployee(AgencyDto agencyDto) {
		logger.debug("AgencyService - selectContractAgencyEmployee - agencyDto : " + agencyDto.toString());
		
		//낙찰된 대행업체에 속해있는 ID들을 select
		List<String> agencyEmployeeDtoId = agencyDao.selectAgencyNakchalEmployeeId(agencyDto);
		logger.debug("★★★★★★★★★★★★★★★★★★★★★");
		logger.debug(agencyEmployeeDtoId.toString());
		logger.debug("AgencyService - selectAgencyNakchalEmployeeId - agencyEmployeeDtoId.size() : " + agencyEmployeeDtoId.size());
		
		List<AgencyEmployeeDto> agencyEmployeeDto = new ArrayList<AgencyEmployeeDto>();
		//낙찰된 대행업체에 속해있는 ID들로 해당 ID를 가지고 있는 데이터들을 select
		for(int i=0; i<agencyEmployeeDtoId.size(); i++) {
			logger.debug("AgencyService - selectAgencyNakchalEmployeeId - agencyEmployeeDtoId.get(i) : " + agencyEmployeeDtoId.get(i));
			agencyEmployeeDto.add(i, agencyDao.selectAgencyEmployee(agencyEmployeeDtoId.get(i)));
		}
		
		return agencyEmployeeDto;
	}
	
	
}
