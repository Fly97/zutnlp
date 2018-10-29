package edu.zut.cs.zutnlp.text.Keyrecognition.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Table(name = "keyrecognition")
@Entity
public class Keyrecognition extends BaseEntity {


    @Column(name="initialtext")
    private String initialtext;

    @Column(name="processedtext")
    private String processedtext;

    public Keyrecognition(){}

    public String getProcessedtext() {
        return processedtext;
    }

    public void setProcessedtext(String processedtext) {
        this.processedtext = processedtext;
    }


    public String getInitialtext() {
        return initialtext;
    }

    public void setInitialtext(String initialtext) {
        this.initialtext = initialtext;
    }


}
