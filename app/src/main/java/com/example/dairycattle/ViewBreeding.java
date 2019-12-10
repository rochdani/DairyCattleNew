package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewBreeding extends AppCompatActivity {

    DatabaseReference databaseBreeding;
    ListView ListViewBreeding;
    List<Breeding> breedingList;
    Button buttonAddBreeding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_breeding);

        Bundle bundle = getIntent().getExtras();



        buttonAddBreeding = (Button)findViewById(R.id.buttonAddBreeding);


        databaseBreeding= FirebaseDatabase.getInstance().getReference("breeding");

        ListViewBreeding= (ListView) findViewById(R.id.listViewBreeding);

        breedingList=new ArrayList<>();

        buttonAddBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddBreeding = new Intent(ViewBreeding.this, AddBreeding.class);
                startActivity(intToAddBreeding);

                Bundle bundles = new Bundle();
                String m = getStuff();
                bundles.putString("CattleID",m);
                intToAddBreeding.putExtras(bundles);
                startActivity(intToAddBreeding);
            }
        });

        ListViewBreeding.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Breeding breeding = breedingList.get(i);


                //updateFarmDetail(farm.getFarmId(),farm.getFarmName(),farm.getFarmRegNo(),farm.getFarmOwnName(),farm.getFarmVetDiv(),farm.getFarmGSDiv(),farm.getFarmAddress(),farm.getFarmContactNo(),farm.getFarmCattleCount(),farm.getFarmDairyCattleCount());
                //deleteBreed(breeding.getBreedingID());

                return true;

            }
        });




    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseBreeding.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String k;


                breedingList.clear();

                for(
                        DataSnapshot breedingSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Breeding breeding = breedingSnapshot.getValue(Breeding.class);
                    k= getStuff();
                    if (breeding.BreedingCattleID!=null && breeding.BreedingCattleID.equals(k)) {

                        breedingList.add(breeding);

                    }
                    //adding farm to the list

                }

                BreedingList adapters = new BreedingList(ViewBreeding.this, breedingList);
                ListViewBreeding.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public  String getStuff() {
        Bundle bundleBreeding = getIntent().getExtras();

        String stuff = bundleBreeding.getString("cattleID");
        return stuff;


    }
    private boolean deleteBreed(String ID){


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("breeding").child(ID);
        databaseReference.removeValue();
        Toast.makeText(this, "Breed Deleted Successfully", Toast.LENGTH_LONG).show();

        Intent intToHome = new Intent(ViewBreeding.this, ViewBreeding.class);
        startActivity(intToHome);





        return true;
    }

}
