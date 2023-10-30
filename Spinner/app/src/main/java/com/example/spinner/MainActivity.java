package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private Spinner dias;
        private TextView mensa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensa=findViewById(R.id.Mensaje);
        dias=findViewById(R.id.dias_semana);
        //Creamos un array de los datos que queremosmque muestre el spinner
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(
                this,R.array.diasemana2, android.R.layout.simple_spinner_item );
        //Especificamos el diseño de la lista que vamos a mostrar
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //asignamos el adaptador a nuestro spinner
        dias.setAdapter(adapter);
        //Le agregamos un escuchador para que pase algo cuando seleccionamos un elemento
        dias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mensa.setText("Selecionaste "+parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            mensa.setText(" ");
            }
        });

    }

}