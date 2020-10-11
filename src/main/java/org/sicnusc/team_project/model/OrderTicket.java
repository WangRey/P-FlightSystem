package org.sicnusc.team_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class OrderTicket {
    public static enum FlightClass{
        businessClass,
        firstClass,
        economyClass
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderTicketId;

    public Integer getOrderTicketId() {
        return orderTicketId;
    }

    public void setOrderTicketId(Integer orderTicketId) {
        this.orderTicketId = orderTicketId;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Column(length = 32)
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Column(length = 32,nullable = false)
    private String email;

    @Column(length = 128)
    private String passport;

    @Column(length = 32, nullable = false)
    private String realName ;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @Column(nullable = false)
    private Double price;

    @Column(length = 32,nullable = false)
    private String orderStatus;

    @Column(length = 128,nullable = false)
    private String startCity;
    @Column(length = 128,nullable = false)
    private String endCity;

    @Column(length = 128,nullable = false)
    private String startAirport;
    @Column(length = 128,nullable = false)
    private String endAirport;

    @Column
    @Enumerated(EnumType.STRING)
    private UserInfo.Sex sex = null;

    public UserInfo.Sex getSex() {
        return sex;
    }

    public void setSex(UserInfo.Sex sex) {
        this.sex = sex;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    //name 设计外键字段名称
    //targetEntity 指定参照外表
    //referenced...指定参照外表的主键名称
    // JoinColumn参数都是类的名称，本来就是 也是面向对象的一个思想
//    @JsonIgnore
    @ManyToOne(targetEntity = Flight.class)
    @JoinColumn(name = "flightNo",referencedColumnName = "flightNo")
    private Flight flight;

    @Column(length = 128,nullable = false)
    private String orderNo;

    @Column(nullable = false)
    private Double discount = 1.0;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }




    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "OrderTicket{" +
                "id=" + orderTicketId +
                ", orderNo='" + orderNo + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", flightClass=" + flightClass +
                ", price=" + price +
                ", orderStatus='" + orderStatus + '\'' +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", startAirport='" + startAirport + '\'' +
                ", endAirport='" + endAirport + '\'' +
                ", startTime=" + startTime +
                ", arrivalTime=" + arrivalTime +
                ", flight=" + flight +
                '}';
    }
}
