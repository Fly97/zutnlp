package edu.zut.cs.zutnlp.cv.object.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyObjectDao extends GenericDao<MyObject,Long> {

    @Query(value="select myObject from MyObject myObject where myObject.image_id=?1")
    public List<MyObject> findByImage_id(Long image_id);

    @Modifying
    @Query(value = "update  MyObject myobject set myobject.region_id = :region_id where myobject.object_id = :object_id")
    public Integer updateByRegion_id(@Param("region_id") Long region_id, @Param("object_id") Long object_id);

    @Modifying
    @Query("update MyObject myobject set myobject.scene_id = :scene_id where myobject.object_id = :object_id")
    public Integer updateSceneId(@Param("scene_id") Long scene_id, @Param("object_id") Long object_id);


}
