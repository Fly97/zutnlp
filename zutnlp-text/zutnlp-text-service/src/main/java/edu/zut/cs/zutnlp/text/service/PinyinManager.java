package edu.zut.cs.zutnlp.text.service;

import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;

import java.util.List;

public interface PinyinManager extends GenericManager<PinyinRecognition,Long> {
    public List<PinyinRecognition> findLastId();
}
