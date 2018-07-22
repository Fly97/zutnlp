package edu.zut.cs.zutnlp.cv.scene.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.scene.domain.Scene;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneDao extends GenericDao<Scene,Long> {

    @Query(value="select scene from Scene scene where scene.image_id=?1")
    public List<Scene> findByImageId(Long image_id);
}