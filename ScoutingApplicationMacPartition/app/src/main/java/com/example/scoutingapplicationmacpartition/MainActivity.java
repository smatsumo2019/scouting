package com.example.scoutingapplicationmacpartition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent startEntryData = new Intent(this, DataEntryActivity.class);
        final Intent startViewData = new Intent(this, DataViewActivity.class);

        Button entryButton = findViewById(R.id.mainEnterData);
        entryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(startEntryData);
            }
        });

        Button viewButton = findViewById(R.id.mainViewData);
        viewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(startViewData);
            }
        });


    }
}