package edu.zut.cs.zutnlp.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_TENANT")
public class Tenant {
    @Column
    private String tenant_code;
}
