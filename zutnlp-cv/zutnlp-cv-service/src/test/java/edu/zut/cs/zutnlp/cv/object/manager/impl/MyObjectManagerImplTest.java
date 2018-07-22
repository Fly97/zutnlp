package edu.zut.cs.zutnlp.cv.object.manager.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.cv.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.MyObjectManager;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

public class MyObjectManagerImplTest extends GenericGenerator {

    @Autowired
    MyObjectManager myObjectManager;

    @Test
    public void testAuto()
    {
        MyObject myObject=new MyObject();
        myObject.setEntityName("MYOBJECT");
        this.myObjectManager.save(myObject);
//        this.myObjectManager.findByImage_id((long)666);
    }
    @Test
    public void addJsonData() {
        try {

            File file = new File("G:\\Java\\ServerFiles\\objects\\complete\\" + 1 + ".json");
            String content = FileUtils.readFileToString(file, "utf-8");
            String[] all = content.split("\"image_id\"");
            for (String a : all) {

                if (a.length() < 5)
                    continue;
                content = "{\"image_id\"" + a.substring(0, a.length() - 2);
                if(content.charAt(content.length()-1)==',')
                    content=content.substring(0,content.length()-1);
                JSONObject job =JSON.parseObject(content);
                JSONArray arr = job.getJSONArray("objects");
                Long image_id = new Long(job.getLong("image_id"));
                for (int j = 0; j < arr.size(); j++) {
                    JSONObject job1 = arr.getJSONObject(j);

                    String synsets = null;
                    JSONArray synset = job1.getJSONArray("synsets");
                    if (synset.size() != 0) {
                        synsets = synset.getString(0);
                        for (int jj = 1; jj < synset.size() && synset.size() > 1; jj++) {
                            synsets = synsets + ",";
                            synsets = synsets + synset.getString(jj);

                        }
                    }
                    int h = job1.getIntValue("h");
                    Long object_id = job1.getLong("object_id");
                    String merged_object_ids = null;
                    JSONArray mo_ids = job1.getJSONArray("merged_object_ids");
                    if (mo_ids.size() != 0) {
                        merged_object_ids = mo_ids.getString(0);
                        for (int jj = 1; jj < mo_ids.size() && mo_ids.size() > 1; jj++) {
                            merged_object_ids = merged_object_ids + ",";
                            merged_object_ids = merged_object_ids + mo_ids.getString(jj);

                        }
                    }
                    String names = "";
                    JSONArray na = job1.getJSONArray("names");
                    if (na.size() != 0) {
                        names = na.getString(0);
                        for (int jj = 1; jj < na.size() && na.size() > 1; jj++) {
                            names = names + ",";
                            names = names + na.getString(jj);

                        }
                    }
                    int w = job1.getIntValue("w");
                    int y = job1.getIntValue("y");
                    int x = job1.getIntValue("x");

                    MyObject myObject = new MyObject();

                    myObject.setMerged_object_ids(merged_object_ids);
                    //从文件中获取各种数据，插入到数据库中
                    myObject.setH(h);
                    myObject.setW(w);
                    myObject.setX(x);
                    myObject.setY(y);
                    myObject.setSynsets(synsets);
                    myObject.setObject_id(object_id);
                    myObject.setNames(names);
                    myObject.setImage_id(image_id);
                    myObject.setEntityName("MYOBJECT");
                    this.myObjectManager.save(myObject);
                }

            }
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

