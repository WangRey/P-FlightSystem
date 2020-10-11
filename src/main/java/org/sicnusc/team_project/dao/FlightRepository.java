package org.sicnusc.team_project.dao;

import org.sicnusc.team_project.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.ArrayList;


public interface FlightRepository extends JpaRepository<Flight,Integer> {
    @Query("from Flight u where u.flightNo = ?1")
    Flight findFilghtByFlightNo(String flightNo);

    @Query("from Flight u where u.startAirport = ?1")
    ArrayList<Flight> findFlightByStartAirport(String startAirport);

    @Query("from Flight u where u.endAirport = ?1")
    ArrayList<Flight> findFlightByEndAirport(String endAirport);

    @Query("from Flight u where u.startAirport = ?1 and u.endAirport = ?2")
    ArrayList<Flight> findFlightByStartAndEndAirport(String startAirport,String endAirport);

    @Query("from Flight u where u.flightNo = ?1")
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Flight findFilghtByFlightNoForUpdate(String flightNo);

    @Query(value = "select * FROM flight where start_city = ?1 and end_city = ?2 and convert(start_time,DATETIME) like ?3% ;",nativeQuery = true)
    ArrayList<Flight> findFlightByTimeAndCity(String startCity,String endCity ,String startTime);




}
