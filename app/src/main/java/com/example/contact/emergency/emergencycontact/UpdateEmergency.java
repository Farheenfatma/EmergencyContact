package com.example.contact.emergency.emergencycontact;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class UpdateEmergency extends AppCompatActivity {
    EditText EmergemcyCon,EmergencyNum;
    String Emergenmcycontact,EmergencyNumber;
    SharedPreferences sp;
    String emergencycname,emergencynumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_emergency);
        EmergemcyCon=findViewById(R.id.emergencycon);
        EmergencyNum=findViewById(R.id.emergencynum);
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
            startActivity(new Intent(UpdateEmergency.this,Setting.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void click(View view) {
        if(view.getId()==R.id.update)
        {

            Emergenmcycontact=EmergemcyCon.getText().toString();
            EmergencyNumber=EmergencyNum.getText().toString();
            if(Emergenmcycontact.equals("")){
                EmergemcyCon.setError("Enter Details");
            }
            if(EmergencyNumber.equals("")){
                EmergemcyCon.setError("Enter Details");
            }
            else {
                sp = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("contact", Emergenmcycontact);
                editor.putString("number", EmergencyNumber);
                editor.commit();
                finish();
                startActivity(new Intent(this, Setting.class));
            }
        }
        else if(view.getId()==R.id.home){
            finish();
            startActivity(new Intent(UpdateEmergency.this,MainActivity.class));
        }
    }
}
