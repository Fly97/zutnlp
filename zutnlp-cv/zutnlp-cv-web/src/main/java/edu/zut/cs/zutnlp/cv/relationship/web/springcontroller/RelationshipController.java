package edu.zut.cs.zutnlp.cv.relationship.web.springcontroller;

import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.manager.RelationshipManager;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/relationship")
public class RelationshipController extends GenericController<Relationship,Long,RelationshipManager> {

    @Autowired
    RelationshipManager relationshipManager;



    @RequestMapping(value = "/relationship/{relationship_id}")
    public Relationship  getByRelationshipId(@PathVariable Long relationship_id) {
        Relationship relationship =  relationshipManager.findByRelationshipId(relationship_id);
        return relationship;
    }

    //通过/image/image_id.json的请求方式返回image_id的所有question and answer
    @RequestMapping(value = "/image/{image_id}")
    public List<Relationship> getList(@PathVariable Long image_id) {
        List<Relationship> relationshipList = new ArrayList<Relationship>();
        relationshipList= relationshipManager.findByImageId(image_id);
        return relationshipList;
    }
}
