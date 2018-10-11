package com.anshare.project.model;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class MenuModel {
    @Id
    @Column(name = "ID")
   // @JSONField(serialize=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

   // @JSONField(serialize=false)
    @Column(name = "ParentID")
    private String parentid;

   // @JSONField(serialize=false)
    @Column(name = "IsDeleted")
    private boolean isdeleted;


   // @JSONField(serialize=false)
    @Column(name = "Sequence")
    private Integer sequence;

  //  @JSONField(serialize=false)
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
    @Resource
    private Meta meta;
    private List<MenuModel> children;

    public MenuModel(String id, String pid, String path, String redirect, String name, String component, String icon, String title, Meta meta) {
        this.id = id;
        this.parentid = pid;
        this.path = path;
        this.redirect = redirect;
        this.name = name;
        this.component = component;
        this.icon = icon;
        this.title = title;
        this.meta = meta;
    }

    public MenuModel() {
    }


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


    public List<MenuModel> getChildren() {
        return children;
    }

    public void setChildren(List<MenuModel> children) {
        this.children = children;
    }


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }


}