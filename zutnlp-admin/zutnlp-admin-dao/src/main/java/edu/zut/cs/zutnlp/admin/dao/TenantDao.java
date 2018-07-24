package edu.zut.cs.zutnlp.admin.dao;

import edu.zut.cs.zutnlp.admin.domain.Tenant;
import edu.zut.cs.zutnlp.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantDao extends GenericDao<Tenant,Long> {

}
