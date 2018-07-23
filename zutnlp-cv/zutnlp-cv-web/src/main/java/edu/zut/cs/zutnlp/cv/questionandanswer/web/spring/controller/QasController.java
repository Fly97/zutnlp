package edu.zut.cs.zutnlp.cv.questionandanswer.web.spring.controller;


import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.manager.QasManager;
import edu.zut.cs.zutnlp.cv.questionandanswer.domain.Qas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/qas")
public class QasController extends GenericController<Qas, Long, QasManager> {


    private QasManager qasManager;

    @Autowired
    public void setQasManager(QasManager qasManager){
        this.qasManager = qasManager;
        this.manager = this.qasManager;
    }

    @RequestMapping(name = "index.html")
    public String index(){
        return "qas/index";
    }
}
