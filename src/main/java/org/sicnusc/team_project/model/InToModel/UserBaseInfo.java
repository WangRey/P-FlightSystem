package org.sicnusc.team_project.model.InToModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.sicnusc.team_project.model.UserInfo;

import java.io.Serializable;
import java.util.Date;

public class UserBaseInfo implements Serializable {

    private Integer id;

    private String nickName ;


    private String phone;

//    private String realName;


    private UserInfo.Sex sex;

//    private String idCard;

    private String postNumber;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getIdCard() {
//        return idCard;
//    }
//
//    public void setIdCard(String idCard) {
//        this.idCard = idCard;
//    }

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

//    public String getRealName() {
//        return realName;
//    }
//
//    public void setRealName(String realName) {
//        this.realName = realName;
//    }


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
