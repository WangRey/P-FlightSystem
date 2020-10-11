package org.sicnusc.team_project.controller;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.config.Response_config.AjaxResponse;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.MailService;
import org.sicnusc.team_project.service.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    RegisterService registerService;
    @Resource
    MailService mailService;

    @PostMapping("/add")
    public AjaxResponse add(@Valid @RequestBody UserInfo user){
        registerService.checkBaseInfoFormat(user);
        registerService.verifyEmailCode(user.getEmail(),user.getCode());
        UserInfoVO userInfoVO = registerService.registerUserService(user);
        return AjaxResponse.success(userInfoVO);
    }
    @PostMapping("/getEmailCode")
    public AjaxResponse getEmailCode(@RequestBody Map<String,String> message){
        registerService.checkEmailFormat(message.get("email"));
        registerService.checkEamilRepeat(message.get("email"));
        mailService.sendSimpleMail(message.get("email"));
        return AjaxResponse.success();
    }

    @PostMapping("/retrievePassword")
    public AjaxResponse retrievePassworde(@RequestBody Map<String,String> message){
        String email = message.get("email");
        String password = message.get("password");
        String code = message.get("code");
        registerService.retrievePassworde(email,password,code);
        return AjaxResponse.success();
    }
    @PostMapping("/retrievePasswordGetEmailCode")
    public AjaxResponse retrievePasswordGetEmailCode(@RequestBody Map<String,String> message){
        String email = message.get("email");
        registerService.checkEmailFormat(email);
        registerService.retrievePasswordGetEmailCode(email);
        return AjaxResponse.success();
    }
}
