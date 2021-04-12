package cn.abb.oa.config;

import cn.abb.oa.pojo.Admin;
import cn.abb.oa.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        logger.info(request.getRequestURI());
        User user = (User) session.getAttribute("user");
        Admin admin = (Admin) session.getAttribute("admin");
        if (user == null && admin == null) {
            request.setAttribute("msg", "没有权限请先登录");
            //request.getRequestDispatcher("/").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/account/index");
            return false;
        } else {
            return true;
        }
    }


}
