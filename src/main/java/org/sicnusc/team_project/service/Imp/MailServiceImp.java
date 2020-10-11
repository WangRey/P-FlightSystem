package org.sicnusc.team_project.service.Imp;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.Utils.VerCodeGenerateUtil;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MailServiceImp implements MailService {

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Resource
    private  JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 发送文本邮件
     */

    @Override
    public void sendSimpleMail(String To) {
        //构造验证码
        String verification = VerCodeGenerateUtil.generateVerCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(To);
        message.setSubject("验证码");
        message.setText("尊敬的用户,您好:\n"
                +"\n 欢迎注册OrgSicnu_AirTicketSystem "
                + "\n本次请求的邮件验证码为:"
                + verification
                + ",本验证码五分钟内有效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请勿回复）");
        try{
            javaMailSender.send(message);
            log.info("发送成功");
        }catch (Exception e) {
            throw new DefException(ExceptionType.SYSTEM_ERROR,"邮件发送失败,可能原因：邮箱格式错误");
        }
        try {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(To, verification);
            redisTemplate.expire(To, 60 * 5, TimeUnit.SECONDS);
        }catch (Exception e) {
            log.info("redis出现问题");
            throw new DefException(ExceptionType.SYSTEM_ERROR,"后台验证码存储出现问题");
        }
    }
    @Override
    public Boolean verification(String email, String unverifiedCode) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //从redis中获取验证码
        String verificationCode = (String)valueOperations.get(email);
        //提交的信息是否正确
        if(verificationCode != null && verificationCode.equals(unverifiedCode)) {
            //删除缓存中的数据
            redisTemplate.delete(email);
            return true;
        }
        return false;
    }
}
