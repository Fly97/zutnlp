package edu.zut.cs.zutnlp.text.Chinese.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChrecognitionDao extends GenericDao<Chrecognition,Long> {

    @Query(value = "select chrecognition from Chrecognition chrecognition where chrecognition.id = (select max(chrecognition.id) from chrecognition)")
    public List<Chrecognition> findlastId();
}
