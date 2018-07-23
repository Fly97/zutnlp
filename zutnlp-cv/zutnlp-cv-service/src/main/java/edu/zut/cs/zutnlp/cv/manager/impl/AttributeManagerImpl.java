package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.attribute.dao.AttributeDao;
import edu.zut.cs.zutnlp.cv.attribute.domain.Attribute;
import edu.zut.cs.zutnlp.cv.manager.AttributeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttributeManagerImpl extends GenericManagerImpl<Attribute,Long> implements AttributeManager {

    AttributeDao attributeDao;

    @Autowired
    public void setAttributeDao(AttributeDao attributeDao){
        this.attributeDao=attributeDao;
        this.dao=this.attributeDao;
    }
    public List<Attribute> findByImage_id(Long image_id){
        return this.attributeDao.findByImageId(image_id);
    }

}
