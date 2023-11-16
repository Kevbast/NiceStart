package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //lamada metodo
        openApp();
        //para cargar la imagen girl
        ImageView mMario=findViewById(R.id.galaxy);
        Glide.with(this).load("https://i.pinimg.com/originals/c6/3b/32/c63b32aacf8ec3df5fbc92125bc23056.jpg").centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mMario);
        //para foto de perfil etc .circleCrop()
        ImageView mlogo=findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.ic_launcher_foreground).centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(mlogo);
        //Glide.with(this).load(R.drawable.ic_launcher_foreground).centerCrop().into(mlogo);
        /*ANIMATION

                //ROTACIÓN
        Animation rotate = AnimationUtils.loadAnimation(
                this, R.anim.rotate_animation1);

        mlogo.startAnimation(rotate);
                //TRASALADO
        Animation translate = AnimationUtils.loadAnimation(
                this, R.anim.translate_animation1);

        mlogo.startAnimation(translate);
                //ESCALA
        Animation scale = AnimationUtils.loadAnimation(
                this, R.anim.scale_animation1);

        mlogo.startAnimation(scale);*/
                //ALPHA
        Animation alpha = AnimationUtils.loadAnimation(
                this, R.anim.alpha_fade_in_animation1);

        mlogo.startAnimation(alpha);
        /*ANIMACION PARA OTRA IMAGEN
        ImageView marioA=findViewById(R.id.mario);

        Animation alpha2 = AnimationUtils.loadAnimation(
                this, R.anim.alpha_fade_out_animation1);
        marioA.startAnimation(alpha2);*/
    }
    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },7000);
    }

}