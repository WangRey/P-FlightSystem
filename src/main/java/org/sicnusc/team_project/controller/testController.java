package org.sicnusc.team_project.controller;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.config.Response_config.AjaxResponse;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.service.MailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/test")
public class testController {

    @Resource
    MailService mailService;

    @PostMapping("/hello")
    public  AjaxResponse testhello(HttpServletRequest request){
        mailService.sendSimpleMail("9836300415");
        log.info("hello登陆时候，赋值的SessionId:"+request.getRequestedSessionId());
        return AjaxResponse.success("hello");
    }

    @PostMapping("/testEmail")
    public  AjaxResponse testEmail(@RequestBody Map<String,String> message){
        mailService.sendSimpleMail(message.get("email"));
        return AjaxResponse.success();
    }
    @PostMapping("/testVerifyCode")
    public  AjaxResponse testRegister(@RequestBody Map<String,String> message){
        Boolean isRight = mailService.verification(message.get("email"), message.get("code"));
        String result = "false";
        if(isRight){
            result = "ture";
        }
        return AjaxResponse.success(result);
    }
    @PostMapping("/login")
    public  AjaxResponse testlogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo","yes");
        log.info("login时候，request.getRequestedSessionId():"+request.getRequestedSessionId());
        log.info("login时候session.getId():"+session.getId());
        return AjaxResponse.success();
    }
    @PostMapping("/person")
    public  AjaxResponse testperson(HttpServletRequest request){
        log.info("personrequest.getRequestedSessionId():"+request.getRequestedSessionId());
//        return AjaxResponse.success("persondate");
        return AjaxResponse.success(new UserInfo());
    }
    @PostMapping("/loginOut")
    public  AjaxResponse loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
//        session.removeAttribute("userInfo");
        session.invalidate();
        log.info("login时候，request.getRequestedSessionId():"+request.getRequestedSessionId());
        log.info("login时候session.getId():"+session.getId());
        return AjaxResponse.success("loginOut");
    }

}
