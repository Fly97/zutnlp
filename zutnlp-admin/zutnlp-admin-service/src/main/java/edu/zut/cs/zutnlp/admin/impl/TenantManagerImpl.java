package edu.zut.cs.zutnlp.admin.impl;

import edu.zut.cs.zutnlp.admin.dao.TenantDao;
import edu.zut.cs.zutnlp.admin.domain.Tenant;
import edu.zut.cs.zutnlp.admin.manager.TenantManager;
import edu.zut.cs.zutnlp.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantManagerImpl extends GenericManagerImpl<Tenant,Long> implements TenantManager{

    private TenantDao tenantDao;
    @Autowired
    public void setTenantDao(TenantDao tenantDao){
        this.tenantDao=tenantDao;
        this.dao=this.tenantDao;
    }
    public List<Tenant> findById(){
        return (List<Tenant>) this.tenantDao.findAll();
    }


}
