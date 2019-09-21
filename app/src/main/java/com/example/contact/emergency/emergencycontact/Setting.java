package com.example.contact.emergency.emergencycontact;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home);
        {
            finish();
            startActivity(new Intent(Setting.this,MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void open(View view) {
        if(view.getId()==R.id.updateUser_button){
            startActivity(new Intent(Setting.this,UpdateUser.class));
        }
        else if(view.getId()==R.id.updateEM_button){
            startActivity(new Intent(Setting.this,UpdateEmergency.class));
        }
        else if (view.getId()==R.id.home_button){
            startActivity(new Intent(Setting.this,MainActivity.class));
        }
        else if(view.getId()==R.id.logout){
            SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.remove("fname");
            editor.commit();
            finish();
            startActivity(new Intent(Setting.this,Registration.class));
        }
    }
}
