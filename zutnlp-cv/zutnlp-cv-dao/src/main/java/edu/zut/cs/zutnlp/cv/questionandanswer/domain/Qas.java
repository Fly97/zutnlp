package edu.zut.cs.zutnlp.cv.questionandanswer.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OBJECT_DETECTION_QAS")
public class Qas extends BaseEntity {


    @Column(name = "A_OBJECTS")
    private String a_objects;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "IMAGE_ID")
    private Long image_id;
    @Column(name = "QA_ID")
    private Long qa_id;
    @Column(name = "ANSWER")
    private String answer;
    @Column(name = "Q_OBJECTS")
    private String  q_objects;


    public String getA_objects() {
        return a_objects;
    }

    public void setA_objects(String a_objects) {
        this.a_objects = a_objects;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Long getQa_id() {
        return qa_id;
    }

    public void setQa_id(Long qa_id) {
        this.qa_id = qa_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQ_objects() {
        return q_objects;
    }

    public void setQ_objects(String q_objects) {
        this.q_objects = q_objects;
    }
}