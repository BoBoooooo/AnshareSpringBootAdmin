package com.anshare.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Unit {
    /**
     * GUID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 机关单位/部门名称
     */
    @Column(name = "UnitName")
    private String unitname;

    /**
     * 上级单位id
     */
    @Column(name = "ParentID")
    private String parentid;


    /**
     * 列表所在顺序
     */
    @Column(name = "Sequence")
    private Integer sequence;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;


    @Column(name = "Timestamp")
    private Date timestamp;



    /**
     * 获取GUID
     *
     * @return ID - GUID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置GUID
     *
     * @param id GUID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取机关单位/部门名称
     *
     * @return UnitName - 机关单位/部门名称
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * 设置机关单位/部门名称
     *
     * @param unitname 机关单位/部门名称
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    /**
     * 获取上级单位id
     *
     * @return ParentID - 上级单位id
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置上级单位id
     *
     * @param parentid 上级单位id
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }


    /**
     * 获取列表所在顺序
     *
     * @return Sequence - 列表所在顺序
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 设置列表所在顺序
     *
     * @param sequence 列表所在顺序
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
     * 获取1:地区 2:单位
     *
     * @return Type - 1:地区 2:单位
     */

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