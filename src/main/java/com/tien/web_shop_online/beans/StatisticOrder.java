package com.tien.web_shop_online.beans;

import java.util.ArrayList;

public class StatisticOrder {
    ArrayList<String> statusOrder;
    ArrayList<Integer> numberOfOrder;

    public StatisticOrder() {
    }

    public StatisticOrder(ArrayList<String> statusOrder, ArrayList<Integer> numberOfOrder) {
        this.statusOrder = statusOrder;
        this.numberOfOrder = numberOfOrder;
    }

    public ArrayList<String> getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(ArrayList<String> statusOrder) {
        this.statusOrder = statusOrder;
    }

    public ArrayList<Integer> getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(ArrayList<Integer> numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    @Override
    public String toString() {
        return "StatisticOrder{" +
                "statusOrder=" + statusOrder +
                ", numberOfOrder=" + numberOfOrder +
                '}';
    }
}
