package org.sicnusc.team_project.service;

import org.sicnusc.team_project.model.InToModel.BuyTicketFlightInfo;
import org.sicnusc.team_project.model.OrderTicket;

import java.util.List;

public interface OrderTicketService {
    void buyOrderTicketByFlightNo(List<BuyTicketFlightInfo> buyTicketFlightInfos,String  email);
    List<OrderTicket> getOrderTicket(String orderNo);
    List<OrderTicket> getPersonalTicket(String email);
}
