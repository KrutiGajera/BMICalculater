package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    Button btnCalculate;
    EditText edtWeight, edtHeightFt, edtHeightIn;
    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightFt.getText().toString());
                int heightIn = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = heightFt*12 + heightIn;

                double totalcm = totalIn*2.53;

                double totalM = totalcm/100;

                double bmi = weight/(totalM*totalM);

                if (bmi > 25) {
                    txtResult.setText("You are Overweigt");
                    llMain.setBackground(getResources().getDrawable(R.color.overWeight));
                } else if (bmi < 18) {
                    txtResult.setText("You are underweight");
                    llMain.setBackground(getResources().getDrawable(R.color.underWeight));
                }else {
                    txtResult.setText("You are Healthy");
                    llMain.setBackground(getResources().getDrawable(R.color.Healthy));

                }
            }
        });
    }
}