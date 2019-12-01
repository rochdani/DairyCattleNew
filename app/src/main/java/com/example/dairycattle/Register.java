package com.example.dairycattle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Register extends AppCompatActivity {

    EditText emailId, passward;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        passward = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signup);
        tvSignIn = findViewById(R.id.login);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String pwd = passward.getText().toString();
                if(email.isEmpty()){

                    emailId.setError("Please enter E-mail Id");
                    emailId.requestFocus();

                }
                else if(pwd.isEmpty()){
                    passward.setError("Please enter your Password");
                    passward.requestFocus();


                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this,"Fields are Empty",Toast.LENGTH_SHORT).show();



                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this,"SignUp Unsuccessful, Please Try Again ",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                startActivity(new Intent(Register.this,Home.class));

                            }

                        }
                    });



                }
                else{
                    Toast.makeText(Register.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
