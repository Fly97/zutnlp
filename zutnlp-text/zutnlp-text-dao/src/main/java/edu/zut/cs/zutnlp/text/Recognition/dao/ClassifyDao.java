package edu.zut.cs.zutnlp.text.Recognition.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Recognition.domain.Classify;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyDao extends GenericDao<Classify,Long> {
    @Query(value = "select classify from Classify classify where classify.id = (select max(classify.id) from classify)")
    public List<Classify> findlastId();
}
