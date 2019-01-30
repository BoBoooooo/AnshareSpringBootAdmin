package com.anshare.project.model.system;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data

public class Dict {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "DictID")
    private String dictid;

    @Column(name = "Title")
    private String title;

    @Column(name = "Code")
    private String code;

    @Column(name = "Sort")
    private Integer sort;

    @Column(name = "IsDeleted")
    private Boolean isdeleted;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "Value")
    private String value;

    @Column(name = "Note")
    private String note;

    @Column(name = "Other")
    private String other;


}