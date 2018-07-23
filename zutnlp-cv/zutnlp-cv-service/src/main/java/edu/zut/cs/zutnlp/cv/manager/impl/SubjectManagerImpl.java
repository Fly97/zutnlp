package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.SubjectManager;
import edu.zut.cs.zutnlp.cv.relationship.dao.SubjectDao;
import edu.zut.cs.zutnlp.cv.relationship.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectManagerImpl extends GenericManagerImpl<Subject,Long> implements SubjectManager {

    SubjectDao subjectDao;

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
        this.dao = this.subjectDao;
    }
    @Override
    public Subject findByRelationshipId(Long relationship_id){
     Subject subject = subjectDao.findByRelationshipId(relationship_id);
     return subject;
    }
}
