package com.example.scoutingapplicationmacpartition;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class CSVGenerator {

    public void generateCSVFile(String[] values) throws IOException {
        String titleString = "Pinetree" + Calendar.getInstance().getTime() + values[0];
        CSVWriter csvWriter = new CSVWriter(new FileWriter("output.csv"));
        csvWriter.writeNext(values);


    }
}
