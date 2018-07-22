package edu.zut.cs.zutnlp.cv.manager.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.manager.SceneManager;
import edu.zut.cs.zutnlp.cv.scene.dao.SceneDao;
import edu.zut.cs.zutnlp.cv.scene.domain.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SceneManagerImpl extends GenericManagerImpl<Scene,Long> implements SceneManager {

    SceneDao sceneDao;
    @Autowired
    public void setSceneDao(SceneDao sceneDao) {
        this.sceneDao = sceneDao;
        this.dao = this.sceneDao;
    }

    @Override
    public List<Scene> findByImageId(Long image_id) {
       return this.sceneDao.findByImageId(image_id);
    }
}
