package com.example.unconsumedfoodmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2_Donate extends AppCompatActivity {

    FirebaseFirestore db;

    TextView textMeal;
    TextView textHour;
    Button btnDonate;
    String textName,textMobileno,textAdd,textPincode;
    String t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_donate);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));

        actionBar.setBackgroundDrawable(colorDrawable);

        textMeal=findViewById(R.id.donateMeal);
        textHour=findViewById(R.id.mealHour);
        btnDonate=findViewById(R.id.btnDonate);



        db= FirebaseFirestore.getInstance();//create socket


        Intent inetnt=getIntent();
        textName=inetnt.getStringExtra("name");
        textMobileno=inetnt.getStringExtra("mob");
        textAdd=inetnt.getStringExtra("Add");
        textPincode=inetnt.getStringExtra("Pin");


        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1=textMeal.getText().toString();
                t2=textHour.getText().toString();

                if(t1.equals("") || t2.equals("")) {
                    Toast.makeText(MainActivity2_Donate.this,"Enter Missing Value",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Map<String, Object> user = new HashMap<>();
                    user.put("DonerName", textName);
                    user.put("DonerMob", textMobileno);
                    user.put("DonerAdd", textAdd);
                    user.put("DonerPincode", textPincode);
                    user.put("DonerMeal", textMeal.getText().toString());
                    user.put("DonerHour", textHour.getText().toString());

                    db.collection("DONER")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(MainActivity2_Donate.this, "Thank You", Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(getApplicationContext(),MainActivity2_hotelLogin.class);
                                    startActivity(intent);
                                }
                            });

                }


           }
    });
    }
}