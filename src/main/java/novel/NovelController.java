package novel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import episodes.EpisodesDTO;
import jakarta.servlet.http.HttpServletRequest;
import main.NovelDAO;
import main.NovelDTO;
import main.NovelService;

@Controller
public class NovelController {
	
	@Autowired
	NovelDAO dao;
	
	@Autowired
	@Qualifier("novelservice")
	NovelService service;

	
	
//	@GetMapping("/oneNovelPage")
//	public String oneNovelPage() {
//		return "novel/oneNovelPage";
//	}
	
	@RequestMapping("/oneNovelPage")
	public ModelAndView oneNovelPage(int id,int page) {
		ModelAndView mv = new ModelAndView();
	//	int viewcount = service.updateViewCount(id);
		NovelDTO noveldto = service.getOneNovel(id);
		int limit = (page - 1) * 3; //page처리 위해서
		int total_list = service.getTotalNovel(id); //1번 소설 몇개인지 불러오기
		List<EpisodesDTO> list= service.getNovelList(id,limit); //소설 리스트 불러오기
//		mv.addObject("viewcount",viewcount);
		mv.addObject("dto",noveldto);
		mv.addObject("cnt", total_list);
		mv.addObject("list", list);
		mv.setViewName("novel/oneNovelPage");
		return mv;
		
	}
	
//	@RequestMapping("/cart")
//	public String cart(HttpServletRequest request) {
//		String checkList = request.getParameter("check");
//		int user_id = (Integer.parseInt(request.getParameter("user_id"))); //아무값이나 넣기
//		String episode_id = request.getParameter("novelID");
//		Map<Object, Object> map = new HashMap<>();
//		map.put("user_id",user_id);
//		map.put("episode_id", episode_id);
//		System.out.println(map);
//		service.insertCart(map);
//		return null;
//	}
	
	
	
}













