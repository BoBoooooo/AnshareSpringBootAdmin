package com.anshare.project.model.system;

import javax.persistence.*;

public class Deptunit {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "DeptID")
    private String deptid;

    @Column(name = "UnitID")
    private String unitid;

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
     * @return DeptID
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * @param deptid
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    /**
     * @return UnitID
     */
    public String getUnitid() {
        return unitid;
    }

    /**
     * @param unitid
     */
    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }
}