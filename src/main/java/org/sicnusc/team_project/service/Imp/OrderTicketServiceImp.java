package org.sicnusc.team_project.service.Imp;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.sicnusc.team_project.config.Response_config.exception.DefException;
import org.sicnusc.team_project.config.Response_config.exception.ExceptionType;
import org.sicnusc.team_project.dao.FlightRepository;
import org.sicnusc.team_project.dao.OrderTickerRepository;
import org.sicnusc.team_project.model.Flight;
import org.sicnusc.team_project.model.InToModel.BuyTicketFlightInfo;
import org.sicnusc.team_project.model.OrderTicket;
import org.sicnusc.team_project.service.OrderTicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class OrderTicketServiceImp implements OrderTicketService {

    @Resource
    FlightRepository flightRepository;

    @Resource
    OrderTickerRepository orderTickerRepository;

    @Override
    @Transactional
    public void buyOrderTicketByFlightNo(List<BuyTicketFlightInfo> buyTicketFlightInfos, String email) {
        int n = buyTicketFlightInfos.size();
        log.info("查询filghtModle");
        Flight flightModel = flightRepository.findFilghtByFlightNoForUpdate(buyTicketFlightInfos.get(0).getFlightNo());
        if(flightModel.getTicketsAmount() < n){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"来晚一步，余票数量不足，请选择其他航班");
        }else{
            flightModel.setTicketsAmount(flightModel.getTicketsAmount() - n);
        }

        for(int i = 0 ; i < n ; i++){
            BuyTicketFlightInfo temp = buyTicketFlightInfos.get(i);
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            OrderTicket initOrderTicket =  mapper.map(flightModel, OrderTicket.class);
            initOrderTicket.setSex(temp.getSex());
            initOrderTicket.setFlight(flightModel);
            initOrderTicket.setEmail(temp.getEmail());
            initOrderTicket.setRealName(temp.getRealName());
            initOrderTicket.setPhone(temp.getPhone());
            initOrderTicket.setOrderStatus("1");
            initOrderTicket.setOrderNo("OT"+email);
            initOrderTicket.setFlightClass(temp.getFlightClass());
            initOrderTicket.setPrice(temp.getPrice());
            initOrderTicket.setIdCard(temp.getIdCard());
            initOrderTicket.setPassport(temp.getPassport());
            log.info(initOrderTicket.toString());

            log.info("save次数"+i);
            orderTickerRepository.save(initOrderTicket);
        }
        log.info("最后反向存flight");
        flightRepository.save(flightModel);

    }

    @Override
    public List<OrderTicket> getOrderTicket(String orderNo) {
        List<OrderTicket> orderTicketByrderNo = orderTickerRepository.findOrderTicketByrderNo(orderNo);
        if(orderTicketByrderNo.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"没有订单信息");
        }
        return orderTicketByrderNo;
    }

    @Override
    public List<OrderTicket> getPersonalTicket(String email) {
        List<OrderTicket> orderTickets = orderTickerRepository.findPersonalTicketByEmail(email);
        if(orderTickets.isEmpty()){
            throw new DefException(ExceptionType.USER_INPUT_ERROR,"没有买票纪录");
        }
        return orderTickets;
    }

}
