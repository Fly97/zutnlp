package edu.zut.cs.zutnlp.cv.region.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.region.domain.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionDao extends GenericDao<Region,Long> {

    @Query(value = "select region from Region  region where region.image_id=?1")
    List<Region> findByImage_id(Long image_id);

}
