package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
        String farmVetDiv=bundle.getString("farmVetDiv");
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

        FarmDairyCattleCount = (TextView)findViewById(R.id.farmDairyCattleCount);
        FarmGSDiv = (TextView)findViewById(R.id.farmGSDiv);

        FarmName.setText(farmName);
        FarmRegNo.setText(farmRegNo);
        FarmOwnName.setText(farmOwnName);
        FarmVetDiv.setText(farmVetDiv);
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

        ListViewCattle.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                Cattle cattle = cattleList.get(i);


                updateCattleDetail(cattle.getCattleID(),cattle.getCattleTAGID(),cattle.getCattleDateOfBirth(),cattle.getCattleBreed(),cattle.getCattleSpecialFeature(),cattle.getCattleSex(),cattle.getCattleNoOfLactation(),cattle.getCattleBirthWeight(),cattle.getBreedingWeight(),cattle.getCattleWeaningWeight(),cattle.getCattleAveragePreWeaningGrowthRate(),cattle.getCattleAveragePostWeaningGrowthRate(),cattle.getCattleLastCalvingDate());
              // deleteCattle(cattle.getCattleID());

                return true;

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

    private void updateCattleDetail(final String ID, String TAGID,  String DateOfBirth, String Breed ,String Specialfeature ,String Sex, String NoLactation, String BirthWeght, String breedingWeight,String WeaningWeght,String AveragePreWeaningGrowthRate,String  AveragePostWeaningGrowthRate,String LastCalving ){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.update_cattles,null);

        dialogBuilder.setView(dialogView);

        final EditText editTextTag = (EditText) dialogView.findViewById(R.id.editTextTagId);
        final EditText editTextDob = (EditText) dialogView.findViewById(R.id.editTextDOB);
        final EditText editTextbreed = (EditText) dialogView.findViewById(R.id.editTextBreed);
        final EditText editTextSpecialfeature = (EditText) dialogView.findViewById(R.id.editTextSpeacialFeature);
        final EditText editTextSex = (EditText) dialogView.findViewById(R.id.editTextSex);
        final EditText editTextNoOfLactation = (EditText) dialogView.findViewById(R.id.editTextNoOfLactation);
        final EditText editTextBirthWeight = (EditText) dialogView.findViewById(R.id.editTextBirthWeight);
        final EditText editTextBreedingWeight = (EditText) dialogView.findViewById(R.id.editTextBreedingWeight);
        final EditText editTextWeaningWeight = (EditText) dialogView.findViewById(R.id.editTextWeaningWeight);
        //  final Button btnCancell = (Button)dialogView.findViewById(R.id.buttonCancel);
        final EditText editTextPreRate = (EditText) dialogView.findViewById(R.id.editTextAveragePreWeaningGrowthRate);
        final EditText editTextPostRate = (EditText) dialogView.findViewById(R.id.editTextAveragePostWeaningGrowthRate);
        final EditText editTextLastCalving=(EditText)dialogView.findViewById(R.id.editTextCattleLastCalvingDate);
        final Button btnUpdate = (Button)dialogView.findViewById(R.id.buttonUpdate1);
        final Button btnDelete = (Button)dialogView.findViewById(R.id.buttonDelete1);

        editTextTag.setText(TAGID);
        editTextDob.setText(DateOfBirth);
        editTextbreed.setText(Breed);
        editTextSpecialfeature.setText(Specialfeature);
        editTextSex.setText(Sex);
        editTextNoOfLactation.setText(NoLactation);
        editTextBirthWeight.setText(BirthWeght);
        editTextBreedingWeight.setText(breedingWeight);
        editTextWeaningWeight.setText(WeaningWeght);
        editTextPreRate.setText(AveragePreWeaningGrowthRate);
        editTextPostRate.setText(AveragePostWeaningGrowthRate);
        editTextLastCalving.setText(LastCalving);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String TAGID = editTextTag.getText().toString().trim();
                String DateOfBirth = editTextDob.getText().toString().trim();
                String Breed = editTextbreed.getText().toString().trim();
                String SpecialFeature = editTextSpecialfeature.getText().toString().trim();
                String Sex = editTextSex.getText().toString().trim();
                String NoOfLactation = editTextNoOfLactation.getText().toString().trim();
                String BirthWeight = editTextBirthWeight.getText().toString().trim();
                String breedingWeight = editTextBreedingWeight.getText().toString().trim();
                String WeaningWeight = editTextWeaningWeight.getText().toString().trim();
                String AveragePreWeaningGrowthRate = editTextPreRate.getText().toString().trim();
                String AveragePostWeaningGrowthRate = editTextPostRate.getText().toString().trim();
                String LastCalving = editTextLastCalving.getText().toString().trim();


                updateCattle(ID,TAGID,DateOfBirth,Breed,SpecialFeature,Sex,NoOfLactation,BirthWeight,breedingWeight,WeaningWeight,AveragePreWeaningGrowthRate,AveragePostWeaningGrowthRate,LastCalving);

            }
        });



        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String Name = editTextName.getText().toString().trim();
//                String RegNo = editTextRegNo.getText().toString().trim();
//                String OwnName = editTextOwnName.getText().toString().trim();
//                String VetDiv = editTextVetDiv.getText().toString().trim();
//                String GSDiv = editTextGSDiv.getText().toString().trim();
//                String Address = editTextAddress.getText().toString().trim();
//                String ContactNo = editTextContactNo.getText().toString().trim();
//                String CattleCount = editTextCattleCount.getText().toString().trim();
//                String DairyCattleCount = editTextDairyCattleCount.getText().toString().trim();
//
//
//                updateFarm(ID,Name,RegNo,OwnName,VetDiv,GSDiv,Address,ContactNo,CattleCount,DairyCattleCount);

                deleteCattle(ID);

            }
        });





//        btnCancell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this, ViewFarms.class);
//                startActivity(intent);
//
//
//
//
//
//            }
//
//
//        });


        dialogBuilder.setTitle("Update Cattle Details");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


    }


    private boolean updateCattle(String ID,String TAGID, String DateOfBirth, String Breed, String SpecialFeature, String Sex, String NoOfLactation, String BirthWeight, String breedingWeight, String WeaningWeight,String AveragePreWeaningGrowthRate,String AveragePostWeaningGrowthRate,String LastCalving){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cattle").child(ID);
        Cattle cattle = new Cattle(ID,TAGID,DateOfBirth,Breed,SpecialFeature,Sex,NoOfLactation,BirthWeight,breedingWeight,WeaningWeight,AveragePreWeaningGrowthRate,AveragePostWeaningGrowthRate,LastCalving);
        databaseReference.setValue(cattle);
        Toast.makeText(this, "Cattles Updated Successfully", Toast.LENGTH_LONG).show();

        Intent intToHome = new Intent(ViewCattles.this, ViewCattles.class);
        startActivity(intToHome);


        return true;


    }

    private boolean deleteCattle(String ID){


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("cattle").child(ID);
        databaseReference.removeValue();
        Toast.makeText(this, "Cattles Deleted Successfully", Toast.LENGTH_LONG).show();

        Intent intToHome = new Intent(ViewCattles.this, ViewCattles.class);
        startActivity(intToHome);





        return true;
    }

}
