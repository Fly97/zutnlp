package edu.zut.cs.zutnlp.cv.attribute.domain;



import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="OBJECT_DETECTION_Attribute")
@Entity

public class Attribute extends BaseEntity {

    private static final long serialVersionUID = 1L;

//    "image_id":495,
//            "attributes":[
//    {
//        "synsets":[
//        "window.n.01"
//            ],
//        "h":340,
//            "object_id":1623661,
//            "names":[
//             "window"
//            ],
//        "w":155,
//        "y":3,
//         "x":2


    @Column(name="IMAGE_ID")
    Long image_id;

    @Column(name="SYNSETS")
    String synsets;

    @Column(name="H")
    int h;

    @Column(name = "OBJECT_ID")
    Long object_id;

    @Column(name = "NAMES")
    String names;

    @Column(name="W")
    int w;

    @Column(name = "Y")
    int y;

    @Column(name = "X")
    int x;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    @Override
    public String toString() {
        return "Attribute{" +
                "image_id=" + image_id +
                ", synsets='" + synsets + '\'' +
                ", h=" + h +
                ", object_id=" + object_id +
                ", names='" + names + '\'' +
                ", w=" + w +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}
