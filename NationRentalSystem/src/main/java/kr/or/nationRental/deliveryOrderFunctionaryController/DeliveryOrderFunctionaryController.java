package kr.or.nationRental.deliveryOrderFunctionaryController;

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

import kr.or.nationRental.deliveryOrderCitizen.service.DeliveryOrderCitizenDto;
import kr.or.nationRental.deliveryOrderFunctionaryService.DeliveryOrderFunctionaryDto;
import kr.or.nationRental.deliveryOrderFunctionaryService.DeliveryOrderFunctionaryService;

@Controller
public class DeliveryOrderFunctionaryController {
	@Autowired
	private DeliveryOrderFunctionaryService deliveryOrderFunctionaryService;
	private static final Logger logger = LoggerFactory.getLogger(DeliveryOrderFunctionaryController.class);
	
	@RequestMapping(value="/selectListDeliveryOrderCitizenForInsertDeliveryOrderFunctionary", method=RequestMethod.GET)
	public String selectListDeliveryOrderCitizenForInsertDeliveryOrderFunctionary(Model model
									,HttpSession session
									,DeliveryOrderFunctionaryDto deliveryOrderFunctionaryDto
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow
									,@RequestParam(value="searchSelect", defaultValue="정기점검 코드") String searchSelect
									,@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		logger.debug("GET selectListDeliveryOrderCitizenForInsertDeliveryOrderFunctionary DeliveryOrderFunctionaryController");
		logger.debug("searchSelect : " + searchSelect);
		logger.debug("searchWord : " + searchWord);
		logger.debug("★★★★★★★★★★★★★deliveryOrderFunctionaryDto★★★★★★★★★★★★★★★★★★");
		logger.debug(deliveryOrderFunctionaryDto.toString());
		
		Map<String, Object> map = deliveryOrderFunctionaryService.selectListDeliveryOrderCitizenForAfterservice(currentPage, pagePerRow, searchSelect, searchWord, deliveryOrderFunctionaryDto);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("beginPageNumForCurrentPage", map.get("beginPageNumForCurrentPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("searchSelect", searchSelect);
		model.addAttribute("searchWord", searchWord);
		logger.debug("list : "+ map.get("list"));
		logger.debug("lastPage : "+ map.get("lastPage"));
		logger.debug("beginPageNumForCurrentPage : "+ map.get("beginPageNumForCurrentPage"));
		logger.debug("currentPage : "+ currentPage);
		logger.debug("pagePerRow : "+ pagePerRow);
		logger.debug("searchSelect : " + searchSelect);
		logger.debug("searchWord : " + searchWord);
		
		// 파일 저장루트 확인용 
		String path = session.getServletContext().getRealPath("/resources/upload/");
		model.addAttribute("path", path);
		
		return "deliveryOrderFunctionary/selectListDeliveryOrderCitizenForInsertDeliveryOrderFunctionary";
	}
}
