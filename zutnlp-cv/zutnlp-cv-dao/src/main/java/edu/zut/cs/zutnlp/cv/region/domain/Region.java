package edu.zut.cs.zutnlp.cv.region.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="OBJECT_DETECTION_REGION")
@Entity
public class Region extends BaseEntity {

    @Column(name="REGION_ID")
    Long region_id;

    @Column(name="WIDTH")
    int width;

    @Column(name="HEIGHT")
    int height;

    @Column(name="PHRASE")
    String phrase;

    @Column(name="X")
    int x;

    @Column(name="Y")
    int y;

    @Column(name="IMAGE_ID")
    Long image_id;

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }
}
