package edu.zut.cs.zutnlp.admin.domain;


import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_LOG")
public class Log extends BaseEntity {
    @Column(name = "Emnu")
    private String emnu;

    @Column(name = "Operation")
    private  String operation;

    @Column(name = "Path")
    private String path;

    @Column(name = "Time")
    private String time;

    @Column(name = "UserId")
    private String userid;

    @Column(name = "UerName")
    private String username;

    @Column(name = "IP")
    private String ip;
    public Log(){}

    public String getTime() {
        return time;
    }

    public String getEmnu() {
        return emnu;
    }

    public String getIp() {
        return ip;
    }

    public String getOperation() {
        return operation;
    }

    public String getPath() {
        return path;
    }

    public String getUsername() {
        return username;
    }

    public String getUserid() {
        return userid;
    }

    public void setEmnu(String emnu) {
        this.emnu = emnu;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
