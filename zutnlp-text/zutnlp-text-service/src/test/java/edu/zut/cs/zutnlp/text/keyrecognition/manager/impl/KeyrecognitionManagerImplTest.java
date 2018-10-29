package edu.zut.cs.zutnlp.text.keyrecognition.manager.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.text.Keyrecognition.domain.Keyrecognition;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.service.KeyrecognitionManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KeyrecognitionManagerImplTest extends GenericGenerator {

    @Autowired //它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    KeyrecognitionManager keyrecognitionManager;

    @Test
    public void test(){
        Keyrecognition c=new Keyrecognition();
        String text="章鱼哥你好啊！我们去抓水母吧。金诚所至，金石为开";
        List<String> processedtext = HanLP.extractKeyword(text, 5);
        c.setInitialtext(text);
        c.setProcessedtext(processedtext.toString());
        keyrecognitionManager.save(c);

    }
}
