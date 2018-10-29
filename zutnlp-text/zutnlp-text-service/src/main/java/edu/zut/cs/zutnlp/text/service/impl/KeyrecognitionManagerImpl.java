package edu.zut.cs.zutnlp.text.service.impl;



import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Keyrecognition.dao.KeyrecognitionDao;
import edu.zut.cs.zutnlp.text.Keyrecognition.domain.Keyrecognition;
import edu.zut.cs.zutnlp.text.service.KeyrecognitionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeyrecognitionManagerImpl extends GenericManagerImpl<Keyrecognition,Long>
        implements KeyrecognitionManager {

    @Autowired
    KeyrecognitionDao keyrecognitionDao;

    @Autowired
    public void setKeyrecognitionDao(KeyrecognitionDao keyrecognitionDao) {
        this.keyrecognitionDao = keyrecognitionDao;
        this.dao=this.keyrecognitionDao;
    }

    @Autowired
    public List<Keyrecognition> findAllKeyrecognition() {
        return keyrecognitionDao.findAll();
    }

    @Autowired
    public List<Keyrecognition> findlastid() {
        return keyrecognitionDao.findlastId();
    }
}
