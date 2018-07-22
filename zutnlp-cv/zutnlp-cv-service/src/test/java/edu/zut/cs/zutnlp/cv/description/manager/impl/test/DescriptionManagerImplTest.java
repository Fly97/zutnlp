package edu.zut.cs.zutnlp.cv.description.manager.impl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu.zut.cs.zutnlp.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.description.domain.Description;
import edu.zut.cs.zutnlp.cv.manager.DescriptionManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class DescriptionManagerImplTest extends GenericGenerator {
        @Autowired
        DescriptionManager descriptionManager;


        @Test
        public void test()
        {
            this.descriptionManager.findByImage_id((long)1);
        }
        @Test
        public void adddescription() throws IOException {
            for(int i=1;i<100;i++) {
                File file = new File("D:\\java学习资源\\任务\\region_descriptions\\copy\\copy" + i + ".json");
                String content = FileUtils.readFileToString(file, "utf-8");
                String[] descriptionList = content.split("\"regions\"");

                for (String str : descriptionList) {
                    if (str.length() > 1 && str.endsWith(", {")) {
                        String description = "{\"regions\"" + str.substring(0, str.length() - 3);
                        JSONObject descriptionJsonObject = JSON.parseObject(description);

                            Long imageId = descriptionJsonObject.getLong("image_id");
                            JSONArray descriptionArray = descriptionJsonObject.getJSONArray("regions");
                        for(int j=0;j<descriptionArray.size();j++) {
                            Description description1 = new Description();
                            JSONObject add=descriptionArray.getJSONObject(j);
                            description1.setHeight(add.getInteger("height"));
                            description1.setWidth(add.getInteger("width"));
                            description1.setImage_id(add.getLong("image_id"));
                            description1.setPhrase(add.getString("phrase"));
                            description1.setRegion_id(add.getLong("region_id"));
                            description1.setX(add.getInteger("x"));
                            description1.setY(add.getInteger("y"));
                            description1.setEntityName("DESCRIPTION");
                            descriptionManager.save(description1);
                        }
                        }
                    }


                }
            }
        }
