package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.QasManager;
import edu.zut.cs.zutnlp.cv.questionandanswer.dao.QasDao;
import edu.zut.cs.zutnlp.cv.questionandanswer.domain.Qas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QasManagerImpl extends GenericManagerImpl<Qas, Long> implements QasManager {

    QasDao qasDao;

    @Autowired
    public void setQasDao(QasDao qasDao) {
        this.qasDao = qasDao;
        this.dao = this.qasDao;
    }

    @Override
    public List<Qas> findByImage_id(Long Image_id) {
        List<Qas> qasList = qasDao.findByImage_id(Image_id);
        return qasList;
    }

    @Override
    public Qas findByQa_id(Long Qa_id) {
        Qas qas = qasDao.findByQa_id(Qa_id);
        return qas;
    }
}
