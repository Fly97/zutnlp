package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.scene.domain.Scene;

import java.util.List;

public interface SceneManager extends GenericManager<Scene,Long> {
    public List<Scene> findByImageId(Long image_id);
}
