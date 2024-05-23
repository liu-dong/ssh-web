package com.dong.web.action;

import com.dong.constant.CommonConstant;
import com.dong.web.entity.Account;
import com.dong.web.model.LoginDTO;
import com.dong.web.model.UpdatePasswordDTO;
import com.dong.web.model.UserDetail;
import com.dong.web.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @author liudong 2024-05-14 16:52:28
 */
public class LoginAction extends ActionSupport {

    private LoginDTO loginDTO;
    private UpdatePasswordDTO updatePasswordDTO;

    private LoginService loginService;


    @Override
    public String execute() throws Exception {
        if (StringUtils.isNotBlank(loginDTO.getUsername()) && StringUtils.isNotBlank(loginDTO.getPassword())) {
            System.out.println(loginDTO.getUsername());
        }
        return super.execute();
    }

    public String login() {
        HttpSession httpSession = ServletActionContext.getRequest().getSession();
        if (StringUtils.isBlank(loginDTO.getUsername()) || StringUtils.isBlank(loginDTO.getPassword())) {
            return LOGIN;
        }
        UserDetail userDetail = loginService.login(loginDTO.getUsername(), loginDTO.getPassword());
        if (userDetail == null) {
            return LOGIN;
        }
        httpSession.setAttribute(CommonConstant.SESSION_USER, userDetail);
        return SUCCESS;
    }

    public String logout() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute(CommonConstant.SESSION_USER);
        session.invalidate();
        return SUCCESS;
    }

    public String updatePassword() {
        loginService.updatePassword(updatePasswordDTO);
        return SUCCESS;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public void setUpdatePasswordDTO(UpdatePasswordDTO updatePasswordDTO) {
        this.updatePasswordDTO = updatePasswordDTO;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
