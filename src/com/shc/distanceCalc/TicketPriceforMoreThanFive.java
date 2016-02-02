package com.shc.distanceCalc;

/**
 * Created by uchaudh on 1/29/2016.
 */
public class TicketPriceforMoreThanFive implements TicketPriceCalculator{


    @Override
    public double calculateFare(double baseFare, double extraKMs) {
        return extraKMs*5;
    }
}
