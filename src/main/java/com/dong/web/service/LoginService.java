package com.dong.web.service;

import com.dong.web.model.LoginDTO;
import com.dong.web.model.UpdatePasswordDTO;
import com.dong.web.model.UserDetail;

/**
 * @author liudong 2024-05-20 09:57:11
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    UserDetail login(String username, String password);

    /**
     * 修改密码
     * @param dto
     */
    void updatePassword(UpdatePasswordDTO dto);
}
