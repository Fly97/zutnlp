package edu.zut.cs.zutnlp.text.grammar.manager.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.grammar.domain.grarecognition;
import edu.zut.cs.zutnlp.text.service.GrammarManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class grammarManagerImplTest extends GenericGenerator {
    @Autowired//它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    GrammarManager grammarmanager;

    @Test
    public void mytext(){
      grarecognition c=new grarecognition();
      String text="你好啊，我叫卢思童，能交个朋友吗？";
      String processedtext=HanLP.parseDependency(text).toString();
      c.setInitialtext(text);
      c.setProcessedtext(processedtext);
      grammarmanager.save(c);
    }
}
