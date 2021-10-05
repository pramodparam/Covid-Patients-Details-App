package com.example.covid_details;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    RecycleData recycleData;
    ArrayList<User> userArrayList;

    public MyRecyclerViewAdapter(RecycleData recycleData, ArrayList<User> userArrayList) {
        this.recycleData = recycleData;
        this.userArrayList = userArrayList;
    }
    @NonNull
    @NotNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater v=LayoutInflater.from(recycleData.getBaseContext());
        View view=v.inflate(R.layout.singlerow,parent,false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyRecyclerViewHolder holder, int position) {
        holder.userName.setText(userArrayList.get(position).getName());
        holder.userEmail.setText(userArrayList.get(position).getEmail());
       holder.userAge.setText(userArrayList.get(position).getAge());
        holder.userAddress.setText(userArrayList.get(position).getAddress());
        holder.userMNumber.setText(userArrayList.get(position).getmNumber());
        holder.userGender.setText(userArrayList.get(position).getGender());
        holder.userAadhar.setText(userArrayList.get(position).getAadhar());
        holder.userADate.setText(userArrayList.get(position).getAdate());
        holder.userDDate.setText(userArrayList.get(position).getDdate());
        holder.userCDate.setText(userArrayList.get(position).getCdate());
        holder.userVaccine.setText(userArrayList.get(position).getVaccine());
        holder.userFirstDose.setText(userArrayList.get(position).getFirstdose());
        holder.userSecondDose.setText(userArrayList.get(position).getSeconddose());



        holder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent press=new Intent(holder.userName.getContext(),Details.class);
                press.putExtra("uname",userArrayList.get(position).getName());
                press.putExtra("uemail",userArrayList.get(position).getEmail());
                press.putExtra("uage",userArrayList.get(position).getAge());
                press.putExtra("uaddress",userArrayList.get(position).getAddress());
                press.putExtra("uadharcard",userArrayList.get(position).getAadhar());
                press.putExtra("uadate",userArrayList.get(position).getAdate());
                press.putExtra("uddate",userArrayList.get(position).getDdate());
                press.putExtra("ucdate",userArrayList.get(position).getCdate());
                press.putExtra("umnumber",userArrayList.get(position).getmNumber());
                press.putExtra("ugender",userArrayList.get(position).getGender());
                press.putExtra("ufirstdose",userArrayList.get(position).getFirstdose());
                press.putExtra("useconddose",userArrayList.get(position).getSeconddose());
                press.putExtra("uvaccine",userArrayList.get(position).getVaccine());
                press.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.userName.getContext().startActivity(press);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}
