package DaoTest;

import edu.zut.cs.zutnlp.admin.dao.TenantDao;
import edu.zut.cs.zutnlp.admin.domain.Tenant;
import edu.zut.cs.zutnlp.base.config.JpaConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaConfiguration.class)
public class TenantDaoTest {

    @Autowired
    private TenantDao tenantDao;
    @Test
    public void Test(){
        tenantDao.save(new Tenant((long)1,"asd","asd"));
        tenantDao.save(new Tenant((long)2,"asd","asd"));
        Assert.assertEquals("asd",tenantDao.findById((long)1));
        Assert.assertEquals(2,tenantDao.findAll().size());

    }
}
