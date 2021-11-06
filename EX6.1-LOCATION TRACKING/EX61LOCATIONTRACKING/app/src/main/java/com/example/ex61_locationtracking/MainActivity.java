package com.example.ex61_locationtracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener{
    Button coord;
    TextView lat, lon;
    LocationManager lmanager;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coord = findViewById(R.id.coord);
        lat = findViewById(R.id.lat);
        lon = findViewById(R.id.lon);
        coord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                provider = lmanager.getBestProvider(criteria,false);
                if (provider != null && !provider.equals("")) {

                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Location location = lmanager.getLastKnownLocation(provider);
                    lmanager.requestLocationUpdates(provider, 20000, 1, (LocationListener) MainActivity.this);
                    if(location!=null){
                        onLocationChanged(location);
                    }else{
                        Toast.makeText(MainActivity.this, "Location not available", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No provider Found", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {

            TextView lat=(TextView)findViewById(R.id.lat);
            TextView lon=(TextView)findViewById(R.id.lon);
            lat.setText("Latitude :"+location.getLatitude());
            lon.setText("Longitude :"+location.getLongitude());
        }
    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
    }
    @Override
    public void onFlushComplete(int requestCode) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }
    @Override
    public void onProviderDisabled(@NonNull String provider) {
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
    }



