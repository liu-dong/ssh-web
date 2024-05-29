package com.dong.web.model.dto;

import lombok.Data;

/**
 * @author LD
 */
@Data
public class AccountDTO {

    private String id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer userType;// 用户类型 2：普通用户，默认为普通用户
    private Integer userStatus;
    private String realName;// 真实姓名

}

