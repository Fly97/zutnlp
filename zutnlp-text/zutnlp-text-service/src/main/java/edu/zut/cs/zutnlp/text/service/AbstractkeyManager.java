package edu.zut.cs.zutnlp.text.service;

import edu.zut.cs.zutnlp.text.Abstractkey.domain.Keyrecognition;
import edu.zut.cs.zutnlp.base.service.GenericManager;

import java.util.List;

public interface AbstractkeyManager extends GenericManager<Keyrecognition,Long> {
    public List<Keyrecognition> findAllChinese();

}
