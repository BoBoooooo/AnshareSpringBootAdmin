package com.anshare.project.model.file;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
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

   
}