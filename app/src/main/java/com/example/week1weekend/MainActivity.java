package com.example.week1weekend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvEquation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEquation = findViewById(R.id.tvEquation);

    }

    public void onClickHandler(View view) {
        switch (view.getId()){
            case R.id.btn0 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "0");
                break;
            case R.id.btn1 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "1");
                break;
            case R.id.btn2 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "2");
                break;
            case R.id.btn3 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "3");
                break;
            case R.id.btn4 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "4");
                break;
            case R.id.btn5 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"" )+ "5");
                break;
            case R.id.btn6 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"" )+ "6");
                break;
            case R.id.btn7 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "7");
                break;
            case R.id.btn8 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "8");
                break;
            case R.id.btn9 :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "9");
                break;
            case R.id.btnPlus :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "+");
                break;
            case R.id.btnMinus :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + "-");
                break;
            case R.id.btnDivide :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"" )+ "/");
                break;
            case R.id.btnTimes :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"" )+ "*");
                break;
            case R.id.btnPeriod :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + ".");
                break;
            case R.id.btnClear :
                tvEquation.setText("");
                break;
            case R.id.btnEquals :
                tvEquation.setText(solve(tvEquation.getText() != null ? tvEquation.getText().toString() : ""));
                break;
            case R.id.btn2ndpower :
                String pownum = tvEquation.getText() != null ? tvEquation.getText().toString() : "";
                tvEquation.setText(String.valueOf( Math.pow(Double.valueOf(pownum),2)) );
                break;
            case R.id.btnln :
                String lognum = tvEquation.getText() != null ? tvEquation.getText().toString() : "";
                tvEquation.setText(String.valueOf( Math.log(Double.valueOf(lognum))) );
                break;
            case R.id.btnSqurt :
                String sqrtnum = tvEquation.getText() != null ? tvEquation.getText().toString() : "";
                tvEquation.setText(String.valueOf( Math.sqrt(Double.valueOf(sqrtnum))) );
                break;
            case R.id.btnPi :
                tvEquation.setText((tvEquation.getText() !=null ? tvEquation.getText().toString():"") + Math.PI);
                break;
        }
    }

    private String solve(String simpleEquation) {
        if (simpleEquation.contains("+")){
            return simpleSolvePlus(simpleEquation);
        }else if(simpleEquation.contains("-")){
            return simpleSolveMinus(simpleEquation);
        }else if(simpleEquation.contains("*")){
            return simpleSolveTimes(simpleEquation);
        }else if(simpleEquation.contains("/")){
            return simpleSolveDivide(simpleEquation);
        }else {
            return simpleEquation;
        }

    }

    private String simpleSolveDivide(String divideEquation) {
        String solution;
        //searches for index of / operator
        int iOfOp = divideEquation.indexOf('/');

        //Splits the equation into two parts
        String val1 = divideEquation.substring(0,iOfOp);
        String val2 = divideEquation.substring(iOfOp + 1,divideEquation.length());

        //turns each half of the equation string into double values
        Double value1 = new Double(val1);
        Double value2 = new Double(val2);

        //divides and returns the quotient of the equation if possible
        if (value2 == 0 )
            return "cannot divide by 0";

        solution = String.valueOf(value1 / value2);

        return solution;
    }

    private String simpleSolveTimes(String multiplyEquation) {
        String solution;
        //searches for index of * operator
        int iOfOp = multiplyEquation.indexOf('*');

        //Splits the equation into two parts
        String val1 = multiplyEquation.substring(0,iOfOp);
        String val2 = multiplyEquation.substring(iOfOp + 1,multiplyEquation.length());

        //turns each half of the equation string into double values
        Double value1 = new Double(val1);
        Double value2 = new Double(val2);

        //multiplies and returns the product of the equation
        solution = String.valueOf(value1 * value2);

        return solution;
    }

    private String simpleSolveMinus(String minusEquation) {
        String solution;
        //searches for index of - operator
        int iOfOp = minusEquation.indexOf('-');

        //Splits the equation into two parts
        String val1 = minusEquation.substring(0,iOfOp);
        String val2 = minusEquation.substring(iOfOp + 1,minusEquation.length());

        //turns each half of the equation string into double values
        Double value1 = new Double(val1);
        Double value2 = new Double(val2);

        //subtracts and returns the diff of the equation
        solution = String.valueOf(value1 - value2);

        return solution;
    }


    private String simpleSolvePlus(String plusEquation) {
        String solution;
        //searches for index of + operator
        int iOfOp = plusEquation.indexOf('+');

        //Splits the equation into two parts
        String val1 = plusEquation.substring(0,iOfOp);
        String val2 = plusEquation.substring(iOfOp + 1,plusEquation.length());

        //turns each half of the equation string into double values
        Double value1 = new Double(val1);
        Double value2 = new Double(val2);

        //adds and returns the sum of the equation
        solution = String.valueOf(value1 + value2);

        return solution;

    }
}
