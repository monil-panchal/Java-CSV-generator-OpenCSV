package com.csv.generator.customfilter;

import com.csv.generator.model.ParkBean;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataModifier {

    public List<ParkBean> ModifyData(String originalCSVFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(originalCSVFile));
        CsvToBean<ParkBean> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ParkBean.class)
                .withSkipLines(1)
                .build();

        List<ParkBean> countryParkList = csvToBean.parse();
        countryParkList.forEach(record -> {
            if (record.getEquipment().contains("Less than ")) {
                record.setEquipment(record.getEquipment().replace("Less than ", "LT"));
            }
            if (record.getEquipment().contains("Single Tent")) {
                record.setEquipment(record.getEquipment().replace("Single Tent", "ST"));
            }
        });
        return countryParkList;
    }
}