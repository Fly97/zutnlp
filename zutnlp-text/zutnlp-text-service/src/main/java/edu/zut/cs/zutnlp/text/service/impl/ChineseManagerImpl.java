package edu.zut.cs.zutnlp.text.service.impl;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.text.Chinese.dao.ChrecognitionDao;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import edu.zut.cs.zutnlp.text.service.ChineseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChineseManagerImpl extends GenericManagerImpl<Chrecognition,Long>
        implements ChineseManager {

    @Autowired
    ChrecognitionDao chrecognitionDao;

    @Autowired
    ChineseManager chineseManager;

    @Autowired
    public void setChrecognitionDao(ChrecognitionDao chrecognitionDao){
        this.chrecognitionDao=chrecognitionDao;
        this.dao=this.chrecognitionDao;
    }

    @Autowired
    public List<Chrecognition> findAllChinese(){
        return chrecognitionDao.findAll();
    }

    @Autowired
    public Chrecognition findlastid(){
        return chrecognitionDao.findlastId();
    }

    /*
    @Autowired
    public void add(String text) {
        Chrecognition c=new Chrecognition();
        //String text="北京大学计算语言学研究所和富士通研究开发中心有限公司，得到了人民日报社新闻信息中心的语料库。";
        String resulttext=HanLP.segment(text).toString();
        String words = "",parts = "",str;
        int count=0;
        str=resulttext.replace("[", "");
        str=str.replace("]", "");
        String[] temp;
        temp=str.split(",");
        for(int i=0;i<temp.length;i++) {
            String[] d;
            d=temp[i].split("/");
            if(!d[1].equals("w"))
            {
                words=words+d[0]+",";
                parts=parts+d[1]+",";
                count++;
            }
        }
        c.setText(text);
        c.setResulttext(resulttext);
        c.setWords(words);
        c.setParts(parts);
        chineseManager.save(c);
    }*/

}
