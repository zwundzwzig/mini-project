package detail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DetailController {

  private DetailService detailService;

  @GetMapping("/detail")
	public String getDetailPage(@RequestParam("novel_id") String novelId, @RequestParam("sequence") String sequence,) {
		return "/detail";
	}

}
