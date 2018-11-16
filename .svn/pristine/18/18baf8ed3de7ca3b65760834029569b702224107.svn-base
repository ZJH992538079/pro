package cn.laeni.ossfile.filter;

import cn.laeni.ossfile.entity.User;
import cn.laeni.ossfile.entity.constant.SessionTypeEnum;
import cn.laeni.ossfile.entity.constant.UserCode;
import cn.laeni.ossfile.entity.other.ApiJson;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 登录认证过滤器
 * @author laeni.cn
 */
@WebFilter(filterName = "authenFilter", urlPatterns = {"/*"})
public class AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");

        HttpSession session = ((HttpServletRequest) request).getSession();

        if (session != null) {
            User user = (User) session.getAttribute(SessionTypeEnum.USER.getKey());
            if (user != null) {
                chain.doFilter(request, response);
                return;
            }
        }

        // 返回为登录的信息
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(new ApiJson(UserCode.LOGIN_INVALID)));

        // --------Test-----------
        System.out.println(session.getId());
    }

    @Override
    public void destroy() {

    }
}
