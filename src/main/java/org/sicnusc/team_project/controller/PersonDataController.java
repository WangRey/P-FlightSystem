package org.sicnusc.team_project.controller;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.config.Response_config.AjaxResponse;
import org.sicnusc.team_project.model.InToModel.UserBaseInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.PersonDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/personalData")
public class PersonDataController {
    @Resource
    PersonDataService personDataService;

    @PostMapping("/getPersonalData")
    public AjaxResponse getPersonalData( HttpServletRequest request){
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("userInfo");
        UserInfoVO userInfo = personDataService.getUserInfo(email);
        return AjaxResponse.success(userInfo);
    }

    @PostMapping("/updateBaseUserInfo")
    public AjaxResponse updateBaseUserInfo(@RequestBody UserBaseInfo userBaseInfo, HttpServletRequest request){
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("userInfo");
        UserInfoVO userInfo = personDataService.updateBaseUserInfo(userBaseInfo,email);
        return AjaxResponse.success(userInfo);
    }
    @PostMapping("/updatePasswordGetEmailCode")
    public AjaxResponse updatePasswordGetEmailCode(HttpServletRequest request){
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("userInfo");
        personDataService.updatePasswordGetEmailCode(email);
        return AjaxResponse.success();
    }
    @PostMapping("/updatePassword")
    public AjaxResponse updatePasswordGetEmailCode(@RequestBody Map<String,String> map, HttpServletRequest request){
        HttpSession session = request.getSession();
        String email =(String) session.getAttribute("userInfo");
        personDataService.updateUserPassword(map.get("code"),map.get("password"),email);
        return AjaxResponse.success();
    }

}
