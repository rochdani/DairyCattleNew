package com.example.dairycattle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CattleHome extends AppCompatActivity {
    Button buttonVaccine, buttonDisease,buttonBreeding,buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattle_home);

        buttonVaccine = (Button)findViewById(R.id.buttonVaccine);

        buttonVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleVaccine = new Intent(CattleHome.this, ViewVaccination.class);
                Bundle bundleVac = new Bundle();
                bundleVac.putString("cattleID",cattleID);

                intToCattleVaccine.putExtras(bundleVac);
                startActivity(intToCattleVaccine);


            }
        });


        buttonDisease = (Button)findViewById(R.id.buttonDisease);

        buttonDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleDisease = new Intent(CattleHome.this, ViewDisease.class);
                Bundle bundleDisease = new Bundle();
                bundleDisease.putString("cattleID",cattleID);

                intToCattleDisease.putExtras(bundleDisease);
                startActivity(intToCattleDisease);


            }
        });

        buttonBreeding = (Button)findViewById(R.id.buttonBreeding);

        buttonBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");


                Intent intToCattleBreeding = new Intent(CattleHome.this, ViewBreeding.class);
                Bundle bundleBreeding = new Bundle();
                bundleBreeding.putString("cattleID",cattleID);

                intToCattleBreeding.putExtras(bundleBreeding);
                startActivity(intToCattleBreeding);


            }
        });



        buttonInfo = (Button)findViewById(R.id.buttonCattleInfo);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = getIntent().getExtras();


                String cattleID = bundle.getString("cattleID");
                String CattleTAGID = bundle.getString("CattleTAGID");
                String CattleFarmID= bundle.getString("CattleFarmID");
                String CattleDateOfBirth= bundle.getString("CattleDateOfBirth");
                String CattleBreed= bundle.getString("CattleBreed");
                String CattleSpecialFeature= bundle.getString("CattleSpecialFeature");
                String CattleSex= bundle.getString("CattleSex");
                String CattleNoOfLactation= bundle.getString("CattleNoOfLactation");
                String CattleBirthWeight= bundle.getString("CattleBirthWeight");
                String BreedingWeight= bundle.getString("BreedingWeight");
                String CattleWeaningWeight= bundle.getString("CattleWeaningWeight");
                String CattleAveragePreWeaningGrowthRate= bundle.getString("CattleAveragePreWeaningGrowthRate");
                String CattleAveragePostWeaningGrowthRate= bundle.getString("CattleAveragePostWeaningGrowthRate");

                String CattleLastCalvingDate= bundle.getString("CattleLastCalvingDate");



                Intent intToCattleInfo = new Intent(CattleHome.this, ViewInfo.class);
                Bundle bundleInfo = new Bundle();
                bundleInfo.putString("cattleID",cattleID);

                bundleInfo.putString("CattleTAGID",CattleTAGID);
                bundleInfo.putString("CattleFarmID",CattleFarmID);
                bundleInfo.putString("CattleDateOfBirth",CattleDateOfBirth);
                bundleInfo.putString("CattleBreed",CattleBreed);
                bundleInfo.putString("CattleSpecialFeature",CattleSpecialFeature);
                bundleInfo.putString("CattleSex",CattleSex);
                bundleInfo.putString("CattleNoOfLactation",CattleNoOfLactation);
                bundleInfo.putString("CattleBirthWeight",CattleBirthWeight);
                bundleInfo.putString("BreedingWeight",BreedingWeight);
                bundleInfo.putString("CattleWeaningWeight",CattleWeaningWeight);
                bundleInfo.putString("CattleAveragePreWeaningGrowthRate",CattleAveragePreWeaningGrowthRate);
                bundleInfo.putString("CattleAveragePostWeaningGrowthRate",CattleAveragePostWeaningGrowthRate);

                bundleInfo.putString("CattleLastCalvingDate",CattleLastCalvingDate);

                intToCattleInfo.putExtras(bundleInfo);
                startActivity(intToCattleInfo);


            }
        });


    }
}