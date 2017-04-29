package com.example.admin.mapa;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.LinkedList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<String> photos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        photos =new LinkedList<>();
        photos.add("p54.3485313,18.6510234.jpg");
        photos.add("p54.3505622,18.6553128.jpg");
        photos.add("p54.3900786,18.6731029.jpg");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addingMarkers();
        LatLng Gdansk = new LatLng(54.3520500, 18.6463700);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                reaction(marker);
                return true;
            }
        }
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Gdansk));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Gdansk, 12.0f));

    }
    private void reaction(Marker marker){
        Intent i=new Intent(this,PrintingOut.class);
        i.putExtra("name",marker.getTitle());
        startActivity(i);
    }
    private void addingMarkers(){
        for(int i = 0; i< photos.size(); i++){
            String[] location= photos.get(i).split(",");
            double latitude=Double.parseDouble(location[0]
            .substring(1,location[0].length()));
            double longitude=Double.parseDouble(location[1]
                    .substring(0,location[1].length()-4));
            LatLng latLng=new LatLng(latitude,longitude);
            mMap.addMarker(new MarkerOptions().position(latLng).title(photos.get(i)));
        }
    }
}
