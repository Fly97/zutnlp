package edu.zut.cs.zutnlp.text.NlpHanlp;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="TEXT_NLP")
@Entity
public class NlpHanlp extends BaseEntity {

    @Column(name = "NLP_ID")
    private Long nlp_id;

    @Column(name = "TEXT")
    private int nlp_text;

    public Long getNlp_id() {
        return nlp_id;
    }

    public void setNlp_id(Long nlp_id) {
        this.nlp_id = nlp_id;
    }

    public int getNlp_text() {
        return nlp_text;
    }

    public void setNlp_text(int nlp_text) {
        this.nlp_text = nlp_text;
    }
}
