package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.beans.StatisticOrder;
import com.tien.web_shop_online.beans.StatsByMonth;
import com.tien.web_shop_online.entities.Order;
import com.tien.web_shop_online.repositories.OrderRepository;
import com.tien.web_shop_online.services.StatsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StatsImplement implements StatsService {

    @Autowired
    OrderRepository orderRepository;

    Integer CART_STATUS = -1;
    Integer PROCESSING_STATUS = 0;
    Integer DELIVERING_STATUS = 1;
    Integer DELIIVERED_STATUS = 2;
    Integer CANCELLED_STATUS = 3;

    @Override
    public JSONObject getTotalPriceSevenDayBefore() throws ParseException {
        JSONObject jsonObject = new JSONObject();

        List<Date> listDate = new ArrayList<>();
        Long oneDay = 86400000L;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Date nowA = dateFormat.parse(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth());
        for(int i = 0; i < 7;i++){
            listDate.add(new Date(nowA.getTime() - oneDay*i));
        }

        ArrayList<Double> sumL = new ArrayList<Double>();
        JSONArray dateArray = new JSONArray();
        for(Date i: listDate){
            dateArray.put(dateFormat.format(i).toString());
        }


        for(Date d : listDate){
            List<Order> listOrder = orderRepository.findAllByOrderDateAndStatus(d, DELIIVERED_STATUS);
            double sum =0;
            if(listOrder.size() > 0){
                for (Order o : listOrder){
                    sum += o.getTotalPrice();
                }
            }
            sumL.add(sum);
        }
        JSONArray valueArray = new JSONArray();
        for (Double i: sumL){
            valueArray.put(i);
        }

        jsonObject.put("date",dateArray);
        jsonObject.put("value",valueArray);
        return jsonObject;
    }

    @Override
    public StatsByMonth getStatsByDate() throws ParseException {

        JSONObject jsonObject = new JSONObject();

        List<Date> listDate = new ArrayList<>();
        Long oneDay = 86400000L;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Date nowA = dateFormat.parse(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth());

        for(int i = 0; i < 7;i++){
            listDate.add(new Date(nowA.getTime() - oneDay*i));
        }

        ArrayList<String> date = new ArrayList<>();
        for(Date a : listDate){
            date.add(dateFormat.format(a).toString());
        }

        ArrayList<Double> sumL = new ArrayList<Double>();

        for(Date d : listDate){
            List<Order> listOrder = orderRepository.findAllByOrderDateAndStatus(d, DELIIVERED_STATUS);
            double sum =0;
            if(listOrder.size() > 0){
                for (Order o : listOrder){
                    sum += o.getTotalPrice();
                }
            }
            sumL.add(sum);
        }
        StatsByMonth stats = new StatsByMonth(date, sumL);

        return stats;
    }

    @Override
    public Double getProfitUpToNow() {
        List<Order> orderList = orderRepository.findAllByStatus(DELIIVERED_STATUS);
        double value = 0;
        for(Order o : orderList){
            value += o.getTotalPrice();
        }
        return value;
    }

    @Override
    public StatisticOrder getNumberOrderStatus() {
        StatisticOrder statisticOrder = new StatisticOrder();

        ArrayList<String> statusOrder = new ArrayList<>();
        statusOrder.add("Đang xử lý");
        statusOrder.add("Đang giao");
        statusOrder.add("Đã giao");
        statusOrder.add("Đã hủy");

        Integer proccessOrder = orderRepository.findAllByStatus(0).size();
        Integer deliveringOrder = orderRepository.findAllByStatus(1).size();
        Integer deliveredOrder = orderRepository.findAllByStatus(2).size();
        Integer cancelledOrder = orderRepository.findAllByStatus(3).size();

        ArrayList<Integer> valueArray = new ArrayList<>();
        valueArray.add(proccessOrder);
        valueArray.add(deliveringOrder);
        valueArray.add(deliveredOrder);
        valueArray.add(cancelledOrder);

        statisticOrder.setStatusOrder(statusOrder);
        statisticOrder.setNumberOfOrder(valueArray);

        return statisticOrder;
    }
}
