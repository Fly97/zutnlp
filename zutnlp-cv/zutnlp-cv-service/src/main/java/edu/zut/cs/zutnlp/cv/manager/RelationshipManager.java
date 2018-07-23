package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;

import java.util.List;

public interface RelationshipManager extends GenericManager<Relationship,Long> {
    public Relationship findByRelationshipId(Long relationshipId);
    public List<Relationship> findByImageId(Long image_id);
    public Integer updateSceneId(Long scene_id, Long relationship_id);

    public Integer updateRegionId(Long region_id, Long relationship_id);
    public Integer updateSubjectId(Long subject_id, Long relationship_id);
}
