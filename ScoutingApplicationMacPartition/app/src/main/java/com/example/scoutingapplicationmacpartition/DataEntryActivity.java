package com.example.scoutingapplicationmacpartition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataEntryActivity extends AppCompatActivity {


    int totalScore = 0;
    String matchString = "";
    String teamString = "";
    String climbString = "";
    String platformString = "";
    String crossString = "";
    String autoFoulString = "";
    String teleopFoulString = "";

    String[] values = new String[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_entry_activity);


        //EditText Code
        final EditText matchInput = (EditText)findViewById(R.id.matchField);
        final EditText teamInput = (EditText)findViewById(R.id.teamField);


        // Spinner declarations
        final Spinner autoSwitchSpinner = (Spinner) findViewById(R.id.autoSwitch);
        final Spinner autoScaleSpinner = (Spinner) findViewById(R.id.autoScale);
        final Spinner teleopSwitchSpinner = (Spinner) findViewById(R.id.teleopSwitch);
        final Spinner teleopScaleSpinner = (Spinner) findViewById(R.id.teleopScale);
        final Spinner teleopExchangeSpinner = (Spinner) findViewById(R.id.teleopExchange);


        // Spinner Element Lists
        List<Integer> autoCubes = new ArrayList<>();
        autoCubes.add(0);
        autoCubes.add(1);
        autoCubes.add(2);
        autoCubes.add(3);

        List<Integer> teleopCubes = new ArrayList<>();
        teleopCubes.add(0);
        teleopCubes.add(1);
        teleopCubes.add(2);
        teleopCubes.add(3);
        teleopCubes.add(4);
        teleopCubes.add(5);
        teleopCubes.add(6);
        teleopCubes.add(7);
        teleopCubes.add(8);
        teleopCubes.add(9);


        // Adapter for Spinners
        ArrayAdapter<Integer> autoCubeArray = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, autoCubes);
        ArrayAdapter<Integer> teleopCubeArray = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teleopCubes);

        // Drop down layout assignmnt
        autoCubeArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Assigning Adapters
        autoSwitchSpinner.setAdapter(autoCubeArray);
        autoScaleSpinner.setAdapter(autoCubeArray);

        teleopSwitchSpinner.setAdapter(teleopCubeArray);
        teleopScaleSpinner.setAdapter(teleopCubeArray);
        teleopExchangeSpinner.setAdapter(teleopCubeArray);









        final Intent returnMainActivity = new Intent(this, MainActivity.class);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                v.setAnimation(new AlphaAnimation(1f, 0.5f));
                //Checkbox bools
                boolean checkBoost = onCheckboxClicked(findViewById(R.id.checkbox_boost));
                boolean checkForce = onCheckboxClicked(findViewById(R.id.checkbox_force));
                boolean checkLevitate = onCheckboxClicked(findViewById(R.id.checkbox_levitate));

                //Match and team string input
                matchString =  "Match " + matchInput.getText().toString();
                values[0] = matchString;
                teamString  =  "Team " + matchInput.getText().toString();
                values[1] = teamString;

                //Spinner code for scale, switch, exchange;
                String autoScaleString = autoScaleSpinner.getSelectedItem().toString();
                values[2] = autoScaleString;
                int autoScaleInt = Integer.parseInt(autoScaleString);
                String autoSwitchString = autoSwitchSpinner.getSelectedItem().toString();
                values[3] = autoSwitchString;
                int autoSwitchInt = Integer.parseInt(autoSwitchString);
                String teleopScaleString = teleopScaleSpinner.getSelectedItem().toString();
                values[4] = teleopScaleString;
                int teleopScaleInt = Integer.parseInt(teleopScaleString);
                String teleopSwitchString = teleopSwitchSpinner.getSelectedItem().toString();
                values[5] = teleopSwitchString;
                int teleopSwitchInt = Integer.parseInt(teleopSwitchString);
                String teleopExchangeString = teleopExchangeSpinner.getSelectedItem().toString();
                values[6] = teleopExchangeString;
                int teleopExchangeInt = Integer.parseInt(teleopExchangeString);


                //getting radio button inputs
                RadioButton clicked;
                RadioGroup buttonGroup;
                int buttonId;

                //getting if auto line crossed
                buttonGroup = findViewById(R.id.autoCrossRadio);
                buttonId = buttonGroup.getCheckedRadioButtonId();
                clicked = findViewById(buttonId);
                boolean hasCrossed = String.valueOf(clicked.getText()).equalsIgnoreCase("yes");
                if (hasCrossed) {
                    crossString = "Yes";
                } else {
                    crossString = "No";
                }
                values[7] = crossString;

                //getting if there was an autonomous foul
                buttonGroup = findViewById(R.id.autoFoulRadio);
                buttonId = buttonGroup.getCheckedRadioButtonId();
                clicked = findViewById(buttonId);
                boolean hasAutoFouled = String.valueOf(clicked.getText()).equalsIgnoreCase("yes");
                if (hasAutoFouled) {
                    autoFoulString = "Yes";
                } else {
                    autoFoulString = "No";
                }
                values[8] = autoFoulString;

                //getting if robot climbed
                buttonGroup = findViewById(R.id.climbRadio);
                buttonId = buttonGroup.getCheckedRadioButtonId();
                clicked = findViewById(buttonId);
                boolean hasClimbed = String.valueOf(clicked.getText()).equalsIgnoreCase("yes");
                if (hasClimbed) {
                    climbString = "Yes";
                } else {
                    climbString = "No";
                }
                values[9] = climbString;

                //getting if robot ended up on platform
                buttonGroup = findViewById(R.id.platformRadio);
                buttonId = buttonGroup.getCheckedRadioButtonId();
                clicked = findViewById(buttonId);
                boolean wasOnPlatform = String.valueOf(clicked.getText()).equalsIgnoreCase("yes");
                if (wasOnPlatform) {
                    platformString = "Yes";
                } else {
                    platformString = "No";
                }
                values[10] = platformString;

                //getting if there was a teleop foul
                buttonGroup = findViewById(R.id.teleopFoulRadio);
                buttonId = buttonGroup.getCheckedRadioButtonId();
                clicked = findViewById(buttonId);
                boolean hasTeleopFouled = String.valueOf(clicked.getText()).equalsIgnoreCase("yes");
                if (hasTeleopFouled) {
                    teleopFoulString = "Yes";
                } else {
                    teleopFoulString = "No";
                }
                values[11] = teleopFoulString;

                //Quick maths for calculating total score
                if (checkBoost) {
                    totalScore+= 20;
                }
                if (checkForce) {
                    totalScore += 20;
                }
                if (checkLevitate) {
                    totalScore += 30;
                }
                if(hasCrossed) {
                    totalScore+= 5;
                }
                if(hasAutoFouled) {
                    totalScore-= 40;
                }
                if(hasClimbed) {
                    totalScore+= 30;
                }
                if(wasOnPlatform) {
                    totalScore+= 10;
                }
                if(hasTeleopFouled) {
                    totalScore-= 40;
                }

                totalScore+= (autoScaleInt*20);
                totalScore+= (autoSwitchInt*20);
                totalScore+= (teleopExchangeInt*5);
                totalScore+= (teleopScaleInt*5);
                totalScore+= (teleopSwitchInt*5);


                //CSV Generator that makes more CSV files
                CSVGenerator csvGenerator = new CSVGenerator();
                try {
                    csvGenerator.generateCSVFile(values);
                } catch (IOException ex) {
                    Log.e(String.valueOf(Log.ERROR), ex.getMessage());
                }

                //Toast statement for checking
                Toast.makeText(DataEntryActivity.this,
                        ""+ totalScore,
                        Toast.LENGTH_LONG).show();

                //Returns to main activity
                startActivity(returnMainActivity);

            }
        });

    }

    public static boolean onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        return checked;
    }


}