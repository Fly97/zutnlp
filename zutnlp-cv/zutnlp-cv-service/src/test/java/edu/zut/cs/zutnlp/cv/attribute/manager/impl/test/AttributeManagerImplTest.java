package edu.zut.cs.zutnlp.cv.attribute.manager.impl.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import edu.zut.cs.zutnlp.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.attribute.domain.Attribute;
import edu.zut.cs.zutnlp.cv.manager.AttributeManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AttributeManagerImplTest extends GenericGenerator {

    @Autowired
    AttributeManager attributemanager;

    @Test
    public void addAttributeJsonData() throws IOException {

            for(int i=0;i<4;++i) {
                File file=new File("E:\\Visualgenome\\attributes\\after_deal\\"+i+".json");
                String content = FileUtils.readFileToString(file,"utf-8");
                    String newcontent = "["+content.substring(0,content.length()-2)+"]";
                    JSONArray jsonArray = JSONArray.parseArray(newcontent);
                    for(int m=0;m<jsonArray.size();m++){

                        JSONObject jsonObject = jsonArray.getJSONObject(m);
                        String image_id = jsonObject.getString("image_id");
                        Long image_id2 =Long.parseLong(image_id);
                        JSONArray jsonArray1 = jsonObject.getJSONArray("attributes");
                        for(int j=0;j<jsonArray1.size();j++){
                            Attribute attribute = new Attribute();
                            JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                            JSONArray jsonArray2 =jsonObject1.getJSONArray("synsets");
                            if(jsonArray2.size() == 0){
                                String synsets = null;
                                attribute.setSynsets(synsets);
                            }
                            else{
                                String synsets = jsonArray2.toJSONString();
                                attribute.setSynsets(synsets);
                            }
                            String object_id = jsonObject1.getString("object_id");
                            Long object_id2 = Long.parseLong(object_id);
                            attribute.setObject_id(object_id2);
                            int h = jsonObject1.getInteger("h");
                            int w = jsonObject1.getInteger("w");
                            int x = jsonObject1.getInteger("x");
                            int y = jsonObject1.getInteger("y");
                            String names = jsonObject1.getString("names");
                            attribute.setNames(names);
                            attribute.setW(w);
                            attribute.setH(h);
                            attribute.setX(x);
                            attribute.setY(y);
                            attribute.setImage_id(image_id2);
                            attribute.setEntityName("ATTRIBUTE");
                            attributemanager.save(attribute);
                        }
                    }
            }





    }




}
