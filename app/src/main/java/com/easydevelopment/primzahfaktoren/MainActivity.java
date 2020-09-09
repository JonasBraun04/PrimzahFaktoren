package com.easydevelopment.primzahfaktoren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    TextView table;
    Button button;
    CheckBox toggleMode;
    String outputText;
    int i;
    int counter;
    boolean mode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputNumber);
        output = findViewById(R.id.output);
        toggleMode = findViewById(R.id.potenzMode);
        button = findViewById(R.id.changeMode);
        table = findViewById(R.id.primeNumberTable);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateDisplay();
            }
        });

        toggleMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateDisplay();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mode) {
                   input.setVisibility(View.GONE);
                   output.setVisibility(View.GONE);
                   toggleMode.setVisibility(View.GONE);
                   table.setVisibility(View.VISIBLE);
                   mode=!mode;
               } else {
                   input.setVisibility(View.VISIBLE);
                   output.setVisibility(View.VISIBLE);
                   toggleMode.setVisibility(View.VISIBLE);
                   table.setVisibility(View.GONE);
                   mode=!mode;
               }
           }
        });


    }

    public void updateDisplay() {
        outputText = "";
        if (input.getText().length() != 0) {
            PrimeFactorsCalculation primeFactorsCalculation = new PrimeFactorsCalculation();
            ArrayList result = primeFactorsCalculation.calculation(Integer.parseInt(input.getText().toString()));
            counter = 1;
            if (toggleMode.isChecked()) {
                for (i = 0; i < result.size()-1; i++) {
                    if (result.get(i) == result.get(i + 1)) {
                        counter++;
                    } else {
                        outputAdd(false, result);
                    }
                }
            } else {
                for (i = 0; i < result.size()-1; i++) {
                    outputAdd(false, result);
                }
            }
            outputAdd(true, result);
        }
        output.setText(outputText);
    }

    public void outputAdd(boolean end, ArrayList array) {
        if (counter > 1) {
            outputText = outputText + array.get(i) + "^" + counter;
            counter = 1;
        } else {
            outputText = outputText + array.get(i) + "";
        }
        if(!end) {
            outputText = outputText + " x ";
        }
    }
}