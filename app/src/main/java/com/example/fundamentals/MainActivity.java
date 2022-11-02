package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up=findViewById(R.id.up);

        up.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                paginaSiguiente();
            }
        });
    }

    public void paginaSiguiente() {
        Intent intent=new Intent(this, Activity_signup.class);
        startActivity(intent);
    }
}
