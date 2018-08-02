package edu.zut.cs.zutnlp.text.Abstractkey.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Abstractkey.domain.Keyrecognition;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyrecognitionDao extends GenericDao<Keyrecognition,Long> {
}
