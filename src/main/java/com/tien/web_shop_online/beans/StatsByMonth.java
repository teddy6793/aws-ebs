package com.tien.web_shop_online.beans;

import java.util.ArrayList;

public class StatsByMonth {
    ArrayList<String> dateArray;
    ArrayList<Double> valueOfDate;

    public StatsByMonth(ArrayList<String> dateArray, ArrayList<Double> valueOfDate) {
        this.dateArray = dateArray;
        this.valueOfDate = valueOfDate;
    }

    public ArrayList<String> getDate() {
        return dateArray;
    }

    public void setDate(ArrayList<String> dateArray) {
        this.dateArray = dateArray;
    }

    public ArrayList<Double> getValue() {
        return valueOfDate;
    }

    public void setValue(ArrayList<Double> valueOfDate) {
        this.valueOfDate = valueOfDate;
    }

    @Override
    public String toString() {
        return "StatsByMonth{" +
                "date=" + dateArray +
                ", value=" + valueOfDate +
                '}';
    }
}
