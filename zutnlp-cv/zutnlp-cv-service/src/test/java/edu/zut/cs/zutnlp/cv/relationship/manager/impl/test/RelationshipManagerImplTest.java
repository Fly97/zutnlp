package edu.zut.cs.zutnlp.cv.relationship.manager.impl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.cv.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.RelationshipManager;
import edu.zut.cs.zutnlp.cv.manager.SubjectManager;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import edu.zut.cs.zutnlp.cv.relationship.domain.Subject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RelationshipManagerImplTest extends GenericGenerator {
    @Autowired
    RelationshipManager relationshipManager;
    @Autowired
    SubjectManager subjectManager;

    @Test
    public void getOneByRelationshipId()
    {
        Relationship relationship = relationshipManager.findByRelationshipId((long)15927);
        System.out.println(relationship.toString());
    }
    @Test
    public void getByImageId()
    {
        List<Relationship> relationshipList = relationshipManager.findByImageId((long)1);
        for(Relationship relationship: relationshipList)
        {
            System.out.println(relationship.toString());
        }
    }

    @Test
    public void addRelationship() throws IOException{
        for (int i = 1; i <= 1; i++) {
            File file = new File("E:\\Visualgenome\\relationships_format\\" + i + ".json");
            String content = FileUtils.readFileToString(file, "utf-8");
            try {
                String[] relationshipList = content.split("\"relationships\"");
                for (String str : relationshipList) {
                    if (str.length() > 1 && str.endsWith(", {")) {
                        String relation = "{\"relationships\"" + str.substring(0, str.length() - 3);
                        JSONObject relationshipJsonObject= JSON.parseObject(relation);

                        Long imageId = relationshipJsonObject.getLong("image_id");

                        JSONArray relationshipsArray = relationshipJsonObject.getJSONArray("relationships");

                        for (int j = 0; j < relationshipsArray.size(); j++) {

                            JSONObject relationshipObject = relationshipsArray.getJSONObject(j);
                            //转换为myobject的json格式
                            JSONObject myObjectJson = relationshipObject.getJSONObject("object");

                            String synsetsMain = "";
                            JSONArray mainSynsets = relationshipObject.getJSONArray("synsets");
                            if (mainSynsets.size() > 1) {
                                for (int m = 0; m < mainSynsets.size(); m++) {
                                    synsetsMain = (String) mainSynsets.get(m) + ",";
                                }
                            } else if (mainSynsets.size() == 1) {
                                synsetsMain = (String) mainSynsets.get(0);
                            }

                            JSONObject subjectObject = relationshipObject.getJSONObject("subject");
                            Subject subject = new Subject();
                            subject.setName(subjectObject.getString("name"));
                            subject.setH(subjectObject.getIntValue("h"));
                            subject.setObject_id(subjectObject.getIntValue("object_id"));
                            String synset2 = "";
                            JSONArray synsets2 = subjectObject.getJSONArray("synsets");
                            if (synsets2.size() > 1) {
                                for (int k = 0; k < synsets2.size(); k++) {
                                    synset2 = (String) synsets2.get(k) + ",";
                                }
                            } else if (synsets2.size() == 1) {
                                synset2 = (String) synsets2.get(0);
                            }
                            subject.setSynsets(synset2);
                            subject.setW(subjectObject.getIntValue("w"));
                            subject.setY(subjectObject.getIntValue("y"));
                            subject.setX(subjectObject.getIntValue("x"));
                            subject.setRelationship_id(relationshipObject.getLong("relationship_id"));
                            subject.setEntityName("SUBJECT");
                            subjectManager.save(subject);

                            Relationship relationship =  new Relationship();
                            relationship.setObject_id(myObjectJson.getLong("object_id"));
                            relationship.setPredicate(relationshipObject.getString("predicate"));
                            relationship.setRelationship_id(relationshipObject.getLong("relationship_id"));
                            relationship.setSynsets(synsetsMain);
                            relationship.setImage_id(imageId);
                            relationship.setSubject(subject);
                            relationship.setEntityName("RELATIONSHIP");
                            relationshipManager.save(relationship);
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}
