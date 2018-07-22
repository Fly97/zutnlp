package edu.zut.cs.zutnlp.cv.attribute.dao;



import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.attribute.domain.Attribute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttributeDao extends GenericDao<Attribute,Long> {
    @Query(value = "select attribute from Attribute attribute where attribute.image_id=?1")
     public List<Attribute> findByImageId(Long image_id);


}
