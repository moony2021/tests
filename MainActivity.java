package com.example.assignmentq1;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class MainActivity extends Activity {
    public static final double KAABA_ALTITUDE = 21.422811;
    public static final double KAABA_LONGITUDE = 39.826175;
    private double myAltitude, myLongitude;
    private TextView tvDistanceToKaaba;
    private Button btnDistanceToKaaba;
    private LocationManager locationManager;
    private LocationListener netListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLocationListener();
        setButtonListener();
    }
    public void setLocationListener() {
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        netListener = new LocationListener() {

            public void onLocationChanged( Location location) {
                myLongitude = location.getLongitude();
                myAltitude = location.getAltitude();
            }
@Override
            public void onStatusChanged(String provider,int status,Bundle extras){}
            @Override
            public void onProviderEnabled (String provider){}
            @Override
            public void onProviderDisabled(String provider)
            {}
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION )!= getPackageManager().PERMISSION_GRANTED)&&
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION )!= getPackageManager().PERMISSION_GRANTED)
       return;}


        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, netListener);
    }


        private void setButtonListener () {
            btnDistanceToKaaba = findViewById(R.id.btn_distance_to_Kaaba);
            btnDistanceToKaaba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float[] results = new float[2];
                    Location.distanceBetween(myAltitude, myLongitude, KAABA_ALTITUDE, KAABA_LONGITUDE, results);
                    tvDistanceToKaaba = findViewById(R.id.tv_distance_to_kaaba);
                    tvDistanceToKaaba.setText("The distance to Holy Mosque is " + Float.toString(Math.round(results[0] / 1000)) + " km");
                }
            });
        }