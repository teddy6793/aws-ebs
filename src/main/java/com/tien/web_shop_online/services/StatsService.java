package com.tien.web_shop_online.services;

import com.tien.web_shop_online.beans.StatisticOrder;
import com.tien.web_shop_online.beans.StatsByMonth;
import org.json.JSONObject;

import java.text.ParseException;

public interface StatsService {
    JSONObject getTotalPriceSevenDayBefore() throws ParseException;
    StatsByMonth getStatsByDate() throws ParseException;
    Double getProfitUpToNow();
    StatisticOrder getNumberOrderStatus();
}
