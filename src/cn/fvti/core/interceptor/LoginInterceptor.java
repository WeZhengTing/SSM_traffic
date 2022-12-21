package cn.fvti.core.interceptor;

import cn.fvti.core.pojo.Customer;
import cn.fvti.core.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI();
        if (url.indexOf("/toAdministrator")>=0){
            return true;
        }
        if (url.indexOf("/volation/user_list")>=0){
            return true;
        }
        if (url.indexOf("/login.action")>=0){
            return true;
        }
        if (url.indexOf("/Customer_login")>=0){
            return true;
        }
        if (url.indexOf("/login_null")>=0){
            return true;
        }
        if (url.indexOf("/customer/User_sign")>=0){
            return true;
        }
        if (url.indexOf("/toUser_VIP")>=0){
            return true;
        }
        if (url.indexOf("/Administrator/sign")>=0){
            return true;
        }
        HttpSession session=request.getSession();

        String name=(String) session.getAttribute("customer_names");
        if (name!=null){
            return true;
        }

        User user= (User) session.getAttribute("USER_SESSION");
        if (user!=null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
