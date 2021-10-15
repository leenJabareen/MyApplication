package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private Button buttonBack;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        buttonBack = findViewById(R.id.buttonBack);
        textView2 = findViewById(R.id.textView2);

        String email = getIntent().getStringExtra("email");
        textView2.setText("Welcome "+" " +email+";)");

    }

    public void back(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}