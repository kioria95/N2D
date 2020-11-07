package com.theknights.drugprev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
public class SplashActivity extends Activity
{

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//Window Color
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashActivity.this,R.color.colorPrimaryDark));
        handler=new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);

    }
}