package com.csv.generator;

import com.csv.generator.customfilter.DataModifier;
import com.csv.generator.writer.CustomCSVWriter;
import com.csv.generator.customfilter.DataExtractor;
import com.csv.generator.model.ParkBean;
import com.csv.generator.model.ParkDetailedBean;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* Main class runner to process the default CSV file and generate the required CSV files*/
public class App {

    private static final String ORIGINAL_CSV = new File("src/main/resources/Original_CSV/DNR_Camping_Parks_Reservation_Data_2016.csv")
            .getAbsolutePath();

    private static final String COUNTRY_SPECIFIC_CSV = new File("src/main/resources/Original_CSV/Parks_Canada_csv_1.csv")
            .getAbsolutePath();

    private static final String EXTRACTED_CSV = new File("src/main/resources/Original_CSV/Parks_Canada_csv_2.csv")
            .getAbsolutePath();

    private static final String FINAL_CSV = new File("src/main/resources/Original_CSV/Parks_Canada_csv_3.csv")
            .getAbsolutePath();

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        DataExtractor dataExtractor = new DataExtractor();
        CustomCSVWriter customCsvWriter = new CustomCSVWriter();
        DataModifier csvDataModifier = new DataModifier();

        //Generate country specific CSV file
        List<ParkDetailedBean> countryFilteredList = dataExtractor.extractCountryData(ORIGINAL_CSV);
        customCsvWriter.generateCSV(countryFilteredList, COUNTRY_SPECIFIC_CSV);

        //Extract specific field from country csv and generate new CSV
        List<ParkBean> list = dataExtractor.extractDataFromCSV(COUNTRY_SPECIFIC_CSV);
        customCsvWriter.generateSpecificCSV(list, EXTRACTED_CSV);

        //Modify specific fields and generate final CSV
        List<ParkBean> modifiedList = csvDataModifier.ModifyData(EXTRACTED_CSV);
        customCsvWriter.generateSpecificCSV(modifiedList, FINAL_CSV);

    }
}
