package edu.zut.cs.zutnlp.cv.manager;


import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.relationship.domain.Subject;

public interface SubjectManager extends GenericManager<Subject,Long> {
    public Subject findByRelationshipId(Long relationship_id);
}
