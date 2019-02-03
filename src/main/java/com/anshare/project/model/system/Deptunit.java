package com.anshare.project.model.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data

public class Deptunit {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "DeptID")
    private String deptid;

    @Column(name = "UnitID")
    private String unitid;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

}