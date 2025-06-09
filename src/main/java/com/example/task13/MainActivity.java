package com.example.task13;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String current = "";
    String operator = "";
    double first = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);

        int[] numberIDs = { R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four,
                R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.dot };

        View.OnClickListener numberClick = view -> {
            Button b = (Button) view;
            current += b.getText().toString();
            display.setText(current);
        };

        for (int id : numberIDs)
            findViewById(id).setOnClickListener(numberClick);

        findViewById(R.id.plus).setOnClickListener(v -> handleOperator("+"));
        findViewById(R.id.minus).setOnClickListener(v -> handleOperator("-"));
        findViewById(R.id.multiply).setOnClickListener(v -> handleOperator("*"));
        findViewById(R.id.divide).setOnClickListener(v -> handleOperator("/"));

        findViewById(R.id.equal).setOnClickListener(v -> {
            double second = Double.parseDouble(current);
            double result = 0;

            switch (operator) {
                case "+": result = first + second; break;
                case "-": result = first - second; break;
                case "*": result = first * second; break;
                case "/": result = second != 0 ? first / second : 0; break;
            }

            display.setText(String.valueOf(result));
            current = "";
            operator = "";
        });

        findViewById(R.id.clear).setOnClickListener(v -> {
            current = "";
            operator = "";
            first = 0;
            display.setText("0");
        });
    }

    private void handleOperator(String op) {
        if (!current.isEmpty()) {
            first = Double.parseDouble(current);
            operator = op;
            current = "";
        }
    }
}
