package com.dong.web.action;

/**
 * 导航Action（控制页面调转）
 *
 * @author liudong 2024-05-17 09:52:05
 */
public class NavigationAction {

    private String page;

    public String execute() {
        // 这里的page字段对应你想要转向的JSP页面的名称
        return "success";
    }

    // getter和setter方法
    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return this.page;
    }
}
