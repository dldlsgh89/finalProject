package kr.or.nationRental.functionary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.nationRental.administrator.service.AdministratorDto;
import kr.or.nationRental.agency.service.AgencyDto;
import kr.or.nationRental.agencyEmployee.service.AgencyEmployeeDto;
import kr.or.nationRental.annualfeePakage.service.AnnualfeePakageDto;
import kr.or.nationRental.citizen.service.CitizenDto;
import kr.or.nationRental.goodsFacility.service.GoodsFacilityDto;
import kr.or.nationRental.login.service.MemberDto;
import kr.or.nationRental.returnGoodsfacilityInfo.service.ReturnGoodsfacilityInfoDto;
import kr.or.nationRental.unitedAfterserviceRequest.service.UnitedAfterserviceRequestDto;

@Service
public class FunctionaryService {

	@Autowired
	private FunctionaryDao functionaryDao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(FunctionaryService.class);
	
	//트랜잭션 처리가 안되는것 같다
	@Transactional
	public void insertFunctionary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryService - insertFunctionary : " + functionaryDto.toString());
		functionaryDao.insertFunctionary(functionaryDto);
		functionaryDao.insertFunctionaryMoveInout(functionaryDto);
	}
	
	public Map<String, Object> selectListFunctionary(int currentPage, int pagePerRow, String searchOption, String keyword) {
		logger.debug("FunctionaryService - selectListFunctionary - currentPage : " + currentPage);
		logger.debug("FunctionaryService - selectListFunctionary - pagePerRow  : " + pagePerRow);
		logger.debug("FunctionaryService - selectListFunctionary - searchOption  : " + searchOption);
		logger.debug("FunctionaryService - selectListFunctionary - keyword  : " + keyword);
		
		int beginRow = (currentPage-1)*pagePerRow; 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);/*
		map.put("loginMemberId", loginMemberId);*/
		
		List<FunctionaryDto> list = functionaryDao.selectListFunctionary(map);
		logger.debug("FunctionaryService - selectListFunctionary - list  : " + list.toString());
		int total = functionaryDao.totalCountFunctionary(map);
		logger.debug("FunctionaryService - selectListFunctionary - total  : " + total);
			
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		int pageView = 5;
		int startPage = ((currentPage-1)/5)*5+1; 
		int endPage = startPage + pageView -1; 
		if(endPage>lastPage) {
			endPage=lastPage;
		}
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("list", list);
		returnmap.put("lastPage", lastPage);
		returnmap.put("startPage", startPage);
		returnmap.put("endPage", endPage);
		
		return returnmap;
	}
	//공무원 기본정보조회
	public FunctionaryDto viewFunctionaryInfo(String functionaryId) {
		logger.debug("FunctionaryService - viewFunctionaryInfo - functionaryId : " + functionaryId.toString());
		
		FunctionaryDto returnfunctionaryDto= functionaryDao.viewFunctionaryInfo(functionaryId);
		logger.debug("FunctionaryService - viewFunctionaryInfo - returnfunctionaryDto : " + returnfunctionaryDto.toString());
		
		return returnfunctionaryDto;
	}
	
	@Transactional
	public int updateFunctionnary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryService - updateFunctionnary - functionaryDto : " + functionaryDto.toString());
		String fuctionaryId = functionaryDto.getFunctionaryId();
		FunctionaryDto returnfunctionaryDto = functionaryDao.selectFunctionaryMoveInout(fuctionaryId);
		logger.debug("FunctionaryService - selectFunctionaryMoveInout - returnfunctionaryDto : " + returnfunctionaryDto.getFunctionaryMoveInoutCode());
		functionaryDao.updateFuctionaryMoveInout(returnfunctionaryDto);
		
		functionaryDao.insertFunctionaryMoveInout(functionaryDto);	
		logger.debug("FunctionaryService - insertFunctionaryMoveInout - functionaryDto : " + functionaryDto.toString());
		
		return functionaryDao.updateFunctionnary(functionaryDto);
	}

	public List<FunctionaryDto> selectAdminagency(String checkAdminagency) {
		logger.debug("FunctionaryService - selectAdminagency - checkAdminagency : " + checkAdminagency);
			
		List<FunctionaryDto> list =  functionaryDao.selectAdminagency(checkAdminagency);		
		
		logger.debug("FunctionaryService - selectAdminagency - list : " + list.toString());
		return list;
	}

	@Transactional
	public void deleteFunctionnary(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryService - deleteFunctionnary - functionaryId : " + functionaryDto);
		String fuctionaryId = functionaryDto.getFunctionaryId();
		//공무원 이력수정처리를 위한 select
		FunctionaryDto returnfunctionaryDto = functionaryDao.selectFunctionaryMoveInout(fuctionaryId);
		//공무원 이력수정처리
		functionaryDao.updateFuctionaryMoveInout(returnfunctionaryDto);
		//탈퇴공무원 데이터 1년저장을 위한 select
		functionaryDto = functionaryDao.viewFunctionaryInfo(fuctionaryId);
		//탈퇴공무원 데이터 1년저장을 위한 insert
		functionaryDao.insertStorageFunctionary(functionaryDto);
		//delete 처리		
		functionaryDao.deleteFunctionnary(functionaryDto);
		 
	}
	
	/*한 화면에 전체 업무조회 List를 뿌려주고 
	 *버튼에 따란 보이는 List를 다르게 해주려했는데 
	 *화면에 무리가 많이 가는지 문제가 좀 있어보여서 포기함
	 */
	/*public Map<String, Object> selectFunctionaryWork(FunctionaryDto functionaryDto) {
		logger.debug("FunctionaryService - selectFunctionaryWork - memberId : " + functionaryDto);
		Map<String, Object> map = new HashMap<String, Object>();
		//배달의뢰신청, 기부등록, 계약해지, 배상청구 등록
		
		//대여물품/시설등록조회
		List<GoodsFacilityDto> goodsfacilityList = functionaryDao.selectFunctionaryWorkGoodsfacility(functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - goodsfacilityList : " + goodsfacilityList.toString());
		//반납정보등록조회
		List<ReturnGoodsfacilityInfoDto> returnGoodsfacilityInfoList = functionaryDao.selectFunctionaryWorkReturnGoodsfacilityInfo(functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - returnGoodsfacilityInfoList : " + returnGoodsfacilityInfoList.toString());
		//AS의뢰신청조회
		List<UnitedAfterserviceRequestDto> unitedAfterserviceRequestList = functionaryDao.selectFunctionaryWorkUnitedAfterserviceReques(functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - unitedAfterserviceRequestList : " + unitedAfterserviceRequestList.toString());
		//배달의뢰신청조회 공무원 배달의뢰신청이 아직 완료되지 않음
		List<GoodsFacilityDto> goodsfacilityList = functionaryDao.selectFunctionaryWorkGoodsfacility(memberId);
		logger.debug("FunctionaryService - selectFunctionaryWork - goodsfacilityList : " + goodsfacilityList.toString());
		
		//대행업체등록조회
		List<AgencyDto> agencyList = functionaryDao.selectFunctionaryWorkAgency(functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - agencyList : " + agencyList.toString());
		//연회비/패키지 등록 조회
		List<AnnualfeePakageDto> annualfeePakageList = functionaryDao.selectFunctionaryWorkAnnualfeePakage(functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - annualfeePakageList : " + annualfeePakageList.toString());
		
		//map.put("goodsfacilityList", goodsfacilityList);
		map.put("returnGoodsfacilityInfoList", returnGoodsfacilityInfoList);
		map.put("unitedAfterserviceRequestList", unitedAfterserviceRequestList);
		map.put("agencyList", agencyList);
		map.put("annualfeePakageList", annualfeePakageList);
		
		return map;
	}*/

	public Map<String, Object> selectFunctionaryWork(FunctionaryDto functionaryDto
																	, int currentPage
																	, int pagePerRow
																	, String searchOption
																	, String keyword
																	, String workType) {		
		int beginRow = (currentPage-1)*pagePerRow; 
		
		Map<String, Object> map = new HashMap<String, Object>();
		logger.debug("FunctionaryService - selectFunctionaryWork - currentPage : " + currentPage);
		logger.debug("FunctionaryService - selectFunctionaryWork - functionaryDto : " + functionaryDto);
		logger.debug("FunctionaryService - selectFunctionaryWork - searchOption : " + searchOption);
		logger.debug("FunctionaryService - selectFunctionaryWork - keyword : " + keyword);
		logger.debug("FunctionaryService - selectFunctionaryWork - workType : " + workType);
		map.put("functionaryDto", functionaryDto);
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);/*
		map.put("loginMemberId", loginMemberId);*/
		Map<String, Object> returnmap = new HashMap<String, Object>();
		//대여물품/시설등록조회
		if(workType.equals("시설/물품등록")) {
			logger.debug("FunctionaryService - selectFunctionaryWork - 시설/물품등록 : ");
			List<GoodsFacilityDto> list = functionaryDao.selectListFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectListFunctionaryWorkGoodsfacility - list : " + list);
			int total = functionaryDao.totalCountFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectListFunctionaryWorkGoodsfacility - total  : " + total);						
			int lastPage = 0;
			if(total%pagePerRow == 0) {
				lastPage = total/pagePerRow;
			}else {
				lastPage = total/pagePerRow + 1;
			}			
			int pageView = 5;
			int startPage = ((currentPage-1)/5)*5+1; 
			int endPage = startPage + pageView -1; 
			if(endPage>lastPage) {
				endPage=lastPage;
			}			
			returnmap.put("list", list);
			returnmap.put("lastPage", lastPage);
			returnmap.put("startPage", startPage);
			returnmap.put("endPage", endPage);			
		}else if(workType.equals("반납등록")) {
			List<ReturnGoodsfacilityInfoDto> list = functionaryDao.selectListFunctionaryWorkReturnGoodsfacilityInfo(map);
			logger.debug("FunctionaryService - selectListFunctionaryWorkReturnGoodsfacilityInfo - list : " + list);	
			int total = functionaryDao.totalCountFunctionaryWorkReturnGoodsfacilityInfo(map);
			logger.debug("FunctionaryService - selectListFunctionaryWorkReturnGoodsfacilityInfo - total  : " + total);						
			int lastPage = 0;
			if(total%pagePerRow == 0) {
				lastPage = total/pagePerRow;
			}else {
				lastPage = total/pagePerRow + 1;
			}			
			int pageView = 5;
			int startPage = ((currentPage-1)/5)*5+1; 
			int endPage = startPage + pageView -1; 
			if(endPage>lastPage) {
				endPage=lastPage;
			}			
			returnmap.put("list", list);
			returnmap.put("lastPage", lastPage);
			returnmap.put("startPage", startPage);
			returnmap.put("endPage", endPage);	
		}/*else if(workType == "의뢰등록") {
			List<GoodsFacilityDto> goodsfacilityList = functionaryDao.selectFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - goodsfacilityList : " + goodsfacilityList);
			int total = functionaryDao.totalCountFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - total  : " + total);						
			int lastPage = 0;
			if(total%pagePerRow == 0) {
				lastPage = total/pagePerRow;
			}else {
				lastPage = total/pagePerRow + 1;
			}			
			int pageView = 5;
			int startPage = ((currentPage-1)/5)*5+1; 
			int endPage = startPage + pageView -1; 
			if(endPage>lastPage) {
				endPage=lastPage;
			}			
			returnmap.put("goodsfacilityList", goodsfacilityList);
			returnmap.put("lastPage", lastPage);
			returnmap.put("startPage", startPage);
			returnmap.put("endPage", endPage);	
		}else if(workType == "대행업체등록") {
			List<GoodsFacilityDto> goodsfacilityList = functionaryDao.selectFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - goodsfacilityList : " + goodsfacilityList);
			int total = functionaryDao.totalCountFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - total  : " + total);						
			int lastPage = 0;
			if(total%pagePerRow == 0) {
				lastPage = total/pagePerRow;
			}else {
				lastPage = total/pagePerRow + 1;
			}			
			int pageView = 5;
			int startPage = ((currentPage-1)/5)*5+1; 
			int endPage = startPage + pageView -1; 
			if(endPage>lastPage) {
				endPage=lastPage;
			}			
			returnmap.put("goodsfacilityList", goodsfacilityList);
			returnmap.put("lastPage", lastPage);
			returnmap.put("startPage", startPage);
			returnmap.put("endPage", endPage);	
		}else if(workType == "연회비등록") {
			List<GoodsFacilityDto> goodsfacilityList = functionaryDao.selectFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - goodsfacilityList : " + goodsfacilityList);
			int total = functionaryDao.totalCountFunctionaryWorkGoodsfacility(map);
			logger.debug("FunctionaryService - selectFunctionaryWorkGoodsfacility - total  : " + total);						
			int lastPage = 0;
			if(total%pagePerRow == 0) {
				lastPage = total/pagePerRow;
			}else {
				lastPage = total/pagePerRow + 1;
			}			
			int pageView = 5;
			int startPage = ((currentPage-1)/5)*5+1; 
			int endPage = startPage + pageView -1; 
			if(endPage>lastPage) {
				endPage=lastPage;
			}			
			returnmap.put("goodsfacilityList", goodsfacilityList);
			returnmap.put("lastPage", lastPage);
			returnmap.put("startPage", startPage);
			returnmap.put("endPage", endPage);	
		}*/
		return returnmap;
	}
	
}
