package edu.zut.cs.zutnlp.text.Pinyin.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PinyinRecognitionDao extends GenericDao<PinyinRecognition,Long> {
    @Query(value = "select pinyinRecognition from PinyinRecognition pinyinRecognition where pinyinRecognition.id = (select max(pinyinRecognition.id) from pinyinRecognition)")
    public List<PinyinRecognition> findLastId();
}
