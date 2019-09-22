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

public class PoliceMap extends FragmentActivity implements OnMapReadyCallback ,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;



    private  static final LatLng jahagirpuri=new LatLng(28.733683922385644,77.17526435852051);
    private  static final LatLng Muaricenagar=new LatLng(28.68485583073565,77.20262289047241);
    private  static final LatLng Shalimarbhag=new LatLng(28.68485583073565,77.20262289047241);
    private  static final LatLng AdarshNagar=new LatLng(28.70996435246745,77.17522144317627);
    private  static final LatLng ModalTown=new LatLng(28.7048169,77.1885148);
    private  static final LatLng SwroopNagar=new LatLng(28.7670571,77.1373276);
    private  static final LatLng Alipur=new LatLng(28.8114379,77.1314911);
    private  static final LatLng KundliPolice=new LatLng(28.86421909711043,77.12443113327026);
    private  static final LatLng Raipolice=new LatLng(28.8626212,77.0636822);
    private  static final LatLng Bahalghar=new LatLng(28.9572907,77.0609356);
    private  static final LatLng Sonepat=new LatLng(28.9840229,77.0441128);
    private  static final LatLng sector7=new LatLng(28.984455178725504,77.07943439483643);
    private  static final LatLng Sadarpolice=new LatLng(28.995716640299303,77.00958967208862);

    private Marker jahagirpuriPolice,Muarice,ShalimarbhagPolice,AdarshNagarPolice,ModaltownPolice,SwroopNagarPolice,AlipurPolice,
            Kundli,Rai,BahalgharPolice,SonepatPolice,Sector7,SadarPolice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_map);

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
        jahagirpuriPolice = mMap.addMarker(new MarkerOptions().position(jahagirpuri).title("JahagirPolice Station"));
        Muarice = mMap.addMarker(new MarkerOptions().position(Muaricenagar).title("Muarice Nagar Police Station"));
        ShalimarbhagPolice = mMap.addMarker(new MarkerOptions().position(Shalimarbhag).title("Shalimar Bagh Police Station"));
        AdarshNagarPolice = mMap.addMarker(new MarkerOptions().position(AdarshNagar).title("Adarsh Nagar POlice Station"));
        ModaltownPolice = mMap.addMarker(new MarkerOptions().position(ModalTown).title("Modal Town Police Station"));
        SwroopNagarPolice = mMap.addMarker(new MarkerOptions().position(SwroopNagar).title("Swroop Nagar Police Station"));
        AlipurPolice = mMap.addMarker(new MarkerOptions().position(Alipur).title("AlipurPolice Station"));
        Kundli = mMap.addMarker(new MarkerOptions().position(KundliPolice).title("Kundli Police Station"));
        Rai = mMap.addMarker(new MarkerOptions().position(Raipolice).title("Rai Police Station"));
        BahalgharPolice = mMap.addMarker(new MarkerOptions().position(Bahalghar).title("Bahalghar Police Station"));
        SonepatPolice = mMap.addMarker(new MarkerOptions().position(Sonepat).title("Sonepat Police Station"));
        Sector7 = mMap.addMarker(new MarkerOptions().position(sector7).title("Sector-7 Police Station"));
        SadarPolice = mMap.addMarker(new MarkerOptions().position(Sadarpolice).title("Sadar Police Station"));



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
