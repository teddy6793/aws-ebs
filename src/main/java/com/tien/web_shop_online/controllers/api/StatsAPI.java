package com.tien.web_shop_online.controllers.api;


import com.tien.web_shop_online.beans.StatisticOrder;
import com.tien.web_shop_online.beans.StatsByMonth;
import com.tien.web_shop_online.services.OrderService;
import com.tien.web_shop_online.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class StatsAPI {

    @Autowired
    OrderService orderService;

    @Autowired
    StatsService statsService;


    @RequestMapping(value = "/api/web_shop/admin/revenue", method = RequestMethod.GET)
    public StatsByMonth revenueJSON() throws ParseException {
        StatsByMonth a = statsService.getStatsByDate();
        return a;
    }

    @RequestMapping(value ="/api/web_shop/admin/number_of_status_order", method = RequestMethod.GET)
    public StatisticOrder analyticByOrderStatus(){
        StatisticOrder statisticOrder = statsService.getNumberOrderStatus();
        return statisticOrder;
    }

}
