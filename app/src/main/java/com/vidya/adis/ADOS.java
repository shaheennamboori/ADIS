package com.vidya.adis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ADOS extends AppCompatActivity {

    Button btn_instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ados);

        btn_instructions = findViewById(R.id.btn_instructions);
        btn_instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ADOS.this,InstructionsActivity.class);
                startActivity(intent);
            }
        });
    }
}