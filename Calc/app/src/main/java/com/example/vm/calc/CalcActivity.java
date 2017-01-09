package com.example.vm.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    String runningNum = "";
    String leftValue;
    String rightValue;
    TextView res;
    Operation currOper;
    int result = 0;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLE, EQUAL
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);
        Button clearBtn = (Button)findViewById(R.id.clearBtn);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton multipleBtn = (ImageButton)findViewById(R.id.multipleBtn);
        ImageButton minusBtn = (ImageButton)findViewById(R.id.minusBtn);
        ImageButton plusBtn = (ImageButton)findViewById(R.id.plusBtn);

        res = (TextView)findViewById(R.id.resTxt);
        res.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                processOper(Operation.DIVIDE);
            }
        });

        multipleBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                processOper(Operation.MULTIPLE);
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                processOper(Operation.SUBTRACT);
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                processOper(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                leftValue = "";
                rightValue = "";
                result = 0;
                runningNum = "";
                currOper = null;
                res.setText("0");
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                processOper(Operation.EQUAL);
            }
        });
    }

    void processOper(Operation oper){
        if(currOper != null){
            if(runningNum != null){
                rightValue = runningNum;
                runningNum = "";

                switch (currOper){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                    case MULTIPLE:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                }

                leftValue = String.valueOf(result);
                res.setText(leftValue);
            }
        } else {
            leftValue = runningNum;
            runningNum = "";
        }
        currOper = oper;
    }

    public void numberPressed(int number){
        runningNum += String.valueOf(number);
        res.setText(runningNum);
    }
}
