package edu.zut.cs.zutnlp.cv.description.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.description.domain.Description;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionDao extends GenericDao<Description,Long> {
    @Query(value = "select description from Description description where description.image_id=?1")
    public List<Description> findByImage_id(Long image_id);
}
