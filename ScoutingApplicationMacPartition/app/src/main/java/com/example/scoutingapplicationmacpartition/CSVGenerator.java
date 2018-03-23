package com.example.scoutingapplicationmacpartition;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVGenerator {
    public void generateCSVFile(String[] values) throws IOException {
        //Definitions
        String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String fileName = "savedData.csv";
        String filePath = baseDir + File.separator + fileName;
        CSVWriter writer;

        FileWriter mFileWriter = new FileWriter(filePath, true);
        writer = new CSVWriter(mFileWriter);

        String[] data = {"matchString= " + values[0] + ", teamString= " + values[1] + ", autoScaleString= " + values[2] + ", autoSwitchString= " + values[3] + ", teleopScaleString= " + values[4] + ", teleopSwitchString= " + values[5] + ", teleopExchangeString= " + values[6] + ", competitionString= " + values[7]};

        writer.writeNext(data);

        writer.close();

    }
}