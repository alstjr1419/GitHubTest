package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintStarActivity extends AppCompatActivity {
    private EditText et;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_star);
        getSupportActionBar().setTitle("print star");
        printStar();
        }
        //엔터 누르면 기존의 숫자 삭제되게 만들기

    private void printStar(){
        et = findViewById(R.id.edittext);
        btn  = findViewById(R.id.button);
        tv = findViewById(R.id.textview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = et.getText().toString();
                int starRow = integer(value);
                if(starRow>0) {
                    String star = "";
                    for (int i = 1; i <= starRow; i++) {
                        for (int j = 0; j < i; j++) {
                            star += "*";
                        }
                        star += "\n";
                    }
                    tv.setText(star);
                    et.setText("");
                }


            }
        });
    }
    private int integer(String s){
        int result = 0;
        try {
            result = Integer.parseInt(s);
        }catch (Exception e){
        }

        return result;
    }
    }

