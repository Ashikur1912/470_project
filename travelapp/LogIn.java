package com.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LogIn extends AppCompatActivity {
    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogIn;
    TextView textViewSignUp;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        textViewSignUp = findViewById(R.id.SignUpText);
        progress = findViewById(R.id.progress);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username, password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());

                if(!username.equals("")&&!password.equals("")) {
                    progress.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         //Starting Write and Read data with URL
                                         //Creating array for parameters
                                         String[] field = new String[2];
                                         field[0] = "username";
                                         field[1] = "password";
                                         //Creating array for data
                                         String[] data = new String[2];
                                         data[0] = username;
                                         data[1] = password;
                                         PutData putData = new PutData("http://192.168.0.107/TRAVELAPPUSERS/login.php", "POST", field, data);
                                         if (putData.startPut()) {
                                             if (putData.onComplete()) {
                                                 progress.setVisibility(View.GONE);
                                                 String result = putData.getResult();
                                                 //End ProgressBar (Set visibility to GONE)
                                                 if(result.equals("Login Success")){

                                                     Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                     startActivity(intent);
                                                     finish();

                                                 }else{
                                                     Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                 }
                                             }
                                         }
                                         //End Write and Read data with URL
                                     }
                                 }
                    );
                }
                else{
                    Toast.makeText(getApplicationContext(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}