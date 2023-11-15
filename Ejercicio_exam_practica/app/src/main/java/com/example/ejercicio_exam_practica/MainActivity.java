package com.example.ejercicio_exam_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText nombre;
private Switch blanco;
private int seekR, seekG, seekB;

private Button mostrar;
private TextView salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre= findViewById(R.id.NombreIntro);
        blanco= findViewById(R.id.Blanco);
        mostrar= findViewById(R.id.mostar);
        salida= findViewById(R.id.salida);

        SeekBar sbR = (SeekBar) findViewById(R.id.Rojo);
        SeekBar sbG = (SeekBar) findViewById(R.id.Verde);
        SeekBar sbB = (SeekBar) findViewById(R.id.Azul);

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekR = progress;
                doSomethingWithColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

// Haz lo mismo para sbG y sbB
        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekG = progress;
                doSomethingWithColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekB = progress;
                doSomethingWithColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    //switch color blanco
        blanco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    salida.setTextColor(Color.WHITE);
                }else{
                    salida.setTextColor(Color.BLACK);
                }
            }
        });


    }
    //Introducir el color y el nombre en el textview
    private void doSomethingWithColor() {
        int color = Color.rgb(seekR, seekG, seekB);
        // Haz algo con el color

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salida.setText(nombre.getText());
                salida.setBackgroundColor(color);

            }
        });

    }

}