package org.sicnusc.team_project.service.Imp;

import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.dao.FlightRepository;
import org.sicnusc.team_project.model.Flight;
import org.sicnusc.team_project.model.OrderTicket;
import org.sicnusc.team_project.service.FlightService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Set;

@Service
public class FlightServiceImp implements FlightService {

    @Resource
    FlightRepository flightRepository;

    @Override
    public Flight findFlightByFilghtNo(String flightNo) {
        Flight flightByFlightNo = flightRepository.findFilghtByFlightNo(flightNo);
        if (flightByFlightNo==null){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"此航班号不存在");
        }
        return flightByFlightNo;
    }

    @Override
    public ArrayList<Flight> findFlightByStartAirport(String startAirport) {
        ArrayList<Flight> flightByStartAirport = flightRepository.findFlightByStartAirport(startAirport);
        if (flightByStartAirport.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"没有出发机场为"+startAirport+"的航班");
        }
        return flightByStartAirport;
    }

    @Override
    public ArrayList<Flight> findFlightByEndAirport(String endAirport) {
        ArrayList<Flight> flightByEndAirport = flightRepository.findFlightByEndAirport(endAirport);
        if (flightByEndAirport.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"没有抵达机场为"+endAirport+"的航班");
        }
        return flightByEndAirport;
    }

    @Override
    public ArrayList<Flight> findFlightByStartAndEndAirport(String startAirport, String endAirport) {
        ArrayList<Flight> flightByStartAndEndAirport = flightRepository.findFlightByStartAndEndAirport(startAirport, endAirport);
        if (flightByStartAndEndAirport.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"没有出发机场为"+startAirport+"抵达机场为"+endAirport+"的航班");
        }
        return flightByStartAndEndAirport;
    }

    @Override
    @Transactional
    public void cancelFlightByFilghtNo(String flightNo) {
        Flight flight = flightRepository.findFilghtByFlightNo(flightNo);
        if(flight==null){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"此航班号不存在,无法取消");
        }
        if(flight.getFlightStatus().equals("cancelled")){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"此航班号已经是取消状态");
        }else{
            flight.setFlightStatus(Flight.FlightStatus.cancelled);
            Set<OrderTicket> orderTicketList = flight.getOrderTicketList();
            for(OrderTicket orderTicket : orderTicketList){
                orderTicket.setOrderStatus("0");
            }
            flightRepository.save(flight);
        }
    }

    @Override
    public ArrayList<Flight> findFlightByTimeAndCity(String startCity, String endCity, String startTime) {
        ArrayList<Flight> flightByTimeAndCity = flightRepository.findFlightByTimeAndCity(startCity, endCity, startTime);
        if(flightByTimeAndCity.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"无相关航班信息");
        }
        return flightByTimeAndCity;
    }

    @Override
    public Flight addFlight(Flight flitht) {
        Flight save = flightRepository.save(flitht);
        return save;
    }
}
