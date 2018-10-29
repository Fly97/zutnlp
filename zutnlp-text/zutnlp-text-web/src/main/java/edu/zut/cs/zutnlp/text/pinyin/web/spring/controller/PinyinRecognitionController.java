package edu.zut.cs.zutnlp.text.pinyin.web.spring.controller;


import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Pinyin.domain.PinyinRecognition;
import edu.zut.cs.zutnlp.text.service.PinyinManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/pinyin")
@CrossOrigin
public class PinyinRecognitionController extends GenericController<PinyinRecognition,Long,PinyinManager> {

    PinyinManager pinyinManager;

    @Autowired
    public void setPinyinManager(PinyinManager pinyinManager) {
        this.pinyinManager = pinyinManager;
        this.manager=this.pinyinManager;
    }


    @GetMapping(value = "getone")
    @ResponseBody
    public List<PinyinRecognition> getone(){
        List<PinyinRecognition> pinyinRecognition=this.pinyinManager.findLastId();
        return pinyinRecognition;
    }

    @GetMapping(value = "getall")
    @ResponseBody
    public List<PinyinRecognition> getall(){
        List<PinyinRecognition> pinyinRecognition=this.pinyinManager.findAll();
        return pinyinRecognition;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public  String gettext(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("text");
        PinyinRecognition py=new PinyinRecognition(text);   //生成对象py
        pinyinManager.save(py);                //保存到数据库
        System.out.println("收到的参数=="+text);   //测试
        return "success";
    }
}
