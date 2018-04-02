package com.lm.filter;
import javax.servlet.*;
import java.io.IOException;

/**
 * 字符过滤器
 * 过滤器是特殊的 servlet:
 * 初始化方法 - doFilter() - 销毁方法
 *
 * @author SONG
 */
public class CharFilter implements Filter {
    private FilterConfig filterConfig; // 过滤器配置对象
    private String encoding; // 字符编码

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        // 通过过滤器配置对象获取指定的字符编码
        this.encoding = this.filterConfig.getInitParameter("encoding");
    }

    /**
     * 过滤处理逻辑
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getCharacterEncoding() == null) {
            // 设置请求对象中的字符编码
            servletRequest.setCharacterEncoding(encoding);
        }

        // 继续执行过滤器后面的操作: servlet | jsp
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}

