package com.example.aleksandra.combined;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

//import mateusz.rutkiewicz.spaceapp.camera_handler.Camera_Handler;

//import mateusz.rutkiewicz.spaceapp.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnCameraButtonClick(View view) {
        Intent intent = new Intent(this, Camera_Handler.class);
        startActivity(intent);
    }

    public void OnGalleryButtonClick(View view) {

    }

    public void OnMapButtonClick(View view) {
    }

    public void OnScoresheetButtonClick(View view) {
        Intent intent = new Intent(this, ScoresheetActivity.class);
        startActivity(intent);
    }
}
