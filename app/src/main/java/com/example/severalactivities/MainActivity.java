package com.example.severalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnWarhammer;
    private Button btnDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
    }

    private void initElements(){
        btnWarhammer = findViewById(R.id.buttonWarhammer);
        btnDice = findViewById(R.id.buttonDice);

        btnWarhammer.setOnClickListener(WarhammerClickListener);
        btnDice.setOnClickListener(DiceClickListener);
    }

    private View.OnClickListener WarhammerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        initActivitytWh();
        }
    };

    private View.OnClickListener DiceClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            initActivityKosc();
        }
    };


    private void initActivityKosc(){
        Intent DiceActivityIntent = new Intent(this,  KoscActivity.class);
        startActivity(DiceActivityIntent);
    }

    private void initActivitytWh(){
        Intent warhammerActivityIntent = new Intent(this, WarhammerActivity.class);
        startActivity(warhammerActivityIntent);
    }




}