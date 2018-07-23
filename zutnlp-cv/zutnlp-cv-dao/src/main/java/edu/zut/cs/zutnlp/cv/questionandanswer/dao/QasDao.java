package edu.zut.cs.zutnlp.cv.questionandanswer.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.questionandanswer.domain.Qas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QasDao extends GenericDao<Qas, Long> {

    @Query("select qas from Qas qas where qas.image_id = ?1")
    List<Qas> findByImage_id(Long Image_id);

    @Query("select qas from Qas qas where qas.qa_id = ?1")
    Qas findByQa_id(Long Qa_id);
}
