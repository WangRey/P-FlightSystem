package org.sicnusc.team_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
//@NotBlank(message = "信息段不能为空为空")
public class Flight implements Serializable {


    public static enum FlightStatus{
        normal,
        delayed,
        boarding,
        expected,
        landed,
        cancelled
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128,nullable = false)
    private String flightNo;

    @Column(length = 128,nullable = false)
    private String startAirport;
    @Column(length = 128,nullable = false)
    private String endAirport;



    @Column(length = 128,nullable = false)
    private String startCity;
    @Column(length = 128,nullable = false)
    private String endCity;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arrivalTime;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startRealTime;

    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date  arrivalRealTime;

    @Column(length = 32,nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @Column(nullable = false)
    private Integer businessClassAmount;
    @Column(nullable = false)
    private Integer firstClassAmount;
    @Column(nullable = false)
    private Integer economyClassAmount;

    @Column(nullable = false)
    private Double firstClassPrice;
    @Column(nullable = false)
    private Double businessClassPrice;

    @Column(nullable = false)
    private Double economyClassPrice;

    @Column(nullable = false)
    private Integer ticketsAmount;

    //对方的那个外键字段属性名，（其实就是this这个类的实例名称）
//    cascade 指定要级联的操作，all代表增删查改
    @JsonIgnore
    @OneToMany(mappedBy = "flight" ,cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderTicket> orderTicketList = new HashSet<OrderTicket>(0);

    @Column(nullable = false)
    private Double discount = 1.0;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
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

    public Date getStartRealTime() {
        return startRealTime;
    }

    public void setStartRealTime(Date startRealTime) {
        this.startRealTime = startRealTime;
    }

    public Date getArrivalRealTime() {
        return arrivalRealTime;
    }

    public void setArrivalRealTime(Date arrivalRealTime) {
        this.arrivalRealTime = arrivalRealTime;
    }



    public Integer getBusinessClassAmount() {
        return businessClassAmount;
    }

    public void setBusinessClassAmount(Integer businessClassAmount) {
        this.businessClassAmount = businessClassAmount;
    }

    public Integer getFirstClassAmount() {
        return firstClassAmount;
    }

    public void setFirstClassAmount(Integer firstClassAmount) {
        this.firstClassAmount = firstClassAmount;
    }

    public Integer getEconomyClassAmount() {
        return economyClassAmount;
    }

    public void setEconomyClassAmount(Integer economyClassAmount) {
        this.economyClassAmount = economyClassAmount;
    }

    public Double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(Double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public Double getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(Double businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public Double getEconomyClassPrice() {
        return economyClassPrice;
    }

    public void setEconomyClassPrice(Double economyClassPrice) {
        this.economyClassPrice = economyClassPrice;
    }
    public Integer getTicketsAmount() {
        return ticketsAmount;
    }

    public void setTicketsAmount(Integer ticketsAmount) {
        this.ticketsAmount = ticketsAmount;
    }

    public Set<OrderTicket> getOrderTicketList() {
        return orderTicketList;
    }

    public void setOrderTicketList(Set<OrderTicket> orderTicketList) {
        this.orderTicketList = orderTicketList;
    }

//    @Override
//    public String toString() {
//        return "Flight{" +
//                "id=" + id +
//                ", flightNo='" + flightNo + '\'' +
//                ", startAirport='" + startAirport + '\'' +
//                ", endAirport='" + endAirport + '\'' +
//                ", startCity='" + startCity + '\'' +
//                ", endCity='" + endCity + '\'' +
//                ", startTime=" + startTime +
//                ", arrivalTime=" + arrivalTime +
//                ", startRealTime=" + startRealTime +
//                ", arrivalRealTime=" + arrivalRealTime +
//                ", flightStatus=" + flightStatus +
//                ", businessClassAmount=" + businessClassAmount +
//                ", firstClassAmount=" + firstClassAmount +
//                ", economyClassAmount=" + economyClassAmount +
//                ", firstClassPrice=" + firstClassPrice +
//                ", businessClassPrice=" + businessClassPrice +
//                ", economyClassPrice=" + economyClassPrice +
//                ", ticketsAmount=" + ticketsAmount +
//                ", orderTicketList=" + orderTicketList +
//                ", discount=" + discount +
//                '}';
//    }
}
