package edu.zut.cs.zutnlp.text.abstractkey.manager.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.text.Abstractkey.domain.Keyrecognition;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.service.AbstractkeyManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractkeyManagerImplTest extends GenericGenerator {

    @Autowired
    AbstractkeyManager abstractkeyManager;

    @Test
    public void hello(){
        Keyrecognition c=new Keyrecognition();
        String text="今天工地好热，砖头晒的烫手";
        String processedtext=HanLP.segment(text).toString();
        c.setInitialtext(text);
        c.setProcessedtext(processedtext);
        abstractkeyManager.save(c);
    }
}
