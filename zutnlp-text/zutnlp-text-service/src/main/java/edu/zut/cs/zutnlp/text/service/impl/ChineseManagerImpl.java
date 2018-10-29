package edu.zut.cs.zutnlp.text.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Chinese.dao.ChrecognitionDao;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import edu.zut.cs.zutnlp.text.service.ChineseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChineseManagerImpl extends GenericManagerImpl<Chrecognition,Long>
        implements ChineseManager {

    @Autowired
    ChrecognitionDao chrecognitionDao;

    @Autowired
    public void setChrecognitionDao(ChrecognitionDao chrecognitionDao){
        this.chrecognitionDao=chrecognitionDao;
        this.dao=this.chrecognitionDao;
    }


    @Autowired
    public List<Chrecognition> findAllChinese(){
        return chrecognitionDao.findAll();
    }

    @Autowired
    public List<Chrecognition> findlastid(){
        return chrecognitionDao.findlastId();
    }
}
