package edu.zut.cs.zutnlp.cv.image.web.spring.controller;

import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.attribute.domain.Attribute;
import edu.zut.cs.zutnlp.cv.description.domain.Description;
import edu.zut.cs.zutnlp.cv.image.domain.Image;
import edu.zut.cs.zutnlp.cv.manager.*;
import edu.zut.cs.zutnlp.cv.object.domain.MyObject;
import edu.zut.cs.zutnlp.cv.region.domain.Region;
import edu.zut.cs.zutnlp.cv.relationship.domain.Relationship;
import edu.zut.cs.zutnlp.cv.synset.domain.Synset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/image")
public class ImageController extends GenericController<Image,Long,ImageManager> {

    private ImageManager imageManager;

    private RelationshipManager relationshipManager;

    private RegionManager regionManager;

    private MyObjectManager myObjectManager;

    private QasManager qasManager;

    private AttributeManager attributeManager;

    private SynsetManager synsetManager;

    private DescriptionManager descriptionManager;

    @Autowired
    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    @Autowired
    public void setMyObjectManager(MyObjectManager myObjectManager) {
        this.myObjectManager = myObjectManager;
    }

    @Autowired
    public void setQasManager(QasManager qasManager) {
        this.qasManager = qasManager;
    }

    @Autowired
    public void setAttributeManager(AttributeManager attributeManager) {
        this.attributeManager = attributeManager;
    }

    @Autowired
    public void setSynsetManager(SynsetManager synsetManager) {
        this.synsetManager = synsetManager;
    }

    @Autowired
    public void setDescriptionManager(DescriptionManager descriptionManager) {
        this.descriptionManager = descriptionManager;
    }

    @Autowired
    public void setRelationshipManager(RelationshipManager relationshipManager) {
        this.relationshipManager = relationshipManager;
    }

    @Autowired
    public void setImageManager(ImageManager imageManager) {
        this.imageManager = imageManager;
        this.manager=this.imageManager;
    }

    @RequestMapping(value="/about/{image_id}")
    public List<List> about(@PathVariable Long image_id)
    {
        List<List> result=new ArrayList<List>();

        List<Region> regions=this.regionManager.findByImage_id(image_id);
        result.add(regions);

        List<MyObject> myObjects=this.myObjectManager.findByImage_id(image_id);
        result.add(myObjects);

        List<Attribute> attributes=this.attributeManager.findByImage_id(image_id);
        result.add(attributes);

        List<Relationship> relationships=this.relationshipManager.findByImageId(image_id);
        result.add(relationships);

        List<Description> descriptions=this.descriptionManager.findByImage_id(image_id);
        result.add(descriptions);

        List<Synset> synsets=this.synsetManager.findByImage_id(image_id);
        result.add(synsets);

        return result;
    }
    @RequestMapping(value = "/index.html")
    public String index()
    {
        return "/image/index";
    }
}
