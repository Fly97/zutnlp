package edu.zut.cs.zutnlp.cv.region.web.spring.controller;


import edu.zut.cs.zutnlp.base.controller.GenericController;
import edu.zut.cs.zutnlp.cv.manager.RegionManager;
import edu.zut.cs.zutnlp.cv.region.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/region")
public class RegionController extends GenericController<Region,Long,RegionManager> {

    RegionManager regionManager;

    @Autowired
    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
        this.manager=this.regionManager;
    }
}
