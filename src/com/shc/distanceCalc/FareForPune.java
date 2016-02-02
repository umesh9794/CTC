package com.shc.distanceCalc;

/**
 * Created by uchaudh on 1/29/2016.
 */
public class FareForPune {

    static String out=null;

    public static void main(String[] args) {

        String[] stations=new String[]{"Hinjewadi","Pimpri","Pimple","Jagtap","Aundh","University","MG Road","Station","Bund Garden"
                                        ,"Yerwada","Shashtri Nagar","Kalyani Nagar","Viman Nagar","Chandan Nagar","Kharadi","Ubale Nagar","Wagholi"};



        out="Ticket Price : "+ new TicketCounter(stations,"Pimpri","Wagholi").getFare()+ " Rs.";

    }



}



