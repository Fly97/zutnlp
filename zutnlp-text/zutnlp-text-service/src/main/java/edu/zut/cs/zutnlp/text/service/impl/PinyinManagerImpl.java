package edu.zut.cs.zutnlp.text.service.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Pinyin.dao.PinyinRecognitionDao;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;
import edu.zut.cs.zutnlp.text.service.PinyinManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PinyinManagerImpl extends GenericManagerImpl<PinyinRecognition,Long> implements PinyinManager {


   private PinyinRecognitionDao pinyinRecognitionDao;

    @Autowired
    public void setPinyinRecognitionDao(PinyinRecognitionDao pinyinRecognitionDao) {
        this.pinyinRecognitionDao = pinyinRecognitionDao;
        this.dao=this.pinyinRecognitionDao;
    }
}
