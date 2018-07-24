package edu.zut.cs.zutnlp.text.named.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.named.domain.namedrecognition;
import org.springframework.stereotype.Repository;

@Repository
public interface namedrecognitionDao extends GenericDao<namedrecognition,Long> {
}
