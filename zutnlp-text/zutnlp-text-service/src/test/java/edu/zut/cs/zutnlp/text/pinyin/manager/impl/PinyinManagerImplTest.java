package edu.zut.cs.zutnlp.text.pinyin.manager.impl;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;
import edu.zut.cs.zutnlp.text.service.PinyinManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PinyinManagerImplTest extends GenericGenerator {
    @Autowired
    PinyinManager pinyinManager;

    @Test
    public void say() throws IOException {

       String content = "我爱吃大米";

  /*      File file=new File("F:\\Java\\ServerFiles\\region_graphs\\1.json");
        String content= FileUtils.readFileToString(file, "utf-8");*/

        PinyinRecognition py=new PinyinRecognition();
        py.setT_rawtext(content);
        List<Pinyin> pinyinList =HanLP.convertToPinyinList(content);
        String t1="原文,";
        for (char c : content.toCharArray())
        {
            t1+=c+",";
        }
        String t2="拼音（数字音调）,";
        for (Pinyin pinyin : pinyinList)
        {
            t2+=pinyin+",";
        }
        System.out.println(t2);
        String t3="拼音（符号音调）,";
        for (Pinyin pinyin : pinyinList)
        {
            t3+=pinyin.getPinyinWithToneMark()+",";
        }
        String t =t1+"   "+t2+"   "+t3;
        py.setT_menthod("Pinyin");
        py.setT_nlptext(t);
        pinyinManager.save(py);



      /*  PinyinRecognition py=new PinyinRecognition();
        py.setT_menthod("就是看到开始");
        py.setT_nlptext("三空间看看大概的");
        py.setT_rawtext("说的就是比较快");
        pinyinManager.save(py);*/

    }
}
