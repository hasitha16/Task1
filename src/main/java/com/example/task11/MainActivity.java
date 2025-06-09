package com.example.task11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView counterText;
    private Button incrementButton, decrementButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);
        incrementButton = findViewById(R.id.incrementButton);
        decrementButton = findViewById(R.id.decrementButton);
        resetButton = findViewById(R.id.resetButton);

        incrementButton.setOnClickListener(v -> {
            count++;
            updateCounter();
        });

        decrementButton.setOnClickListener(v -> {
            count--;
            updateCounter();
        });

        resetButton.setOnClickListener(v -> {
            count = 0;
            updateCounter();
        });
    }

    private void updateCounter() {
        counterText.setText(String.valueOf(count));
    }
}