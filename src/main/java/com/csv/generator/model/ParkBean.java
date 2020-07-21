package com.csv.generator.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;


public class ParkBean implements Serializable {

    @CsvBindByName(column = "ParkName")
    @CsvBindByPosition(position = 0)
    private String parkName;

    @CsvBindByName(column = "State")
    @CsvBindByPosition(position = 1)
    private String state;

    @CsvBindByName(column = "partySize")
    @CsvBindByPosition(position = 2)
    private String partySize;

    @CsvBindByName(column = "BookingType")
    @CsvBindByPosition(position = 3)
    private String bookingType;

    @CsvBindByName(column = "RateType")
    @CsvBindByPosition(position = 4)
    private String rateType;

    @CsvBindByName(column = "Equipment")
    @CsvBindByPosition(position = 5)
    private String equipment;

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPartySize() {
        return partySize;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    @Override
    public String toString() {
        return "ParkBean{" +
                "parkName='" + parkName + '\'' +
                ", state='" + state + '\'' +
                ", partySize=" + partySize +
                ", rateType='" + rateType + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
