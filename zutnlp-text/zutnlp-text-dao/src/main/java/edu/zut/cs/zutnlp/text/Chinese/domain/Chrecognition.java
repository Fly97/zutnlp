package edu.zut.cs.zutnlp.text.Chinese.domain;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="Chinese")
@Entity
public class Chrecognition extends BaseEntity {

    @Column(name="text")
    private String text;

    @Column(name="resulttext")
    private String resulttext;

    @Column(name="Words")
    private String Words;

    @Column(name="Parts")
    private String Parts;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResulttext() {
        return resulttext;
    }

    public void setResulttext(String resulttext) {
        this.resulttext = resulttext;
    }

    public String getWords() {
        return Words;
    }

    public void setWords(String words) {
        Words = words;
    }

    public String getParts() {
        return Parts;
    }

    public void setParts(String parts) {
        Parts = parts;
    }

    @Override
    public String toString() {
        return "Chrecognition{" +
                "text='" + text + '\'' +
                ", resulttext='" + resulttext + '\'' +
                ", Words='" + Words + '\'' +
                ", Parts='" + Parts + '\'' +
                '}';
    }
}
