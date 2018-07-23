package edu.zut.cs.zutnlp.cv.scene.manager.impl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.MyObjectManager;
import edu.zut.cs.zutnlp.cv.manager.RelationshipManager;
import edu.zut.cs.zutnlp.cv.manager.SceneManager;
import edu.zut.cs.zutnlp.cv.scene.domain.Scene;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SceneManagerImplTest extends GenericGenerator {

    @Autowired
    SceneManager sceneManager;
    @Autowired
    RelationshipManager relationshipManager;
    @Autowired
    MyObjectManager myObjectManager;
    @Test
    public void findByImageId()
    {
        List<Scene> sceneList = sceneManager.findByImageId((long)1);
        System.out.println(sceneList.size());
    }
    @Test
    public void addScene() throws IOException{
        for (int i = 0; i < 4; i++) {
            File file = new File("E:\\Visualgenome\\scene_format\\" + i + ".json");
            String content = FileUtils.readFileToString(file, "utf-8");

            String[] sceneList = content.split("\"relationships\"");
            for (String str : sceneList) {
                if (str.length() > 1 && str.endsWith(", {")) {
                    String oneScene = "{\"relationships\"" + str.substring(0, str.length() - 3);

                    JSONObject sceneJsonObject = JSON.parseObject(oneScene);
                    Long imageId = sceneJsonObject.getLong("image_id");
                    if (imageId == 1) {
                        Scene scene = new Scene();
                        scene.setImage_id(imageId);
                        scene.setEntityName("SCENE");
                        sceneManager.save(scene);
                        JSONArray relationshipJsonArray = sceneJsonObject.getJSONArray("relationships");
                        for (int j = 0; j < relationshipJsonArray.size(); j++) {
                            JSONObject relationshipOne = relationshipJsonArray.getJSONObject(j);
                            Long relationship_id = (long) relationshipOne.getIntValue("relationship_id");
                            relationshipManager.updateSceneId(scene.getId(), relationship_id);
                        }
                        JSONArray myObjectJsonArray = sceneJsonObject.getJSONArray("objects");
                        for (int n = 0; n < myObjectJsonArray.size(); n++) {
                            JSONObject myObjectOne = myObjectJsonArray.getJSONObject(n);
                            Long object_id = (long) myObjectOne.getIntValue("object_id");
                            myObjectManager.updateSceneId(scene.getId(), object_id);
                        }
                    }else{
                        System.err.println("处理到第二个文件");
                    }
                }
            }
        }

    }
}
