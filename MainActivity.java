package com.example.lucas.numberguesser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    int smallest = 0, largest = 99;
    int guess = 0, ans = 0;
    int random = new Random().nextInt(100) + 1;

    public class Reset {
        int guess = 0, ans = 0;
        int random = new Random().nextInt(100);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvrange = (TextView) findViewById(R.id.tvrange);
        final TextView tvguess = (TextView) findViewById(R.id.tvguess);
        final EditText et = (EditText) findViewById(R.id.et);
        final Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = Integer.valueOf(et.getText().toString());
            }
        });


        while (ans != random) {
            guess++;
            tvguess.setText(guess);

            if (ans > largest || ans < smallest) {
                Toast.makeText(MainActivity.this, "Your input is out of the range: " + smallest + "-" + largest, Toast.LENGTH_SHORT).show();
            } else {
                if (ans > random) {
                    largest = ans;
                    tvrange.setText(smallest + "-" + largest);
                } else {
                    smallest = ans;
                    tvrange.setText(smallest + "-" + largest);
                }
            }

        }

        tvrange.setText(random);
        //call snackbar, ask player playAgain
        
    }
}