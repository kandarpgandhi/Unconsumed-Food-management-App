package com.example.unconsumedfoodmanagement;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;


public class MainActivity2_getMeal extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Information> listArr;
    FirebaseFirestore db;
    MyAdapter myAdapter;
    String textPincodengo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_get_meal);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));

        actionBar.setBackgroundDrawable(colorDrawable);

        Intent inetnt=getIntent();
        textPincodengo=inetnt.getStringExtra("Pin");


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();
        listArr=new ArrayList<Information>();
        myAdapter =new MyAdapter(this,listArr);

        recyclerView.setAdapter(myAdapter);
        EventChangeListener();

                }

    private void EventChangeListener() {

        db.collection("DONER").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null)
                {
                    return;
                }
                else
                {
                    for(DocumentChange dc : value.getDocumentChanges())
                    {
                        if(dc.getType()==DocumentChange.Type.ADDED)
                        {
                            //String str=dc.getDocument().toObject(Information.class).toString();
                            String str=dc.getDocument().get("DonerPincode").toString();
                            if(textPincodengo.equals(str)) {
                                listArr.add(dc.getDocument().toObject(Information.class));
                            }
                        }

                        myAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}

