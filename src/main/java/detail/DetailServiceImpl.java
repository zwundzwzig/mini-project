package detail;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("detailservice")
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailDAO dao;

    @Override
    public String getContents(int episodeId, int userId) {
        return dao.getContents(episodeId, userId);
    }

    @Override
    public Map<String, Integer> getPrevAndNext(int episodeId) {
        Map<String, Integer> seqPreNext = dao.getSeqPrevAndNext(episodeId);
        int novelId = Integer.parseInt(String.valueOf(seqPreNext.get("novelId")));
        int prevSeq = Integer.parseInt(String.valueOf(seqPreNext.get("prevSeq")));
        Integer prevId = dao.getEpisodeId(novelId, prevSeq);
        int nextSeq = Integer.parseInt(String.valueOf(seqPreNext.get("nextSeq")));
        Integer nextId = dao.getEpisodeId(novelId, nextSeq);

        Map<String, Integer> prevAndNext = new HashMap<>();
        prevAndNext.put("prevId", prevId);
        prevAndNext.put("nextId", nextId);
        return prevAndNext;

    }

	@Override
	public int getNovelId(int episodeId) {
		return dao.getNovelId(episodeId);
	}
    
    


}
