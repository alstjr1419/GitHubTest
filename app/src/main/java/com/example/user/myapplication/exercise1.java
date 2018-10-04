package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class exercise1 extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        init();
    }
    private void init(){
        btn1 = findViewById(R.id.mainCalc);
        btn2 = findViewById(R.id.mainPlayer);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(exercise1.this,R.string.calcTitle,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(exercise1.this,exercise2.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.mainPlayer);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(exercise1.this,R.string.mp3_player_title,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(exercise1.this, exercise3.class);
                startActivity(intent);
            }
        });
    }
}
