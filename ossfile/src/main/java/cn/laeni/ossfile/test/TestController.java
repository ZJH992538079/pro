package cn.laeni.ossfile.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin // 跨域访问
@Controller
public class TestController {

    @RequestMapping("/showCookies")
    @ResponseBody
    public String cookie(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        return "成功打印到控制台";
    }

    /**
     * 获取SessionId
     * @param request
     * @return
     */
    @RequestMapping("/getSessionId")
    @ResponseBody
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    /**
     * 设置SessionId值,仅供测试
     * @param request
     * @return
     */
    @RequestMapping("/setSession")
    @ResponseBody
    public String setSession(HttpServletRequest request,String key, String value) {
        if (key == null || value == null) {
            return "请使用'?key=xxx&value=xxx'方式设置Session值";
        }
        request.getSession().setAttribute(key, value);
        return "【设置成功】=> " + key + ":" + value;
    }

    /**
     * 获取SessionId值,仅供测试
     * @param request
     * @return
     */
    @RequestMapping("/getSession")
    @ResponseBody
    public String getSession(HttpServletRequest request,String key) {
        if (key == null) {
            return "请使用'?key=xxx'方式设置需要或者的Sessionkey";
        }
        return "【获取成功】=> " + key + ":" + request.getSession().getAttribute(key);
    }

}
