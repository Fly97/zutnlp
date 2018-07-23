package edu.zut.cs.zutnlp.cv.description.web.spring.controller;


import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.description.domain.Description;
import edu.zut.cs.zutnlp.cv.manager.DescriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/description")
public class DescriptionController extends GenericController<Description,Long,DescriptionManager> {

    DescriptionManager descriptionmanager;

    @Autowired
    public void setDescriptionmanager(DescriptionManager descriptionmanager) {
        this.descriptionmanager = descriptionmanager;
        this.manager = this.descriptionmanager;
    }
}
