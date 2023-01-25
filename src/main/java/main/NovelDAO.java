package main;

import java.util.HashMap;
import java.util.Objects;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NovelDAO {

    public List<HashMap<Object, Object>> getNumberOfNovels();
    public List<NovelDTO> getNewNovels(int page);
    public List<NovelDTO> getRomanceNovels(int page);
    public List<NovelDTO> getFantasyNovels(int page);
    public List<NovelDTO> getBLNovels(int page);
    public List<NovelDTO> searchSimple(NovelDTO dto);

}
