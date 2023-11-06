package com.example.practica21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ContadorClics;
    Button BotonSuma;
    Button BotonResta;
    Button Reset;
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContadorClics=findViewById(R.id.ContadorClics);
        BotonSuma=findViewById(R.id.Suma);
        BotonResta=findViewById(R.id.Resta);
        Reset=findViewById(R.id.Borrador);
        BotonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                ContadorClics.setText(Integer.toString(contador));
            }
        });
        BotonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador--;
                ContadorClics.setText(Integer.toString(contador));
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=0;
                ContadorClics.setText(Integer.toString(contador));
            }
        });

    }
}