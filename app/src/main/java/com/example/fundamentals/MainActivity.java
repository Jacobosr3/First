package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button cancel;
    TextView up;
    EditText username, password, email;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up=findViewById(R.id.text);
        cancel=findViewById(R.id.cancel);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        up.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                paginaSiguiente();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                email.setText("");
                password.setText("");

            }
        });

        ImageView girl = findViewById(R.id.fondo);
        Glide.with(this)
                .load(R.drawable.girl)
                //.centerCrop()
                .into(girl);

        //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo
        ImageView logo = findViewById(R.id.ancla);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.expand);
        logo.startAnimation(myanim);
    }

    public void paginaSiguiente() {
        Intent intent=new Intent(this, Activity_signup.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //no volver para atras
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
