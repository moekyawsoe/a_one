package com.mks.FirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tsecond = findViewById(R.id.secondtext);
        tsecond.setText(getIntent().getStringExtra("key1"));


    }
    public void Previous(View v){
//        Intent i = new Intent(SecondActivity.this,MainActivity.class);
//        startActivity(i);
        super.onBackPressed();
    }
}
