package com.theknights.drugprev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {
    private Button okay_btn, stressed_btn, verystressed_btn;
    private TextView quote_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");

        okay_btn = findViewById(R.id.okay_btn);
        stressed_btn = findViewById(R.id.stressed_button);
        verystressed_btn = findViewById(R.id.verystressed_button);
        quote_text = findViewById(R.id.quote);


        okay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            quote_text.setText("Great job, keep it up!");
            }
        });

        stressed_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, StressedActivity.class));
            }


        });

        verystressed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0701448559"));
                startActivity(callIntent);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.Exit:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                return true;


            case R.id.Settings:
                Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


}