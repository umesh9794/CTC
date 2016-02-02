package com.shc.distanceCalc;

import java.util.Arrays;

/**
 * Created by uchaudh on 1/29/2016.
 */
public class TicketCounter {

    private String fromStation;
    private String toStation;
    private String[] allStations;
    private double totalFare;

    TicketCounter(String[] stations,String from,String to)
    {
        allStations=stations;
        fromStation=from;
        toStation=to;

    }


    public double getFare()
    {
        double indexOfFromStation= Arrays.asList(allStations).indexOf(fromStation);
        double indexOfToStation= Arrays.asList(allStations).indexOf(toStation);
        double totalStations= Math.floor((indexOfToStation - indexOfFromStation)/5);
        totalFare=new TicketPriceupToFive().calculateFare(totalFare,0)+new TicketPriceforMoreThanFive().calculateFare(0,totalStations-1);
        return totalFare;
    }


}
