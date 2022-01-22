package com.example.severalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WarhammerActivity extends AppCompatActivity {

    private Button btnEdit;
    private TextView labelrasa;
    private TextView labelName;
    private TextView labelprofesja;
    private TextView labelWW;
    private TextView labelUS;
    private TextView labelZR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warhammer);

        initElements();
    }

    private void initElements(){
        btnEdit = findViewById(R.id.buttonEdit);
        labelName = findViewById(R.id.labelName);
        labelrasa = findViewById(R.id.labelrasa);
        labelprofesja = findViewById(R.id.labelprofesja);
        labelWW = findViewById(R.id.labelWW);
        labelUS = findViewById(R.id.labelUS);
        labelZR = findViewById(R.id.labelZR);

        btnEdit.setOnClickListener(editClickListener);
    }

    private View.OnClickListener editClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         editClick();
        }
    };

    private void editClick(){
        Intent intentWithResult = new Intent(this, WarhammerEditActivity.class);
        intentWithResult.putExtra("sendname",labelName.getText().toString());
        intentWithResult.putExtra("sendrasa",labelrasa.getText().toString());
        intentWithResult.putExtra("sendprofesja",labelprofesja.getText().toString());
        intentWithResult.putExtra("sendww",labelWW.getText().toString());
        intentWithResult.putExtra("sendus",labelUS.getText().toString());
        intentWithResult.putExtra("sendzr",labelZR.getText().toString());
        startActivityForResult(intentWithResult, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                labelName.setText(data.getStringExtra("name"));
                labelrasa.setText(data.getStringExtra("rasa"));
                labelprofesja.setText(data.getStringExtra("profesja"));
                labelWW.setText(data.getStringExtra("WW"));
                labelUS.setText(data.getStringExtra("US"));
                labelZR.setText(data.getStringExtra("ZR"));
            }
        }
    }


}