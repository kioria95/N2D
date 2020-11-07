package com.theknights.drugprev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class OkayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okay);

        Toolbar toolbar = findViewById(R.id.okay_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Congratulations");
    }
}