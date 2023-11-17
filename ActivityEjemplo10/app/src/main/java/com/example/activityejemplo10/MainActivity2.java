package com.example.activityejemplo10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView txt;
Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    txt= findViewById(R.id.textView);
        Intent intent = getIntent();
        String menssage=intent.getStringExtra(MainActivity.mensa);
        txt.setText(menssage);
    boton= findViewById(R.id.volver);
    boton.setOnClickListener(V ->volverAlMain());
    }
    private void volverAlMain(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}