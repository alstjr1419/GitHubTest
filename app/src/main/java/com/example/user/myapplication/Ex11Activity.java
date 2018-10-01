package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ex11Activity extends AppCompatActivity {
    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11);

    }

    private void init(){
        btn1 = findViewById(R.id.cal);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ex11Activity.this, "버튼1", Toast.LENGTH_LONG).show();
            }
        });
        btn2 = findViewById(R.id.mp3);
        btn2.setOnClickListener(new Button2());

    }
    class Button2 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Toast.makeText(Ex11Activity.this, "버튼2", Toast.LENGTH_LONG).show();
        }
    }
}
