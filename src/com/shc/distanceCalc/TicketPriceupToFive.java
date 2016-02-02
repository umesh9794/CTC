package com.shc.distanceCalc;

/**
 * Created by uchaudh on 1/29/2016.
 */
public class TicketPriceupToFive implements TicketPriceCalculator{

    @Override
    public double calculateFare(double baseFare, double extraKMs) {
        return baseFare+10;
    }
}
