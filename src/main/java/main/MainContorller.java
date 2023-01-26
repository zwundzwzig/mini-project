package main;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainContorller {

    @Autowired
    @Qualifier("novelservice")
    NovelService service;

    public int romanceNovelPage;
    public int fantasyNovelPage;
    public int BLNovelPage;

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        List<HashMap<Object, Object>> genre = service.getNumberOfNovels();
        for (int i = 0; i < genre.size(); i++) {
            HashMap<Object, Object> hm = genre.get(i);
            if (hm.get("genre").equals("로맨스/로판")) {
                romanceNovelPage = Integer.parseInt(String.valueOf(hm.get("cnt"))) / 4;
            } else if (hm.get("genre").equals("판타지/무협")) {
                fantasyNovelPage = Integer.parseInt(String.valueOf(hm.get("cnt"))) / 4;
            } else if (hm.get("genre").equals("BL")) {
                BLNovelPage = Integer.parseInt(String.valueOf(hm.get("cnt"))) / 4;
            }
        }
        ;
        mv.addObject("romanceNovelPage", romanceNovelPage); //13
        mv.addObject("fantasyNovelPage", fantasyNovelPage); //8
        mv.addObject("BLNovelPage", BLNovelPage); //4

        //NEW! 신작
        List<NovelDTO> list = service.getNewNovels(0);
        mv.addObject("list", list);
        //로맨스/로판 BEST
        List<NovelDTO> romanceList = service.getRomanceNovels(0);
        mv.addObject("romanceList", romanceList);
        //판타지/무협 BEST
        List<NovelDTO> fantasyList = service.getFantasyNovels(0);
        mv.addObject("fantasyList", fantasyList);
        //BL BEST
        List<NovelDTO> BLList = service.getBLNovels(0);
        mv.addObject("BLList", BLList);
        mv.setViewName("main");
        return mv;
    }

    //NEW! 신작 페이징 AJAX
    @RequestMapping(value = "/newNovels", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<NovelDTO> getNewNovels(int page) {
        int limit = (page - 1) * 4;
        return service.getNewNovels(limit);
    }

    //로맨스/로판 BEST 페이징 AJAX
    @RequestMapping(value = "/romanceNovels", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<NovelDTO> getRomanceNovels(int page) {
        int limit = (page - 1) * 4;
        return service.getRomanceNovels(limit);
    }

    //판타지/무협 BEST 페이징 AJAX
    @RequestMapping(value = "/fantasyNovels", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<NovelDTO> getFantasyNovels(int page) {
        int limit = (page - 1) * 4;
        return service.getFantasyNovels(limit);
    }

    //BL BEST 페이징 AJAX
    @RequestMapping(value = "/BLNovels", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<NovelDTO> getBLNovels(int page) {
        int limit = (page - 1) * 4;
        return service.getBLNovels(limit);
    }

    @RequestMapping("/search")
    public ModelAndView searchSimple(
        @RequestParam(value = "search_select", required = true) String search_select,
        @RequestParam(value = "keyword", required = true) String keyword) {
        ModelAndView mv = new ModelAndView();
        NovelDTO dto = new NovelDTO();
        if (search_select.equals("title")) {
            dto.setTitle(keyword);
        } else if (search_select.equals("author")) {
            dto.setAuthor(keyword);
        } else if (search_select.equals("genre")) {
            dto.setGenre(keyword);
        }
        List<NovelDTO> searchresult = service.searchSimple(dto);
        mv.addObject("searchresult", searchresult);
        mv.setViewName("main/searchResult");
        return mv;
    }

}
