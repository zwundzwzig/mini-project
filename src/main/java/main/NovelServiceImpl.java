package main;

import episodes.EpisodesDTO;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("novelservice")
public class NovelServiceImpl implements NovelService {

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

    //소설 상세페이지 하나씩 확인
    @Override
    public NovelDTO getOneNovel(int id) {
        updateViewCount(id);
        return dao.getOneNovel(id);
    }

    @Override
    public int getTotalNovel(int id) {
        return dao.getTotalNovel(id);
    }

    @Override
    public List<EpisodesDTO> getNovelList(int id, int limit) {
        return dao.getNovelList(id, limit);
    }

    @Override
    public int updateViewCount(int id) {
        return dao.updateViewCount(id);
    }

    @Override
    public void insertCart(int user_id, Integer episode_id) {
        dao.insertCart(user_id, episode_id);
    }

    @Override
    public void insertLibraries(int user_id, Integer episode_id) {
        dao.insertLibraries(user_id, episode_id);
    }

    @Override
    public void updateSand(int novel_cnt, int user_id) {
        dao.updateSand(novel_cnt, user_id);
    }

    @Override
    public List<Integer> getLibraries(int user_id) {
        return dao.getLibraries(user_id);
    }



}
