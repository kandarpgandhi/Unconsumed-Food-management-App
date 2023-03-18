package com.example.unconsumedfoodmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2_hotelLogin extends AppCompatActivity {

    TextView textName;
    TextView textMobileno;
    TextView textAdd;
    TextView textPincode;
    Button btnLogin;
    String t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_hotel_login);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));

        actionBar.setBackgroundDrawable(colorDrawable);

        textName=findViewById(R.id.hotelName);
        textMobileno=findViewById(R.id.mobileNumber);
        textAdd=findViewById(R.id.hotelAdd);
        textPincode=findViewById(R.id.pincode);
        btnLogin=findViewById(R.id.hotelLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1=textName.getText().toString();
                t2=textMobileno.getText().toString();
                t3=textAdd.getText().toString();
                t4=textPincode.getText().toString();

                if(t1.equals("") || t2.equals("") || t3.equals("") || t4.equals("")) {
                    Toast.makeText(MainActivity2_hotelLogin.this,"Enter Missing Value",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(),MainActivity2_Donate.class);
                    intent.putExtra("name", textName.getText().toString());
                    intent.putExtra("mob", textMobileno.getText().toString());
                    intent.putExtra("Add", textAdd.getText().toString());
                    intent.putExtra("Pin", textPincode.getText().toString());

                    startActivity(intent);
                }
            }
        });
    }
}