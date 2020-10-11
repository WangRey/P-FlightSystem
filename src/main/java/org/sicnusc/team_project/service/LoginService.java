package org.sicnusc.team_project.service;

import org.sicnusc.team_project.model.VOmodel.UserInfoVO;

public interface LoginService {
    UserInfoVO checkLogin(String email,String password);
}
