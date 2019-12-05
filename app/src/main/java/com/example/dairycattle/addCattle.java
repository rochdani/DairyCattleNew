package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class addCattle extends AppCompatActivity {

    EditText editTextCattleTagId,editTextCattleSpecialFeature,editTextCattleSex,editTextCattleNoOfLactation,editTextFarmBirthWeight,editTextCattleBreedingWeight,editTextCattleWeaningWeight,editTextCattleAveragePreWeaningGrowthRate,editTextCattleAveragePostWeaningGrowthRate,editTextCattleLastCalvingDate,editTextCattleBreed;
    Button btnAddCattle;
    DatabaseReference databaseCattle;

    private static final String TAG = "MainActivity";

    private TextView editTextCattleDOB;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cattle);




        databaseCattle= FirebaseDatabase.getInstance().getReference("cattle");



        editTextCattleTagId = (EditText) findViewById(R.id.editTextCattleTagId);
        editTextCattleDOB = (EditText) findViewById(R.id.editTextCattleDOB);

        editTextCattleDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addCattle.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //  dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                String months = String.format("%02d", month);
                String days = String.format("%02d", day);
                Log.d(TAG, "onDateSet: yyyy/mm/dd: " + year + "-" + months + "-" + day);

                String date = year + "-" + months + "-" + days;
                editTextCattleDOB.setText(date);
                editTextCattleLastCalvingDate.setText(date);
            }
        };
        editTextCattleSpecialFeature = (EditText) findViewById(R.id.editTextCattleSpeacialFeature);
        editTextCattleSex = (EditText) findViewById(R.id.editTextCattleSex);
        editTextCattleNoOfLactation = (EditText)findViewById(R.id.editTextCattleNoOfLactation);
        editTextFarmBirthWeight = (EditText) findViewById(R.id.editTextFarmBirthWeight);
        editTextCattleBreedingWeight = (EditText) findViewById(R.id.editTextCattleBreedingWeight);
        editTextCattleWeaningWeight = (EditText) findViewById(R.id.editTextCattleWeaningWeight);
        editTextCattleAveragePreWeaningGrowthRate = (EditText)findViewById(R.id.editTextCattleAveragePreWeaningGrowthRate);
        editTextCattleAveragePostWeaningGrowthRate =(EditText)findViewById(R.id.editTextCattleAveragePostWeaningGrowthRate);
        editTextCattleLastCalvingDate =(EditText)findViewById(R.id.editTextCattleLastCalvingDate);

        editTextCattleLastCalvingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addCattle.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });

        editTextCattleBreed = (EditText)findViewById(R.id.editTextCattleBreed);




        btnAddCattle = (Button) findViewById(R.id.btnAddCattle);

        btnAddCattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCattle();

            }
        });


    }

    private void addCattle(){

        String CattleTAGID= editTextCattleTagId.getText().toString().trim();
        String CattleDateOfBirth = editTextCattleDOB.getText().toString().trim();


        String CattleBreed =editTextCattleBreed.getText().toString().trim();
        String CattleSpecialFeature = editTextCattleSpecialFeature.getText().toString().trim();
        String CattleSex = editTextCattleSex.getText().toString().trim();
        String CattleNoOfLactation = editTextCattleNoOfLactation.getText().toString().trim();
        String CattleBirthWeight= editTextFarmBirthWeight.getText().toString().trim() ;
        String BreedingWeight = editTextCattleBreedingWeight.getText().toString();
        String CattleWeaningWeight = editTextCattleWeaningWeight.getText().toString();
        String CattleAveragePreWeaningGrowthRate = editTextCattleAveragePreWeaningGrowthRate.getText().toString();
        String CattleAveragePostWeaningGrowthRate = editTextCattleAveragePostWeaningGrowthRate.getText().toString();
        String CattleLastCalvingDate = editTextCattleBreed.getText().toString();




        if (!TextUtils.isEmpty(CattleDateOfBirth)&&!TextUtils.isEmpty(CattleBreed)&&!TextUtils.isEmpty(CattleSpecialFeature)&&!TextUtils.isEmpty(CattleSex)&&!TextUtils.isEmpty(CattleNoOfLactation)&&!TextUtils.isEmpty(CattleBirthWeight)&&!TextUtils.isEmpty(BreedingWeight)&&!TextUtils.isEmpty(CattleWeaningWeight)&&!TextUtils.isEmpty(CattleAveragePreWeaningGrowthRate)&&!TextUtils.isEmpty(CattleAveragePostWeaningGrowthRate)&&!TextUtils.isEmpty(CattleLastCalvingDate)) {

            String CattleID = databaseCattle.push().getKey();

            //creating an Artist Object
            Bundle bundle = getIntent().getExtras();


            String FarmID = bundle.getString("farmid");
            Cattle cattle = new Cattle(CattleID,CattleTAGID,FarmID,CattleDateOfBirth,CattleBreed,CattleSpecialFeature,CattleSex,CattleNoOfLactation,CattleBirthWeight,BreedingWeight,CattleWeaningWeight,CattleAveragePreWeaningGrowthRate,CattleAveragePostWeaningGrowthRate,CattleLastCalvingDate);
            databaseCattle.child(CattleID).setValue(cattle);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Farm Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(addCattle.this, ViewCattles.class);
            startActivity(intToCattle);
            finish();




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
