package com.example.omantrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ntrip,aboutus,out860;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ntrip = findViewById(R.id.ntrip);
        aboutus = findViewById(R.id.aboutus);
        out860 = findViewById(R.id.out860);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8601=new Intent(MainActivity.this,AboutUsPage.class);
                startActivity(intent8601);
                finish();
            }
        });
        ntrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8602=new Intent(MainActivity.this,netrip.class);
                startActivity(intent8602);
                finish();
            }
        });
        out860.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // out of the system
                finish();
                System.exit(0);
            }
        });
    }
}