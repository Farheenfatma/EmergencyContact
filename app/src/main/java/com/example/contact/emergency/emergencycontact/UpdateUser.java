package com.example.contact.emergency.emergencycontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {
    EditText fname,lname,email;
    RadioGroup radioGroup;
    Button signupbtn;
    String finame,laname,emailid,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        fname= findViewById(R.id.firstnamesignup);
        lname=findViewById(R.id.lastnamesignup);
        email=findViewById(R.id.emailsignup);
        radioGroup=findViewById(R.id.radioGroup);
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
            startActivity(new Intent(UpdateUser.this,Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void click(View view) {

        if(view.getId()==R.id.update) {

            finame = fname.getText().toString();
            laname = lname.getText().toString();
            emailid = email.getText().toString();

            int selectedid = radioGroup.getCheckedRadioButtonId();
            if (selectedid == R.id.radioButton) {
                gender = "Male";
            } else if (selectedid == R.id.radioButton2) {
                gender = "Female";
            }
            if(finame.equals("")){
                fname.setError("Enter Details");
            }
            if(laname.equals("")){
                lname.setError("Enter Details");
            }
            if(emailid.equals("")){
                email.setError("Enter Details");
            }
            else {
                SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("fname", finame);
                editor.putString("lname", laname);
                editor.putString("email", emailid);
                editor.putString("gender", gender);
                editor.commit();
                finish();
                Toast.makeText(this, "Details Updated", Toast.LENGTH_SHORT).show();
            }



        }
        else if(view.getId()==R.id.home){
            finish();
            startActivity(new Intent(UpdateUser.this,MainActivity.class));
        }
    }
}
