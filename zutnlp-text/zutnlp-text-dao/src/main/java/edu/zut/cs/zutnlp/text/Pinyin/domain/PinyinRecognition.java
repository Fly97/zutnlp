package edu.zut.cs.zutnlp.text.Pinyin.domain;


import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Table(name = "pinyin_translation")
@Entity
public class PinyinRecognition extends BaseEntity {
    @Column(name = "TEXT_ID")
    private Long text_id;
    @Column(name = "T_RAWTEXT")
    private String t_rawtext;
    @Column(name = "T_NLPTEXT1")
    private String t_nlptext1;
    @Column(name = "T_MENTHOD")
    private String t_menthod;

    @Column(name = "T_NLPTEXT2")
    private String t_nlptext2;
    @Column(name = "T_NLPTEXT3")
    private String t_nlptext3;

    public PinyinRecognition(){       //虚构函数
    }

    public PinyinRecognition(String content){
        PinyinRecognition py=new PinyinRecognition();
        py.setT_rawtext(content);
        List<Pinyin> pinyinList =HanLP.convertToPinyinList(content);
        String t1="拼音（符号音调）:";
        for (Pinyin pinyin : pinyinList)
        {
            t1+=pinyin.getPinyinWithToneMark()+",";
        }
        String t2="声母：";
        for (Pinyin pinyin : pinyinList)
        {
            t2+=pinyin.getShengmu()+",";
        }
        String t3="韵母：";
        for (Pinyin pinyin : pinyinList)
        {
            t3+=pinyin.getYunmu()+",";
        }
        this.t_rawtext=content;
        this.t_nlptext1=t1;
        this.t_nlptext2=t2;
        this.t_nlptext3=t3;
        this.t_menthod="Pinyin";
    }

    public Long getText_id() {
        return text_id;
    }

    public void setText_id(Long text_id) {
        this.text_id = text_id;
    }

    public String getT_rawtext() {
        return t_rawtext;
    }

    public void setT_rawtext(String t_rawtext) {
        this.t_rawtext = t_rawtext;
    }

    public String getT_nlptext1() {
        return t_nlptext1;
    }

    public void setT_nlptext1(String t_nlptext1) {
        this.t_nlptext1 = t_nlptext1;
    }

    public String getT_menthod() {
        return t_menthod;
    }

    public void setT_menthod(String t_menthod) {
        this.t_menthod = t_menthod;
    }

    public String getT_nlptext2() {
        return t_nlptext2;
    }

    public void setT_nlptext2(String t_nlptext2) {
        this.t_nlptext2 = t_nlptext2;
    }

    public String getT_nlptext3() {
        return t_nlptext3;
    }

    public void setT_nlptext3(String t_nlptext3) {
        this.t_nlptext3 = t_nlptext3;
    }

    @Override
    public String toString() {
        return "PinyinRecognition{" +
                "text_id=" + text_id +
                ", t_rawtext='" + t_rawtext + '\'' +
                ", t_nlptext1='" + t_nlptext1 + '\'' +
                ", t_menthod='" + t_menthod + '\'' +
                ", t_nlptext2='" + t_nlptext2 + '\'' +
                ", t_nlptext3='" + t_nlptext3 + '\'' +
                '}';
    }
}
