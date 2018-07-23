package edu.zut.cs.zutnlp.cv.description.domain;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="OBJECT_DETECTION_DESCRIPTION")
@Entity
public class Description extends BaseEntity {
// "region_id": 1382,
// "width": 82,
// "height": 139,
// "image_id": 1,
// "phrase": "the clock is green in colour",
// "y": 57,
// "x": 421
    @Column(name="WIDTH")
    private int width;
    @Column(name="HEIGHT")
    private int height;
    @Column(name="IMAGE_ID")
    private Long image_id;
    @Column(name="PHRASE")
    private String phrase;
    @Column(name="Y")
    private int y;
    @Column(name="X")
    private int x;
    @Column(name="REGION_ID")
    private Long region_id;

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

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


    @Override
    @Transient
    public String toString() {
        return "Description{" +
                "width=" + width +
                ", height=" + height +
                ", image_id=" + image_id +
                ", phrase='" + phrase + '\'' +
                ", y=" + y +
                ", x=" + x +
                ", region_id=" + region_id +
                '}';
    }
}
