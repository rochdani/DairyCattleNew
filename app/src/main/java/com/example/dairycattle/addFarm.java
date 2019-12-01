package com.example.dairycattle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addFarm extends AppCompatActivity {

    EditText editTextFarmName,editTextFarmRegNo,editTextFarmOwnName,editTextFarmVetDiv,editTextFarmGSDiv,editTextFarmAddress,editTextFarmContactNo,editTextFarmCattleCount,editTextFarmDairyCattleCount;
    Button btnAddFarm2;
    DatabaseReference databaseFarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);

        databaseFarm= FirebaseDatabase.getInstance().getReference("farms");



        editTextFarmName = (EditText) findViewById(R.id.editTextFarmName);
        editTextFarmRegNo = (EditText) findViewById(R.id.editTextFarmRegNo);
        editTextFarmOwnName = (EditText) findViewById(R.id.editTextFarmOwnName);
        editTextFarmVetDiv = (EditText) findViewById(R.id.editTextFarmVetDiv);
        editTextFarmGSDiv= (EditText)findViewById(R.id.editTextFarmGSDiv);
        editTextFarmAddress = (EditText)findViewById(R.id.editTextFarmAddress);
        editTextFarmContactNo = (EditText) findViewById(R.id.editTextFarmContactNo);
        editTextFarmCattleCount = (EditText) findViewById(R.id.editTextFarmCattleCount);
        editTextFarmDairyCattleCount = (EditText) findViewById(R.id.editTextFarmDairyCattleCount);

        btnAddFarm2 = (Button) findViewById(R.id.btnAddCattle);

        btnAddFarm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFarm();

            }
        });


    }

    private void addFarm(){

        String FarmName = editTextFarmName.getText().toString().trim();
        String FarmRegNo = editTextFarmRegNo.getText().toString().trim();
        String FarmOwnName = editTextFarmOwnName.getText().toString().trim();
        String FarmVetDiv = editTextFarmVetDiv.getText().toString().trim();
        String FarmGSDiv = editTextFarmGSDiv.getText().toString().trim();
        String FarmAddress = editTextFarmAddress.getText().toString().trim();
        String FarmContactNo = editTextFarmContactNo.getText().toString().trim();
        String FarmCattleCount = editTextFarmCattleCount.getText().toString().trim();
        String FarmDairyCattleCount = editTextFarmDairyCattleCount.getText().toString().trim();


        if (!TextUtils.isEmpty(FarmName)&&!TextUtils.isEmpty(FarmRegNo)&&!TextUtils.isEmpty(FarmOwnName)&&!TextUtils.isEmpty(FarmVetDiv)&&!TextUtils.isEmpty(FarmGSDiv)&&!TextUtils.isEmpty(FarmAddress)&&!TextUtils.isEmpty(FarmContactNo)&&!TextUtils.isEmpty(FarmCattleCount)&&!TextUtils.isEmpty(FarmDairyCattleCount)) {

            if((FarmContactNo.length()<11)&&(FarmContactNo.length()>9)) {

                String id = databaseFarm.push().getKey();

                //creating an Artist Object
                Farm farm = new Farm(id, FarmName, FarmRegNo, FarmOwnName, FarmVetDiv, FarmGSDiv, FarmAddress, FarmContactNo, FarmCattleCount, FarmDairyCattleCount);
                databaseFarm.child(id).setValue(farm);

                //setting edittext to blank again


                //displaying a success toast
                Toast.makeText(this, "New Farm Added", Toast.LENGTH_LONG).show();
                Intent intToHome = new Intent(addFarm.this, Home.class);
                startActivity(intToHome);
            }else {

                Toast.makeText(this, "Please fill phone number correctly", Toast.LENGTH_LONG).show();

            }



        } else {

            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the values", Toast.LENGTH_LONG).show();
        }



    }
}
