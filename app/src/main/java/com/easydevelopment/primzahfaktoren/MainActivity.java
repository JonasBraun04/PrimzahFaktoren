package com.easydevelopment.primzahfaktoren;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ListView list;
EditText input;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.inputNumber);
        bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                algorithmus a = new algorithmus();
                ArrayList res = a.calc(Integer.parseInt(input.getText().toString()));
                list  = (ListView)findViewById(R.id.list);
                ListAdapter adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,res);
                list.setAdapter(adapter);
            }
        });
        while(true) {
            int old = 0;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           //if (input.isInEditMode()) {
           //    int New = input.getText().toString().length();
           //    if (New != old) {
           //        New = old;
           //        Log.d("test", "ft");

           //    }
           //}
        }



    }


}
