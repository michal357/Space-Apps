package com.example.admin.mapa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class PrintingOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing_out);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String imageName=getIntent().getStringExtra("name");
        ImageView imageView=(ImageView)findViewById(R.id.image);
        if(imageName.equals("p54.3485313,18.6510234.jpg")){
            imageView.setImageResource(R.drawable.neptun);
        }else if(imageName.equals("p54.3505622,18.6553128.jpg")){
            imageView.setImageResource(R.drawable.gdanskwieczorowapora);
        }else{
            imageView.setImageResource(R.drawable.stadion);
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
