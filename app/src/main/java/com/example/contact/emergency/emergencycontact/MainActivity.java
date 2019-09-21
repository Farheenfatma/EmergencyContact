package com.example.contact.emergency.emergencycontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sp;
    GridView gridView;
    String arr[]={"Hospital","Fire Station","Police Station","Ambulance","SOS","Help"};
    Integer imgicon[]={R.drawable.hospital,R.drawable.fire,R.drawable.police,R.drawable.ambulance,R.drawable.sos
            ,R.drawable.help_th};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header=navigationView.getHeaderView(0);

        TextView headername=header.findViewById(R.id.userid);
        TextView headeremail=header.findViewById(R.id.useremail);

        SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
        String fname=sp.getString("fname",null);
        String lname=sp.getString("lname",null);
        String useremail=sp.getString("email",null);
        headername.setText(fname+" "+lname);
        headeremail.setText(useremail);


        CustomListAdapter customListAdapter=new CustomListAdapter(this,arr,imgicon);
        sp= getSharedPreferences("pref", Context.MODE_PRIVATE);
        gridView=findViewById(R.id.grid);
        gridView.setAdapter(customListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(MainActivity.this,HospitalMap.class));
                }
                else if(position==1){
                    startActivity(new Intent(MainActivity.this,FireStationMap.class));
                }
                else if(position==2){
                    startActivity(new Intent(MainActivity.this,PoliceMap.class));
                }
                else if(position==3){

                    startActivity(new Intent(MainActivity.this,AmbulanceMap.class));
                }
                else if(position==4){
                    startActivity(new Intent(MainActivity.this,Sos.class));
                }
                else if(position==5){
                    SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
                    String num=sp.getString("number",null);
                    Intent intent=new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+num));
                    startActivity(intent);
                }


            }


        });
    }

    public class CustomListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] itemname;
        private final Integer[] imgid;

        public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
            super(context, R.layout.grid_layout, itemname);
            // TODO Auto-generated constructor stub

            this.context = context;
            this.itemname = itemname;
            this.imgid = imgid;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.grid_layout, null, true);

            TextView txtTitle = rowView.findViewById(R.id.text);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

            txtTitle.setText(itemname[position]);
            imageView.setImageResource(imgid[position]);
            return rowView;

        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,Setting.class));
        }
        else if(id==R.id.share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"share via"));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.rate)
        {
            startActivity(new Intent(MainActivity.this,Rateus.class));

        } else if (id == R.id.feedback)
        {
            startActivity(new Intent(MainActivity.this,Feedback.class));
        } else if (id == R.id.contact)
        {
            startActivity(new Intent(MainActivity.this,Contact.class));
        } else if (id == R.id.setting)
        {
            //finish();
            startActivity(new Intent(MainActivity.this,Setting.class));
        } else if (id == R.id.logout)
        {
            SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.remove("fname");
            editor.commit();
            finish();
            startActivity(new Intent(MainActivity.this,Registration.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
