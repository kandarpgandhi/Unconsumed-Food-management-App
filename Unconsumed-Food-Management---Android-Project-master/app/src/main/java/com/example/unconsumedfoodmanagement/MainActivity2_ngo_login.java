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

public class MainActivity2_ngo_login extends AppCompatActivity {

    TextView textName;
    TextView textmanagerName;
    TextView textID;
    TextView textAdd;
    TextView textPincode;
    Button btnngoLogin;
    String t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_ngo_login);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        textName=findViewById(R.id.ngoName);
        textmanagerName=findViewById(R.id.managerName);
        textID=findViewById(R.id.ngoidNo);
        textAdd=findViewById(R.id.ngoAdd);
        textPincode=findViewById(R.id.ngoPincode);
        btnngoLogin=findViewById(R.id.btnnogLogin);



        btnngoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1=textName.getText().toString();
                t2=textmanagerName.getText().toString();
                t3=textID.getText().toString();
                t4=textAdd.getText().toString();
                t5=textPincode.getText().toString();

                Intent intent=new Intent(getApplicationContext(),MainActivity2_getMeal.class);

                if(t1.equals("") || t2.equals("") || t3.equals("") || t4.equals("") || t5.equals("")) {
                    Toast.makeText(MainActivity2_ngo_login.this,"Enter Missing Value",Toast.LENGTH_LONG).show();

                }
                else
                {
                    intent.putExtra("name", textName.getText().toString());
                    intent.putExtra("manager", textmanagerName.getText().toString());
                    intent.putExtra("Id", textID.getText().toString());
                    intent.putExtra("Add", textAdd.getText().toString());
                    intent.putExtra("Pin", textPincode.getText().toString());

                    startActivity(intent);
                }
            }
        });
    }
}