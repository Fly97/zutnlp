package edu.zut.cs.zutnlp.cv.relationship.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OBJECT_DETECTION_SUBJECT")
public class Subject extends BaseEntity {

    private static final long serialVersionUID = -781763L;

    private String name;

    private int h;

    private int object_id;

    private String synsets;

    private int w;

    private int y;

    private int x;

    private Long relationship_id;

    public Long getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(Long relationship_id) {
        this.relationship_id = relationship_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }

    public String getSynsets() {
        return synsets;
    }

    public void setSynsets(String synsets) {
        this.synsets = synsets;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
