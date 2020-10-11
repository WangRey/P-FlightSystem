package org.sicnusc.team_project.controller;

import lombok.extern.slf4j.Slf4j;
import org.sicnusc.team_project.config.Response_config.AjaxResponse;
import org.sicnusc.team_project.model.Flight;
import org.sicnusc.team_project.service.FlightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Resource
    FlightService flightService;

    @RequestMapping("/addFlight")
    public AjaxResponse addFlight(@RequestBody  Flight flight){
        log.info(flight.toString());
        Flight newFlight = flightService.addFlight(flight);
        return AjaxResponse.success(newFlight);
    }

    @RequestMapping("/byFlightNo")
    public AjaxResponse byFlightNo(@RequestBody Map<String ,String> message){
        log.info(message.get("flightNo"));
        Flight flightNo = flightService.findFlightByFilghtNo(message.get("flightNo"));
        log.info("准备返回："+flightNo.getFlightNo());
        return AjaxResponse.success(flightNo);
    }
    @RequestMapping("/byStartAirport")
    public AjaxResponse byStartAirport(@RequestBody Map<String ,String> message){
        log.info(message.get("startAirport"));
        ArrayList<Flight> startAirport = flightService.findFlightByStartAirport(message.get("startAirport"));
        return AjaxResponse.success(startAirport);
    }
    @RequestMapping("/byEndAirport")
    public AjaxResponse byEndAirport(@RequestBody Map<String ,String> message){
        log.info(message.get("endAirport"));
        ArrayList<Flight> endAirport = flightService.findFlightByEndAirport(message.get("endAirport"));
        return AjaxResponse.success(endAirport);
    }
    @RequestMapping("/byStartAndEndAirport")
    public AjaxResponse byStartAndEndAirport(@RequestBody Map<String ,String> message){
        log.info(message.get("startAirport")+message.get("endAirport"));
        ArrayList<Flight> flightByStartAndEndAirport = flightService.findFlightByStartAndEndAirport(message.get("startAirport"), message.get("endAirport"));
        return AjaxResponse.success(flightByStartAndEndAirport);
    }

    @RequestMapping("/byStartTimeAndCity")
    public AjaxResponse byStartTimeAndCity(@RequestBody Map<String ,String> message){
        ArrayList<Flight> flightByStartAndEndAirport = flightService.findFlightByTimeAndCity(message.get("startCity"),message.get("endCity"),message.get("startTime"));
        return AjaxResponse.success(flightByStartAndEndAirport);
    }

    @RequestMapping("/cancelByFlightNo")
    public AjaxResponse cancelByFlightNo(@RequestBody Map<String ,String> message){
        log.info("cancellByFlightNo");
        flightService.cancelFlightByFilghtNo(message.get("flightNo"));
        return AjaxResponse.success();

    }




}
