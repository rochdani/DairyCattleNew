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

public class ViewVaccination extends AppCompatActivity {

    DatabaseReference databaseVaccine;
    ListView ListViewVaccine;
    List<Vaccine> vaccineList;
    Button buttonAddVacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vaccination);

        Bundle bundle = getIntent().getExtras();



        buttonAddVacc = (Button)findViewById(R.id.buttonAddBreeding);



        databaseVaccine= FirebaseDatabase.getInstance().getReference("vaccine");

        ListViewVaccine= (ListView) findViewById(R.id.listViewDisease);

        vaccineList=new ArrayList<>();

        buttonAddVacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddVaccine = new Intent(ViewVaccination.this, AddVaccine.class);
                startActivity(intToAddVaccine);

                Bundle bundles = new Bundle();
                String m = getStuff();
                bundles.putString("CattleID",m);
                intToAddVaccine.putExtras(bundles);
                startActivity(intToAddVaccine);
            }
        });




    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseVaccine.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String k;


                vaccineList.clear();

                for(
                        DataSnapshot vaccineSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Vaccine vaccine = vaccineSnapshot.getValue(Vaccine.class);
                    k= getStuff();
                    if (vaccine.CattleVaccineID!=null && vaccine.CattleVaccineID.equals(k)) {

                        vaccineList.add(vaccine);

                    }
                    //adding farm to the list

                }

                VaccineList adapters = new VaccineList(ViewVaccination.this, vaccineList);
                ListViewVaccine.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public  String getStuff() {
        Bundle bundleVac = getIntent().getExtras();


        String stuff = bundleVac.getString("cattleID");
        return stuff;


    }

}
