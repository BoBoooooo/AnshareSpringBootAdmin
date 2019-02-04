package com.anshare.project.model.business;

import javax.persistence.*;
import java.util.Date;

@Table(name = "SIX_RewardOrPunish")
public class SixRewardorpunish {
    @Id

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "StaffID")
    private String staffid;

    @Column(name = "Date")
    private String date;

    @Column(name = "RewardOrPunish")
    private String rewardorpunish;

    @Column(name = "Money")
    private Integer money;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "Type")
    private String type;

    @Column(name = "Content")
    private String content;

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

    /**
     * @return RewardOrPunish
     */
    public String getRewardorpunish() {
        return rewardorpunish;
    }

    /**
     * @param rewardorpunish
     */
    public void setRewardorpunish(String rewardorpunish) {
        this.rewardorpunish = rewardorpunish;
    }

    /**
     * @return Money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Integer money) {
        this.money = money;
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
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}