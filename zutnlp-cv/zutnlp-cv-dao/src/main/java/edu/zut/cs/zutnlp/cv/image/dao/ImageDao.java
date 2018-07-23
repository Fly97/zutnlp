package edu.zut.cs.zutnlp.cv.image.dao;

import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.image.domain.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends GenericDao<Image,Long> {

}
