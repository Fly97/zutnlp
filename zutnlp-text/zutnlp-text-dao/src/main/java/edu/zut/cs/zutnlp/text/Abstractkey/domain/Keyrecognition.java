package edu.zut.cs.zutnlp.text.Abstractkey.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Abstractkey")
@Entity
public class Keyrecognition extends BaseEntity {

    @Column(name="id")
    private Long id;

    @Column(name="initialtext")//最初的
    private String initialtext;


    @Column(name="processedtext")//处理后
    private String processedtext;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getInitialtext() {
        return initialtext;
    }

    public void setInitialtext(String initialtext) {
        this.initialtext = initialtext;
    }

    public String getProcessedtext() {
        return processedtext;
    }

    public void setProcessedtext(String processedtext) {
        this.processedtext = processedtext;
    }

   /*@Column(name = "keyword")//关键词提取
            String keyword;

    @Column(name = "summary")//自动摘要
            String summary;

    @Column(name = "extraction ")//短语提取
            String extraction ;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getExtraction() {
        return extraction;
    }

    public void setExtraction(String extraction) {
        this.extraction = extraction;
    }*/
}
