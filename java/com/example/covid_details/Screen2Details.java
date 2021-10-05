package com.example.covid_details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Screen2Details extends AppCompatActivity {
     EditText Name,Email,PNumber,Address,ConfirmDate,Discharge,Admission,Age, Gender;
     Button B1;
       FirebaseAuth fAuth;
     FirebaseFirestore db;
     ImageButton img;
     int day;
     int month;
     int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2_details);
        Name = findViewById(R.id.editName);
        Email = findViewById(R.id.editEmail);
        Age = findViewById(R.id.Age);
        PNumber =  findViewById(R.id.MbNo);
        Address = findViewById(R.id.Address);
        ConfirmDate =  findViewById(R.id.ConfirmDate);
        Discharge =  findViewById(R.id.discharge);
        Admission = findViewById(R.id.Admission);
       // img=findViewById(R.id.imageButton);
        Gender = findViewById(R.id.Gender);
        B1 = findViewById(R.id.B1);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

B1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        insertData();

    }
});

}

    public void insertData()
    {
       if(Name.getText().toString().isEmpty()){
           Name.setError("Please Enter Name");
       }
        if(Email.getText().toString().isEmpty()){
            Email.setError("Please Enter Email");
        }
        if (Email.getText().toString().endsWith("@gmail.com")) {
            Email.setError(" Enter Valid Email ID");
        if(Age.getText().toString().isEmpty()){
            Age.setError("Please Enter Age");
        }
        if(Age.getText().toString().length()>3){
            Age.setError("Please Enter Correct Age");
        }
        if(Gender.getText().toString().isEmpty()){
            Gender.setError("Please Enter Gender");
        }
            if(Gender.getText().toString().chars('0')){
                Gender.setError("Please Enter Gender");
            }
        if(Name.getText().toString().isEmpty()){
            Name.setError("Please Enter Name");
        }
    Map<String,Object>items=new HashMap<>();
        items.put("name", Name.getText().toString().trim());
        items.put("email", Email.getText().toString().trim());
        items.put("Age", Age.getText().toString().trim());
        items.put("Gender",Gender.getText().toString().trim());
        items.put("Address",Address.getText().toString().trim());
        items.put("Confirm Date",ConfirmDate.getText().toString().trim());
        items.put("Admission Date",Admission.getText().toString().trim());
        items.put("Discharge Date",Discharge.getText().toString().trim());
        items.put("Phone Number",PNumber.getText().toString().trim());
        db.collection("Patients").add(items).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DocumentReference> task) {
                Name.setText("");
                Email.setText("");
                Age.setText("");
                Gender.setText("");
                Address.setText("");
                ConfirmDate.setText("");
                Admission.setText("");
                Discharge.setText("");
                PNumber.setText("");
                Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
          Intent i=new Intent(Screen2Details.this,Screen3Details.class);
          startActivity(i);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_SHORT).show();

            }
        });
    }


}
