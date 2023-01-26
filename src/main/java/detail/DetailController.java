package detail;

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
			String contents = service.getContents(episodeId, userId);
			ModelAndView mv = new ModelAndView();
			mv.addObject("contents", contents);
			mv.setViewName("/viewpage");
		return mv;
	}
}
