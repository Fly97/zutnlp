package edu.zut.cs.zutnlp.text.Pinyin.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "pinyin_translation")
@Entity
public class PinyinRecognition extends BaseEntity {
    @Column(name = "TEXT_ID")
    private Long text_id;
    @Column(name = "T_RAWTEXT")
    private String t_rawtext;
    @Column(name = "T_NLPTEXT")
    private String t_nlptext;
    @Column(name = "T_MENTHOD")
    private String t_menthod;

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

    public String getT_nlptext() {
        return t_nlptext;
    }

    public void setT_nlptext(String t_nlptext) {
        this.t_nlptext = t_nlptext;
    }

    public String getT_menthod() {
        return t_menthod;
    }

    public void setT_menthod(String t_menthod) {
        this.t_menthod = t_menthod;
    }
}
