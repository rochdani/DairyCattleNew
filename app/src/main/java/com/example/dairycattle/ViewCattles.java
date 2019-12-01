package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewCattles extends AppCompatActivity {

    DatabaseReference databaseCattle;
    ListView ListViewCattle;
    List<Cattle> cattleList;
    Button btnAddCattle;
    TextView
            FarmName, FarmRegNo,FarmOwnName,FarmVetDiv,FarmAddress,FarmContactNo,FarmCattleCount,FarmDairyCattleCount,FarmGSDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cattles);

        Bundle bundle = getIntent().getExtras();


        String stuff = bundle.getString("stuff");
        String farmName = bundle.getString("fameName");
        String farmRegNo = bundle.getString("farmRegNo");
        String farmOwnName = bundle.getString("farmOwnName");
        String farmGSDiv = bundle.getString("farmGSDiv");
        String farmAddress = bundle.getString("farmAddress");
        String farmContactNo = bundle.getString("farmContactNo");
        String farmCattleCount = bundle.getString("farmCattleCount");
        String farmDairyCattleCount = bundle.getString("farmDairyCattleCount");


        FarmName = (TextView)findViewById(R.id.FarmName);
        FarmRegNo = (TextView)findViewById(R.id.farmRegNo);
        FarmOwnName = (TextView)findViewById(R.id.farmOwnName);
        FarmVetDiv= (TextView)findViewById(R.id.farmVetDiv);
        FarmAddress = (TextView)findViewById(R.id.farmAddress);
        FarmContactNo = (TextView)findViewById(R.id.farmContactNo);
        FarmCattleCount = (TextView)findViewById(R.id.farmCattleCount);
        FarmCattleCount = (TextView)findViewById(R.id.farmDairyCattleCount);
        FarmDairyCattleCount = (TextView)findViewById(R.id.farmDairyCattleCount);
        FarmGSDiv = (TextView)findViewById(R.id.farmGSDiv);

        FarmName.setText(farmName);
        FarmRegNo.setText(farmRegNo);
        FarmOwnName.setText(farmOwnName);
        FarmGSDiv.setText(farmGSDiv);
        FarmAddress.setText(farmAddress);
        FarmContactNo.setText(farmContactNo);
        FarmCattleCount.setText(farmCattleCount);
        FarmDairyCattleCount.setText(farmDairyCattleCount);






        btnAddCattle = (Button)findViewById(R.id.buttonAddCattle);



        databaseCattle= FirebaseDatabase.getInstance().getReference("cattle");

        ListViewCattle= (ListView) findViewById(R.id.ListViewCattle);

        cattleList=new ArrayList<>();

        btnAddCattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intToAddCattle = new Intent(ViewCattles.this, addCattle.class);
                startActivity(intToAddCattle);

                Bundle bundles = new Bundle();
                String m = getSfuff();
                bundles.putString("farmid",m);
                intToAddCattle.putExtras(bundles);
                startActivity(intToAddCattle);
            }
        });

        ListViewCattle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Cattle cattle = cattleList.get(i);
                //  showFarmDetail(farm.getFarmName(),farm.getFarmRegNo(),farm.getFarmOwnName(),farm.getFarmVetDiv(),farm.getFarmGSDiv(),farm.getFarmAddress(),farm.getFarmContactNo(),farm.getFarmCattleCount(),farm.getFarmDairyCattleCount());

                Intent intToCattleHome = new Intent(ViewCattles.this, CattleHome.class);
                Bundle bundle = new Bundle();
                bundle.putString("cattleID",cattle.getCattleID());
                bundle.putString("CattleTAGID",cattle.getCattleTAGID());
                bundle.putString("CattleFarmID",cattle.getCattleFarmID());
                bundle.putString("CattleDateOfBirth",cattle.getCattleDateOfBirth());
                bundle.putString("CattleBreed",cattle.getCattleBreed());
                bundle.putString("CattleSpecialFeature",cattle.getCattleSpecialFeature());
                bundle.putString("CattleSex",cattle.getCattleSex());
                bundle.putString("CattleBirthWeight",cattle.getCattleBirthWeight());
                bundle.putString("BreedingWeight",cattle.getBreedingWeight());
                bundle.putString("CattleWeaningWeight",cattle.getCattleWeaningWeight());
                bundle.putString("CattleAveragePreWeaningGrowthRate",cattle.getCattleAveragePreWeaningGrowthRate());
                bundle.putString("CattleAveragePostWeaningGrowthRate",cattle.getCattleAveragePostWeaningGrowthRate());
                bundle.putString("CattleLastCalvingDate",cattle.getCattleLastCalvingDate());



                intToCattleHome.putExtras(bundle);
                startActivity(intToCattleHome);

            }
        });




    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseCattle.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                cattleList.clear();

                for(
                        DataSnapshot cattleSnapshot :dataSnapshot.getChildren())

                {
                    //getting farm
                    Cattle cattle = cattleSnapshot.getValue(Cattle.class);
                    String k = getSfuff();
                   if (cattle.CattleFarmID.equals(k)) {

                        cattleList.add(cattle);


                    }
                    //adding farm to the list

                }

                CattleList adapters = new CattleList(ViewCattles.this, cattleList);
                ListViewCattle.setAdapter(adapters);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public  String getSfuff() {
        Bundle bundle = getIntent().getExtras();


        String stuff = bundle.getString("stuff");
        return stuff;


    }

}
