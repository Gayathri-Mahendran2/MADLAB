package com.example.ex62_locationofplace;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button coord;
    TextView lat,lon;
    EditText place;
    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place=(EditText)findViewById(R.id.place);
        coord=(Button)findViewById(R.id.coord);
        lat=(TextView)findViewById(R.id.lat);
        lon=(TextView)findViewById(R.id.lon);
        coord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Geocoder geocoder=new Geocoder(getBaseContext(), Locale.getDefault());
                List<Address> address;
                try {
                    address=geocoder.getFromLocationName(place.getText().toString(),1);
                    if(address.size()>=0){
                        latitude=address.get(0).getLatitude();
                        longitude=address.get(0).getLongitude();
                        lat.setText("Latitude:"+latitude);
                        lon.setText("Longitude:"+longitude);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}