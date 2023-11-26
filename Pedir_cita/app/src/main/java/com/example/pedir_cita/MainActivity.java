package com.example.pedir_cita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendar;
    private TextView date_view;
    int dayOfWeek,Date;
    private Button enviar;
    private EditText dni;
    private EditText hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView) findViewById(R.id.calendar);
        date_view = (TextView) findViewById(R.id.date_view);
        enviar= findViewById(R.id.enviar);
        dni= findViewById(R.id.dniIntro);
        hora= findViewById(R.id.hora);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;

            }
        });
         enviar.setOnClickListener(new View.OnClickListener() {
             String palabra =hora.getText().toString();
             int hora1=Integer.parseInt(palabra);
             @Override
             public void onClick(View v) {
                 if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                     errorfecha();
                 } else if(dni.getText().length()!=9){

                     errorDNI();
                 }else if(!(hora1 >= 9 && hora1 <= 14)){
                    errorHora();
                     }
                 }
         });
    }

    protected void errorfecha() {
        Toast.makeText(this,"No hay citas disponibles los sábados y domingos",Toast.LENGTH_SHORT).show();
    }

    protected void errorHora(){
        Toast.makeText(this,"La hora indicada está mal",Toast.LENGTH_SHORT).show();
    }
    protected void errorDNI(){
        /*public class ValidadorDNI {
            private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

            public static boolean validar(String dni) {
                // Comprueba si el DNI tiene 9 caracteres
                if (dni.length() != 9) {
                    return false;
                }

                // Extrae los números y la letra del DNI
                String numeros = dni.substring(0, 8);
                char letra = Character.toUpperCase(dni.charAt(8));

                // Comprueba si la parte numérica son solo dígitos
                try {
                    int numeroDNI = Integer.parseInt(numeros);
                } catch (NumberFormatException e) {
                    return false;
                }

                // Calcula la letra del DNI
                int indice = Integer.parseInt(numeros) % 23;
                char letraCalculada = LETRAS_DNI.charAt(indice);

                // Comprueba si la letra calculada coincide con la letra del DNI
                return letra == letraCalculada;
            }
        }*/
        Toast.makeText(this,"El DNI está mal",Toast.LENGTH_SHORT).show();
    }
    protected void mensaEnviado(){
        Toast.makeText(this,"La cita ha sido medida con éxito",Toast.LENGTH_SHORT).show();
    }
}
