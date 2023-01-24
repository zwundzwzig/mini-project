package main;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NovelDAO {

    public int getNumberOfNovels();
    public List<NovelDTO> getAllNovels();

}
