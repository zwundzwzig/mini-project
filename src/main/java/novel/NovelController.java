package novel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NovelController {
//	@Autowired
//	@Qualifier("")
//	NovelDTO dto;

	@GetMapping("/onenovelpage")
	public String onenovelpage() {
		return "novel/oneNovelPage";
	}
	
}
