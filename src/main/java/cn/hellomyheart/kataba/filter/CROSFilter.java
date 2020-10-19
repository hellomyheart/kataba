package cn.hellomyheart.kataba.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description 解决跨域问题
 * @className: CROSFilter
 * @package: cn.hellomyheart.kataba.filter
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:46
 */
@WebFilter("/*")
public class CROSFilter implements Filter {
    /**
     * 过滤
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
