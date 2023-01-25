package main;

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
    public int getNumberOfNovels() {
        return dao.getNumberOfNovels();
    }

    @Override
    public List<NovelDTO> getAllNovels() {
        return dao.getAllNovels();
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
