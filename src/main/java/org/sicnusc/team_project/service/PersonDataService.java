package org.sicnusc.team_project.service;


import org.sicnusc.team_project.model.InToModel.UserBaseInfo;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;

public interface PersonDataService {
    UserInfoVO getUserInfo(String email);
    UserInfoVO updateBaseUserInfo(UserBaseInfo newUserBaseInfo,String email);
    void updatePasswordGetEmailCode(String email);
    UserInfoVO updateUserPassword(String code,String password,String email);
    UserInfo updateUserEmail(String newEmail,String oldemail);
}
