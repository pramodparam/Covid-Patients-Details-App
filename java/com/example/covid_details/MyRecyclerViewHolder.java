package com.example.covid_details;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView userName,userEmail,userMNumber,userAge,userAddress,userGender,
    userAadhar,userCDate,userADate,userDDate,userVaccine,userFirstDose,userSecondDose;


    public MyRecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        userName=itemView.findViewById(R.id.nametext);
        userEmail=itemView.findViewById(R.id.emailtext);
        userMNumber=itemView.findViewById(R.id.patientPNumber);
        userAadhar=itemView.findViewById(R.id.patientAdNumber);
        userMNumber=itemView.findViewById(R.id.patientPNumber);
        userADate=itemView.findViewById(R.id.patientADate);
        userAddress=itemView.findViewById(R.id.patientAds);
        userCDate=itemView.findViewById(R.id.patientCDate);
        userDDate=itemView.findViewById(R.id.patientDDate);
        userAge=itemView.findViewById(R.id.patientAge);
        userGender=itemView.findViewById(R.id.patientGender);
        userVaccine=itemView.findViewById(R.id.patientvaccine);
        userFirstDose=itemView.findViewById(R.id.patient1stdose);
        userSecondDose=itemView.findViewById(R.id.patient2nddose);

    }
}

