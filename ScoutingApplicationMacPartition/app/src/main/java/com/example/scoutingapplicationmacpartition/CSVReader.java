package com.example.scoutingapplicationmacpartition;

//important
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

//Start
public class CSVReader extends DataEntryActivity {

    public static void main(String[] args) {

        String csvFile = "./saves/savedData.csv";   //You must create a "saves" folder and a "savedData.csv" file first

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Tablet [matchString= " + matchString[0] + ", teamString= " + teamString[1] + ", autoScaleString= " + autoScaleString[2] + ", autoSwitchString= " + autoSwitchString[3] + ", teleopScaleString= " + teleopScaleString[4] + ", teleopSwitchString= " + teleopSwitchString[5] + ", teleopExchangeString= " + teleopExchangeString[6] + ", competitionString= " + competitionString[7] "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
