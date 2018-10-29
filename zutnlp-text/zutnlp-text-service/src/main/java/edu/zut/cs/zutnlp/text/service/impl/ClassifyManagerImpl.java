package edu.zut.cs.zutnlp.text.service.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Recognition.dao.ClassifyDao;
import edu.zut.cs.zutnlp.text.Recognition.domain.Classify;
import edu.zut.cs.zutnlp.text.service.ClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassifyManagerImpl extends GenericManagerImpl<Classify,Long>
        implements ClassifyManager {

    @Autowired
    ClassifyDao classifyDao;

    @Autowired
    public void setClassifyDao(ClassifyDao classifyDao) {
        this.classifyDao = classifyDao;
        this.dao=this.classifyDao;
    }

    @Override
    public List<Classify> findAllClassify() {
        return classifyDao.findAll();
    }

    @Override
    public List<Classify> findlastid() {
        return classifyDao.findlastId();
    }
}
