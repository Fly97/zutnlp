package edu.zut.cs.zutnlp.text.grammar.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;
import com.hankcs.hanlp.HanLP;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "grammar")
@Entity
//创建一个实体类，首先声明私有属性，然后在调用set和get方法。
public class grarecognition extends BaseEntity {

    @Column(name="initialtext")
    private String initialtext;

    @Column(name="processedtext")
    private String processedtext;

    public grarecognition(){}

    public grarecognition(String text){
        String processedtext=HanLP.parseDependency(text).toString();
        this.initialtext=text;
        this.processedtext=processedtext;
    }

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

    @Override
    public String toString() {
        return "grarecognition{" +
                "initialtext='" + initialtext + '\'' +
                ", processedtext='" + processedtext + '\'' +
                '}';
    }
}
