package com.example.contact.emergency.emergencycontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    Handler handler;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sp= getSharedPreferences("pref", Context.MODE_PRIVATE);
                String un= sp.getString("fname",null);

                if(un!=null){
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(Splash.this,Registration.class));
                    finish();
                }
            }
        },2000);
    }
}
