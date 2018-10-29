package edu.zut.cs.zutnlp.text.classify.web.spring.controller;

import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Recognition.domain.Classify;
import edu.zut.cs.zutnlp.text.service.ClassifyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/classify")
@CrossOrigin
public class ClassifyController extends
        GenericController<Classify,Long,ClassifyManager> {

    ClassifyManager classifyManager;

    @Autowired
    public void setClassifyManager(ClassifyManager classifyManager) {
        this.classifyManager = classifyManager;
        this.manager=this.classifyManager;
    }

    @RequestMapping(value="/getone",method = RequestMethod.GET)
    @ResponseBody
    public List<Classify> getone(){
        List<Classify> classifyList = this.classifyManager.findlastid();
        return classifyList;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String gettext(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("text");
        Classify classify=new Classify(text);
        //System.out.println(classify.toString());
        classifyManager.save(classify);
        /*Classify c=new Classify();
        c.setText(text);
        c.setCategory1("体育");
        c.setNo1(0.5);
        c.setCategory2("体育");
        c.setNo2(0.5);
        c.setCategory3("体育");
        c.setNo3(0.5);
        c.setCategory4("体育");
        c.setNo4(0.5);
        classifyManager.save(c);*/
        System.out.println("收到的参数=="+text);
        return "文本分类";
    }
}
