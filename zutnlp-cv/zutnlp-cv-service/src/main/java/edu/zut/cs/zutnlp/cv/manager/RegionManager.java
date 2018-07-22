package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.region.domain.Region;

import java.util.List;

public interface RegionManager extends GenericManager<Region,Long> {

    List<Region> findByImage_id(Long image_id);

}
