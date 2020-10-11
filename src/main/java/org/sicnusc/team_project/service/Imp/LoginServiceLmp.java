package org.sicnusc.team_project.service.Imp;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.dao.UserRepository;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceLmp implements LoginService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserInfoVO checkLogin(String email,String password) {
        UserInfo User = userRepository.findUserByEmail(email);
        if(User==null)
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"邮箱还未注册");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserInfoVO userInfoVO = mapper.map(User, UserInfoVO.class);
//        if(BCrypt.checkpw(User.getPassword(),password))
        if(User.getPassword().equals(password))
            return userInfoVO;
        else
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"密码错误");
    }
}
