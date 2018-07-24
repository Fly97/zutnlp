package edu.zut.cs.zutnlp.text.manager.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.NlpHanlp.NlpDao;
import edu.zut.cs.zutnlp.text.NlpHanlp.NlpHanlp;
import edu.zut.cs.zutnlp.text.manager.NlpManager;
import org.springframework.beans.factory.annotation.Autowired;

public class NlpManagerImpl  extends GenericManagerImpl<NlpHanlp,Long>
        implements NlpManager {
    NlpDao nlpDao;

    @Autowired
    public void setImageDao(NlpDao nlpDao) {
        this.nlpDao = nlpDao;
        this.dao=this.nlpDao;
    }
}
