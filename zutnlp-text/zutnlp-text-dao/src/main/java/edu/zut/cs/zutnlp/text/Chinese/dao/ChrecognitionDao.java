package edu.zut.cs.zutnlp.text.Chinese.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import org.springframework.stereotype.Repository;

@Repository
public interface ChrecognitionDao extends GenericDao<Chrecognition,Long> {
}
