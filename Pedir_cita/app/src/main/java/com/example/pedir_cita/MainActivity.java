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

         enviar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                     @Override
                     public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                         Calendar calendar = Calendar.getInstance();
                         calendar.set(year, month, dayOfMonth);

                         int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                         if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                             errorfecha();
                         } else {
                             String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                             date_view.setText(Date);
                         }
                     }
                 });
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
        Toast.makeText(this,"El DNI está mal",Toast.LENGTH_SHORT).show();
    }
    protected void mensaEnviado(){
        Toast.makeText(this,"La cita ha sido medida con éxito",Toast.LENGTH_SHORT).show();
    }
}
