package edu.zut.cs.zutnlp.cv.synset.manager.impl.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.cv.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.SynsetManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class SynsetManagerImplTest extends GenericGenerator {

    @Autowired
    SynsetManager synsetManager;

    @Test
    public void updateTest()
    {
        try {
            File file = new File("G:\\Java\\ServerFiles\\Visualgenome\\synsets.json");
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONArray synsetList= JSON.parseArray(content);
            for(int i=0;i<synsetList.size();i++)
            {
                //{"synset_definition": "solid-hoofed herbivorous quadruped domesticated since prehistoric times",
                // "synset_name": "horse.n.01"}
                JSONObject temSyn=synsetList.getJSONObject(i);
                String synset_definition=temSyn.getString("synset_definition");
                String synset_name=temSyn.getString("synset_name");
                this.synsetManager.updateSynset_definition(synset_definition,synset_name);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
