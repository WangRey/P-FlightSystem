package org.sicnusc.team_project.service;

import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;


public interface RegisterService {
    UserInfoVO registerUserService(UserInfo u);
    void verifyEmailCode(String email,String code);
    void checkEamilRepeat(String email);
    void checkBaseInfoFormat(UserInfo u);
    void checkEmailFormat(String email);
    void retrievePasswordGetEmailCode(String email);
    void retrievePassworde(String email,String password,String code);
}
