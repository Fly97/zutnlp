package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;

import java.util.List;

public interface MyObjectManager extends GenericManager<MyObject,Long> {

    public List<MyObject> findByImage_id(Long image_id);

    public Integer updateByRegion_id(Long region_id, Long object_id);

    public Integer updateSceneId(Long scene_id, Long object_id);

}
