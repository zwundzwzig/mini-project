package detail;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface DetailDAO {

    public String getContents(int episodeId, int userId);

    public Map<String, Integer> getSeqPrevAndNext(int episodeId);

    public Integer getEpisodeId(@Param("novelId") int novelId, @Param("sequence") int sequence);

}
