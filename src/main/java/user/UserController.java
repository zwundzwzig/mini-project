package user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sale.ItemDTO;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userservice")
	UserService service;
	
	@GetMapping("/mypage")
	public ModelAndView showMyPage(HttpSession session) {
		//int userId = (String)session.getAttribute("userId");
		int userId = 1;
		
		List<ItemDTO> purchases = service.getPurchases(userId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchases", purchases);
		mv.setViewName("mypage");
		
		return mv;
	}
}
