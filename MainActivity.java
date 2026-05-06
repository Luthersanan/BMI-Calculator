package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputHeight;
    private EditText inputWeight;
    private Button calculateButton;
    private TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        inputHeight = findViewById(R.id.inputHeight);
        inputWeight = findViewById(R.id.inputWeight);
        calculateButton = findViewById(R.id.calculateButton);
        bmiResult = findViewById(R.id.bmiResult);

        // Set the onClickListener for the button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get input values as strings
        String heightStr = inputHeight.getText().toString();
        String weightStr = inputWeight.getText().toString();

        // Check if inputs are not empty
        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            // Parse the height and weight values into floats
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            // Calculate BMI using the formula
            float bmi = weight / (height * height);

            // Display the result
            bmiResult.setText(String.format("Your BMI is: %.2f", bmi));
        } else {
            // Display an error message if inputs are missing
            bmiResult.setText("Please enter valid height and weight!");
        }
    }
}
