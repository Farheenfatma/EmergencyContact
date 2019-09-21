package com.example.contact.emergency.emergencycontact;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Sos extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        intent=new Intent(Intent.ACTION_DIAL);
         android.support.v7.widget.Toolbar toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home);
        {finish();}
        return super.onOptionsItemSelected(item);
    }



    public void call(View view) {
        if(view.getId()==R.id.police){

            intent.setData(Uri.parse("tel:100"));
            startActivity(intent);
        }
        else if(view.getId()==R.id.ambulance){
            intent.setData(Uri.parse("tel:102"));
            startActivity(intent);
        }
        else if(view.getId()==R.id.fire){
            intent.setData(Uri.parse("tel:101"));
            startActivity(intent);
        }
        else if(view.getId()==R.id.button4){
            finish();
            startActivity(new Intent(Sos.this,MainActivity.class));
        }
    }
}
