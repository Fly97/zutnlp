package edu.zut.cs.zutnlp.text.Pinyin.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;
import org.springframework.stereotype.Repository;


@Repository
public interface PinyinRecognitionDao extends GenericDao<PinyinRecognition,Long> {
}
