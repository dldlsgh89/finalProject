/* 27기 koogle 이인호 */
package kr.or.nationRental.annualfeePakage.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AnnualfeePakageDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="kr.or.nationRental.annualfeePakage.service.AnnualfeePakageMapper.";
	private static final Logger logger = LoggerFactory.getLogger(AnnualfeePakageDao.class);
	
	//연회비패키지정보 insert
	public int insertAnnualfeePakage(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - insertAnnualfeePakage - annualfeePakageDto : " + annualfeePakageDto.toString());
		int row = sqlSession.insert(NS+"insertAnnualfeePakage", annualfeePakageDto);
		return row;
	}
	
	//연회비패키지 적용 행정기관 insert
	//annualfee_pakage_authority테이블의 추가한 행정기관 데이터 insert처리
	public void insertAnnualfeePakageAuthority(Map<String, Integer> map) {
		logger.debug("AnnualfeePakageDao - insertAnnualfeePakageAuthority - map : " + map.toString());
		sqlSession.insert(NS+"insertAnnualfeePakageAuthority", map);
			
	}
	
	//연회비패키지를 select해 List로 받음
	public List<AnnualfeePakageDto> selectListAnnualfeePakage(Map<String, Object> map) {
		logger.debug("AnnualfeePakageDao - selectListAnnualfeePakage - map : " + map.toString());
		return sqlSession.selectList(NS+"selectListAnnualfeePakage", map);
	}
	
	//select한 연회비패키지의 총갯수
	public int totalCountAnnualfeePakage(Map<String, Object> map) {
		logger.debug("AnnualfeePakageDao - totalCountAnnualfeePakage - map : " + map.toString());
		return sqlSession.selectOne(NS+"totalCountAnnualfeePakage", map);
	}
	
	//연회비패키지 상세보기
	public AnnualfeePakageDto annualfeePakageSangse(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - annualfeePakageSangse - annualfeePakageDto : " + annualfeePakageDto.toString());
		AnnualfeePakageDto returnAnnualfeePakageDto = sqlSession.selectOne(NS+"annualfeePakageSangse", annualfeePakageDto);			
		return returnAnnualfeePakageDto;
	}
	
	//연회비패키지정보 삭제처리
	public void deleteAnnualfeePakage(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - deleteAnnualfeePakage - annualfeePakageDto : " + annualfeePakageDto.toString());
		sqlSession.delete(NS+"deleteAnnualfeePakage", annualfeePakageDto);
	}
	
	//연회비패키지 적용 행정기관 삭제처리
	public void deleteAnnualfeePakageAuthority(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - deleteAnnualfeePakageAuthority - annualfeePakageDto : " + annualfeePakageDto.toString());
		sqlSession.delete(NS+"deleteAnnualfeePakageAuthority", annualfeePakageDto);		
	}
	
	//annualfee_pakage테이블의 데이터 update 처리
	public void updateAnnualfeePakage(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - updateAnnualfeePakage - annualfeePakageDto : " + annualfeePakageDto.toString());
		sqlSession.update(NS+"updateAnnualfeePakage", annualfeePakageDto);
	}
	
	//annualfee_pakage_authority테이블의 삭제한 행정기관 데이터 delete처리
	public void deleteCheckAnnualfeePakageAuthority(Integer integer) {
		logger.debug("AnnualfeePakageDao - deleteCheckAnnualfeePakageAuthority - integer : " + integer.toString());
		sqlSession.delete(NS+"deleteCheckAnnualfeePakageAuthority", integer);
		
	}
	
	//연회비 구입
	public void insertAnnualfeePakageOwnership(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - insertAnnualfeePakageOwnership - annualfeePakageDto : " + annualfeePakageDto.toString());
		sqlSession.insert(NS+"insertAnnualfeePakageOwnership", annualfeePakageDto);		
	}	
	
	//시민이 자신이 구입한 연회비패키지 보기
	public List<AnnualfeePakageDto> selectListAnnualfeePakageOwnership(String memeberId) {
		logger.debug("AnnualfeePakageDao - selectListAnnualfeePakageOwnership - memeberLevel : " + memeberId);		
		return sqlSession.selectList(NS+"selectListAnnualfeePakageOwnership", memeberId);	
	}

	/*public int insertAnnualfeePakageAuthority(AnnualfeePakageDto annualfeePakageDto) {
		logger.debug("AnnualfeePakageDao - insertAnnualfeePakageAuthority - annualfeePakageDto : " + annualfeePakageDto.toString());
		int row = sqlSession.insert(NS+"insertAnnualfeePakageAuthority", annualfeePakageDto);
		return row;
	}*/
}
