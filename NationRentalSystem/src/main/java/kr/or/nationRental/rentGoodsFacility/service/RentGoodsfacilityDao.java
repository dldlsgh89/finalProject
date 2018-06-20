package kr.or.nationRental.rentGoodsFacility.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.nationRental.goodsFacility.service.GoodsFacilityDao;
import kr.or.nationRental.goodsFacility.service.GoodsFacilityDto;

@Repository
public class RentGoodsfacilityDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="kr.or.nationRental.rentGoodsFacility.service.RentGoodsfacilityMapper.";
	private static final Logger logger = LoggerFactory.getLogger(RentGoodsfacilityDao.class);
	
	public GoodsFacilityDto selectGoodsFacilityInfo(GoodsFacilityDto goodsFacilityDto) {
		logger.debug("RentGoodsfacilityDao selectGoodsFacilityInfo : " + goodsFacilityDto.toString());
		goodsFacilityDto = sqlSession.selectOne(NS+"selectGoodsFacilityInfo", goodsFacilityDto);
		return goodsFacilityDto;
	}

	public int insertApplicationRent(RentGoodsfacilityDto rentGoodsfacilityDto) {
		logger.debug("RentGoodsfacilityDao insertApplicationRent : " + rentGoodsfacilityDto.toString());
		int row = sqlSession.insert(NS+"insertApplicationRent", rentGoodsfacilityDto);
		return row;
	}

	public List<RentGoodsfacilityDto> getApplicationList(Map<String, Object> map) {
		logger.debug("RentGoodsfacilityDao getApplicationList : ");
		return sqlSession.selectList(NS+"getApplicationList", map);		
	}

	public int totalCountRentFORM(Map<String, Object> map) {
		logger.debug("RentGoodsfacilityDao totalCountRentFORM : ");
		return sqlSession.selectOne(NS+"totalCountRentFORM", map);
	}

}