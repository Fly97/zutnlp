package edu.zut.cs.zutnlp.cv.relationship.dao;



import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.relationship.domain.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends GenericDao<Subject,Long> {
    @Query(value = "select subject from Subject subject where subject.relationship_id=?1")
    public Subject findByRelationshipId(Long relationship_id);

}
