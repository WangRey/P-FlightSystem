package org.sicnusc.team_project.dao;

import org.sicnusc.team_project.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    @Query("from UserInfo u where u.email = ?1")
    UserInfo findUserByEmail(String email);

//    @Query("from UserInfo u where u.phone = ?1")
//    UserInfo findUserByPhone(String phone);


}
