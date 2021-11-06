package com.example.studentplanerguide.mainPages;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Constants;
import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomescreenActivity extends AppCompatActivity {

    private List<subjectList> subjectList;

    BottomNavigationView bottomNavigationView;

    Constants constants;

    RecyclerView recyclerSubjectView;
    RecyclerViewSubjectsAdapter subjectAdapter;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        constants = new Constants(HomescreenActivity.this);

        recyclerSubjectView = findViewById(R.id.diffSubjects);

        Map<Boolean, List<subjectList>> values = constants.numberofdocuments();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.subjectsOption:
                    System.out.println("hello");
                    break;
                case R.id.rememberingOption:
                    System.out.println("hellos");
                    break;
                case R.id.statsOption:
                    System.out.println("helloss");
                    break;
                case R.id.taskListOption:
                    System.out.println("hellosss");
                    break;
            }
            return true;
        });
    }

    private void initRecyclerView() {
        subjectAdapter = new RecyclerViewSubjectsAdapter(this, subjectList);
        recyclerSubjectView.setHasFixedSize(true);
        recyclerSubjectView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerSubjectView.setAdapter(subjectAdapter);
    }





}