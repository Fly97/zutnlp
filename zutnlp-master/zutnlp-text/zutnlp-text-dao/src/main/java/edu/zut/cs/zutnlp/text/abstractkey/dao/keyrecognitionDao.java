package edu.zut.cs.zutnlp.text.abstractkey.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.abstractkey.domain.keyrecognition;
import org.springframework.stereotype.Repository;

@Repository
public interface keyrecognitionDao extends GenericDao<keyrecognition,Long> {
}
