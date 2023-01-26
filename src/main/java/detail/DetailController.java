package detail;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DetailController {
	
	@Autowired
	@Qualifier("detailservice")
	DetailService service;
	
	@GetMapping("/viewer")
	public ModelAndView openViewPage(HttpSession session, 
							   HttpServletRequest request) {
			//int userId =  Integer.valueOf((String)session.getAttribute("userId"));
			int userId = 1;
			int episodeId = Integer.valueOf(request.getParameter("episodeId"));
			ModelAndView mv = new ModelAndView();
			String contents = service.getContents(episodeId, userId);
			
			if(contents==null) {
				mv.addObject("contents", "구매한 작품이 아닙니다.");
			}else {
				mv.addObject("contents", contents);
			}
			
			Map<String, Integer> prevAndNext = service.getPrevAndNext(episodeId);
			System.out.println(prevAndNext);
			mv.addObject("prevAndNext", prevAndNext);
			
			
			mv.setViewName("/viewpage");
		return mv;
	}
}
