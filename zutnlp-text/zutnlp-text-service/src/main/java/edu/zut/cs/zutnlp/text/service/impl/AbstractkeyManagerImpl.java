package edu.zut.cs.zutnlp.text.service.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Abstractkey.dao.KeyrecognitionDao;
import edu.zut.cs.zutnlp.text.Abstractkey.domain.Keyrecognition;
import edu.zut.cs.zutnlp.text.service.AbstractkeyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AbstractkeyManagerImpl extends GenericManagerImpl<Keyrecognition,Long>
        implements AbstractkeyManager {

    @Autowired
    KeyrecognitionDao keyrecognitionDao;

    @Autowired

    public void setKeyrecognitionDao(KeyrecognitionDao keyrecognitionDao) {
        this.keyrecognitionDao = keyrecognitionDao;
        this.dao=this.keyrecognitionDao;
    }
     @Autowired
    public List<Keyrecognition> findAllChinese(){
        return keyrecognitionDao.findAll();

    }

}
