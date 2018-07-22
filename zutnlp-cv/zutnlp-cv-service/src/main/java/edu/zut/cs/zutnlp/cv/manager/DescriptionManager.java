package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.description.domain.Description;

import java.util.List;

public interface DescriptionManager extends GenericManager<Description,Long> {
    public List<Description> findByImage_id(Long image_id);
}
