package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.SynsetManager;
import edu.zut.cs.zutnlp.cv.synset.dao.SynsetDao;
import edu.zut.cs.zutnlp.cv.synset.domain.Synset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynsetManagerImpl extends GenericManagerImpl<Synset,Long> implements SynsetManager {

    SynsetDao synsetDao;

    @Autowired
    public void setSynsetDao(SynsetDao synsetDao) {
        this.synsetDao = synsetDao;
        this.dao=this.synsetDao;
    }

    @Override
    public List<Synset> findByImage_id(Long image_id) {
        return this.synsetDao.findByImage_id(image_id);
    }

    @Override
    public int updateSynset_definition(String synset_definition, String synset_name) {
        return this.synsetDao.updateSynset_definition(synset_definition, synset_name);
    }
}
