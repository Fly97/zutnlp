package edu.zut.cs.zutnlp.text.service.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Url.dao.UrlRecognitionDao;
import edu.zut.cs.zutnlp.text.Url.domain.UrlRecogntion;
import edu.zut.cs.zutnlp.text.service.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlManagerImpl extends GenericManagerImpl<UrlRecogntion,Long> implements UrlManager {

    @Autowired
    UrlRecognitionDao urlRecognitionDao;



    @Autowired
    public void setUrlRecognitionDao(UrlRecognitionDao urlRecognitionDao) {
        this.urlRecognitionDao = urlRecognitionDao;
        this.dao=this.urlRecognitionDao;
    }

    @Autowired
    public List<UrlRecogntion> findLastId() {
        return urlRecognitionDao.findLastId();
    }
}
