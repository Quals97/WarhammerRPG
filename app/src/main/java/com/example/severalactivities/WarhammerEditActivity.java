package com.example.severalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WarhammerEditActivity extends AppCompatActivity {
    private Button btnSave;
    private EditText edtname;
    private EditText edtrasa;
    private EditText edtprofesja;
    private EditText edtWW;
    private EditText edtUS;
    private EditText edtZR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warhammer_edit);

        initElements();
    }

    private void initElements(){
        btnSave = findViewById(R.id.buttonSave);
        edtname = findViewById(R.id.editTextName);
        edtrasa = findViewById(R.id.editTextrasa);
        edtprofesja = findViewById(R.id.editTextprofesja);
        edtWW = findViewById(R.id.editTextWW);
        edtUS = findViewById(R.id.editTextUS);
        edtZR = findViewById(R.id.editTextZR);
        getIntentFromActivity();
        btnSave.setOnClickListener(saveClickListener);
    }

    private void getIntentFromActivity(){
        Intent intent = getIntent();
        edtname.setText(intent.getStringExtra("sendname"));
        edtrasa.setText(intent.getStringExtra("sendrasa"));
        edtprofesja.setText(intent.getStringExtra("sendprofesja"));
        edtWW.setText(intent.getStringExtra("sendww"));
        edtUS.setText(intent.getStringExtra("sendus"));
        edtZR.setText(intent.getStringExtra("sendzr"));
    }

    private View.OnClickListener saveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveClick();
        }
    };

    private void saveClick(){
        Intent sendInfoBack = new Intent();
        sendInfoBack.putExtra("name", edtname.getText().toString());
        sendInfoBack.putExtra("rasa", edtrasa.getText().toString());
        sendInfoBack.putExtra("profesja", edtprofesja.getText().toString());
        sendInfoBack.putExtra("WW", edtWW.getText().toString());
        sendInfoBack.putExtra("US", edtUS.getText().toString());
        sendInfoBack.putExtra("ZR", edtZR.getText().toString());
        setResult(RESULT_OK, sendInfoBack);
        finish();
    }



}