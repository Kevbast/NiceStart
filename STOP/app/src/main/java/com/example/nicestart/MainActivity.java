package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView= findViewById(R.id.video);
        String enlace= "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uItM9iB_EY8?si=YUQvSDjN-W3zS9ve\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(enlace,"text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
    }
    public void openLogin(View v) {
        Intent intent= new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
    public void openRegister(View v) {
        Intent intent= new Intent(MainActivity.this, Carga_Register.class);
        startActivity(intent);
    }
    public void openNonepeople(View v) {
        Intent intent= new Intent(MainActivity.this, Nopeople.class);
        startActivity(intent);
    }
}