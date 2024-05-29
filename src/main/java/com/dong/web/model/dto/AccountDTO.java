package com.dong.web.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LD
 */
@Data
public class AccountDTO {

    private String id;
    private String username;
    private String password;
    private Integer userType;// 用户类型 2：普通用户，默认为普通用户
    private String captcha;// 验证码
    private String realName;// 真实姓名
    private String identityCard;// 身份证号

    /**
     * 用户状态
     */
    private Integer userStatus;
}

