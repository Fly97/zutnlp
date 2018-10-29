package edu.zut.cs.zutnlp.text.service;

import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.grammar.domain.grarecognition;

import java.util.List;

public interface GrammarManager extends GenericManager<grarecognition,Long> {
    public List<grarecognition> findAllgra();
    public List<grarecognition> findlastid();
}
