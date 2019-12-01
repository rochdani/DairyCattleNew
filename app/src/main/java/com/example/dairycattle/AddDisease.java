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

public class AddDisease extends AppCompatActivity {
    EditText editTextClinicalSign,editTextTypeOfClinicalSign,editTextDiagnosis,editTextTreatment,editTextRemarks,editTextNameOfVeterinarian;
    Button buttonAddDisease;
    DatabaseReference databaseDisease;

    private static final String TAG = "MainActivity";

    private TextView editTextDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disease);


        databaseDisease= FirebaseDatabase.getInstance().getReference("disease");



        editTextDate = (EditText) findViewById(R.id.editTextDate);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddDisease.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
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
                editTextDate.setText(date);

            }
        };
        editTextClinicalSign = (EditText) findViewById(R.id.editTextClinicalSign);
        editTextTypeOfClinicalSign = (EditText) findViewById(R.id.editTextTypeOfClinicalSign);
        editTextDiagnosis = (EditText) findViewById(R.id.editTextDiagnosis);
        editTextTreatment = (EditText)findViewById(R.id.editTextTreatment);
        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);
        editTextNameOfVeterinarian = (EditText) findViewById(R.id.editTextNameOfVeterinarian);





        buttonAddDisease = (Button) findViewById(R.id.buttonAddBreeding);

        buttonAddDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addDisease();

            }
        });


    }

    private void addDisease(){

        String DiseaseDate = editTextDate.getText().toString().trim();
        String DiseaseClinicalSigns = editTextClinicalSign.getText().toString().trim();
        String DiseaseTypeOfClinicalSigns = editTextTypeOfClinicalSign.getText().toString().trim();
        String DiseaseDiagnosis = editTextDiagnosis.getText().toString().trim();
        String DiseaseTreatment = editTextTreatment.getText().toString().trim();
        String DiseaseRemarks =editTextRemarks.getText().toString().trim();
        String DiseaseNameOfVeterinarian =editTextNameOfVeterinarian.getText().toString().trim();




        if (!TextUtils.isEmpty(DiseaseDate)&&!TextUtils.isEmpty(DiseaseClinicalSigns)&&!TextUtils.isEmpty(DiseaseTypeOfClinicalSigns)&&!TextUtils.isEmpty(DiseaseDiagnosis)&&!TextUtils.isEmpty(DiseaseTreatment)&&!TextUtils.isEmpty(DiseaseRemarks)&&!TextUtils.isEmpty(DiseaseNameOfVeterinarian)) {

            String DiseaseID = databaseDisease.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String DiseaseCattleID = bundles.getString("CattleID");
            Disease disease = new Disease(DiseaseID,DiseaseDate,DiseaseCattleID,DiseaseClinicalSigns,DiseaseTypeOfClinicalSigns,DiseaseDiagnosis,DiseaseTreatment,DiseaseRemarks,DiseaseNameOfVeterinarian);
            databaseDisease.child(DiseaseID).setValue(disease);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Disease Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(AddDisease.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
