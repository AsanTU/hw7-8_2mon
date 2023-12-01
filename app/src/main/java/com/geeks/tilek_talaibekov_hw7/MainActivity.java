package com.geeks.tilek_talaibekov_hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstOperand, secondOperand, result;
    private String operation;
    private Boolean isOperationClick;

    public static final String KEY1 = "key1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        Button invisibleButton = findViewById(R.id.invisible_button);
        invisibleButton.setVisibility(View.INVISIBLE);

        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            firstOperand = 0;
            secondOperand = 0;
        } else if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        Button invisibleButton = findViewById(R.id.invisible_button);
        invisibleButton.setVisibility(View.INVISIBLE);
        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "x";
        } else if (view.getId() == R.id.btn_division) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            secondOperand = Integer.valueOf(textView.getText().toString());
            invisibleButton.setVisibility(View.VISIBLE);
            if (operation.equals("+")) {
                result = firstOperand + secondOperand;
            } else if (operation.equals("-")) {
                result = firstOperand - secondOperand;
            } else if (operation.equals("x")) {
                result = firstOperand * secondOperand;
            } else if (operation.equals("/")) {
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    Toast.makeText(this, "Ошибка. Деление на ноль нельзя.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            textView.setText(result.toString());
        }
        isOperationClick = true;
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.invisible_button){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(MainActivity.KEY1, textView.getText().toString());
            startActivity(intent);
        }
    }
}