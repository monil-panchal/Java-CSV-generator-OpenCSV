package com.csv.generator.customfilter;

import com.csv.generator.model.ParkBean;
import com.csv.generator.model.ParkDetailedBean;
import com.opencsv.bean.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataExtractor {

    public List<ParkBean> extractDataFromCSV(String originalCSVFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(originalCSVFile));
        CsvToBean<ParkDetailedBean> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ParkDetailedBean.class)
                .withSkipLines(1)
                .build();

        List<ParkBean> extractList = new ArrayList();

        Iterator<ParkDetailedBean> csvRecordIterator = csvToBean.iterator();
        csvRecordIterator.forEachRemaining(record -> {

            ParkBean newBean = new ParkBean();

            newBean.setParkName(record.getParkName());
            newBean.setState(record.getState());
            newBean.setPartySize(record.getPartySize());
            newBean.setBookingType(record.getBookingType());
            newBean.setRateType(record.getRateType());
            newBean.setEquipment(record.getEquipment());

            extractList.add(newBean);
        });

        reader.close();
        return extractList;
    }

    public List<ParkDetailedBean> extractCountryData(String originalCSVFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(originalCSVFile));
        CsvToBean<ParkDetailedBean> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ParkDetailedBean.class)
                .withSkipLines(1)
                .build();

        List<ParkDetailedBean> countryFilteredList = new ArrayList<>();
        /* Generating a iterator from the CSVBean object.*/
        Iterator<ParkDetailedBean> csvRecordIterator = csvToBean.iterator();
        csvRecordIterator.forEachRemaining(record -> {
            /* if the park record belongs to Canada country, it will add to the countryFilteredList*/
            if (!record.getCountry().isEmpty()
                    && record.getCountry().contains("CANADA")) {
                countryFilteredList.add(record);
            }
        });
        reader.close();
        return countryFilteredList;
    }
}