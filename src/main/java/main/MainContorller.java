package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainContorller {

    @Autowired
    @Qualifier("novelservice")
    NovelService service;

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        int cnt = service.getNumberOfNovels();
        List<NovelDTO> list = service.getAllNovels();
        mv.addObject("cnt", cnt);
        mv.addObject("list", list);
        mv.setViewName("main");
        return mv;
    }

}
