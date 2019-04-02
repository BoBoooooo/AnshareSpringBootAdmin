package com.anshare.project.model.system;

import lombok.Data;

@Data

public class Auth {
    private String realName;
    private String userName;
    private String deptName;
    private String roleName;
    private String deptID;
    private String userID;
    private String roleID;
    private String userDept;   //类似存储 'id1','id2','id3'等形式
    private String userUser;
    private String userFunction;
}
