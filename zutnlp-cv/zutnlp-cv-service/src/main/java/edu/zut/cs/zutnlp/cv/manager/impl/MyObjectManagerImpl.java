package edu.zut.cs.zutnlp.cv.manager.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.MyObjectManager;
import edu.zut.cs.zutnlp.cv.object.dao.MyObjectDao;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyObjectManagerImpl extends GenericManagerImpl<MyObject,Long> implements MyObjectManager {

    MyObjectDao myObjectDao;

    @Autowired
    public void setMyObjectDao(MyObjectDao myObjectDao) {
        this.myObjectDao = myObjectDao;
        this.dao=this.myObjectDao;
    }

    public List<MyObject> findByImage_id(Long image_id) {

        return this.myObjectDao.findByImage_id(image_id);
    }

    @Override
    public Integer updateByRegion_id(Long region_id, Long object_id) {

        return this.myObjectDao.updateByRegion_id(region_id, object_id);
    }
    @Override
    public Integer updateSceneId(Long scene_id,Long object_id)
    {
        return  this.myObjectDao.updateSceneId(scene_id,object_id);

    }
}
