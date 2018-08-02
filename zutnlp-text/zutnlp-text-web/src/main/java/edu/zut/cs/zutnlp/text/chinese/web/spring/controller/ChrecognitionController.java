package edu.zut.cs.zutnlp.text.chinese.web.spring.controller;

import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import edu.zut.cs.zutnlp.text.service.ChineseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/hanlp")
public class ChrecognitionController extends GenericController<Chrecognition,Long,ChineseManager>{

    ChineseManager chineseManager;

    @RequestMapping(value = "/receive")
    public String receive(){
        return "hanlp/receive";
    }

    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    public String receive(String text){
        System.out.println("原文："+text);
        return "hanlp/receive";
    }

    @Autowired
    public void setChineseManager(ChineseManager chineseManager){
        this.chineseManager=chineseManager;
        this.manager=this.chineseManager;
    }

    @RequestMapping("/main")
    public String index()
    {
        return "main";
    }

    @GetMapping("/named")
    public String named()
    {
        return "named";
    }

    @GetMapping("/chinese")
    public String chinese()
    {
        return "chinese";
    }


    @RequestMapping(value = "/fenci", method = RequestMethod.GET)
    public String fenci(ModelMap modelMap) {
        modelMap.put("msg", "分词");
        return "fenci";
    }

    @RequestMapping(value="/list",method = RequestMethod.POST)
    @ResponseBody
    public List<Chrecognition> list(){
        List<Chrecognition> chrecognitionList = this.chineseManager.findAllChinese();
        return chrecognitionList;
    }

    @RequestMapping(value="/getone",method = RequestMethod.GET)
    @ResponseBody
    public Chrecognition getone(){
        Chrecognition chrecognition = this.chineseManager.findlastid();
        return chrecognition;
    }



}
