package com.dong.web.action;

import lombok.Getter;
import lombok.Setter;

/**
 * 导航Action（控制页面调转）
 *
 * @author liudong 2024-05-17 09:52:05
 */
@Getter
@Setter
public class NavigationAction {

    /**
     * 业务模块
     */
    private String module;

    /**
     * 页面类型 list、detail
     */
    private String type;

    /**
     * 页面名称
     */
    private String page;

    public String execute() {
        // 这里的page字段对应你想要转向的JSP页面的名称
        page = module + type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
        return "success";
    }

}
