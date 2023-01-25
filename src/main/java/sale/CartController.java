package sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	@Autowired
    @Qualifier("saleservice")
    SaleService service;
	
	
	@GetMapping("/cart")
	public ModelAndView cart(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//String userId = (String)session.getAttribute("id");
		/*
		if(loginId == null) {
			mv.setViewName("/login");
			return mv;
		}
		*/
		
		int id = 1;
		
		int cnt = service.getNumberOfItems();
        List<ItemDTO> items = service.getCartItems(id);
        mv.addObject("cnt", cnt);
        mv.addObject("items", items);
        mv.setViewName("cart");
        return mv;
	}
	
	@ResponseBody
	@DeleteMapping("/cart")
	public boolean deleteCartItem(HttpSession session, int id) {
		//String userId = (String)session.getAttribute("id");
		/*
		if(loginId == null) {
			mv.setViewName("/login");
			return mv;
		}
		*/
		
		service.deleteCartItem(id);
		return true;
		
	}
		
}
