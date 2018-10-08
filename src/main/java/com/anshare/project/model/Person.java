package com.anshare.project.model;

import java.util.Date;
import javax.persistence.*;

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

    @Column(name = "Score")
    private Integer score;

    @Column(name = "Score2")
    private Integer score2;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "Punish")
    private String punish;

    @Column(name = "PunishTime")
    private String punishtime;

    @Column(name = "Sequence")
    private Integer sequence;

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
     * 获取录入人员ID
     *
     * @return HandleStaff - 录入人员ID
     */
    public String getHandlestaff() {
        return handlestaff;
    }

    /**
     * 设置录入人员ID
     *
     * @param handlestaff 录入人员ID
     */
    public void setHandlestaff(String handlestaff) {
        this.handlestaff = handlestaff;
    }

    /**
     * 获取录入人员所在部门ID
     *
     * @return HandleDept - 录入人员所在部门ID
     */
    public String getHandledept() {
        return handledept;
    }

    /**
     * 设置录入人员所在部门ID
     *
     * @param handledept 录入人员所在部门ID
     */
    public void setHandledept(String handledept) {
        this.handledept = handledept;
    }

    /**
     * 获取干部身份证号
     *
     * @return IdCard - 干部身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置干部身份证号
     *
     * @param idcard 干部身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取干部姓名
     *
     * @return Name - 干部姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置干部姓名
     *
     * @param name 干部姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所在单位
     *
     * @return WorkUnit - 所在单位
     */
    public String getWorkunit() {
        return workunit;
    }

    /**
     * 设置所在单位
     *
     * @param workunit 所在单位
     */
    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    /**
     * @return UnitId
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

    /**
     * 获取职务
     *
     * @return WorkDuty - 职务
     */
    public String getWorkduty() {
        return workduty;
    }

    /**
     * 设置职务
     *
     * @param workduty 职务
     */
    public void setWorkduty(String workduty) {
        this.workduty = workduty;
    }

    /**
     * @return WorkCharge
     */
    public String getWorkcharge() {
        return workcharge;
    }

    /**
     * @param workcharge
     */
    public void setWorkcharge(String workcharge) {
        this.workcharge = workcharge;
    }

    /**
     * 获取职级
     *
     * @return WorkLevel - 职级
     */
    public String getWorklevel() {
        return worklevel;
    }

    /**
     * 设置职级
     *
     * @param worklevel 职级
     */
    public void setWorklevel(String worklevel) {
        this.worklevel = worklevel;
    }

    /**
     * 获取任职时间
     *
     * @return DutyTime - 任职时间
     */
    public String getDutytime() {
        return dutytime;
    }

    /**
     * 设置任职时间
     *
     * @param dutytime 任职时间
     */
    public void setDutytime(String dutytime) {
        this.dutytime = dutytime;
    }

    /**
     * 获取任职级时间
     *
     * @return LevelTime - 任职级时间
     */
    public String getLeveltime() {
        return leveltime;
    }

    /**
     * 设置任职级时间
     *
     * @param leveltime 任职级时间
     */
    public void setLeveltime(String leveltime) {
        this.leveltime = leveltime;
    }

    /**
     * 获取参加工作时间
     *
     * @return WorkTime - 参加工作时间
     */
    public String getWorktime() {
        return worktime;
    }

    /**
     * 设置参加工作时间
     *
     * @param worktime 参加工作时间
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
     * 获取民族
     *
     * @return Nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取籍贯
     *
     * @return NativePlace - 籍贯
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * 设置籍贯
     *
     * @param nativeplace 籍贯
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**
     * 获取出生年月
     *
     * @return BirthDate - 出生年月
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * 设置出生年月
     *
     * @param birthdate 出生年月
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获取出生地
     *
     * @return BirthPlace - 出生地
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * 设置出生地
     *
     * @param birthplace 出生地
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * 获取成长地
     *
     * @return GrowPlace - 成长地
     */
    public String getGrowplace() {
        return growplace;
    }

    /**
     * 设置成长地
     *
     * @param growplace 成长地
     */
    public void setGrowplace(String growplace) {
        this.growplace = growplace;
    }

    /**
     * 获取入党时间
     *
     * @return PartyDate - 入党时间
     */
    public String getPartydate() {
        return partydate;
    }

    /**
     * 设置入党时间
     *
     * @param partydate 入党时间
     */
    public void setPartydate(String partydate) {
        this.partydate = partydate;
    }

    /**
     * 获取政治面貌
     *
     * @return PoliticsStatus - 政治面貌
     */
    public String getPoliticsstatus() {
        return politicsstatus;
    }

    /**
     * 设置政治面貌
     *
     * @param politicsstatus 政治面貌
     */
    public void setPoliticsstatus(String politicsstatus) {
        this.politicsstatus = politicsstatus;
    }

    /**
     * 获取婚姻状况
     *
     * @return Marriage - 婚姻状况
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * 设置婚姻状况
     *
     * @param marriage 婚姻状况
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    /**
     * 获取健康状况
     *
     * @return Health - 健康状况
     */
    public String getHealth() {
        return health;
    }

    /**
     * 设置健康状况
     *
     * @param health 健康状况
     */
    public void setHealth(String health) {
        this.health = health;
    }

    /**
     * 获取全日制学历
     *
     * @return Education - 全日制学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置全日制学历
     *
     * @param education 全日制学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取全日制毕业院校
     *
     * @return School - 全日制毕业院校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置全日制毕业院校
     *
     * @param school 全日制毕业院校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取全日制专业
     *
     * @return Major - 全日制专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置全日制专业
     *
     * @param major 全日制专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取最高学历
     *
     * @return HighestEducation - 最高学历
     */
    public String getHighesteducation() {
        return highesteducation;
    }

    /**
     * 设置最高学历
     *
     * @param highesteducation 最高学历
     */
    public void setHighesteducation(String highesteducation) {
        this.highesteducation = highesteducation;
    }

    /**
     * 获取家庭住址
     *
     * @return Address - 家庭住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置家庭住址
     *
     * @param address 家庭住址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取联系电话
     *
     * @return Phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取技能或特长
     *
     * @return Skill - 技能或特长
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置技能或特长
     *
     * @param skill 技能或特长
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * 获取民主党派
     *
     * @return Democratic - 民主党派
     */
    public String getDemocratic() {
        return democratic;
    }

    /**
     * 设置民主党派
     *
     * @param democratic 民主党派
     */
    public void setDemocratic(String democratic) {
        this.democratic = democratic;
    }

    /**
     * @return Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return Score2
     */
    public Integer getScore2() {
        return score2;
    }

    /**
     * @param score2
     */
    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    /**
     * @return Photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return Punish
     */
    public String getPunish() {
        return punish;
    }

    /**
     * @param punish
     */
    public void setPunish(String punish) {
        this.punish = punish;
    }

    /**
     * @return PunishTime
     */
    public String getPunishtime() {
        return punishtime;
    }

    /**
     * @param punishtime
     */
    public void setPunishtime(String punishtime) {
        this.punishtime = punishtime;
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