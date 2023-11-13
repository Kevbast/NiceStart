package com.example.propina;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private EditText cantidad;
private RadioGroup radio;
private Button ok;
private Button del;
private TextView texto;

private StringBuilder numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad=findViewById(R.id.textoIntro);
        cantidad.setInputType(InputType.TYPE_NULL);//para que no aparezca el teclado si clicamos en el edittext
        radio=findViewById(R.id.GRUPO);
        ok=findViewById(R.id.botonOk);
        texto=findViewById(R.id.txt);
        numeros= new StringBuilder();
        del=findViewById(R.id.botonBorrar);
        //Para crear nosotros nuestro pad numérico
        //Asignamos clic a cada boton
        for (int i=0;i<9;i++){
            //para saber que boton es
            int botonId=getResources().getIdentifier("boton"+i,"id",getPackageName());
            //le proporciona acceso al xml(getResources),y el package todar el paquete de la aplicación
            Button boton=findViewById(botonId);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button b=(Button) view;
                    //Lo guarda aquí cada vez que lo vamos pulsando(solo lo hace una vez)
                    numeros.append(b.getText().toString());
                    //Vamos a crear una funcion que vaya pasando de uno a otro,se va a hacer fuera del proyect void
                actualizardorEdit();
                }
            });

        }
        //boton borrar
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numeros.length()>0){
                    numeros.deleteCharAt(numeros.length()- 1);//-1 para que me quite el anterior
                    actualizardorEdit();//lo llamamos para que se actulice
                }
            }
        });
        //boton aceptar
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularProp();
            }
        });

    }//final proyect void 1


    private void actualizardorEdit()
    {
    cantidad.setText(numeros.toString());
    }
    private void calcularProp(){
        String cantiSTR= cantidad.getText().toString();
        if(cantiSTR.isEmpty()){
            texto.setText("Por favor, introduce cuanto ha pagado");

        }
        double cantidadPagar= Double.parseDouble(cantiSTR);
        int calidad=radio.getCheckedRadioButtonId();
        double propmulti= 1;
        if(radio.getCheckedRadioButtonId()==-1){
            texto.setText("Selecciona la calidad del servicio");
            return;}

        if(calidad== R.id.malo){
            propmulti=0;
        }
        else if (calidad==R.id.regular) {
            propmulti=0.05;
        }else if (calidad==R.id.bueno) {
            propmulti=0.1;
        }else if (calidad==R.id.excelente) {
            propmulti=0.2;
        }else {
            texto.setText("Diga la calidad del servicio");
        }
        double propina=cantidadPagar *propmulti;
        texto.setText("La propina es: "+propina+" $");

    }

}//Final de actividad