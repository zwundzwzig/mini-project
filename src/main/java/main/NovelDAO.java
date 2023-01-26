package main;

import java.util.HashMap;
import java.util.Objects;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import episodes.EpisodesDTO;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NovelDAO {

  //한솔
	public NovelDTO getOneNovel(int id);
	public int getTotalNovel(int id); 
	public List<EpisodesDTO> getNovelList(@Param("id")int id, @Param("limit")int limit);
    //public void insertCart(Map<Object, Object> map);
	public int updateViewCount(int id);
  
  //승희
  public List<HashMap<Object, Object>> getNumberOfNovels();
  public List<NovelDTO> getNewNovels(int page);
  public List<NovelDTO> getRomanceNovels(int page);
  public List<NovelDTO> getFantasyNovels(int page);
  public List<NovelDTO> getBLNovels(int page);
  public List<NovelDTO> searchSimple(NovelDTO dto);

}
