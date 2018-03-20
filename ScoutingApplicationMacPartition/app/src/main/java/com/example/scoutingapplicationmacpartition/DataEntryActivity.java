package com.example.scoutingapplicationmacpartition;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataEntryActivity extends AppCompatActivity {


    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_entry_activity);


        //EditText Code
        final EditText matchInput = (EditText)findViewById(R.id.matchField);
        final EditText teamInput = (EditText)findViewById(R.id.teamField);


        //Checkbox Code
        boolean checkBoost = onCheckboxClicked(findViewById(R.id.checkbox_boost));
        boolean checkForce = onCheckboxClicked(findViewById(R.id.checkbox_force));
        boolean checkLevitate = onCheckboxClicked(findViewById(R.id.checkbox_levitate));

        final int boostInt;
        final int forceInt;
        final int levitateInt;

        if (checkBoost) {
           boostInt = 20;
        } else {
            boostInt = 0;
        }

        if (checkForce) {
            forceInt = 20;
        } else {
            forceInt = 0;
        }

        if (checkLevitate) {
            levitateInt = 30;
        } else {
            levitateInt = 0;
        }


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

        Button entryButton = findViewById(R.id.submitButton);
        entryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button


                String autoScaleString = autoScaleSpinner.getSelectedItem().toString();
                int autoScaleInt = Integer.parseInt(autoScaleString);
                String autoSwitchString = autoSwitchSpinner.getSelectedItem().toString();
                int autoSwitchInt = Integer.parseInt(autoSwitchString);
                String teleopScaleString = teleopScaleSpinner.getSelectedItem().toString();
                int teleopScaleInt = Integer.parseInt(teleopScaleString);
                String teleopSwitchString = teleopScaleSpinner.getSelectedItem().toString();
                int teleopSwitchInt = Integer.parseInt(teleopSwitchString);
                String teleopExchangeString = teleopScaleSpinner.getSelectedItem().toString();
                int teleopExchangeInt = Integer.parseInt(teleopExchangeString);


                String matchString      =  matchInput.getText().toString();
                String teamString      =  matchInput.getText().toString();



                totalScore+=boostInt;
                totalScore+=forceInt;
                totalScore+=levitateInt;
                totalScore+= (autoScaleInt*10);
                totalScore+= (autoSwitchInt*10);
                totalScore+= (teleopExchangeInt*5);
                totalScore+= (teleopScaleInt*5);
                totalScore+= (teleopSwitchInt*5);


                //Context context = getActivity();
                //SharedPreferences sharedPref = context.getSharedPreferences(
                //        getString(enteredName), Context.MODE_PRIVATE);






                startActivity(returnMainActivity);

            }
        });

    }

    String crossYN = "Filler";
    boolean crossBool = false;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.cross_yes:
                if (checked)
                    crossYN = "Yes";
                    crossBool = true;
                break;

            case R.id.cross_no:
                if (checked)
                    crossYN = "No";
                    crossBool = false;
                break;
        }
    }


    public static boolean onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        return checked;
    }


}