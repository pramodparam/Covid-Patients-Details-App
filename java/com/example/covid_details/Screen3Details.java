package com.example.covid_details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Screen3Details extends AppCompatActivity {
 EditText ANo,Dose1,Dose2,VName;
 Button B2;
  CheckBox check2;
    FirebaseAuth fA;
    FirebaseFirestore dBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3_details);
        ANo= findViewById(R.id.AadharNo);
        Dose1= findViewById(R.id.Dose1);
        Dose2= findViewById(R.id.Dose2);
        VName= findViewById(R.id.VName);
        B2=findViewById(R.id.Enter2);
        check2=findViewById(R.id.check2);
        fA=FirebaseAuth.getInstance();
        dBase=FirebaseFirestore.getInstance();

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateSecondUser();
            }
        });

    }

    public void UpdateSecondUser() {

        Map<String,Object> items=new HashMap<>();
        items.put("AadhaarCard Number", ANo.getText().toString().trim());
        items.put("Dose1 date", Dose1.getText().toString().trim());
        items.put("Dose2 date", Dose2.getText().toString().trim());
        items.put("Vaccine Name",VName.getText().toString().trim());
        dBase.collection("Patients").add(items).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DocumentReference> task) {
                ANo.setText("");
                Dose1.setText("");
                Dose2.setText("");
                VName.setText("");
                Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
                Intent x=new Intent(Screen3Details.this,RecycleData.class);
                startActivity(x);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_SHORT).show();

            }
        });

    }
}