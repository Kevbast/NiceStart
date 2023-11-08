package com.example.practica22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner profesiones;
    private String profesionSeleccionada;
    private TextView vista;
    private EditText nombre, edad;
    private RadioGroup sexo;
    private RadioButton f, m;
    private String sexoSeleccionado;
    private CheckBox h1, h2, h3;
    private String hobbiesSeleccionados;
    private Button enviar, limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profesiones = findViewById(R.id.spinnerProfesion);
        vista = findViewById(R.id.Vista);
        nombre = findViewById(R.id.NameIntro);
        edad = findViewById(R.id.inputEdad);
        //radiobuttons
        sexo = findViewById(R.id.sexo);
        f = findViewById(R.id.femenino);
        m = findViewById(R.id.masculino);
        //checkboxs
        h1 = findViewById(R.id.checkBox1);
        h2 = findViewById(R.id.checkBox2);
        h3 = findViewById(R.id.checkBox3);
        //botones
        enviar = findViewById(R.id.botonEnviar);
        limpiar = findViewById(R.id.botonLimpiar);

        hobbiesSeleccionados = "";
        vista.setText("");

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(
                this, R.array.profesiones2,android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        profesiones.setAdapter(adapter);

        sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.femenino)
                    sexoSeleccionado = "femenino";
                else if (checkedId == R.id.masculino)
                    sexoSeleccionado = "masculino";
            }
        });
        profesiones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                    profesionSeleccionada = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {profesionSeleccionada = "";}
        });

        h1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbiesSeleccionados += h1.getText()+" ";
                else
                    hobbiesSeleccionados = "";
            }
        });

        h2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbiesSeleccionados += h2.getText()+" ";
                else
                    hobbiesSeleccionados = "";
            }
        });

        h3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    hobbiesSeleccionados += h3.getText()+" ";
                else
                    hobbiesSeleccionados = "";
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vista.setText(
                        "Eres "+nombre.getText()+" con edad "+edad.getText()+" tu sexo es "+sexoSeleccionado+"\n"
                                +"Profesión "+profesionSeleccionada+"\n"
                                +"Y hobbies:\n"
                                +hobbiesSeleccionados);
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vista.setText("");
                nombre.setText("");
                edad.setText("");
                f.setChecked(false);
                m.setChecked(false);
                profesiones.setSelection(0);
                h1.setChecked(false);
                h2.setChecked(false);
                h3.setChecked(false);
            }
        });
    }
}