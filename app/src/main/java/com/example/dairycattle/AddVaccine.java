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

import com.example.dairycattle.Vaccine;
import com.example.dairycattle.ViewVaccination;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AddVaccine extends AppCompatActivity {
    EditText editTextClinicalSign,editTextTypeOfClinicalSign,editTextKindOfDisease,editTextTreatment,editTextRemarks,editTextNameOfVeterinarian;
    Button btnAddVaccine;
    DatabaseReference databaseVaccine;

    private static final String TAG = "MainActivity";

    private TextView editTextDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccine);


        databaseVaccine= FirebaseDatabase.getInstance().getReference("vaccine");



        editTextDate = (EditText) findViewById(R.id.editTextDate);

        editTextDate = (EditText) findViewById(R.id.editTextDate);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddVaccine.this,
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
        editTextKindOfDisease = (EditText) findViewById(R.id.editTextKindOfDisease);
        editTextTreatment = (EditText)findViewById(R.id.editTextTreatment);
        editTextRemarks = (EditText) findViewById(R.id.editTextRemarks);
        editTextNameOfVeterinarian = (EditText) findViewById(R.id.editTextNameOfVeterinarian);





        btnAddVaccine = (Button) findViewById(R.id.buttonAddVaccine);

        btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addVaccine();

            }
        });


    }

    private void addVaccine(){

        String VaccineDate = editTextDate.getText().toString().trim();
        String VaccineClinicalSigns = editTextClinicalSign.getText().toString().trim();
        String VaccineTypeOfClinicalSign = editTextTypeOfClinicalSign.getText().toString().trim();
        String VaccineKindOfDisease = editTextKindOfDisease.getText().toString().trim();
        String VaccineTreatment = editTextTreatment.getText().toString().trim();
        String VaccineRemarks =editTextRemarks.getText().toString().trim();
        String VaccineNameOfVeterinarian =editTextNameOfVeterinarian.getText().toString().trim();




        if (!TextUtils.isEmpty(VaccineDate)||!TextUtils.isEmpty(VaccineClinicalSigns)||!TextUtils.isEmpty(VaccineTypeOfClinicalSign)||!TextUtils.isEmpty(VaccineKindOfDisease)||!TextUtils.isEmpty(VaccineTreatment)||!TextUtils.isEmpty(VaccineRemarks)) {

            String VaccineID = databaseVaccine.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String CattleVaccineID = bundles.getString("CattleID");
            Vaccine vaccine = new Vaccine(VaccineID,CattleVaccineID,VaccineDate,VaccineClinicalSigns,VaccineTypeOfClinicalSign,VaccineKindOfDisease,VaccineTreatment,VaccineRemarks,VaccineNameOfVeterinarian);
            databaseVaccine.child(VaccineID).setValue(vaccine);

            //setting edittext to blank again


            //displaying a success toast
            //  Toast.makeText(this, "New Vaccine Added", Toast.LENGTH_LONG).show();
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Success!!")
                    .setContentText("New Vaccine Added")
                    .show();
            Intent intToCattle = new Intent(AddVaccine.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            //Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
            new SweetAlertDialog(this)
                    .setTitleText("Please fill the values")
                    .show();
        }





    }
}
