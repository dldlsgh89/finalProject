package kr.or.nationRental.returnGoodsfacilityInfo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nationRental.login.service.MemberDto;
import kr.or.nationRental.returnGoodsfacilityInfo.service.DateDto;
import kr.or.nationRental.returnGoodsfacilityInfo.service.ReturnGoodsfacilityInfoDto;
import kr.or.nationRental.returnGoodsfacilityInfo.service.ReturnGoodsfacilityInfoService;
import kr.or.nationRental.returnGoodsfacilityInfo.service.StateGoodsDto;


@Controller
public class ReturnGoodsfacilityInfoController {
	
	@Autowired private ReturnGoodsfacilityInfoService returnGoodsfacilityInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReturnGoodsfacilityInfoController.class);
	
	//반납등록화면으로 이동
	@RequestMapping(value="/insertReturnGoodsfacilityInfoForm", method=RequestMethod.GET)
	public String insertReturnGoodsfacilityInfoForm(ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto
													,Model model) {
		logger.debug("ReturnGoodsfacilityInfoController - insertReturnGoodsfacilityInfoForm - GET - returnGoodsfacilityInfoDto : " + returnGoodsfacilityInfoDto.toString());
		//선택할 수 있는 반납 상태 리스트
		List<StateGoodsDto> list = returnGoodsfacilityInfoService.stateGoodsCode();
		logger.debug("ReturnGoodsfacilityInfoController - insertReturnGoodsfacilityInfoForm - list : " + list.toString());
		model.addAttribute("adminagencyCode", returnGoodsfacilityInfoDto.getAdminagencyCode());
		model.addAttribute("list", list);
		return "/returnGoodsfacilityInfo/insertReturnGoodsfacilityInfoForm";
	}
	
	//반납등록
	//반납등록시에 만약 배달신청정보가 있으면 반납등록하는 동시에 배달신청을 취소로 업데이트한다
	@RequestMapping(value="/insertReturnGoodsfacilityInfoForm", method=RequestMethod.POST)
	public String insertReturnGoodsfacilityInfoForm(ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto
													,Model model
													,HttpSession session) {
		logger.debug("ReturnGoodsfacilityInfoController - insertReturnGoodsfacilityInfoForm - POST - returnGoodsfacilityInfoDto : " + returnGoodsfacilityInfoDto.toString());
		MemberDto member = (MemberDto) session.getAttribute("member");
		returnGoodsfacilityInfoDto.setFunctionaryId(member.getMemberId());
		returnGoodsfacilityInfoService.insertReturnGoodsfacilityInfo(returnGoodsfacilityInfoDto);
		return "redirect:/selectReturnGoodsfacilityInfo";
	}
	
	//반납정보 조회
	@RequestMapping(value="/selectReturnGoodsfacilityInfo", method=RequestMethod.GET)
	public String selectReturnGoodsfacilityInfo(@RequestParam(value="currentPage", defaultValue="1") int currentPage
												,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow
												,@RequestParam(value="searchOption", defaultValue="전체 검색") String searchOption
												,@RequestParam(value="keyword", defaultValue="") String keyword
												,DateDto dateDto
												,Model model
												,HttpSession session) throws ParseException {
		logger.debug("ReturnGoodsfacilityInfoController - selectReturnGoodsfacilityInfo - searchOption : " + searchOption);
		logger.debug("ReturnGoodsfacilityInfoController - selectReturnGoodsfacilityInfo - keyword : " + keyword);
		logger.debug("ReturnGoodsfacilityInfoController - selectReturnGoodsfacilityInfo - dateDto : " + dateDto.toString());
		//검색했을때 검색되는 정보가 하나도 없을때는 currentPage가 0이 되기 때문에 defaultValue가 적용되지도 않고 0이 들어와 계산 되는 경우를 막기 위해서
		if(currentPage == 0) {
			currentPage = 1;
		}		
		MemberDto member = (MemberDto) session.getAttribute("member");
		ReturnGoodsfacilityInfoDto returnGoodsfacilityInfoDto = new ReturnGoodsfacilityInfoDto();
		Map<String, Object> map  = null;
		//조회하는 사람의 권한이 시민인지 공무원인지에 따라 조회할 수 있는 범위가 다르다
		returnGoodsfacilityInfoDto.setMemberLevel(member.getMemberLevel());
		if(returnGoodsfacilityInfoDto.getMemberLevel() == "공무원") {
			returnGoodsfacilityInfoDto.setAdminagencyCode(member.getAdminagencyCode());			
			map = returnGoodsfacilityInfoService.selectReturnGoodsfacilityInfo(returnGoodsfacilityInfoDto ,currentPage ,pagePerRow ,searchOption ,keyword, dateDto);
			
		}else if(returnGoodsfacilityInfoDto.getMemberLevel() == "시민") {
			returnGoodsfacilityInfoDto.setCitizenId(member.getMemberId());
			map = returnGoodsfacilityInfoService.selectReturnGoodsfacilityInfo(returnGoodsfacilityInfoDto ,currentPage ,pagePerRow ,searchOption ,keyword, dateDto);
		}
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("searchOption", map.get("searchOption"));
		model.addAttribute("keyword", keyword);
		model.addAttribute("startDate", dateDto.getStartDate());
		model.addAttribute("endDate", dateDto.getEndDate());
		model.addAttribute("memberLevel", returnGoodsfacilityInfoDto.getMemberLevel());
		return "/returnGoodsfacilityInfo/selectReturnGoodsfacilityInfo";
	}
}
