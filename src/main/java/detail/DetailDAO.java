package detail;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface DetailDAO {

	public String getContents(int episodeId, int userId);
	
}
