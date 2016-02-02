package com.shc.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uchaudh on 6/22/2015.
 */
public class SegmentDesc {

    @SerializedName("segmentType")
    public  String segmentType;

    @SerializedName("segmentDescription")
    public String segmentDescription;
    @SerializedName("Indicator")
    public String Indicator;
    @SerializedName("Segment Length")
    public  String SegmentLength;
    @SerializedName("Version Number")
    public String VersionNumber;
    @SerializedName("Store Number")
    public String StoreNumber;
    @SerializedName("Register Number")
    public  String RegisterNumber;
    @SerializedName("Transaction Number")
    public String TransactionNumber;
    @SerializedName("Transaction Date")
    public String TransactionDate;
    @SerializedName("Transaction Time")
    public  String TransactionTime;
    @SerializedName("Credited Store Number")
    public String CreditedStoreNumber;
    @SerializedName("Ringing Associate Number")
    public String RingingAssociateNumber;
    @SerializedName("Purchasing Customer ID")
    public  String PurchasingCustomerID;
    @SerializedName("Purchasing Address ID")
    public String PurchasingAddressID;
    @SerializedName("Customer ID Status Code")
    public String CustomerIDStatusCode;
}
