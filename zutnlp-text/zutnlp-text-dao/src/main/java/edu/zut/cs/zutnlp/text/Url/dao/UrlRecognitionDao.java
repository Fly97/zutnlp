package edu.zut.cs.zutnlp.text.Url.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.text.Url.domain.UrlRecogntion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UrlRecognitionDao extends GenericDao<UrlRecogntion,Long> {
    @Query(value = "select urlRecognition from UrlRecogntion urlRecognition where urlRecognition.id = (select max(urlRecognition.id) from urlRecognition)")
    public List<UrlRecogntion> findLastId();
}
