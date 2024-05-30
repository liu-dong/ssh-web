package com.dong.web.model.vo;

import lombok.Data;

/**
 * @author LD
 * @date 2020/3/22 22:02
 */
@Data
public class AccountVO {


    private String id;
    private String username;
    private String password;
    private String passwordHash;
    private String phone;
    private String email;
    private Integer userType;// 用户类型 2：普通用户，默认为普通用户
    private Integer userStatus;
    private String realName;// 真实姓名
    private String lastLoginTime;// 上次登录时间

    /**
     * 登录次数
     */
    private Integer loginCount;
}

