package edu.zut.cs.zutnlp.cv.synset.dao;


import edu.zut.cs.zutnlp.base.dao.GenericDao;
import edu.zut.cs.zutnlp.cv.synset.domain.Synset;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SynsetDao extends GenericDao<Synset,Long> {

    @Query(value = "select synset from Synset  synset where synset.image_id=?1")
    public List<Synset> findByImage_id(Long image_id);

    @Modifying
    @Query(value = "update Synset synset set synset.synset_definition =:synset_definition where synset.synset_name =:synset_name")
    public int updateSynset_definition(@Param("synset_definition") String synset_definition, @Param("synset_name") String synset_name);

}
