package edu.zut.cs.zutnlp.text.keyrecognition.web.spring.controller;

import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Keyrecognition.domain.Keyrecognition;
import edu.zut.cs.zutnlp.text.service.KeyrecognitionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/keyrecogn")
@CrossOrigin
public class KeyrecognitionController extends GenericController<Keyrecognition,Long,KeyrecognitionManager> {

    KeyrecognitionManager keyrecognitionManager;

    @Autowired
    public void setKeyrecognitionManager(KeyrecognitionManager keyrecognitionManager) {
        this.keyrecognitionManager = keyrecognitionManager;
        this.manager = keyrecognitionManager;

    }

    @RequestMapping(value="/getone",method = RequestMethod.GET)
    @ResponseBody
    public List<Keyrecognition> getone(){
        List<Keyrecognition> keyrecognition = this.keyrecognitionManager.findlastid();
        return keyrecognition;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String text(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("initial");
        Integer textId = (Integer) map.get("processed");
        List<String> processedtext = HanLP.extractKeyword(text, 5);
        Keyrecognition keyrecognition=new Keyrecognition();
        keyrecognition.setInitialtext(text);
        keyrecognition.setProcessedtext(processedtext.toString());
        keyrecognitionManager.save(keyrecognition);
        System.out.println("收到的参数=="+text+textId);
        return "测试开发";
    }

}
