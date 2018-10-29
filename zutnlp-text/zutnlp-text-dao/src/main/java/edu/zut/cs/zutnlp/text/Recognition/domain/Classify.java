package edu.zut.cs.zutnlp.text.Recognition.domain;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;
import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="Classify")
@Entity
public class Classify  extends BaseEntity {

    @Column(name="text")
    private String text;

    @Column(name="category1")
    private String category1;

    @Column(name="no1")
    private Double no1;

    @Column(name="category2")
    private String category2;

    @Column(name="no2")
    private Double no2;

    @Column(name="category3")
    private String category3;

    @Column(name="no3")
    private Double no3;

    @Column(name="category4")
    private String category4;

    @Column(name="no4")
    private Double no4;

    public Classify() {}

    public Classify(String text) {
        // 新建分类器对象
        BasicTextClassifier classifier = new BasicTextClassifier();

        // 设置分类种类，并读取模型
        classifier.loadCategoryListFromFile("zutnlp-text/zutnlp-text-dao/src/main/resources/model/category");
        classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
        classifier.getTextClassifier().loadModel("zutnlp-text/zutnlp-text-dao/src/main/resources/model");

        // 之后就可以使用分类器进行分类
        //String text = "再次回到世锦赛的赛场上，林丹终于变回了以前的那个超级丹.";
        int topN = 4;  // 保留最有可能的3个结果,共14个
        ClassifyResult[] result=classifier.classifyText(text, topN);
        /*for (int i = 0; i < topN; ++i) {              //输出
            // 输出分类编号，分类名称，以及概率值。
            System.out.println(result[i].label + "\t" +
                    classifier.getCategoryName(result[i].label) + "\t" +
                    result[i].prob);
        }*/
        this.text = text;
        this.category1=classifier.getCategoryName(result[0].label);
        this.no1=result[0].prob;
        this.category2=classifier.getCategoryName(result[1].label);
        this.no2=result[1].prob;
        this.category3=classifier.getCategoryName(result[2].label);
        this.no3=result[2].prob;
        this.category4=classifier.getCategoryName(result[3].label);
        this.no4=result[3].prob;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public Double getNo1() {
        return no1;
    }

    public void setNo1(Double no1) {
        this.no1 = no1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public Double getNo3() {
        return no3;
    }

    public void setNo3(Double no3) {
        this.no3 = no3;
    }

    public String getCategory4() {
        return category4;
    }

    public void setCategory4(String category4) {
        this.category4 = category4;
    }

    public Double getNo4() {
        return no4;
    }

    public void setNo4(Double no4) {
        this.no4 = no4;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "text='" + text + '\'' +
                ", category1='" + category1 + '\'' +
                ", no1=" + no1 +
                ", category2='" + category2 + '\'' +
                ", no2=" + no2 +
                ", category3='" + category3 + '\'' +
                ", no3=" + no3 +
                ", category4='" + category4 + '\'' +
                ", no4=" + no4 +
                '}';
    }
}
