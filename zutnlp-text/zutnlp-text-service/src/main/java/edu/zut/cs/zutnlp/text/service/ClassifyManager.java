package edu.zut.cs.zutnlp.text.service;

import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.Recognition.domain.Classify;

import java.util.List;

public interface ClassifyManager extends GenericManager<Classify,Long> {
    public List<Classify> findAllClassify();
    public List<Classify> findlastid();
}
