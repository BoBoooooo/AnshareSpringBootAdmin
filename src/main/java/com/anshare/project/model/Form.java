package com.anshare.project.model;

import javax.persistence.*;
import java.util.Date;

public class Form {
    @Id

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Table_Name")
    private String tableName;

    @Column(name = "Form_Json")
    private String formJson;
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
     * @return Table_Name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return Form_Json
     */
    public String getFormJson() {
        return formJson;
    }

    /**
     * @param formJson
     */
    public void setFormJson(String formJson) {
        this.formJson = formJson;
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