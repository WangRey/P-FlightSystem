package org.sicnusc.team_project.model.VOmodel;

import org.sicnusc.team_project.model.UserInfo;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class UserInfoVO implements Serializable {
    public static enum Sex {
        male,
        female;
    }
    private Integer id;

    private String email;

    private String nickName ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    private String phone;

    private String realName ;

//    private String password;

    private UserInfo.Sex sex;

    private String idCard;

    private String postNumber;

    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserInfo.Sex getSex() {
        return sex;
    }

    public void setSex(UserInfo.Sex sex) {
        this.sex = sex;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
