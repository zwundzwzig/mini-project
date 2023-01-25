package main;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("novelservice")
public class NovelServiceImpl implements NovelService{

    @Autowired
    NovelDAO dao;

    @Override
    public List<HashMap<Object, Object>> getNumberOfNovels() {
        return dao.getNumberOfNovels();
    }

    @Override
    public List<NovelDTO> getNewNovels(int page) {
        return dao.getNewNovels(page);
    }

    @Override
    public List<NovelDTO> getRomanceNovels(int page) {
        return dao.getRomanceNovels(page);
    }

    @Override
    public List<NovelDTO> getFantasyNovels(int page) {
        return dao.getFantasyNovels(page);
    }

    @Override
    public List<NovelDTO> getBLNovels(int page) {
        return dao.getBLNovels(page);
    }

    @Override
    public List<NovelDTO> searchSimple(NovelDTO dto) {
        return dao.searchSimple(dto);
    }
}
