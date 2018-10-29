package edu.zut.cs.zutnlp.text.service.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.grammar.dao.GrarecognitionDao;
import edu.zut.cs.zutnlp.text.grammar.domain.grarecognition;
import edu.zut.cs.zutnlp.text.service.GrammarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class grammarManagerImpl extends GenericManagerImpl<grarecognition,Long>
        implements GrammarManager {

    @Autowired
    GrarecognitionDao grarecognitiondao;

    @Autowired
    public void setGrarecognitiondao(GrarecognitionDao grarecognitiondao) {
        this.grarecognitiondao = grarecognitiondao;
        this.dao = this.grarecognitiondao;
    }


    @Override
    public List<grarecognition> findAllgra() {
        return grarecognitiondao.findAll();
    }

    @Override
    public List<grarecognition> findlastid() {
        return grarecognitiondao.findlastId();
    }
}