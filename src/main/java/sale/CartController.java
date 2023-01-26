package sale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

        int id = 5;

        int cnt = service.getNumberOfItems(id);
        List<ItemDTO> items = service.getCartItems(id);
        int balance = service.getBalance(id);
        mv.addObject("cnt", cnt);
        mv.addObject("items", items);
        mv.addObject("balance", balance);
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
	


    @PostMapping("/buy")
    public String buyEpisodes(HttpSession session,
        HttpServletRequest request) {
        //String userId = (String)session.getAttribute("id");
		/*
		if(userId == null) {
			mv.setViewName("/login");
			return mv;
		}
		*/
        int userId = 5;
        String[] strEpisodeIds = request.getParameterValues("toBuy");
        int[] episodeIds = Arrays.stream(strEpisodeIds).mapToInt(Integer::parseInt).toArray();

        try {
            service.buyEpisodes(userId, episodeIds);
        } catch (Exception e) {
            return "redirect:/cart";
        }
        return "redirect:/mypage";
    }

}
