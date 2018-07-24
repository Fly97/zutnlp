package edu.zut.cs.zutnlp.admin.controller;

import edu.zut.cs.zutnlp.admin.domain.Tenant;
import edu.zut.cs.zutnlp.admin.manager.TenantManager;
import edu.zut.cs.zutnlp.base.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tenant")
public class TenantController extends GenericController<Tenant,Long,TenantManager> {
    TenantManager tenantManager;
    @Autowired
    public void setTenantManager(TenantManager tenantManager){
        this.tenantManager=tenantManager;
        this.manager=this.tenantManager;

    }
}
