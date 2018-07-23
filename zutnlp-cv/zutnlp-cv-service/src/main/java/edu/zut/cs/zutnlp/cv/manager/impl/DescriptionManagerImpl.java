package edu.zut.cs.zutnlp.cv.manager.impl;

import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.description.dao.DescriptionDao;
import edu.zut.cs.zutnlp.cv.description.domain.Description;
import edu.zut.cs.zutnlp.cv.manager.DescriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DescriptionManagerImpl extends GenericManagerImpl<Description,Long> implements DescriptionManager {

    DescriptionDao descriptionDao;
    @Autowired
    public void setDescriptionDao(DescriptionDao descriptionDao) {
        this.descriptionDao = descriptionDao;
        this.dao=this.descriptionDao;
    }

    @Override
    public List<Description> findByImage_id(Long image_id){
        List<Description> descriptionList = descriptionDao.findByImage_id(image_id);
        return descriptionList;
    }
}
