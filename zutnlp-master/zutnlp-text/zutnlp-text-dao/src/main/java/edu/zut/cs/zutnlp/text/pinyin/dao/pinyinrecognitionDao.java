package edu.zut.cs.zutnlp.text.pinyin.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.pinyin.domain.pinyinrecognition;
import org.springframework.stereotype.Repository;


@Repository
public interface pinyinrecognitionDao extends GenericDao<pinyinrecognition,Long> {
}
