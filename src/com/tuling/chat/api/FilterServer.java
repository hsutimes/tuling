package com.tuling.chat.api;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterServer")
public class FilterServer implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 解决跨域问题
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        // 指定允许其他域名访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST");
        // 响应头设置
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
