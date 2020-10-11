package org.sicnusc.team_project.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;

//继承吗？
@Configuration
public class CacheConfig  {

    @Resource
    private RedisConnectionFactory factory;
    @Resource
    StringRedisSerializer stringRedisSerializer;
    @Resource
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer;

    //    redis和springCache整合的缓存管理器
    @Bean(name = "redisCacheManager")
    public CacheManager cacheManager(){
        //生成一个默认的配置，通过config对象既可对缓存进行自定义配置
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        //对key的序列化采用RedisString
        config = config
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                //对value的序列化采用RedisString
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                //设置缓存的默认过期时间
                .entryTtl(Duration.ofMinutes(30L));
                //不缓存空置
                //.disableCachingNullValues();
        //使用自定义的的缓存配置初试化一个cacheManager
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory ).cacheDefaults(config).build();
        return cacheManager;
    }

}
