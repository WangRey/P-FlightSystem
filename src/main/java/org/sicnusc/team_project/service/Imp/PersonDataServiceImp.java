package org.sicnusc.team_project.service.Imp;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.dao.UserRepository;
import org.sicnusc.team_project.model.InToModel.UserBaseInfo;
import org.sicnusc.team_project.model.UserInfo;
import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
import org.sicnusc.team_project.service.MailService;
import org.sicnusc.team_project.service.PersonDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class PersonDataServiceImp implements PersonDataService {
    @Resource
    UserRepository userRepository;

    @Resource
    MailService mailService;


    @Override
    public UserInfoVO getUserInfo(String email) {
        UserInfo user = userRepository.findUserByEmail(email);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserInfoVO userInfoVO = mapper.map(user, UserInfoVO.class);
        return userInfoVO;
    }

    @Override
    public UserInfoVO updateBaseUserInfo(UserBaseInfo newUserBaseInfo,String email) {
        UserInfo userByEmail = userRepository.findUserByEmail(email);
        userByEmail.setNickName(newUserBaseInfo.getNickName());
        userByEmail.setPhone(newUserBaseInfo.getPhone());
        userByEmail.setSex(newUserBaseInfo.getSex());
//        userByEmail.setRealName(newUserBaseInfo.getRealName());
//        userByEmail.setIdCard(newUserBaseInfo.getIdCard());
        userByEmail.setPostNumber(newUserBaseInfo.getPostNumber());
        userByEmail.setAddress(newUserBaseInfo.getAddress());

        UserInfo save = userRepository.save(userByEmail);

        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserInfoVO userInfoVO = mapper.map(save, UserInfoVO.class);

        return userInfoVO;
    }

    @Override
    public void updatePasswordGetEmailCode(String email) {
        mailService.sendSimpleMail(email);
    }

    @Override
    public UserInfoVO updateUserPassword(String code,String password,String email) {
        log.info(password+"验证码"+code);
        Boolean verification = mailService.verification(email, code);
        if(!verification){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"验证码错误");
        }
        UserInfo userByEmail = userRepository.findUserByEmail(email);
        userByEmail.setPassword(password);
//        try {
//            userByEmail.setPassword(BCrypt.hashpw(userByEmail.getPassword(),BCrypt.gensalt()));
//            log.info("密码加密成功");
//        }catch (Exception e){
//            log.info("密码加密失败");
//            throw new DefException(ExceptionType.USER_INPUT_ERROR,"数据库密码加密失败，16608043061");
//        }
        userRepository.save(userByEmail);

        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserInfoVO userInfoVO = mapper.map(userByEmail, UserInfoVO.class);
        return userInfoVO;
    }

    @Override
    public UserInfo updateUserEmail(String newEmail,String oldemail) {
        return null;
    }

}
