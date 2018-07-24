package edu.zut.cs.zutnlp.admin.domain;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_ADMIN_TENANT")
public class Tenant extends BaseEntity{
    @Column(name="TENANT_ID")
    private Long tenant_id;
    @Column(name="TENANT_NAME")
    private String tenant_name;
    @Column(name="DESCRIPTION")
    private String description;

    public Tenant() {
    }

    public Tenant(Long tenant_id, String tenant_name, String description) {
        this.tenant_id = tenant_id;
        this.tenant_name = tenant_name;
        this.description = description;
    }

    public Long getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Long tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
