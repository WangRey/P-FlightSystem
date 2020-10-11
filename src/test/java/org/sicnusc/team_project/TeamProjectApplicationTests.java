package org.sicnusc.team_project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.sicnusc.team_project.dao.FlightRepository;
import org.sicnusc.team_project.dao.OrderTickerRepository;
import org.sicnusc.team_project.model.Flight;
import org.sicnusc.team_project.model.OrderTicket;
import org.sicnusc.team_project.service.MailService;
import org.sicnusc.team_project.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@Slf4j
@SpringBootTest
class TeamProjectApplicationTests {


    @Autowired
    PersonDataService personDataService;
    @Autowired
    MailService mailService;
    @Autowired
    OrderTickerRepository orderTickerRepository;
    @Autowired
    FlightRepository flightRepository;

    @Test
    void contextLoads() {
//        ArrayList<Flight> flightByTime = flightRepository.findFlightByTime("2018-02-04");
//        log.info(flightByTime.toString());
    }

}
