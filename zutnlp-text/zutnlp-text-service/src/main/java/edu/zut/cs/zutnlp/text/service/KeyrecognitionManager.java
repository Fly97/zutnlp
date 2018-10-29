package edu.zut.cs.zutnlp.text.service;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.Keyrecognition.domain.Keyrecognition;

import java.util.List;

public interface KeyrecognitionManager extends GenericManager<Keyrecognition,Long> {

    public List<Keyrecognition> findAllKeyrecognition();
    public List<Keyrecognition> findlastid();
}
