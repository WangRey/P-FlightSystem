package org.sicnusc.team_project.config;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.annotation.Resource;

@Slf4j
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30*60*100)
public class SessionConfig {
    /**
     * 设置spring session redis 序列化方式
     * @param factory
     * @return
     */
    @Resource
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer;

    @Bean("springSessionDefaultRedisSerializer")
    public RedisSerializer<Object> defaultRedisSerializer(){
        log.info("自定义Redis Session序列化加载成功");
        return jackson2JsonRedisSerializer;
    }

    /**
     * 实际上提问者浏览器cookie里存的sessionId是经过base64编码过的，而服务器上获取的sessionId是没有编码的。cookie里的解码后与服务器上其实是一致的。这里的关键是spring session 在设置cookie的时候设置的，可以看源码 DefaultCookieSerializer 类里面的writeCookieValue 方法，里面有关键的一段代码
     *
     * Cookie sessionCookie = new Cookie(this.cookieName, this.useBase64Encoding
     *       ? base64Encode(actualCookieValue) : actualCookieValue);
     * 而在类的成员变量里面是直接指定了
     *
     * private boolean useBase64Encoding = true;
     * 解决方案:直接注入这个类去取代就可以了
     * @return
     */
    @Bean
    public DefaultCookieSerializer getDefaultCookieSerializer(){
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setUseBase64Encoding(false);
        return cookieSerializer;
    }
    //redis内session过期时事件监听
    @EventListener
    public void onSessionExpired(SessionExpiredEvent expiredEvent) {
        String sessionId = expiredEvent.getSessionId();

        log.info("session失效事件："+sessionId);
    }

    //redis内session创建事件监听
    @EventListener
    public void onSessionCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();

        log.info("创建session事件："+sessionId);
    }

    //redis内session删除事件监听
    @EventListener
    public void onSessionDeleted (SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();

        log.info("删除session事件："+sessionId);
    }
}
