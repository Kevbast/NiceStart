package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//para cargar la imagen girl
        ImageView mGirl=findViewById(R.id.girl);
        Glide.with(this).load(R.drawable.girl).into(mGirl);

    }
    public void openMain(View v){
        Intent intent= new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openRegister(View v) {
        Intent intent= new Intent(Login.this, Register2.class);
        startActivity(intent);
    }
}//fin