package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Register2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        //IMAGEN CHICO
        //para cargar la imagen girl
        ImageView mChico=findViewById(R.id.chico_image);
        Glide.with(this).load(R.drawable.chico).into(mChico);

        //LOGO
        ImageView mlogo=findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.prickly_pear_svgrepo_com).centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(mlogo);
    }
    public void openLogin(View v) {
        Intent intent= new Intent(Register2.this, Login.class);
        startActivity(intent);
    }
    public void openSplash(View v) {
        Intent intent= new Intent(Register2.this, Splash.class);
        startActivity(intent);
    }
}