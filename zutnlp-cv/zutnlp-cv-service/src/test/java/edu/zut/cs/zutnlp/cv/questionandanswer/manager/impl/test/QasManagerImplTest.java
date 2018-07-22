package edu.zut.cs.zutnlp.cv.questionandanswer.manager.impl.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.cv.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.manager.QasManager;
import edu.zut.cs.zutnlp.cv.questionandanswer.domain.Qas;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class QasManagerImplTest extends GenericGenerator {

    @Autowired
    QasManager qasManager;

    @Test
    public void initData(){
        for (int i = 0; i < 201; i++) {
            String path = "C:\\Users\\戴尔\\Desktop\\question_answers\\after_deal\\" + i + ".json";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(path));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    //处理第一条json
                    if(i==0){
                        String newline = line.substring(0, line.length()-1)+"]";
                        handle(newline);
                    }
                    //处理最后一条json
                    else if(i==200){
                        String newline = "["+line;
                        handle(newline);
                    }
                    //处理中间的json
                    else{
                        String newline = "["+line.substring(0, line.length()-2)+"]";
                        handle(newline);
                    }
                }
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (JSONException j1){
                j1.printStackTrace();
            }
        }
    }

    public void handle(String line){
        //处理最外层的array（字符串转成json数组）
        JSONArray jsonArray = JSONArray.parseArray(line);
        for(int i=0; i<jsonArray.size(); i++){
            //处理每一个数组的元素
            JSONObject jsonObject = jsonArray.getJSONObject(i);


            //处理内部qas数据
            JSONArray jsonArray1 = jsonObject.getJSONArray("qas");
            for(int j=0; j<jsonArray1.size(); j++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                Qas qas = new Qas();
                String question = jsonObject1.getString("question");
                String image_id = jsonObject1.getString("image_id");
                Long image_id2 = Long.parseLong(image_id);
                String qa_id = jsonObject1.getString("qa_id");
                Long qa_id2 = Long.parseLong(qa_id);
                String answer = jsonObject1.getString("answer");
                qas.setAnswer(answer);
                qas.setImage_id(image_id2);
                qas.setQa_id(qa_id2);
                qas.setQuestion(question);
                qas.setEntityName("QAS");

                //处理a_objects and p_objects
                JSONArray jsonArray2 = jsonObject1.getJSONArray("a_objects");
                JSONArray jsonArray3 = jsonObject1.getJSONArray("q_objects");
                String aobjects = jsonArray2.toString();
                String qobjects = jsonArray3.toString();
                if(jsonArray2.isEmpty()){
                    aobjects = null;
                }
                qas.setA_objects(aobjects);
                if(jsonArray3.isEmpty()){
                    qobjects = null;
                }
                qas.setQ_objects(qobjects);
                qasManager.save(qas);
            }
        }
    }

    @Test
    public void findByImage_idTest(){
        Long Image_id = (long) 1;
        List<Qas> qasList2 = qasManager.findByImage_id(Image_id);
        for(int i=0;i<qasList2.size();i++){
            System.out.println(qasList2.get(i).getQuestion());
        }
    }

    @Test
    public void findByQa_idTest(){
        Long Qa_id = (long) 986768;
        Qas qas = qasManager.findByQa_id(Qa_id);
        System.out.println(qas.getQuestion());
    }


}
