package com.example.scoutingapplicationmacpartition;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent startEntryData = new Intent(this, DataEntryActivity.class);
        final Intent startViewData = new Intent(this, DataViewActivity.class);

        TextView textView = (TextView) findViewById(R.id.title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PressStart2P.ttf");
        textView.setTypeface(typeface);

        textView = (TextView) findViewById(R.id.mainEnterData);
        textView.setTypeface(typeface);

        textView = (TextView) findViewById(R.id.mainViewData);
        textView.setTypeface(typeface);

        Button entryButton = findViewById(R.id.mainEnterData);

        final AlphaAnimation BUTTON_CLICK = new AlphaAnimation(1f, 0.5f);
        entryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v.startAnimation(BUTTON_CLICK);
                // Code here executes on main thread after user presses button
                startActivity(startEntryData);
            }
        });

        Button viewButton = findViewById(R.id.mainViewData);
        viewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                v.startAnimation(BUTTON_CLICK);
                startActivity(startViewData);
            }
        });


    }
}