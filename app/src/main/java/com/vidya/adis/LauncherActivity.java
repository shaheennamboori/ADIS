package com.vidya.adis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends AppCompatActivity {

    Button btn_ados,btn_adis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        btn_ados = findViewById(R.id.btn_ados);
        btn_adis = findViewById(R.id.btn_adis);
        btn_ados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this,ADOS.class);
                startActivity(intent);
            }
        });
        btn_adis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}