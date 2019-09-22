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


public class HospitalMap extends FragmentActivity implements OnMapReadyCallback,
    GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    LocationListener {

        private GoogleMap mMap;
        GoogleApiClient mGoogleApiClient;
        Location mLastLocation;
        Marker mCurrLocationMarker;
        LocationRequest mLocationRequest;



        private  static final LatLng BhatiaHospital=new LatLng(28.7292602,77.16088549999995);
        private  static final LatLng FortisHospital=new LatLng(28.709597367236213,77.17011451721191);
        private  static final LatLng AanandMaya=new LatLng(28.72927630944663,77.16031908988953);
        private  static final LatLng MaxHospital=new LatLng(28.757115941862555,77.15349555015564);
        private  static final LatLng DevMedical=new LatLng(28.755046685694992,77.15170383453369);
        private  static final LatLng RJHospital=new LatLng(28.762100799674705,77.15209007263184);
        private  static final LatLng FIMSHospital=new LatLng(28.97232896753809,77.06866264343262);
        private  static final LatLng AngmanHealthcare=new LatLng(28.967654553097734,77.08070039749146);
        private  static final LatLng RajHospital=new LatLng(29.027092107406776,77.07448303699493);
        private  static final LatLng JantaHospital=new LatLng(28.924486033302962,77.09475517272949);
        private  static final LatLng ParnamiOrtho=new LatLng(28.879420634916478,77.12106227874756);
        private  static final LatLng NidanHospital=new LatLng(28.97127771200985,77.07655906677246);
        private  static final LatLng VivanHospital=new LatLng(28.8819652,77.1173469);
        private  static final LatLng EsiDespencery=new LatLng(28.8824308,77.1170608);
        private  static final LatLng VijayNursing=new LatLng(28.8827079,77.1168777);
        private  static final LatLng TulipHospital=new LatLng(28.9974455,77.0291791);
        private  static final LatLng CivilHospital=new LatLng(28.9974455,77.0291791);
        private  static final LatLng MukhiHospital=new LatLng(29.0007486,77.022484);
        private  static final LatLng GirdharHospital=new LatLng(29.0007486,77.0224843);
        private  static final LatLng SanjayHospital=new LatLng(28.7333427,77.1577528);
        private  static final LatLng MaxSuper=new LatLng(28.7333427,77.1577528);
        private  static final LatLng BansalHospital=new LatLng(28.7269828,77.1654776);
        private  static final LatLng MaxMulti=new LatLng(28.6994687,77.1487406);
        private  static final LatLng MuniMayaRam=new LatLng(28.6994687,77.1487406);
        private  static final LatLng SantomHospital=new LatLng(28.7079381,77.1396425);
        private  static final LatLng NavjeevanHospital=new LatLng(28.7060937,77.1035936);
        private  static final LatLng BhramShakti=new LatLng(28.7127183,77.0870283);
        private  static final LatLng SanjayGandhi=new LatLng(28.7101588,77.0777586);

        private Marker Bhatiahospital,Fortishospital,Aanandmaya,Maxhospital,Devmedical,RJhospital,FIMShospital,
                AngmanhealthCare,Rajhospital,Jantahospital,parnamiortho,Nidanhospital,Vivanhospital,Esidespencery,Vijaynursing,Tuliphospital,Civilhospital,
                Mukhihospital,Girdharihospital,Sanjayhospital,Maxsuper,Bansalhospital,Maxmulti,Munnimayaram,Santomhospital,Navjeevanhospital,
                Bhramshakti,Sanjaygandhi;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_hospital_map);

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
            Bhatiahospital = mMap.addMarker(new MarkerOptions().position(BhatiaHospital).title("Bhatia Hospital"));
            Fortishospital = mMap.addMarker(new MarkerOptions().position(FortisHospital).title("Fortis Hospital"));
            Aanandmaya = mMap.addMarker(new MarkerOptions().position(AanandMaya).title("Aanand Maya Hospital"));
            Maxhospital = mMap.addMarker(new MarkerOptions().position(MaxHospital).title("Max Hospital"));
            Devmedical = mMap.addMarker(new MarkerOptions().position(DevMedical).title("Dev Medical"));
            RJhospital = mMap.addMarker(new MarkerOptions().position(RJHospital).title("RJ Hospital"));
            FIMShospital = mMap.addMarker(new MarkerOptions().position(FIMSHospital).title("FIMS Hospital"));
            AngmanhealthCare = mMap.addMarker(new MarkerOptions().position(AngmanHealthcare).title("Angman Health Care"));
            Rajhospital = mMap.addMarker(new MarkerOptions().position(RajHospital).title("Raj Hospital"));
            Jantahospital = mMap.addMarker(new MarkerOptions().position(JantaHospital).title("Janta Hospital"));
            parnamiortho = mMap.addMarker(new MarkerOptions().position(ParnamiOrtho).title("Parnami Ortho"));
            Nidanhospital = mMap.addMarker(new MarkerOptions().position(NidanHospital).title("Nidaan Hospital"));
            Vivanhospital = mMap.addMarker(new MarkerOptions().position(VivanHospital).title("Vivan Hospital"));
            Esidespencery = mMap.addMarker(new MarkerOptions().position(EsiDespencery).title("ESI Despencery"));
            Vijaynursing = mMap.addMarker(new MarkerOptions().position(VijayNursing).title("Vijay Nursing"));
            Tuliphospital = mMap.addMarker(new MarkerOptions().position(TulipHospital).title("Tulip Hospital"));
            Civilhospital = mMap.addMarker(new MarkerOptions().position(CivilHospital).title("Civil Hospital"));
            Mukhihospital = mMap.addMarker(new MarkerOptions().position(MukhiHospital).title("Mukhi Hospital"));
            Girdharihospital = mMap.addMarker(new MarkerOptions().position(GirdharHospital).title("Girdhar Hospital"));
            Sanjayhospital = mMap.addMarker(new MarkerOptions().position(SanjayHospital).title("Sanjay Hospital"));
            Maxsuper = mMap.addMarker(new MarkerOptions().position(MaxSuper).title("Max Super Hospital"));
            Maxmulti = mMap.addMarker(new MarkerOptions().position(MaxMulti).title("Max Multi Hospital"));
            Munnimayaram = mMap.addMarker(new MarkerOptions().position(MuniMayaRam).title("Munni Maya Ram Hospital"));
            Santomhospital = mMap.addMarker(new MarkerOptions().position(SantomHospital).title("Santom Hospital"));
            Bansalhospital = mMap.addMarker(new MarkerOptions().position(BansalHospital).title("Bansal Hospital"));
            Navjeevanhospital = mMap.addMarker(new MarkerOptions().position(NavjeevanHospital).title("Navjeevan Hospital"));
            Bhramshakti = mMap.addMarker(new MarkerOptions().position(BhramShakti).title("Bhram Shakti Hospital"));
            Sanjaygandhi = mMap.addMarker(new MarkerOptions().position(SanjayGandhi).title("Sanjay Gandhi Hospital"));


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
