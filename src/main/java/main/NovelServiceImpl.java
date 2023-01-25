package main;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import episodes.EpisodesDTO;

import java.util.List;
import java.util.Map;

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

//	@Override
//	public void insertCart(Map<Object, Object> map) {
//		dao.insertCart(map);
//	}


	@Override
	public int updateViewCount(int id) {
		return dao.updateViewCount(id);
	}
}
