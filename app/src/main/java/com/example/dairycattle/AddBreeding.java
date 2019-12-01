package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
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

public class AddBreeding extends AppCompatActivity {
    EditText editTextDateOfFirstAI,editTextDateOfSecondAI,editTextSemenID,editTextVeterinianCode,editTextDateOfPD,editTextDateOfLastCalving,editTextNameOfTechnician,editTextNoOfCalving,editTextNameOfAIReceiptNo;
    Button buttonAddBreeding;
    DatabaseReference databaseBreeding;

    private static final String TAG = "MainActivity";

    private TextView editTextDateOFHeatSignObserved;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_breeding);


        databaseBreeding= FirebaseDatabase.getInstance().getReference("breeding");



        editTextDateOFHeatSignObserved = (EditText) findViewById(R.id.editTextDateOFHeatSignObserved);

        editTextDateOFHeatSignObserved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBreeding.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
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
                editTextDateOFHeatSignObserved.setText(date);
                editTextDateOfFirstAI.setText(date);
                editTextDateOfSecondAI.setText(date);
                editTextDateOfPD.setText(date);
                editTextDateOfLastCalving.setText(date);
            }
        };

        editTextDateOfFirstAI = (EditText) findViewById(R.id.editTextDateOfFirstAI);

        editTextDateOfFirstAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBreeding.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });


        editTextDateOfSecondAI = (EditText) findViewById(R.id.editTextDateOfSecondAI);

        editTextDateOfSecondAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBreeding.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });
        editTextSemenID = (EditText) findViewById(R.id.editTextSemenID);
        editTextVeterinianCode = (EditText) findViewById(R.id.editTextVeterinianCode);
        editTextDateOfPD = (EditText)findViewById(R.id.editTextDateOfPD);

        editTextDateOfPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBreeding.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });
        editTextDateOfLastCalving = (EditText) findViewById(R.id.editTextDateOfLastCalving);

        editTextDateOfLastCalving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBreeding.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });
        editTextNameOfTechnician = (EditText) findViewById(R.id.editTextNameOfTechnician);
        editTextNoOfCalving = (EditText) findViewById(R.id.editTextNoOfCalving);
        editTextNameOfAIReceiptNo = (EditText) findViewById(R.id.editTextNameOfAIReceiptNo);






        buttonAddBreeding = (Button) findViewById(R.id.buttonAddBreeding);

        buttonAddBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addBreeding();

            }
        });


    }

    private void addBreeding(){

        String BreedingDateOfHeatSignObserved = editTextDateOFHeatSignObserved.getText().toString().trim();
        String BreedingDateOfFirstAI = editTextDateOfFirstAI.getText().toString().trim();
        String BreedingDateOfSecondAI = editTextDateOfSecondAI.getText().toString().trim();
        String BreedingSemenID = editTextSemenID.getText().toString().trim();
        String BreedingVeterinarianCode = editTextVeterinianCode.getText().toString().trim();
        String BreedingDateOfPD = editTextDateOfPD.getText().toString().trim();
        String BreedingDateOfLastCalving =editTextDateOfLastCalving.getText().toString().trim();
        String BreedingNameOfTechnnician =editTextNameOfTechnician.getText().toString().trim();
        String BreedingNoOfCalving =editTextNoOfCalving.getText().toString().trim();
        String BreedingAIReceiptNo =editTextNameOfAIReceiptNo.getText().toString().trim();





        if (!TextUtils.isEmpty(BreedingDateOfHeatSignObserved)&&!TextUtils.isEmpty(BreedingDateOfFirstAI)&&!TextUtils.isEmpty(BreedingDateOfSecondAI)&&!TextUtils.isEmpty(BreedingSemenID)&&!TextUtils.isEmpty(BreedingVeterinarianCode)&&!TextUtils.isEmpty(BreedingDateOfPD)&&!TextUtils.isEmpty(BreedingDateOfLastCalving)&&!TextUtils.isEmpty(BreedingNameOfTechnnician)&&!TextUtils.isEmpty(BreedingNoOfCalving)&&!TextUtils.isEmpty(BreedingAIReceiptNo)) {

            String BreedingID = databaseBreeding.push().getKey();

            //creating an Artist Object
            Bundle bundles = getIntent().getExtras();


            String BreedingCattleID = bundles.getString("CattleID");
            Breeding breeding = new Breeding(BreedingID,BreedingCattleID,BreedingDateOfHeatSignObserved,BreedingDateOfFirstAI,BreedingDateOfSecondAI,BreedingSemenID,BreedingVeterinarianCode,BreedingDateOfPD,BreedingDateOfLastCalving,BreedingNameOfTechnnician,BreedingNoOfCalving,BreedingAIReceiptNo);
            databaseBreeding.child(BreedingID).setValue(breeding);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "New Breeding Added", Toast.LENGTH_LONG).show();
            Intent intToCattle = new Intent(AddBreeding.this, ViewVaccination.class);




        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }





    }
}
