package com.anshare.project.model;

import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.*;
import java.util.List;

public class Menu {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "ParentID")
    private String parentid;

    @Column(name = "Sequence")
    private Integer sequence;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "Title")
    private String title;

    @Column(name = "Name")
    private String name;

    @Column(name = "Icon")
    private String icon;

    @Column(name = "Path")
    private String path;

    @Column(name = "Redirect")
    private String redirect;

    @Column(name = "Component")
    private String component;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;




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
     * @return ParentID
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * @return Sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    /**
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return Path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return Redirect
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * @param redirect
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * @return Component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component;
    }

    public boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * @param isdeleted
     */
    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

}