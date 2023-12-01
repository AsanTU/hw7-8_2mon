package com.geeks.tilek_talaibekov_hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button myButton;
    private Boolean buttonPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myButton = findViewById(R.id.myButton);
        TextView textView = findViewById(R.id.tv_res);
        String textFromMain = getIntent().getStringExtra(MainActivity.KEY1);
        textView.setText(textFromMain);
        myButton.setOnClickListener(v -> {
            buttonPress = true;
            if (buttonPress){
                myButton.setBackgroundResource(R.drawable.heart_style);
            } else if (buttonPress = false
            ){
                myButton.setBackgroundResource(R.drawable.ic_heart_fill);
            }
        });
        nextClick(findViewById(R.id.next));
    }

    public void nextClick(View view){
        findViewById(R.id.next).setOnClickListener(v -> {
            finishAffinity();
        });
    }
}