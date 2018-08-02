package edu.zut.cs.zutnlp.text.service;


import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;


import java.util.List;

public interface ChineseManager extends GenericManager<Chrecognition,Long> {
    public List<Chrecognition> findAllChinese();
    //public void add(String text);
    public Chrecognition findlastid();
}
