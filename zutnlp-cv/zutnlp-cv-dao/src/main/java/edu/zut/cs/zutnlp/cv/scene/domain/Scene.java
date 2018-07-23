package edu.zut.cs.zutnlp.cv.scene.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OBJECT_DETECTION_SCENE")
public class Scene extends BaseEntity
{
    private static final long serialVersionUID = -5L;

    private Long image_id;

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "image_id=" + image_id +
                '}';
    }
}
