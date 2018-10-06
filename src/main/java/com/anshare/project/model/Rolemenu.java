package com.anshare.project.model;

import java.util.Date;
import javax.persistence.*;

public class Rolemenu {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "RoleID")
    private String roleid;

    @Column(name = "MenuID")
    private String menuid;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return RoleID
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * @return MenuID
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * @param menuid
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    /**
     * @return IsDeleted
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * @param isdeleted
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * @return Timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}