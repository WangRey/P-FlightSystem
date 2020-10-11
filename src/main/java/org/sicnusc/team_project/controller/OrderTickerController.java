//package org.sicnusc.team_project.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.sicnusc.team_project.config.Response_config.AjaxResponse;
//import org.sicnusc.team_project.model.InToModel.BuyTicketFlightInfo;
//import org.sicnusc.team_project.model.OrderTicket;
//import org.sicnusc.team_project.service.OrderTicketService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/orderTicket")
//public class OrderTickerController {
//    @Resource
//    OrderTicketService orderTicketService;
//
//    @PostMapping("/buyOrderTicketByFlightNo")
//    public AjaxResponse buyOrderTicketByFlightNo(@RequestBody List<BuyTicketFlightInfo> buyTicketFlightInfos, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String email = (String) session.getAttribute("userInfo");
//       orderTicketService.buyOrderTicketByFlightNo(buyTicketFlightInfos,email);
//        return AjaxResponse.success();
//    }
//
//    @PostMapping("/getOrderTicket")
//    public AjaxResponse getOrderTicket(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String email = (String) session.getAttribute("userInfo");
//        String orderNo = "OT"+email;
//        List<OrderTicket> orderTicket = orderTicketService.getOrderTicket(orderNo);
//        return AjaxResponse.success( orderTicket);
//    }
//
//    @PostMapping("/getPersonalOrderTicket")
//    public AjaxResponse getPersonalOrderTicket(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String email = (String) session.getAttribute("userInfo");
//        List<OrderTicket> personalTicket = orderTicketService.getPersonalTicket(email);
//        return AjaxResponse.success( personalTicket);
//    }
//    @PostMapping("/alipay")
//    public  AjaxResponse getAlipay(HttpServletRequest request, HttpServletResponse response){
//        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);
//
//        //设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//
//        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//        //付款金额，必填
//        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
//        //订单名称，必填
//        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
//        //商品描述，可空
//        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
//
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                + "\"total_amount\":\""+ total_amount +"\","
//                + "\"subject\":\""+ subject +"\","
//                + "\"body\":\""+ body +"\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//
//        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
//        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//        //		+ "\"total_amount\":\""+ total_amount +"\","
//        //		+ "\"subject\":\""+ subject +"\","
//        //		+ "\"body\":\""+ body +"\","
//        //		+ "\"timeout_express\":\"10m\","
//        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
//
//        //请求
//        String form="";
//        try {
//            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
//        response.getWriter().write(form);//直接将完整的表单html输出到页面
//        response.getWriter().flush();
//        response.getWriter().close();
//    }
//
//}
