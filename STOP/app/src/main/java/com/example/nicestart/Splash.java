package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //para cargar la imagen girl
        ImageView mMario=findViewById(R.id.mario);
        Glide.with(this).load("https://i.pinimg.com/originals/c6/3b/32/c63b32aacf8ec3df5fbc92125bc23056.jpg").centerCrop().into(mMario);
        //para foto de perfil etc .circleCrop()
        ImageView mlogo=findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.ic_launcher_foreground).centerCrop().into(mlogo);
    }
}