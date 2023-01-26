package detail;

import java.util.Map;

public interface DetailService {
	public String getContents(int episodeId, int userId);
	public Map<String, Integer> getPrevAndNext(int episodeId);
}
