package com.example.contact.emergency.emergencycontact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FireStationMap extends FragmentActivity implements OnMapReadyCallback ,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;



    private  static final LatLng JahagirpuriFire=new LatLng(28.72604456905627,77.16229319572449);
    private  static final LatLng Jahagirpuri=new LatLng(28.73404141539209,77.17482447624207);
    private  static final LatLng Wazirpur=new LatLng(28.73404141539209,77.17482447624207);
    private  static final LatLng MauriceNagar=new LatLng(28.73404141539209,77.17482447624207);
    private  static final LatLng RaniJhasi=new LatLng(28.6649659,77.1985485);
    private  static final LatLng Rakabganj=new LatLng(28.6399596,77.2055866);
    private  static final LatLng Mathuraroad=new LatLng(28.6399596,77.2055866);
    private  static final LatLng Okhla=new LatLng(28.6176598,77.103963);
    private  static final LatLng Bawana=new LatLng(28.8787871,77.104649);
    private  static final LatLng HSIIDC=new LatLng(28.9473077,77.1139187);
    private  static final LatLng Sector53=new LatLng(28.9473077,77.1139187);
    private  static final LatLng Sonepat=new LatLng(28.9789211,76.9365819);
    private  static final LatLng PaschimVihar=new LatLng(28.9789211,76.9365819);

    private Marker Jahagirpurifire,jahagirPuri,WazirpurFire,Maurice,Ranijhansi,RakabGanj,MathuraRoad,
            OkhlaFire,BawanaFire,Hsiidc,sector53,sonepat,Paschimvihar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_station_map);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Jahagirpurifire = mMap.addMarker(new MarkerOptions().position(JahagirpuriFire).title("Jahagirpuri Fire Station"));
        jahagirPuri = mMap.addMarker(new MarkerOptions().position(Jahagirpuri).title("JahagirPuri Fire Station"));
        WazirpurFire = mMap.addMarker(new MarkerOptions().position(Wazirpur).title("Wazipur Fire Station"));
        Maurice = mMap.addMarker(new MarkerOptions().position(MauriceNagar).title("Maurice Fire Station"));
        Ranijhansi = mMap.addMarker(new MarkerOptions().position(RaniJhasi).title("RaniJhansi Road Fire Station"));
        RakabGanj = mMap.addMarker(new MarkerOptions().position(Rakabganj).title("Rakabganj Fire Station"));
        MathuraRoad = mMap.addMarker(new MarkerOptions().position(Mathuraroad).title("Mathura Road Fire Station"));
        OkhlaFire = mMap.addMarker(new MarkerOptions().position(Okhla).title("Okhla Fire Station"));
        BawanaFire = mMap.addMarker(new MarkerOptions().position(Bawana).title("Bawana Fire Station"));
        Hsiidc = mMap.addMarker(new MarkerOptions().position(HSIIDC).title("HSIIDC Fire Station"));
        sector53 = mMap.addMarker(new MarkerOptions().position(Sector53).title("Sector 53 Fire Station"));
        sonepat = mMap.addMarker(new MarkerOptions().position(Sonepat).title("Sonepat Fire Station"));
        Paschimvihar = mMap.addMarker(new MarkerOptions().position(PaschimVihar).title("Sonepat Fire Station"));


        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

        }
    }
}
