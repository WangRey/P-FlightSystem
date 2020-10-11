package org.sicnusc.team_project.controller;

import lombok.extern.slf4j.Slf4j;

import org.sicnusc.team_project.config.Response_config.AjaxResponse;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.LoginService;
import org.sicnusc.team_project.service.RegisterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    RegisterService registerService;

    @Resource
    LoginService loginService;

    @RequestMapping("/userLogin")
    public AjaxResponse userLogin(@RequestBody Map<String ,String> message, HttpServletRequest request){
        log.info(message.get("email")+" "+message.get("password"));
        registerService.checkEmailFormat(message.get("email"));
        UserInfoVO userInfoVO = loginService.checkLogin(message.get("email"), message.get("password"));
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",message.get("email"));
        return AjaxResponse.success(userInfoVO);
    }
    @RequestMapping("/loginOut")
    public AjaxResponse loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return AjaxResponse.success();
    }
}
