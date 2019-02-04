package com.anshare.project.model.business;

import javax.persistence.*;
import java.util.Date;

@Table(name = "SIX_Salary")
public class SixSalary {
    @Id

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "StaffID")
    private String staffid;

    @Column(name = "Salary")
    private String salary;

    @Column(name = "OvertimePay")
    private String overtimepay;

    @Column(name = "Pension")
    private String pension;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "Date")
    private String date;

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
     * @return StaffID
     */
    public String getStaffid() {
        return staffid;
    }

    /**
     * @param staffid
     */
    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    /**
     * @return Salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return OvertimePay
     */
    public String getOvertimepay() {
        return overtimepay;
    }

    /**
     * @param overtimepay
     */
    public void setOvertimepay(String overtimepay) {
        this.overtimepay = overtimepay;
    }

    /**
     * @return Pension
     */
    public String getPension() {
        return pension;
    }

    /**
     * @param pension
     */
    public void setPension(String pension) {
        this.pension = pension;
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

    /**
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
}