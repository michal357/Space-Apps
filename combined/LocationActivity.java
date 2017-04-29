package com.example.aleksandra.combined;


//slawek
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
        import android.Manifest;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.location.LocationListener;
        import android.support.v4.app.ActivityCompat;
        import android.location.LocationManager;
        import android.provider.Settings;
        import android.content.Intent;
        import android.widget.Toast;
        import android.support.v4.content.ContextCompat;
        import android.content.Context;

public class LocationActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private double longitude = 0, latitude = 0;
    private  Location location = null;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 1, this);
                location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
            }
            else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        2000, 1, this);
                location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
            }

            if(location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                // Toast.makeText(this, "Latitude: " + location.getLatitude() + "\nLongitude: " + location.getLongitude(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                Toast.makeText(this, "Location is disabled", Toast.LENGTH_LONG).show();
            }
            else{

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);

            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {

        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "GPS is turned off" +
                        " ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        Toast.makeText(getBaseContext(), "GPS is turned on",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    public Location getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }
}