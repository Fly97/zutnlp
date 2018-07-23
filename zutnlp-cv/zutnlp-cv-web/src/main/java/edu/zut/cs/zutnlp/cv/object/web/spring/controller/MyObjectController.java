package edu.zut.cs.zutnlp.cv.object.web.spring.controller;


import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.manager.MyObjectManager;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/object")
public class MyObjectController extends GenericController<MyObject,Long,MyObjectManager> {

    MyObjectManager myObjectManager;

    @Autowired
    public void setMyObjectManager(MyObjectManager myObjectManager) {
        this.myObjectManager = myObjectManager;
        this.manager=this.myObjectManager;
    }

    @RequestMapping(value = "/index.html")
    public String index ()
    {
        return "/object/index";
    }
}
