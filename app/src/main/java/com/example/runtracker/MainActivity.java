package com.example.runtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button stopButton;
    LocationManager locationManager;
    List<Pair<String,String>> gpsPoints;

    private LocationListener mListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            // Previously mock location is cleared.
            // getLastKnownLocation(LocationManager.GPS_PROVIDER); will not return mock location.
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };



    public void startTracking(View view) {
        switchButton();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Track();
            }
        });


    }

    public void Track(){
        while (true) {

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location;

            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 2000, 10, mListener);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


            String Long = location.getLongitude() + "";
            String Lat = location.getLatitude() + "";
            Pair<String, String> locationPoint = new Pair(Lat, Long);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        gpsPoints.add(locationPoint);


            Log.v("succ", "Succccc");
        }
    }


    public void stopTracking(View view) {
        switchButton();
    }


    public void switchButton() {
        if (startButton.getVisibility() == View.VISIBLE) {
            startButton.setVisibility(View.INVISIBLE);
        } else {
            startButton.setVisibility(View.VISIBLE);
        }
        if (stopButton.getVisibility() == View.VISIBLE) {
            stopButton.setVisibility(View.INVISIBLE);
        } else {
            stopButton.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);


    }

    public void showMap(View view) {

    }

}
