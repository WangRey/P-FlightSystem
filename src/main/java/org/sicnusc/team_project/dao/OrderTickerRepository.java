package org.sicnusc.team_project.dao;


import org.sicnusc.team_project.model.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderTickerRepository extends JpaRepository<OrderTicket,Integer> {
    @Query("from OrderTicket ot where ot.orderNo = ?1")
    List<OrderTicket> findOrderTicketByrderNo(String orderNo);

    @Query("from OrderTicket ot where ot.email = ?1")
    List<OrderTicket> findPersonalTicketByEmail(String email);
}
