package com.example.user.myapplication;

import android.content.Intent;
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
        showTitle();
    }

    private void showTitle(){
        btn1 = findViewById(R.id.cal);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ex11Activity.this, "계산기", Toast.LENGTH_LONG).show();
                //이동체 생성  ex11에서 calc클래스로 출발지와 목적지 설정(네비설정?).
                Intent intent = new Intent(Ex11Activity.this, CalculatorActivity.class);
                //startActivity메소드안에 intent객체를 넣어 서 보내면 이동한다. (택시?)
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.mp3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ex11Activity.this, "mp3플레이어", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Ex11Activity.this, Mp3playerActivity.class);
                startActivity(intent);
            }
        });

    }
}
