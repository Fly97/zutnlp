package edu.zut.cs.zutnlp.text.service;

import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.Url.domain.UrlRecogntion;

import java.util.List;

public interface UrlManager extends GenericManager<UrlRecogntion,Long>{
    public List<UrlRecogntion> findLastId();
}
