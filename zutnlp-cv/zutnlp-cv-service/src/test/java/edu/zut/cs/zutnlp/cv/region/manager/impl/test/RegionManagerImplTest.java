package edu.zut.cs.zutnlp.cv.region.manager.impl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.MyObjectManager;
import edu.zut.cs.zutnlp.cv.manager.RegionManager;
import edu.zut.cs.zutnlp.cv.manager.RelationshipManager;
import edu.zut.cs.zutnlp.cv.manager.SynsetManager;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import edu.zut.cs.zutnlp.cv.region.domain.Region;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import edu.zut.cs.zutnlp.cv.synset.domain.Synset;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class RegionManagerImplTest extends GenericGenerator {

    @Autowired
    RegionManager regionManager;

    @Autowired
    SynsetManager synsetManager;

    @Autowired
    MyObjectManager myObjectManager;

    @Autowired
    RelationshipManager relationshipManager;

    @Test
    public void testUpdate()
    {
        this.relationshipManager.updateRegionId((long)1383,(long)15927);
    }

    public void testAdd()
    {
        try {
            File file=new File("G:\\Java\\ServerFiles\\region_graphs\\1.json");
            String content= FileUtils.readFileToString(file, "utf-8");
            System.out.println(content);
            JSONObject job= JSON.parseObject(content);
            JSONArray regions=job.getJSONArray("regions");
            for(int j=0;j<regions.size();j++)
            {
                Region region=new Region();
                JSONObject temRegion=(JSONObject) regions.get(j);
                Long region_id=temRegion.getLong("region_id");
                region.setRegion_id(region_id);
                //从文件中获取各种数据，插入到数据库中
                region.setWidth(temRegion.getIntValue("width"));
                region.setHeight(temRegion.getIntValue("height"));
                region.setPhrase(temRegion.getString("phrase"));
                region.setX(temRegion.getIntValue("x"));
                region.setY(temRegion.getIntValue("y"));
                Long image_id=temRegion.getLong("image_id");
                region.setEntityName("REGION");
                region.setImage_id(image_id);
                this.regionManager.save(region);
                JSONArray relationships=temRegion.getJSONArray("relationships");
                for(int k=0;k<relationships.size();k++)
                {
                    JSONObject temRela=relationships.getJSONObject(k);

                        Relationship r=new Relationship();
                        r.setPredicate(temRela.getString("predicate"));
                        Long relationship_id=temRela.getLong("relationship_id");
                        r.setRelationship_id(relationship_id);
                        JSONArray temSyn=temRela.getJSONArray("synsets");
                        String strSyn="";
                        for(int p=0;p<temSyn.size();p++)
                        {
                            strSyn+=temSyn.getString(p)+",";
                        }
                        r.setSynsets(strSyn);
                        Long subject_id=temRela.getLong("subject_id");
                        r.setSubject_id(subject_id);
                        r.setEntityName("RELATIONSHIP");
                        r.setRegion_id(region_id);
                        boolean f=false;
                        List<Relationship> relationshipList=this.relationshipManager.findAll();
                        for(Relationship relationship:relationshipList)
                        {
                            if(relationship.getRelationship_id().longValue()==relationship_id.longValue())
                            {
                                System.out.println(relationship_id);
                                this.relationshipManager.updateRegionId(region_id,relationship_id);
                                this.relationshipManager.updateSubjectId(region_id,relationship_id);
                                f=true;
                            }
                        }
                        if(!f)
                        {
                            this.relationshipManager.save(r);
                        }

                }
                JSONArray synsets=temRegion.getJSONArray("synsets");
                for(int k=0;k<synsets.size();k++)
                {
                    JSONObject temSyn=synsets.getJSONObject(k);
                    Synset synset=new Synset();
                    synset.setSynset_name(temSyn.getString("synset_name"));
                    synset.setEntityName("SYNSET");
                    synset.setEntity_name(temSyn.getString("entity_name"));
                    synset.setEntity_idx_end(temSyn.getIntValue("entity_idx_end"));
                    synset.setEntity_idx_start(temSyn.getIntValue("entity_idx_start"));
                    synset.setRegion_id(region_id);
                    synset.setImage_id(image_id);
                    this.synsetManager.save(synset);
                }
                JSONArray objects=temRegion.getJSONArray("objects");
                for(int k=0;k<objects.size();k++)
                {
                    JSONObject temObj=objects.getJSONObject(k);
                    MyObject myObject;
                    myObject=new MyObject();
                    myObject.setName(temObj.getString("name"));
                    Long object_id=temObj.getLong("object_id");
                    myObject.setObject_id(object_id);
                    //从文件中获取各种数据，插入到数据库中
                    myObject.setH(temObj.getIntValue("h"));
                    myObject.setW(temObj.getIntValue("w"));
                    myObject.setY(temObj.getIntValue("y"));
                    myObject.setX(temObj.getIntValue("x"));
                    myObject.setEntityName("MYOBJECT");
                    JSONArray temSyn=temObj.getJSONArray("synsets");
                    String strSyn="";
                    for(int p=0;p<temSyn.size();p++)
                    {
                        strSyn+=temSyn.getString(p)+",";
                    }
                    myObject.setSynsets(strSyn);
                    myObject.setRegion_id(region_id);
                    myObject.setImage_id(image_id);
                    List<MyObject> myObjects=this.myObjectManager.findAll();
                    boolean f=false;
                    for(MyObject myObject1:myObjects)
                    {
                        if(myObject1.getObject_id().longValue()==myObject.getObject_id().longValue())
                        {
                            this.myObjectManager.updateByRegion_id(region_id,object_id);
                            f=true;
                        }
                    }
                    if(!f)
                        this.myObjectManager.save(myObject);

                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
