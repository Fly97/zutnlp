package edu.zut.cs.zutnlp.cv.relationship.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="OBJECT_DETECTION_RELATIONSHIP")
public class Relationship extends BaseEntity {

    private static final long serialVersionUID = -3L;

    @Column(name="image_id")
    private Long image_id;

    @Column(name = "predicate")
    private String predicate;

    @Column(name="object_id")
    private  Long object_id;

    @Column(name="relationship_id")
    private Long relationship_id;

    private String synsets;


    @OneToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    @Column(name="scene_id")
    private Long scene_id;

    @Column(name="REAL_SUBJECT_ID")
    private Long subject_id;

    @Column(name = "REGION_ID")
    private Long region_id;

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public Long getScene_id() {
        return scene_id;
    }

    public void setScene_id(Long scene_id) {
        this.scene_id = scene_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Long getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(Long relationship_id) {
        this.relationship_id = relationship_id;
    }

    public String getSynsets() {
        return synsets;
    }

    public void setSynsets(String synsets) {
        this.synsets = synsets;
    }

//    public Long getSubject_id() {
//        return subject_id;
//    }
//
//    public void setSubject_id(Long subject_id) {
//        this.subject_id = subject_id;
//    }

    @Override
    public String toString() {
        return "Relationship{" +
                "image_id=" + image_id +
                ", predicate='" + predicate + '\'' +
                ", object_id=" + object_id +
                ", relationship_id=" + relationship_id +
                ", synsets='" + synsets + '\'' +
//                ", subject_id=" + subject_id +
                '}';
    }
}
