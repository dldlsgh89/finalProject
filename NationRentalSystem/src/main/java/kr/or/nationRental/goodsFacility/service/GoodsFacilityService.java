package kr.or.nationRental.goodsFacility.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nationRental.citizen.service.CitizenService;
import kr.or.nationRental.functionary.service.FunctionaryDto;

@Service
public class GoodsFacilityService {
	
	@Autowired
	private GoodsFacilityDao goodsFacilityDao;
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsFacilityService.class);
	
	public Map<String, Object> selectadminagency(FunctionaryDto functionaryDto) {
		logger.debug("GoodsFacilityService selectadminagency :");
		List<FunctionaryDto> functionaryList = goodsFacilityDao.selectadminagency(functionaryDto);
		logger.debug("GoodsFacilityService selectadminagency : functionaryList " + functionaryList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("functionaryList", functionaryList);
		
		return map;
	}

}
