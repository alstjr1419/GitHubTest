package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    //constraint 공부하기
    EditText firstInput, secondInput;
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
        //밑처럼 string xml에 삽입하여 구현한다.
        getSupportActionBar().setTitle(R.string.calcTitle);
        firstInput = findViewById(R.id.firstInput);
        firstInput.setShowSoftInputOnFocus(false);
        secondInput = findViewById(R.id.secondInput);
        secondInput.setShowSoftInputOnFocus(false);
        operator = findViewById(R.id.operator);
        result = findViewById(R.id.result);
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
    //쌤 코드
    private int intParseFormString(String v){
        int result = -1;
        try{
            result = Integer.parseInt(v);
        }catch (Exception e){

        }
        return  result;
    };

    private String doCalc(String v1, String v2, String calcSymbol){
        String result  = "";
        int intv1 = intParseFormString(v1);
        int intv2 = intParseFormString(v2);


        switch (calcSymbol){
            case "+" :
                result = Integer.toString(intv1 + intv2);
                break;
            case "-" :
                result = Integer.toString(intv1 - intv2);
                break;
            case "*" :
                result = Integer.toString(intv1 * intv2);
                break;
            case "/" :
                if(intv2==0){
                    result = "div 0";
                }else{
                    result = Double.toString((double)intv1 / intv2);
                }
                break;
        }


        return  result;
    };
    //숫자 버튼 이벤트
    public  void clkNobtn(View v){
        //log를 이용하여 부분 테스트가 가능하다 .
        Log.i("test","이벤트 연결 성공");
        String calcSymbol = operator.getText().toString();
        if(v.getId() == R.id.btn_equal){
            String val_1 = firstInput.getText().toString();
            String val_2 = secondInput.getText().toString();
                //셋중 하나라도 빈칸이면
            if(calcSymbol.equals("") || val_1.equals("") || val_2.equals("")){
                result.setText("incomplete"); //출력
            }else{
                String result = doCalc(val_1, val_2, calcSymbol);
                //result 가 textView로 잡혀야하는데 여기서는 코드가 달라 중복이 되어 숨겻다
                //result.setText(result);
            }
        }else{

            EditText target = null;
            //입력할 exitText결정
            if(calcSymbol.equals("")){
                target = firstInput;
            }else{
                target = secondInput;
            }

            if(target != null){
                //v의 객체가 button형변환이 가능한지 확인후
                if(v instanceof  Button){
                    //누른 버튼의 값 button 형변환
                    Button b = (Button) v;
                    //b객체의 text값을 가져와 string으로 변환하여 string 객체의 pressNo에 담는다.
                    String pressNo = b.getText().toString();

                    //기존에 있던 값을 existvalue에 담는다.
                    String existValue = target.getText().toString();
                    existValue += pressNo;

                    //합친 텍스트 값을 다시 타겟에 입력
                    target.setText(existValue);
                }

            }
        }

    }


    public void clkLeftBtn(View v){
        Log.i("test","이벤트 연결 성공");
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
                        if(firstInput.getText().toString().equals("0")||secondInput.getText().toString().equals("0")){
                            result.setText("div 0");
                            //return !!!! 대박 스 메소드 종료 구문
                            return;
                        }else {
                            res = (double) fir / (double) sed;

                        }
                     }

                    String resu = formatUtil(res);
                     result.setText(resu);
                }else{
                    result.setText("incomplete");
                }
            }

            if(operator.getText().toString().equals("")){
                if(num.equals("=")){

                }else{
                    firstText += num;
                    firstInput.setText(firstText);
                }

            }else{
                if(num.equals("=")){

                }else{
                    secondText += num;
                    secondInput.setText(secondText);
                }

            }


        }
    }
    //double형 결과물의 소수점 단위 구분해서 없으면 소수점 버리고 스트링 변환
    private String formatUtil(double result){
        if(result == (long)result){
            return String.format("%d",(long)result);
        }else{
           return String.format("%s",result);
        }

    }

}
