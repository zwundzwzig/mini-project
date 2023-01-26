package main;

import episodes.EpisodesDTO;
import java.util.HashMap;
import java.util.List;
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

    public List<EpisodesDTO> getNovelList(@Param("id") int id, @Param("limit") int limit);

    public int updateViewCount(int id);

    public void insertCart(@Param("user_id") int user_id, @Param("episode_id") Integer episode_id);

    public void insertLibraries(@Param("user_id") int user_id,
        @Param("episode_id") Integer episode_id);

    public void updateSand(@Param("novel_cnt") int novel_cnt, @Param("user_id") int user_id);

    public List<Integer> getLibraries(int user_id);

    //승희
    public List<HashMap<Object, Object>> getNumberOfNovels();

    public List<NovelDTO> getNewNovels(int page);

    public List<NovelDTO> getRomanceNovels(int page);

    public List<NovelDTO> getFantasyNovels(int page);

    public List<NovelDTO> getBLNovels(int page);

    public List<NovelDTO> searchSimple(NovelDTO dto);

}
