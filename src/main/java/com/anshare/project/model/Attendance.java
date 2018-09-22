package com.anshare.project.model;

import java.util.Date;
import javax.persistence.*;

public class Attendance {
    /**
     * 数据资源ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 数据类别ID
     */
    @Column(name = "PersonId")
    private String personid;

    /**
     * 上班时间
     */
    @Column(name = "StartTime")
    private String starttime;

    /**
     * 下班时间
     */
    @Column(name = "EndTime")
    private String endtime;

    /**
     * 时间
     */
    @Column(name = "Date")
    private String date;

    /**
     * 是否请假   (1 请假  0 正常)
     */
    @Column(name = "Vacation")
    private Integer vacation;

    /**
     * 请假事由
     */
    @Column(name = "Vacation_Reason")
    private String vacationReason;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "TimeStamp")
    private Date timestamp;

    /**
     * 获取数据资源ID
     *
     * @return ID - 数据资源ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置数据资源ID
     *
     * @param id 数据资源ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取数据类别ID
     *
     * @return PersonId - 数据类别ID
     */
    public String getPersonid() {
        return personid;
    }

    /**
     * 设置数据类别ID
     *
     * @param personid 数据类别ID
     */
    public void setPersonid(String personid) {
        this.personid = personid;
    }

    /**
     * 获取上班时间
     *
     * @return StartTime - 上班时间
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置上班时间
     *
     * @param starttime 上班时间
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取下班时间
     *
     * @return EndTime - 下班时间
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * 设置下班时间
     *
     * @param endtime 下班时间
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取时间
     *
     * @return Date - 时间
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置时间
     *
     * @param date 时间
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取是否请假   (1 请假  0 正常)
     *
     * @return Vacation - 是否请假   (1 请假  0 正常)
     */
    public Integer getVacation() {
        return vacation;
    }

    /**
     * 设置是否请假   (1 请假  0 正常)
     *
     * @param vacation 是否请假   (1 请假  0 正常)
     */
    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    /**
     * 获取请假事由
     *
     * @return Vacation_Reason - 请假事由
     */
    public String getVacationReason() {
        return vacationReason;
    }

    /**
     * 设置请假事由
     *
     * @param vacationReason 请假事由
     */
    public void setVacationReason(String vacationReason) {
        this.vacationReason = vacationReason;
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
     * @return TimeStamp
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