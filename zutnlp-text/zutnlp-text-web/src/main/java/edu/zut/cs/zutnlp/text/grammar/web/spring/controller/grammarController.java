package edu.zut.cs.zutnlp.text.grammar.web.spring.controller;


import com.hankcs.hanlp.HanLP;
import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.grammar.domain.grarecognition;
import edu.zut.cs.zutnlp.text.service.GrammarManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/grammar")
@CrossOrigin
public class grammarController  extends GenericController<grarecognition,Long,GrammarManager> {
    GrammarManager grammarManager;
    @Autowired
    public void setGrammarManager(GrammarManager grammarManager) {
        this.grammarManager = grammarManager;
        this.manager = this.grammarManager;
    }

    @RequestMapping(value="/getone",method = RequestMethod.GET)//RequestMapping请求value和method的属性
    @ResponseBody
    public List<grarecognition> getone(){
        List<grarecognition> gra = this.grammarManager.findlastid();
        return gra;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String text(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("text");
        grarecognition g=new grarecognition(text);
        grammarManager.save(g);
        System.out.println("收到的参数=="+text);
        return "卢思童";
    }
}
