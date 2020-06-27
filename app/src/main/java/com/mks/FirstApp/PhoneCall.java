package com.mks.FirstApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneCall extends AppCompatActivity {
EditText et,sms;
String phoneno,SMSData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        et = findViewById(R.id.etphone);
        sms = findViewById(R.id.etsms);

        //permission Request
        ActivityCompat.requestPermissions(
                PhoneCall.this,
                new String[] {Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS},0
        );



    }
    public void PhoneCall(View v){
        Log.i("OnClick","It  is  works");
        phoneno = et.getText().toString();
        Intent phoneCall = new Intent(Intent.ACTION_CALL);
        phoneCall.setData(Uri.parse("tel:"+phoneno));
        //permission check
        if(ActivityCompat.checkSelfPermission(PhoneCall.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(phoneCall);
    }
    public void SendSMS(View v){
        Log.i("OnClick","It  is  works");
        phoneno = et.getText().toString();
        SMSData = sms.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneno,null,SMSData,null,null);
        Toast.makeText(getApplicationContext(),"Message sent",Toast.LENGTH_LONG).show();
    }
}
