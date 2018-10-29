package edu.zut.cs.zutnlp.text.grammar.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.grammar.domain.grarecognition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//基于传统dao层接口的实现方式
public interface GrarecognitionDao extends GenericDao<grarecognition,Long> {
    @Query(value = "select gra from grarecognition gra " +
            "where gra.id = (select max(gra.id) from gra)")
    public List<grarecognition> findlastId();

}
