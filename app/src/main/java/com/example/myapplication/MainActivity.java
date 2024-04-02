package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText cal, result;
    private String cur, res;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, mul, add, dev, sub, equals, btn_clear;
    private boolean op_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (EditText) findViewById(R.id.cal);
        result = (EditText) findViewById(R.id.result);

        op_insert = false;
        cur = "";
        res = "";

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        mul = (Button) findViewById(R.id.mul);
        add = (Button) findViewById(R.id.add);
        dev = (Button) findViewById(R.id.dev);
        sub = (Button) findViewById(R.id.sub);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        equals = (Button) findViewById(R.id.equals);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "0";
                displayOne();
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "1";
                displayOne();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "2";
                displayOne();
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "3";
                displayOne();
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "4";
                displayOne();
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "5";
                displayOne();
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "6";
                displayOne();
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "7";
                displayOne();
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "8";
                displayOne();
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur = cur + "9";
                displayOne();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cur.isEmpty()) {
                    if (op_insert == false) {
                        cur = cur + " ÷ ";
                        op_insert = true;
                    }
                }

                displayOne();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cur.isEmpty()) {
                    if (op_insert == false) {
                        cur = cur + " x ";
                        op_insert = true;
                    }
                }

                displayOne();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cur.isEmpty()) {
                    if (op_insert == false) {
                        cur = cur + " - ";
                        op_insert = true;
                    }
                }

                displayOne();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cur.isEmpty()) {
                    if (op_insert == false) {
                        cur = cur + " + ";
                        op_insert = true;
                    }
                }

                displayOne();
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cur.isEmpty() && op_insert) {
                    String[] tokens = cur.split(" ");
                    if (tokens.length >= 3) {
                        int operand1 = Integer.parseInt(tokens[0]);
                        char operator = tokens[1].charAt(0);
                        int operand2 = Integer.parseInt(tokens[2]);
                        int result = 0; // Result will be an integer

                        switch (operator) {
                            case '+':
                                result = operand1 + operand2;
                                break;
                            case '-':
                                result = operand1 - operand2;
                                break;
                            case '*':
                                result = operand1 * operand2;
                                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                                    res = "Error: Result exceeds integer range";
                                    displayTwo();
                                    return;
                                }
                                break;
                            case '/':
                                if (operand2 != 0) {
                                    result = operand1 / operand2;
                                } else {
                                    res = "Error: Division by zero";
                                    displayTwo();
                                    return;
                                }
                                break;
                            default:
                                res = "Error: Invalid operator";
                                displayTwo();
                                return;
                        }
                        res = Integer.toString(result);
                    } else {
                        res = "Error: Insufficient number of tokens";
                    }
                    displayTwo();
                }
            }
        });



    }



    public void displayOne(){
        cal.setText(cur);
    }

    public void displayTwo(){
        result.setText(res);
    }

    public void clear(){
        cur= "";
        res= "";
        op_insert = false;
    }




}