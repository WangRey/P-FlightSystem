package org.sicnusc.team_project.config.Interceptor_config;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Slf4j
public class Login_Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        log.info("本次请求的方法是:"+request.getMethod());
        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo==null) {
            log.info("被拦截，：session.getId()ID为："+session.getId());
            throw  new DefException(ExceptionType.USER_INPUT_ERROR,"尚未登陆");
        }else {
            log.info(userInfo.toString()+"被放行：SessionID为:"+request.getRequestedSessionId());
            return true;
        }
    }
}
