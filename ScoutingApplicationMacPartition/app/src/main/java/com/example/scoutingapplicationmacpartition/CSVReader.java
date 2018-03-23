package com.example.scoutingapplicationmacpartition;

//important
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

//Start
public class CSVReader extends DataEntryActivity {

    public void main(String[] args) {

        String csvFile = "./saves/savedData.csv";   //You must create a "saves" folder and a "savedData.csv" file first

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Tablet [matchString= " + values[0] + ", teamString= " + values[1] + ", autoScaleString= " + values[2] + ", autoSwitchString= " + values[3] + ", teleopScaleString= " + values[4] + ", teleopSwitchString= " + values[5] + ", teleopExchangeString= " + values[6] + ", competitionString= " + values[7] "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
