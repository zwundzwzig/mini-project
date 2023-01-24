package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
