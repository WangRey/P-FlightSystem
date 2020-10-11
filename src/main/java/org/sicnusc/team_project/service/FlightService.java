package org.sicnusc.team_project.service;

import org.sicnusc.team_project.model.Flight;

import java.util.ArrayList;

public interface FlightService {
    Flight findFlightByFilghtNo(String flightNo);
    ArrayList<Flight> findFlightByStartAirport(String startAirport);
    ArrayList<Flight> findFlightByEndAirport(String endAirport);
    ArrayList<Flight> findFlightByStartAndEndAirport(String startAirport,String endAirport);
    void cancelFlightByFilghtNo(String flightNo);
    ArrayList<Flight> findFlightByTimeAndCity(String startCity,String endCity ,String startTime);
    Flight addFlight(Flight flight);
}
