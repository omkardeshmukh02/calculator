package com.example.omkard.myapplication;

//import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
import java.text.DecimalFormat;

import com.example.omkard.myapplication.databinding.ActivityMainBinding;
import com.example.omkard.myapplication.databinding.MainCalculatorBinding;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double valueOne = Double.NaN;
    private double valueTwo;
    private ActivityMainBinding binding;


    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main_calculator);

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.##########");

        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edttxt1.setText(binding.edttxt1.getText() + ".");
            }
        });

        binding.btnzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "0");
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "1");

            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "6");
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                binding.edttxt1.setText(binding.edttxt1.getText() + "9");
            }
        });
        binding.btndel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (binding.edttxt1.getText().length() > 0) {
                    CharSequence currentText = binding.edttxt1.getText();
                    binding.edttxt1.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.edttxt1.setText("");
                    binding.infoTextView.setText("");
                }
            }
        });


        binding.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.edttxt1.setText(null);
            }
        });

        binding.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.edttxt1.setText(null);
            }
        });

        binding.btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.edttxt1.setText(null);
            }
        });

        binding.btnslash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.edttxt1.setText(null);
            }
        });

        binding.btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });


    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.edttxt1.getText().toString());
            binding.edttxt1.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.edttxt1.getText().toString());
            } catch (Exception e) {
            }
        }
    }


    @Override
    public void onClick(View v) {

    }


}
