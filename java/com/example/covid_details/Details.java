package com.example.covid_details;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    ImageView profilePic;

    /*TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    Button back;
    FirebaseFirestore firebaseFirestore;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        profilePic=findViewById(R.id.profilePic);


      profilePic.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              choosePicture();
          }
      });
        /*t1=findViewById(R.id.patientName);
        t2=findViewById(R.id.patientEmail);
        t3=findViewById(R.id.patientAge);
        t4=findViewById(R.id.patientGender);
        t5=findViewById(R.id.patientPNumber);
        t6=findViewById(R.id.patientAdNumber);
        t7=findViewById(R.id.patientAds);
        t8=findViewById(R.id.patientCDate);
        t9=findViewById(R.id.patientADate);
        t10=findViewById(R.id.patientDDate);
        t11=findViewById(R.id.patient1stdose);
        t12=findViewById(R.id.patient2nddose);
        t13=findViewById(R.id.patientvaccine);
        back=findViewById(R.id.buttonBack);
        firebaseFirestore=FirebaseFirestore.getInstance();
        //getData();
t1.setText(getIntent().getStringExtra("uname").toString());
t2.setText(getIntent().getStringExtra("uemail").toString());
t3.setText(getIntent().getStringExtra("uage").toString());
t4.setText(getIntent().getStringExtra("ugender").toString());
t5.setText(getIntent().getStringExtra("umnumber").toString());
t6.setText(getIntent().getStringExtra("uadharcard").toString());
t7.setText(getIntent().getStringExtra("uaddress").toString());
t8.setText(getIntent().getStringExtra("ucdate").toString());
t9.setText(getIntent().getStringExtra("uadate").toString());
t10.setText(getIntent().getStringExtra("uddate").toString());
t11.setText(getIntent().getStringExtra("ufirstdose").toString());
t12.setText(getIntent().getStringExtra("useconddose").toString());
t13.setText(getIntent().getStringExtra("uvaccine").toString());


back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),RecycleData.class));
        finish();
    }
});
    }

    /*private void getData() {
        firebaseFirestore.collection("Patients").document().get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    t1.setText(documentSnapshot.getString("name"));
                    t2.setText(documentSnapshot.getString("email"));
                    t3.setText(documentSnapshot.getString("Age"));
                    t4.setText(documentSnapshot.getString("Gender"));
                    t5.setText(documentSnapshot.getString("PHONE"));
                    t6.setText(documentSnapshot.getString("AadhaarCard Number"));
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong...",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(getApplicationContext(),"user not found",Toast.LENGTH_SHORT).show();

            }
        });*/

    }

    private void choosePicture() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }
}