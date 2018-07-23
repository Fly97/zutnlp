package edu.zut.cs.zutnlp.cv.synset.domain;



import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "OBJECT_DETECTION_SYNSET")
@Entity
public class Synset extends BaseEntity {

    @Column(name="SYNSET_ENTITY_NAME")
    private String entity_name;

    @Column(name="SYNSET_NAME")
    private String synset_name;

    @Column(name="ENTITY_IDX_START")
    private int entity_idx_start;

    @Column(name="ENTITY_IDX_END")
    private int entity_idx_end;

    @Column(name="SYNSET_DEFNITION")
    private String synset_definition;

    @Column(name = "REGION_ID")
    private Long region_id;

    @Column(name = "IMAGE_ID")
    private Long image_id;

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

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public String getSynset_name() {
        return synset_name;
    }

    public void setSynset_name(String synset_name) {
        this.synset_name = synset_name;
    }

    public int getEntity_idx_start() {
        return entity_idx_start;
    }

    public void setEntity_idx_start(int entity_idx_start) {
        this.entity_idx_start = entity_idx_start;
    }

    public int getEntity_idx_end() {
        return entity_idx_end;
    }

    public void setEntity_idx_end(int entity_idx_end) {
        this.entity_idx_end = entity_idx_end;
    }

    public String getSynset_definition() {
        return synset_definition;
    }

    public void setSynset_definition(String synset_definition) {
        this.synset_definition = synset_definition;
    }
}
