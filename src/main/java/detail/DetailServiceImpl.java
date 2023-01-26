package detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detailservice")
public class DetailServiceImpl implements DetailService{
	@Autowired
	DetailDAO dao;
	
	@Override
	public String getContents(int episodeId, int userId) {
		return dao.getContents(episodeId, userId);
	}
	
}
