package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.attribute.domain.Attribute;

import java.util.List;

public interface AttributeManager extends GenericManager<Attribute,Long> {


    public List<Attribute> findByImage_id(Long image_id);



}
