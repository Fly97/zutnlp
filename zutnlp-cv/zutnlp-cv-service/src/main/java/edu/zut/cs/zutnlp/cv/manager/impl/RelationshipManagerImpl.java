package edu.zut.cs.zutnlp.cv.manager.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.RelationshipManager;
import edu.zut.cs.zutnlp.cv.relationship.dao.RelationshipDao;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RelationshipManagerImpl extends GenericManagerImpl<Relationship,Long> implements RelationshipManager {

    RelationshipDao relationshipDao;

    @Autowired
    public void setRelationshipDao(RelationshipDao relationshipDao) {
        this.relationshipDao = relationshipDao;
        this.dao = this.relationshipDao;
    }
    @Override
    public Relationship findByRelationshipId(Long relationshipId){
        return this.relationshipDao.findByRelationshipId(relationshipId);
    }
    @Override
    public List<Relationship> findByImageId(Long image_id){
        return this.relationshipDao.findByImageId(image_id);
    }

    @Override
    public Integer updateRegionId(Long region_id, Long relationship_id) {
        return this.relationshipDao.updateRegionId(region_id, relationship_id);
    }

    @Override
    public Integer updateSceneId(Long scene_id, Long relationship_id) {
        return this.relationshipDao.updateSceneId(scene_id, relationship_id);
    }

    @Override
    public Integer updateSubjectId(Long subject_id, Long relationship_id) {
        return this.relationshipDao.updateSubjectId(subject_id, relationship_id);
    }
}
