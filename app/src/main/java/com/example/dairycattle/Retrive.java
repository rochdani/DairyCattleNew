/*package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrive extends AppCompatActivity {

    ListView listViewFarms;
    FirebaseDatabase database;
    DatabaseReference reff;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Farm farm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        farm=new Farm();

        listViewFarms = findViewById(R.id.listViewFarms);

        database = FirebaseDatabase.getInstance();

        reff = database.getReference("farms");
        list = new ArrayList<>();
        adapter =  new ArrayAdapter<String>(this,R.layout.user_info,R.id.view,list);

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    farm = ds.getValue(Farm.class);
                    list.add(farm.getFarmName().toString()+" "+farm.getFarmAddress().toString());


                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
*/