package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    //constraint 공부하기
    EditText firstInput,secondInput;
    TextView operator, result;
    TextView tv_calc_operator;
    String firstText = "";
    String secondText = "";
    String opt = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();


    }

    private void init(){
        getSupportActionBar().setTitle("계산기");
        firstInput = findViewById(R.id.firstInput);
        firstInput.setShowSoftInputOnFocus(false);
        secondInput = findViewById(R.id.secondInput);
        secondInput.setShowSoftInputOnFocus(false);
        operator = findViewById(R.id.operator);
        result = findViewById(R.id.result);
        tv_calc_operator = findViewById(R.id.operator);
    }

    public void clkRightBtn(View v){
        if(v instanceof Button){
            //강제형변환 및 버튼에 삽입
            Button b = (Button)v;
            //string 형변환
            opt = b.getText().toString();
            if(opt.equals("c")){
                firstInput.setText("");
                secondInput.setText("");
                operator.setText("");
                result.setText("");
                firstText = "";
                secondText = "";
            }else{
                tv_calc_operator.setText(opt);
            }
        }
    }

    public void clkLeftBtn(View v){
        if(v instanceof Button){
            Button b = (Button)v;
            String num = b.getText().toString();
            double res =0;

            if(num.equals("=")){
                if(firstText != "" && secondText != ""){
                    int fir = Integer.parseInt(firstText);
                    int sed = Integer.parseInt(secondText);
                     if(opt.equals("+")){
                         res = fir + sed;
                     }else if(opt.equals("-")){
                         res = fir - sed;
                     }else if(opt.equals("*")){
                         res = fir * sed;
                     }else if(opt.equals("/")){
                         res = (double)fir * (double)sed;
                     }
                     res.format
                    String resu = Double.toString(res);
                     result.setText(resu);
                }
            }

            if(operator.getText().toString().equals("")){
                firstText += num;
                firstInput.setText(firstText);
            }else{
                secondText += num;
                secondInput.setText(secondText);
            }


        }
    }

}
