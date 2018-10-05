package com.anshare.project.model;

import java.util.Date;
import javax.persistence.*;

public class Affix {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 资源ID
     */
    @Column(name = "MasterID")
    private String masterid;

    @Column(name = "Type")
    private String type;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "FileName")
    private String filename;

    @Column(name = "SaveName")
    private String savename;

    @Column(name = "FileExtension")
    private String fileextension;

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
     * 获取资源ID
     *
     * @return MasterID - 资源ID
     */
    public String getMasterid() {
        return masterid;
    }

    /**
     * 设置资源ID
     *
     * @param masterid 资源ID
     */
    public void setMasterid(String masterid) {
        this.masterid = masterid;
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
     * @return FileName
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return SaveName
     */
    public String getSavename() {
        return savename;
    }

    /**
     * @param savename
     */
    public void setSavename(String savename) {
        this.savename = savename;
    }

    /**
     * @return FileExtension
     */
    public String getFileextension() {
        return fileextension;
    }

    /**
     * @param fileextension
     */
    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }
}