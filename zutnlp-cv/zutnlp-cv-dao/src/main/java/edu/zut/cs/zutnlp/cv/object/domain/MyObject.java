package edu.zut.cs.zutnlp.cv.object.domain;



import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="OBJECT_DETECTION_MYOBJECT")
@Entity
public class MyObject extends BaseEntity {

    @Column(name = "IMAGE_ID")
    private Long image_id;

    @Column(name = "SYNSETS")
    private String synsets;

    @Column(name="NAME")
    private String name;

    @Column(name = "H")
    private int h;

    @Column(name = "W")
    private int w;

    @Column(name = "X")
    private int x;

    @Column(name = "Y")
    private int y;

    @Column(name = "NAMES")
    private String names;

    @Column(name = "MERGED_OBJECT_IDS")
    private String merged_object_ids;

    @Column(name = "OBJECT_ID")
    private Long object_id;

    @Column(name="REGION_ID")
    private Long region_id;

    @Column(name="scene_id")
    private Long scene_id;

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public String getSynsets() {
        return synsets;
    }

    public void setSynsets(String synsets) {
        this.synsets = synsets;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMerged_object_ids() {
        return merged_object_ids;
    }

    public void setMerged_object_ids(String merged_object_ids) {
        this.merged_object_ids = merged_object_ids;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }
}
