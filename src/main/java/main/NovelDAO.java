package main;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import episodes.EpisodesDTO;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NovelDAO {

    public int getNumberOfNovels();
    public List<NovelDTO> getAllNovels();
	public NovelDTO getOneNovel(int id);
	public int getTotalNovel(int id); 
	public List<EpisodesDTO> getNovelList(@Param("id")int id, @Param("limit")int limit);
//	public void insertCart(Map<Object, Object> map);
	public int updateViewCount(int id);

}
