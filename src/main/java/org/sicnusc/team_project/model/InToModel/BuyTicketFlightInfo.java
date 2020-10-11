package org.sicnusc.team_project.model.InToModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.sicnusc.team_project.model.OrderTicket;
import org.sicnusc.team_project.model.UserInfo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.sql.Date;


public class BuyTicketFlightInfo implements Serializable {

    String email;
    String flightNo;
    String realName;
    String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
            Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    Date arrivalTime;
    String startCity;
    String endCity;
    String startAirport;
    String endAirport;
    OrderTicket.FlightClass flightClass;
    Double price;
    String idCard;
    String passport;

    @Enumerated(EnumType.STRING)
    private UserInfo.Sex sex = null;

    public UserInfo.Sex getSex() {
        return sex;
    }

    public void setSex(UserInfo.Sex sex) {
        this.sex = sex;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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


    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public void setArrivalTime(String arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }

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

    public OrderTicket.FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(OrderTicket.FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        return "FlightInfo{" +
                "flightNo='" + flightNo + '\'' +
                ", startTime=" + startTime +
                ", arrivalTime=" + arrivalTime +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", flightClass='" + flightClass + '\'' +
                ", price=" + price +
                '}';
    }
}
