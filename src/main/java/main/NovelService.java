package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import episodes.EpisodesDTO;

public interface NovelService {

  //한솔
	public NovelDTO getOneNovel(int id);
	public int getTotalNovel(int id);
	public List<EpisodesDTO> getNovelList(int id, int limit);
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
