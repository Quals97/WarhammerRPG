package com.example.severalactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KoscActivity extends AppCompatActivity {
    private Button btnRoll;
    private ImageView imgDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosc);
        initElements();
    }


    private void initElements(){
        btnRoll = findViewById(R.id.buttonroll);
        imgDice=findViewById(R.id.imageView);
        btnRoll.setOnClickListener(RollWithToastListener);
    }

    private View.OnClickListener RollWithToastListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rollWithToast();
        }
    };


    private void rollWithToast(){
        int dice =roll();
        imgDice.setVisibility(View.VISIBLE);
        setImg(dice);
        Toast.makeText(KoscActivity.this, "Wylosowałeś "+dice, Toast.LENGTH_SHORT).show();
    }


    private void setImg(int d){
        if(d==1){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll1));
        }
        if(d==2){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll2));
        }
        if(d==3){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll3));
        }
        if(d==4){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll4));
        }

        if(d==5){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll5));
        }

        if(d==6){
            imgDice.setImageDrawable(getResources().getDrawable(R.drawable.roll6));
        }

    }


    private int roll(){
        return (int)((Math.random() * 6)+1);
    }


}