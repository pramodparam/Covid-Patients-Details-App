package com.example.covid_details;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecycleData extends AppCompatActivity {
    Button back;
    RecyclerView recyclerView;
    FirebaseFirestore db;
    ArrayList<User> userArrayList;

    MyRecyclerViewAdapter myRecyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_data);
       userArrayList=new ArrayList<>();
        setUpRecyclerView();
        setUpFirebase();
        loadDataFromFirebase();
    }

    /*private void loadDataFromFirebase2() {

        db.collection("Patients").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot query: Objects.requireNonNull(task.getResult())){

                   User user2=new User;
                   userArrayList.add(user2);
                }
                myRecyclerViewAdapter=new MyRecyclerViewAdapter(RecycleData.this,userArrayList);
                recyclerView.setAdapter(myRecyclerViewAdapter);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(RecycleData.this,"problem....",Toast.LENGTH_SHORT).show();

            }
        });
    }*/


    private void loadDataFromFirebase() {
        if(userArrayList.size()>0)
        userArrayList.clear();
        db.collection("Patients").orderBy("name", Query.Direction.DESCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot query: Objects.requireNonNull(task.getResult())){
                    User user=new User(query.getString("name"),query.getString("email"),query.getString("Age"),query.getString("mNumber"),query.getString("Gender"),query.getString("Address"),
                            query.getString("Confirm Date"),query.getString("Admission Date"),query.getString("Dishcharge Date"),query.getString("Vaccine Name"),
                            query.getString("Dose1 Date"),query.getString("Dose2 Date"),query.getString("AadharCard Number"));
                  userArrayList.add(user);
                }
                myRecyclerViewAdapter=new MyRecyclerViewAdapter(RecycleData.this,userArrayList);
                recyclerView.setAdapter(myRecyclerViewAdapter);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(RecycleData.this,"problem....",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpFirebase() {

        db=FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView() {
        recyclerView= findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchbar,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s)
    {
        FirebaseRecyclerOptions<User> options=new FirebaseRecyclerOptions.Builder<User>().
                setQuery(FirebaseDatabase.getInstance().getReference().child("Patients").orderByChild("name"),User.class).build();

        myRecyclerViewAdapter=new MyRecyclerViewAdapter(options);
        recyclerView.setAdapter(myRecyclerViewAdapter);

    }*/

}