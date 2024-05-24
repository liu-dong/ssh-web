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
    private String userToken;// 用户token
    private Integer userType;// 用户类型 2：普通用户，默认为普通用户
    private String captcha;// 验证码
    private String realName;// 真实姓名
    private String identityCard;// 身份证号
    private List<String> roleIdList;// 角色id
    private String accountId;// 角色id

    /**
     * 用户状态
     */
    private String userStatus;
}

