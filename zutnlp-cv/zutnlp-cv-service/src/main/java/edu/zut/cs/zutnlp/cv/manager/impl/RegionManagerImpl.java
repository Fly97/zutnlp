package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.RegionManager;
import edu.zut.cs.zutnlp.cv.region.dao.RegionDao;
import edu.zut.cs.zutnlp.cv.region.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegionManagerImpl extends GenericManagerImpl<Region,Long> implements RegionManager {

    RegionDao regionDao;

    @Autowired
    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
        this.dao=this.regionDao;
    }

    @Override
    public List<Region> findByImage_id(Long image_id) {
        return this.regionDao.findByImage_id(image_id);
    }
}
