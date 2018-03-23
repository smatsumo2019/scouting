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
                System.out.println("Tablet [matchString= " + value[0] + ", teamString= " + value[1] + ", autoScaleString= " + value[2] + ", autoSwitchString= " + value[3] + ", teleopScaleString= " + value[4] + ", teleopSwitchString= " + value[5] + ", teleopExchangeString= " + value[6] + ", competitionString= " + value[7] "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
