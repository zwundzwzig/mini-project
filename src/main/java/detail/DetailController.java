package detail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {

    @Autowired
    @Qualifier("detailservice")
    DetailService service;

    @GetMapping("/viewer")
    public ModelAndView openViewPage(HttpSession session, HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
    	 if(session.getAttribute("loginid") == null) {
 			mv.setViewName("user/login");
 			return mv;
 		}
         
         Integer userId = (Integer)session.getAttribute("loginid");
        int episodeId = Integer.valueOf(request.getParameter("episodeId"));
        String contents = service.getContents(episodeId, userId);
        int novelId = service.getNovelId(episodeId);
        mv.addObject("novelId", novelId);
        
        if (contents == null) {
            mv.addObject("contents", "구매한 작품이 아닙니다.<a href='/oneNovelPage?id=" + novelId + "&page=1'>구매하러 가기</a>");
        } else {
            mv.addObject("contents", contents);
        }

        Map<String, Integer> prevAndNext = service.getPrevAndNext(episodeId);
        System.out.println(prevAndNext);
        mv.addObject("prevAndNext", prevAndNext);

        mv.setViewName("/viewpage");
        return mv;
    }
}
