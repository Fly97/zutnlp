package edu.zut.cs.zutnlp.text.Keyrecognition.dao;



import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Keyrecognition.domain.Keyrecognition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyrecognitionDao extends GenericDao<Keyrecognition,Long> {

    @Query(value = "select keyrecognition from Keyrecognition keyrecognition where keyrecognition.id = (select max(keyrecognition.id) from keyrecognition)")
    public List<Keyrecognition> findlastId();
}
