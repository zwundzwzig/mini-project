package user;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login2(String nickname, int password, HttpSession session) {
        UserDTO dto = service.oneMember(nickname);
        String view = "";
        if (dto == null) {
            //가입한 적이 없으면 회원가입 화면으로 연결
            view = "user/join";
        } else {
            if (password == dto.getPassword()) {
                session.setAttribute("nickname", dto.getNickname());
                session.setAttribute("loginid", dto.getId());
                view = "redirect:/";
            } else {
                view = "user/login";
            }
        }
        return view;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println(session.getAttribute("loginid"));
        if (session.getAttribute("loginid") != null) {
            session.removeAttribute("loginid");
        }
        return "redirect:/";
    }

}
