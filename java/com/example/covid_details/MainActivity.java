package com.example.covid_details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    EditText et, password;
    TextView login;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        et = (TextInputEditText) findViewById(R.id.et);
        password = (TextInputEditText) findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter  Input!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(et.getText().toString().equals("AndroidDEV")|password.getText().equals("LOGINFREE")){
                        Intent next=new Intent(MainActivity.this,Screen2Details.class);
                        startActivity(next);

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Enter  Correct Input!", Toast.LENGTH_SHORT).show();


                    }

                }
            }
        });
    }
}
