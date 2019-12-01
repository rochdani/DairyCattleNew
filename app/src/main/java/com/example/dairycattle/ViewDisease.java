package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewDisease extends AppCompatActivity {

    DatabaseReference databaseDisease;
    ListView ListViewDisease;
    List<Disease> diseaseList;
    Button buttonAddVacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_disease);

        Bundle bundle = getIntent().getExtras();



        buttonAddVacc = (Button)findViewById(R.id.buttonAddBreeding);



        databaseDisease= FirebaseDatabase.getInstance().getReference("disease");

        ListViewDisease= (ListView) findViewById(R.id.listViewDisease);

        diseaseList=new ArrayList<>();

        buttonAddVacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddDisease = new Intent(ViewDisease.this, AddDisease.class);
                startActivity(intToAddDisease);

                Bundle bundles = new Bundle();
                String m = getStuff();
                bundles.putString("CattleID",m);
                intToAddDisease.putExtras(bundles);
                startActivity(intToAddDisease);
            }
        });



    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseDisease.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String k;


                diseaseList.clear();

                for(
                        DataSnapshot diseaseSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Disease disease = diseaseSnapshot.getValue(Disease.class);
                    k= getStuff();
                    if (disease.DiseaseCattleID!=null && disease.DiseaseCattleID.equals(k)) {

                        diseaseList.add(disease);

                    }
                    //adding farm to the list

                }

                DiseaseList adapters = new DiseaseList(ViewDisease.this, diseaseList);
                ListViewDisease.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public  String getStuff() {
        Bundle bundleDisease = getIntent().getExtras();

        String stuff = bundleDisease.getString("cattleID");
        return stuff;


    }

}
