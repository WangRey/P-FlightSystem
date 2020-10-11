package org.sicnusc.team_project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "userinfo")
public class UserInfo {
    public static enum Sex {
        male,
        female;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(length = 128)
//    private String orderNo;
//
//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }

    @Column(length = 32,nullable = false)
    @NotBlank(message = "邮箱不能为空")
    private String email;


    @Column(length = 32, nullable = false)
    @NotBlank(message = "昵称不能为空")
    private String nickName ;

    @Column(nullable = false)
    @NotNull(message = "电话号码不能为空")
    private String phone;

    @Column(length = 32, nullable = false)
    @NotBlank(message = "姓名不能为空")
    private String realName ;

    @Column(length = 255, nullable = false)
    @NotBlank(message = "密码不能为空")
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex = null;

    @Column(length = 64,nullable = false)
    @NotBlank(message = "身份证号码不能为空")
    private String idCard;

    @Column
    private String postNumber;

    @Column(length = 128)
    private String address;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length = 32)
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    @Temporal(TemporalType.DATE)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
