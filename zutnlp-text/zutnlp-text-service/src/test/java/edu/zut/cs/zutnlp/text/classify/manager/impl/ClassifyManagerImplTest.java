package edu.zut.cs.zutnlp.text.classify.manager.impl;

import edu.zut.cs.zutnlp.text.Recognition.domain.Classify;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.service.ClassifyManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

public class ClassifyManagerImplTest extends GenericGenerator {
    @Autowired
    ClassifyManager classifyManager;

    @Test
    public void data(){
        String text = "再次回到世锦赛的赛场上，林丹终于变回了以前的那个超级丹.";
        Classify c=new Classify(text);
        System.out.println(c.toString());
        //classifyManager.save(c);
    }
}
