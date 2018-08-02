package edu.zut.cs.zutnlp.text.chinese.manager.impl;


//import edu.zut.cs.zutnlp.base.service.impl.GenericGenerator;
import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.service.ChineseManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChineseMangerImplTest extends GenericGenerator {

    @Autowired
    ChineseManager chineseManager;

    @Test
    public void adddata(){
        Chrecognition c=new Chrecognition();
        String text="NBA一共有30支球队，分为东部联盟和西部联盟，每个联盟又被划分为3个赛区，每个赛区由5支球队组成。";
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
    }
}
