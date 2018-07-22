package edu.zut.cs.zutnlp.cv.relationship.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipDao extends GenericDao<Relationship,Long> {

    @Query(value="select relationship from Relationship relationship where relationship.relationship_id = ?1")
    public Relationship findByRelationshipId(Long relationship_id);
    @Query(value="select relationship from Relationship relationship where relationship.image_id=?1")
    public List<Relationship> findByImageId(Long image_id);
    @Modifying
    @Query("update Relationship relationship set relationship.scene_id = :scene_id where relationship.relationship_id = :relationship_id")
    public Integer updateSceneId(@Param("scene_id") Long scene_id, @Param("relationship_id") Long relationship_id);

    @Modifying
    @Query("update Relationship relationship set relationship.region_id = :region_id where relationship.relationship_id = :relationship_id")
    public Integer updateRegionId(@Param("region_id") Long region_id, @Param("relationship_id") Long relationship_id);

    @Modifying
    @Query("update Relationship relationship set relationship.subject_id = :subject_id where relationship.relationship_id = :relationship_id")
    public Integer updateSubjectId(@Param("subject_id") Long subject_id, @Param("relationship_id") Long relationship_id);


}
