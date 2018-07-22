package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.questionandanswer.domain.Qas;

import java.util.List;

public interface QasManager extends GenericManager<Qas, Long> {

    List<Qas> findByImage_id(Long Image_id);

    Qas findByQa_id(Long Qa_id);
}
