package edu.zut.cs.zutnlp.cv.manager.impl;


import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import edu.zut.cs.zutnlp.cv.image.dao.ImageDao;
import edu.zut.cs.zutnlp.cv.image.domain.Image;
import edu.zut.cs.zutnlp.cv.manager.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageManagerImpl extends GenericManagerImpl<Image,Long> implements ImageManager {

    ImageDao imageDao;

    @Autowired
    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
        this.dao=this.imageDao;
    }
}
