package edu.zut.cs.zutnlp.text.url.web.spring.controller;

import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Url.domain.UrlRecogntion;
import edu.zut.cs.zutnlp.text.service.UrlManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/url")
@CrossOrigin
public class UrlRecognititionController extends GenericController<UrlRecogntion,Long,UrlManager> {

    UrlManager urlManager;

    @Autowired
    public void setUrlManager(UrlManager urlManager) {
        this.urlManager = urlManager;
        this.manager=this.urlManager;
    }

    @GetMapping(value = "/getone")
    @ResponseBody
    public List<UrlRecogntion> getone(){
        List<UrlRecogntion> urlRecogntions=this.urlManager.findLastId();
        return urlRecogntions;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  String gettext(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("text");
        UrlRecogntion ur=new UrlRecogntion(text);   //生成对象py
        urlManager.save(ur);                //保存到数据库
        System.out.println("收到的参数=="+text);   //测试
        return "success";
    }
}
