package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewInfo extends AppCompatActivity {

    TextView editTextCattleBreed,editTextCattleFarmName,TextViewCattleTagId,TextViewCattleDOB,TextViewCattleSpeacialFeature,TextViewCattleSex,TextViewCattleNoOfLactation,TextViewFarmBirthWeight,TextViewCattleBreedingWeight,TextViewCattleWeaningWeight,TextViewCattleAveragePreWeaningGrowthRate,TextViewCattleAveragePostWeaningGrowthRate,editTextCattleLastCalvingDate;
    DatabaseReference databaseInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);


        Bundle bundleInfo = getIntent().getExtras();

        String stuff = bundleInfo.getString("cattleID");

        databaseInfo= FirebaseDatabase.getInstance().getReference("cattle");



        editTextCattleBreed = (TextView) findViewById(R.id.editTextCattleBreed);
        TextViewCattleTagId = (TextView) findViewById(R.id.TextViewCattleTagId);
        TextViewCattleDOB = (TextView) findViewById(R.id.TextViewCattleDOB);
        TextViewCattleSpeacialFeature = (TextView) findViewById(R.id.TextViewCattleSpeacialFeature);
        TextViewCattleNoOfLactation = (TextView) findViewById(R.id.TextViewCattleNoOfLactation);
        TextViewFarmBirthWeight = (TextView) findViewById(R.id.TextViewFarmBirthWeight);
        TextViewCattleBreedingWeight = (TextView) findViewById(R.id.TextViewCattleBreedingWeight);
        TextViewCattleWeaningWeight = (TextView) findViewById(R.id.TextViewCattleWeaningWeight);
        TextViewCattleAveragePreWeaningGrowthRate = (TextView) findViewById(R.id.TextViewCattleAveragePreWeaningGrowthRate);
        TextViewCattleAveragePostWeaningGrowthRate = (TextView) findViewById(R.id.TextViewCattleAveragePostWeaningGrowthRate);
        editTextCattleLastCalvingDate = (TextView) findViewById(R.id.editTextCattleLastCalvingDate);
        editTextCattleFarmName = (TextView)findViewById(R.id.editTextCattleFarmName);
        TextViewCattleSex = (TextView)findViewById(R.id.TextViewCattleSex);


        getStuff();





    }



    public void getStuff() {
        Bundle bundleInfo = getIntent().getExtras();

        String stuff = bundleInfo.getString("cattleID");
        String CattleTAGID = bundleInfo.getString("CattleTAGID");
        String CattleFarmID= bundleInfo.getString("CattleFarmID");
        String CattleDateOfBirth= bundleInfo.getString("CattleDateOfBirth");
        String CattleBreed= bundleInfo.getString("CattleBreed");
        String CattleSpecialFeature= bundleInfo.getString("CattleSpecialFeature");
        String CattleSex= bundleInfo.getString("CattleSex");
        String CattleNoOfLactation= bundleInfo.getString("CattleNoOfLactation");
        String CattleBirthWeight= bundleInfo.getString("CattleBirthWeight");
        String BreedingWeight= bundleInfo.getString("BreedingWeight");
        String CattleWeaningWeight= bundleInfo.getString("CattleWeaningWeight");
        String CattleAveragePreWeaningGrowthRate= bundleInfo.getString("CattleAveragePreWeaningGrowthRate");
        String CattleAveragePostWeaningGrowthRate= bundleInfo.getString("CattleAveragePostWeaningGrowthRate");

        String CattleLastCalvingDate= bundleInfo.getString("CattleLastCalvingDate");




        editTextCattleBreed.setText(CattleBreed);
        editTextCattleFarmName.setText(CattleFarmID);
        editTextCattleLastCalvingDate.setText(CattleLastCalvingDate);
        TextViewCattleDOB.setText(CattleDateOfBirth);
        TextViewCattleSex.setText(CattleSex);
        TextViewCattleAveragePostWeaningGrowthRate.setText(CattleAveragePostWeaningGrowthRate);
        TextViewCattleAveragePreWeaningGrowthRate.setText(CattleAveragePreWeaningGrowthRate);
        TextViewCattleBreedingWeight.setText(BreedingWeight);
        TextViewCattleNoOfLactation.setText(CattleNoOfLactation);
        TextViewCattleSpeacialFeature.setText(CattleSpecialFeature);
        editTextCattleLastCalvingDate.setText(CattleLastCalvingDate);
        TextViewFarmBirthWeight.setText(CattleBirthWeight);
        TextViewCattleWeaningWeight.setText(CattleWeaningWeight);
        TextViewCattleTagId.setText(CattleTAGID);









    }



}
