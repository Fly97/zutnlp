package edu.zut.cs.zutnlp.cv.image.domain;



import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="OBJECT_DETECTION_IMAGE")
@Entity
public class Image extends BaseEntity {
    //"width": 800,
    // "url": "https://cs.stanford.edu/people/rak248/VG_100K_2/1.jpg",
    // "height": 600,
    // "image_id": 1,
    // "coco_id": null,
    // "flickr_id": null}
    @Column(name = "IMAGE_ID")
    private Long image_id;

    @Column(name = "WIDTH")
    private int width;

    @Column(name = "HEIGHT")
    private int height;

    @Column(name = "COCO_ID")
    private Long coco_id;

    @Column(name = "FLICKR_ID")
    private Long flickr_id;

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
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

    public Long getCoco_id() {
        return coco_id;
    }

    public void setCoco_id(Long coco_id) {
        this.coco_id = coco_id;
    }

    public Long getFlickr_id() {
        return flickr_id;
    }

    public void setFlickr_id(Long flickr_id) {
        this.flickr_id = flickr_id;
    }
}
