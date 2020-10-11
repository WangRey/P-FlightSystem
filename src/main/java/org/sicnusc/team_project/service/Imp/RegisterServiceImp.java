package org.sicnusc.team_project.service.Imp;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.dao.UserRepository;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.MailService;
import org.sicnusc.team_project.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;


@Service
@Slf4j
public class RegisterServiceImp implements RegisterService {

    @Resource
    private UserRepository userRepository;
    @Resource
    MailService mailService;


    @Override
    public UserInfoVO registerUserService(UserInfo user){

//        try {
//            u.setPassword(BCrypt.hashpw(u.getPassword(),BCrypt.gensalt()));
//            log.info("密码加密成功");
//        }catch (Exception e){
//            log.info("密码加密失败");
//            throw new DefException(ExceptionType.USER_INPUT_ERROR,"数据库密码加密失败，16608043061");
//        }
        userRepository.save(user);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserInfoVO userInfoVO = mapper.map(user, UserInfoVO.class);
        return userInfoVO;
    }

    @Override
    public void verifyEmailCode(String email, String code) {
        Boolean isRight = mailService.verification(email, code);
        if(!isRight){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"验证码错误");
        }
    }

    @Override
    public void checkEamilRepeat(String email) {
        UserInfo User_email = userRepository.findUserByEmail(email);
        if(User_email!=null)
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"邮箱已经被注册");
    }

    @Override
    public void checkBaseInfoFormat(UserInfo user) {
        if(user.getPassword().length()<8)
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"密码长度不够八位");
        if(user.getIdCard().length()!=18)
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"身份证信息有误");
        if(!user.getNickName().matches("[\\w]+"))
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"昵称格式有误");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD");

    }

    @Override
    public void checkEmailFormat(String email) {
        if(!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+"))
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"邮箱格式错误");
    }

    @Override
    public void retrievePasswordGetEmailCode(String email) {
        mailService.sendSimpleMail(email);
    }

    @Override
    public void retrievePassworde(String email, String password, String code) {
        Boolean verification = mailService.verification(email, code);
        if(verification){
            UserInfo userByEmail = userRepository.findUserByEmail(email);
            userByEmail.setPassword(password);
//            try {
//                userByEmail.setPassword(BCrypt.hashpw(userByEmail.getPassword(),BCrypt.gensalt()));
//                log.info("密码加密成功");
//            }catch (Exception e){
//                log.info("密码加密失败");
//                throw new DefException(ExceptionType.USER_INPUT_ERROR,"数据库密码加密失败，16608043061");
//            }
            userRepository.save(userByEmail);
        }else{
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"验证码错误");
        }
    }

}
