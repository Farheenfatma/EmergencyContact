package com.example.contact.emergency.emergencycontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Registration extends AppCompatActivity {
    EditText fname,lname,email,emergencycon,emergencynum;
    RadioGroup radioGroup;
    Button signupbtn;
    String finame,laname,emailid,contact,number,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname= findViewById(R.id.firstnamesignup);
        lname=findViewById(R.id.lastnamesignup);
        email=findViewById(R.id.emailsignup);
        emergencycon=findViewById(R.id.emergencycon);
        emergencynum=findViewById(R.id.emergencynum);
        radioGroup=findViewById(R.id.radioGroup);
        signupbtn=findViewById(R.id.signupbtn);
    }
    public void click(View v){
        finame=fname.getText().toString();
        laname=lname.getText().toString();
        emailid=email.getText().toString();
        contact=emergencycon.getText().toString();
        number=emergencynum.getText().toString();
        int selectedid=radioGroup.getCheckedRadioButtonId();
        if(selectedid==R.id.radioButton){
            gender="Male";
        }
        else if(selectedid==R.id.radioButton2){
            gender="Female";
        }

        if(finame.equals("")){
            fname.setError("enter details");
        }
        else if(laname.equals("")){
            lname.setError("enter details");
        }
        else if(emailid.equals("")){
            email.setError("enter details");
        }
        else if(contact.equals("")){
            emergencycon.setError("enter details");
        }
        else if(number.equals("")){
            emergencynum.setError("enter details");
        }
        else{
            SharedPreferences preferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("fname",finame);
            editor.putString("lname",laname);
            editor.putString("email",emailid);;
            editor.putString("contact",contact);
            editor.putString("number",number);
            editor.putString("gender",gender);
            editor.commit();
            finish();
            startActivity(new Intent(Registration.this,MainActivity.class));
        }
    }
}
