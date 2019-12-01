package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class ViewFarms extends AppCompatActivity {

    private static final String TAG = "ViewDatabase";

    private FirebaseDatabase mFirebaseDatabases;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String userID;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_farms);

        mListView = (ListView) findViewById(R.id.listViewFarms);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabases = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabases.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG ,"onAuthStateChanged: signed_in:" +user.getUid());
                    toastMessage("Succefuly Signe" + user.getEmail());


                } else {
                    Log.d(TAG,"onAuthStateChanged:signed_out");
                    toastMessage("succedfully Signed out");
                }
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            private void showData(DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Farm farm = new Farm();
                    farm.setFarmName(ds.child(userID).getValue(Farm.class).getFarmName());
                    farm.setFarmAddress(ds.child(userID).getValue(Farm.class).getFarmAddress());

                    Log.d(TAG, "shoData: name: " + farm.getFarmName());
                    Log.d(TAG, "shoData: address: " + farm.getFarmAddress());

                    ArrayList <String> array = new ArrayList<>();
                    array.add(farm.getFarmName());
                    array.add(farm.getFarmAddress());




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }
    @Override
    public void onStop(){
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
