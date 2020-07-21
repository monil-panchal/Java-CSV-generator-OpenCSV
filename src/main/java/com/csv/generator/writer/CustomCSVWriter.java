package com.csv.generator.writer;

import com.csv.generator.model.ParkBean;
import com.csv.generator.model.ParkDetailedBean;
import com.csv.generator.util.CustomMappingStrategybyNameAndOrderForCSV;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CustomCSVWriter {

    public void generateCSV(List<ParkDetailedBean> countryParkList, String fileName) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        System.out.println("Writing data to the file: " + fileName);
        Writer writer = Files.newBufferedWriter(Paths.get(fileName));
        CustomMappingStrategybyNameAndOrderForCSV<ParkDetailedBean> parkCSVBeanCustomMappingStrategybyNameAndOrder = new CustomMappingStrategybyNameAndOrderForCSV<>();
        parkCSVBeanCustomMappingStrategybyNameAndOrder.setType(ParkDetailedBean.class);

        StatefulBeanToCsv<ParkDetailedBean> beanToCsv2 = new StatefulBeanToCsvBuilder<ParkDetailedBean>(writer)
                .withMappingStrategy(parkCSVBeanCustomMappingStrategybyNameAndOrder)
                .withSeparator(ICSVWriter.DEFAULT_SEPARATOR)
                .withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
                .build();
        beanToCsv2.write(countryParkList);
        writer.close();
        System.out.println("CSV file generated successfully");
    }

    public void generateSpecificCSV(List<ParkBean> parkList, String fileName) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        System.out.println("Writing data to the file: " + fileName);
        Writer writer = Files.newBufferedWriter(Paths.get(fileName));
        CustomMappingStrategybyNameAndOrderForCSV<ParkBean> parkCSVBeanCustomMappingStrategybyNameAndOrder = new CustomMappingStrategybyNameAndOrderForCSV<>();
        parkCSVBeanCustomMappingStrategybyNameAndOrder.setType(ParkBean.class);

        StatefulBeanToCsv<ParkBean> beanToCsv2 = new StatefulBeanToCsvBuilder<ParkBean>(writer)
                .withMappingStrategy(parkCSVBeanCustomMappingStrategybyNameAndOrder)
                .withSeparator(ICSVWriter.DEFAULT_SEPARATOR)
                .withQuotechar(ICSVWriter.NO_QUOTE_CHARACTER)
                .build();
        beanToCsv2.write(parkList);
        writer.close();

        System.out.println("CSV file generated successfully");
    }
}