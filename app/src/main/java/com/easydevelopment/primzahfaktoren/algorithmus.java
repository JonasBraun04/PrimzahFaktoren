package com.easydevelopment.primzahfaktoren;

import android.os.Debug;
import android.util.Log;

import java.io.Console;
import java.util.ArrayList;

public class algorithmus {

    public ArrayList<Integer> primZahlen = new ArrayList();
    ArrayList output = new ArrayList();
    int num;
    boolean run =true;

    public  void ini(){
        primZahlen.add(2);
        primZahlen.add(3);
        primZahlen.add(5);
        primZahlen.add(7);
        primZahlen.add(11);
    }

    public ArrayList calc (int input){
        output.clear();

        ini();
        num =input;
        while (run){
            loop();
        }
        return output;
    }
    void loop( ){

        for(int i = 0; i< primZahlen.size();i++){

            if( primZahlen.get(i)> Math.sqrt((double)num)){
                run = false;
                output.add(num);
                return;


            }if(num % primZahlen.get(i) == 0){
                output.add(primZahlen.get(i));
                num = num / (int) primZahlen.get(i);
                return;
            }

        }
        output.add("Error!");
        run =false;
    }
}
