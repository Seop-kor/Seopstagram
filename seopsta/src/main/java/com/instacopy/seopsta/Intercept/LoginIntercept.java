package com.instacopy.seopsta.Intercept;

import com.instacopy.seopsta.Entity.InstaEntity;
import lombok.extern.java.Log;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log
public class LoginIntercept extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("token") == null){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        InstaEntity instaEntity = (InstaEntity) session.getAttribute("boards");
        modelAndView.setViewName("index");
        modelAndView.addObject("boards",instaEntity.getBoards());
        modelAndView.addObject("usernick",instaEntity.getUsernick());
        modelAndView.addObject("userprofileimg",instaEntity.getUserprofileimg());
    }
}
