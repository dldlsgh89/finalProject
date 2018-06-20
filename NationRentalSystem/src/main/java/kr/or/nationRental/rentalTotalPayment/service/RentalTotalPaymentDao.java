package kr.or.nationRental.rentalTotalPayment.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.nationRental.goodsFacility.service.GoodsFacilityDto;
import kr.or.nationRental.rentGoodsFacility.service.RentGoodsfacilityDto;


@Repository
public class RentalTotalPaymentDao {
	private static final Logger logger = LoggerFactory.getLogger(RentalTotalPaymentDao.class);
	final String NS = "kr.or.nationRental.rentalTotalPayment.service.RentalTotalPaymentMapper.";
	@Autowired private SqlSessionTemplate sqlSession;
	
	//RentGoodsfacilityDto 리스트를 가져오는 작업
		public List<RentGoodsfacilityDto> getRentGoodsfacilityDtoList() {
			logger.debug("---getRentGoodsfacilityDtoList");
			return sqlSession.selectList(NS+"getRentGoodsfacilityDtoList");	
		}
}
