package com.anshare.project.model.business;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data

public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 录入人员ID
     */
    @Column(name = "HandleStaff")
    private String handlestaff;

    /**
     * 录入人员所在部门ID
     */
    @Column(name = "HandleDept")
    private String handledept;

    /**
     * 干部身份证号
     */
    @Column(name = "IdCard")
    private String idcard;

    /**
     * 干部姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 所在单位
     */
    @Column(name = "WorkUnit")
    private String workunit;

    @Column(name = "UnitId")
    private String unitid;

    /**
     * 职务
     */
    @Column(name = "WorkDuty")
    private String workduty;

    @Column(name = "WorkCharge")
    private String workcharge;

    /**
     * 职级
     */
    @Column(name = "WorkLevel")
    private String worklevel;

    /**
     * 任职时间
     */
    @Column(name = "DutyTime")
    private String dutytime;

    /**
     * 任职级时间
     */
    @Column(name = "LevelTime")
    private String leveltime;

    /**
     * 参加工作时间
     */
    @Column(name = "WorkTime")
    private String worktime;

    /**
     * 性别
     */
    @Column(name = "Gender")
    private String gender;

    /**
     * 民族
     */
    @Column(name = "Nation")
    private String nation;

    /**
     * 籍贯
     */
    @Column(name = "NativePlace")
    private String nativeplace;

    /**
     * 出生年月
     */
    @Column(name = "BirthDate")
    private String birthdate;

    /**
     * 出生地
     */
    @Column(name = "BirthPlace")
    private String birthplace;

    /**
     * 成长地
     */
    @Column(name = "GrowPlace")
    private String growplace;

    /**
     * 入党时间
     */
    @Column(name = "PartyDate")
    private String partydate;

    /**
     * 政治面貌
     */
    @Column(name = "PoliticsStatus")
    private String politicsstatus;

    /**
     * 婚姻状况
     */
    @Column(name = "Marriage")
    private String marriage;

    /**
     * 健康状况
     */
    @Column(name = "Health")
    private String health;

    /**
     * 全日制学历
     */
    @Column(name = "Education")
    private String education;

    /**
     * 全日制毕业院校
     */
    @Column(name = "School")
    private String school;

    /**
     * 全日制专业
     */
    @Column(name = "Major")
    private String major;

    /**
     * 最高学历
     */
    @Column(name = "HighestEducation")
    private String highesteducation;

    /**
     * 家庭住址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 联系电话
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 技能或特长
     */
    @Column(name = "Skill")
    private String skill;

    /**
     * 民主党派
     */
    @Column(name = "Democratic")
    private String democratic;


    @Column(name = "Photo")
    private String photo;



    @Column(name = "Sequence")
    private Integer sequence;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;


}