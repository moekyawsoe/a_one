package com.mks.FirstApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView tv;
    EditText et;
    Button button1,button2,button3;
    String tag = "MainActivity";
    String str ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview1); //this is finding id
        et = findViewById(R.id.edtext);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        tv.setText("This is text from java");
        tv.setTextColor(0xFFef6c00);
        tv.setTextSize(30);



    }
    public void onClick(View clickview) {
        switch (clickview.getId()){
            case R.id.button1:
                Intent a = new Intent(MainActivity.this,PhoneCall.class);
                startActivity(a);
                break;
            case R.id.button2:
                tv.setText("You pressed Button 2");
                Toast.makeText(getApplicationContext(),"This is the Second button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                tv.setText("You pressed Button 3");
                Toast.makeText(MainActivity.this,"This is the Third button",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void ShowToast(View showtoast){
        Toast.makeText(this, "Git Testing", Toast.LENGTH_SHORT).show();
    }
    public void Next(View v){
        str = et.getText().toString();
        Intent i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("key1","Hello "+str);
        startActivity(i);
    }
}
