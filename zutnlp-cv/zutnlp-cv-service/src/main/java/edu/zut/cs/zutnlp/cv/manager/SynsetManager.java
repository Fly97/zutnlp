package edu.zut.cs.zutnlp.cv.manager;



import edu.zut.cs.zutnlp.base.service.GenericManager;
import edu.zut.cs.zutnlp.cv.synset.domain.Synset;

import java.util.List;

public interface SynsetManager extends GenericManager<Synset,Long> {

    public List<Synset> findByImage_id(Long image_id);

    public int updateSynset_definition(String synset_definition, String synset_name);


}
