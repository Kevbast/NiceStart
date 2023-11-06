package com.example.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre;
    private EditText Edad;

    private Spinner profesiones;
    private RadioButton fem,masc;
    private RadioGroup grupo;

    private CheckBox h1,h2,h3;

    private Button Enviar;
    private Button Limpiar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre= findViewById(R.id.NombreIntro);


    }
}