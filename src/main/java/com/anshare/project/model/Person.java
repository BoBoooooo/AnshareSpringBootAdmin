package com.anshare.project.model;

import java.util.Date;
import javax.persistence.*;

public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "DeptID")
    private String deptid;

    /**
     * 统一编号 
     */
    @Column(name = "No")
    private Integer no;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 行政职务
     */
    @Column(name = "Workduty")
    private String workduty;

    /**
     * 入职时间
     */
    @Column(name = "WorkTime")
    private String worktime;

    /**
     * 性别
     */
    @Column(name = "Gender")
    private String gender;

    /**
     * 手机号码
     */
    @Column(name = "Phone")
    private String phone;

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
     * 获取统一编号 
     *
     * @return No - 统一编号 
     */
    public Integer getNo() {
        return no;
    }

    /**
     * 设置统一编号 
     *
     * @param no 统一编号 
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * 获取姓名
     *
     * @return Name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取行政职务
     *
     * @return Workduty - 行政职务
     */
    public String getWorkduty() {
        return workduty;
    }

    /**
     * 设置行政职务
     *
     * @param workduty 行政职务
     */
    public void setWorkduty(String workduty) {
        this.workduty = workduty;
    }

    /**
     * 获取入职时间
     *
     * @return WorkTime - 入职时间
     */
    public String getWorktime() {
        return worktime;
    }

    /**
     * 设置入职时间
     *
     * @param worktime 入职时间
     */
    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    /**
     * 获取性别
     *
     * @return Gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取手机号码
     *
     * @return Phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
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