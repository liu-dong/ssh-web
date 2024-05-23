package com.dong.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liudong 2024-05-23 15:23:54
 */
public class ContextPathFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpRequest.setAttribute("_path", httpRequest.getContextPath());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter 初始化逻辑
    }

    @Override
    public void destroy() {
        // Filter 销毁逻辑
    }
}
