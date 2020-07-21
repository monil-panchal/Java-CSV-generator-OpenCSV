package com.csv.generator.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.*;
import com.opencsv.bean.CsvCustomBindByPosition;
import jdk.jfr.Name;

import java.io.Serializable;

/* Bean mapping to the original CSV*/
public class ParkDetailedBean implements Serializable {

    @CsvBindByName(column = "ParkName")
    @CsvBindByPosition(position = 0)
    private String parkName;

    @CsvBindByName(column = "State")
    @CsvBindByPosition(position = 1)
    private String state;

    @CsvBindByName(column = "Country")
    @CsvBindByPosition(position = 2)
    private String country;

    @CsvBindByName(column = "Adult")
    @CsvBindByPosition(position = 3)
    private String adult;

    @CsvBindByName(column = "Child")
    @CsvBindByPosition(position = 4)
    private String child;

    @CsvBindByName(column = "partySize")
    @CsvBindByPosition(position = 5)
    private String partySize;

    @CsvBindByName(column = "RateType")
    @CsvBindByPosition(position = 6)
    private String rateType;

    @CsvBindByName(column = "BookingType")
    @CsvBindByPosition(position = 7)
    private String bookingType;

    @CsvBindByName(column = "Equipment")
    @CsvBindByPosition(position = 8)
    private String equipment;

    @CsvBindByName(column = "BookingStartDate")
    @CsvBindByPosition(position = 9)
    private String bookingStartDate;

    @CsvBindByName(column = "BookingEnddate")
    @CsvBindByPosition(position = 10)
    private String bookingEnddate;

    @CsvBindByName(column = "Night")
    @CsvBindByPosition(position = 11)
    private String night;

    @CsvBindByName(column = "Permits")
    @CsvBindByPosition(position = 12)
    private String permits;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
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

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(String bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public String getBookingEnddate() {
        return bookingEnddate;
    }

    public void setBookingEnddate(String bookingEnddate) {
        this.bookingEnddate = bookingEnddate;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getPermits() {
        return permits;
    }

    public void setPermits(String permits) {
        this.permits = permits;
    }

    @Override
    public String toString() {
        return "ParkDetailedBean{" +
                "parkName='" + parkName + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", adult=" + adult +
                ", child=" + child +
                ", partySize=" + partySize +
                ", rateType='" + rateType + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", equipment='" + equipment + '\'' +
                ", bookingStartDate='" + bookingStartDate + '\'' +
                ", bookingEnddate='" + bookingEnddate + '\'' +
                ", night=" + night +
                ", permits=" + permits +
                '}';
    }
}
