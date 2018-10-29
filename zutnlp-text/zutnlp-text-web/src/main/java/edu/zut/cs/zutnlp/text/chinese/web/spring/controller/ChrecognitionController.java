package edu.zut.cs.zutnlp.text.chinese.web.spring.controller;

import com.spring4all.swagger.EnableSwagger2Doc;
import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.text.Chinese.domain.Chrecognition;
import edu.zut.cs.zutnlp.text.service.ChineseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/chinese")
@CrossOrigin
public class ChrecognitionController extends
        GenericController<Chrecognition,Long,ChineseManager>{

    ChineseManager chineseManager;

    @Autowired
    public void setChineseManager(ChineseManager chineseManager){
        this.chineseManager=chineseManager;
        this.manager=this.chineseManager;
    }

    @RequestMapping(value="/getone",method = RequestMethod.GET)
    @ResponseBody
    public List<Chrecognition> getone(){
        List<Chrecognition> chrecognition = this.chineseManager.findlastid();
        return chrecognition;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String gettext(@RequestBody Map<String, Object> map) {
        String text=(String) map.get("text");
        Integer textId = (Integer) map.get("textid");
        Chrecognition chrecognition=new Chrecognition(text);
        chineseManager.save(chrecognition);
        System.out.println("收到的参数=="+text+textId);
        return "success";
    }
}
