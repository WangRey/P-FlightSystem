//package org.sicnusc.team_project.service.Imp;
//
//import org.dozer.DozerBeanMapperBuilder;
//import org.dozer.Mapper;
//import org.sicnusc.team_project.dao.UserRepository;
//import org.sicnusc.team_project.model.UserInfo;
//import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
//import org.sicnusc.team_project.service.PersonDateService;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
//public class test {
//    package org.sicnusc.team_project.service.Imp;
//
//import org.dozer.DozerBeanMapperBuilder;
//import org.dozer.Mapper;
//import org.sicnusc.team_project.dao.UserRepository;
//import org.sicnusc.team_project.model.UserInfo;
//import org.sicnusc.team_project.model.VOmodel.UserInfoVO;
//import org.sicnusc.team_project.service.PersonDateService;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
//
//    @Service
//    @CacheConfig(cacheNames = "hot",cacheManager = "redisCacheManager")
//    public class PersonDateServiceImp implements PersonDateService {
//        @Resource
//        UserRepository userRepository;
//        @Cacheable(value = {"New"} ,key = "'new'")
//        public UserInfoVO getPersonalDate(String email){
//            UserInfo user = userRepository.findUserByEmail(email);
//            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//            UserInfoVO userInfoVO = mapper.map(user, UserInfoVO.class);
//            return userInfoVO;
//        }
//    }
//
//}
