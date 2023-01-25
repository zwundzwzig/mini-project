package main;

import java.util.List;
import java.util.Map;

import episodes.EpisodesDTO;

public interface NovelService {

    public int getNumberOfNovels();
    public List<NovelDTO> getAllNovels();
	public NovelDTO getOneNovel(int id);
	public int getTotalNovel(int id);
	public List<EpisodesDTO> getNovelList(int id, int limit);
//	public void insertCart(Map<Object, Object> map);
	public int updateViewCount(int id);

}
