package com.example.studentplanerguide.mainPages.subjects;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.tasksList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.example.studentplanerguide.adapters.RecyclerViewTopicsAdapter;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.stats.statsActivity;
import com.example.studentplanerguide.mainPages.taskListing.taskListerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubjectTopicsActivity extends AppCompatActivity {

    private Intent information;
    private TextView textView;
    String subjectname;
    String subjectid;

    private List<tasksList> tasksListList;
    BottomNavigationView bottomNavigationView;

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();
    CollectionReference collectionReference = firebasefirestore.collection("subjects");

    private RecyclerView recyclerViewTasks;
    private RecyclerViewTopicsAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_topics);

        textView = findViewById(R.id.subjectName);
        recyclerViewTasks = findViewById(R.id.tasksRecyclerView);

        information = getIntent();
        subjectname = information.getStringExtra(RecyclerViewSubjectsAdapter.EXTRA_NAME);
        subjectid = information.getStringExtra(RecyclerViewSubjectsAdapter.EXTRA_ID);
        textView.setText(subjectname);
        initData();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.subjectsOption);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.subjectsOption:
                    startActivity(new Intent(this, HomescreenActivity.class));
                    finish();
                    break;
                case R.id.rememberingOption:
                    startActivity(new Intent(this, reminderActivity.class));
                    finish();
                    break;
                case R.id.statsOption:
                    startActivity(new Intent(this, statsActivity.class));
                    finish();
                    break;
                case R.id.taskListOption:
                    startActivity(new Intent(this, taskListerActivity.class));
                    finish();
                    break;
            }
            return true;
        });
    }

    private void initRecyclerView() {
        taskAdapter = new RecyclerViewTopicsAdapter(this, tasksListList);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        tasksListList = new ArrayList<>();
        collectionReference.document(subjectid).collection(subjectname).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                    String color = "#efefef";
                    tasksListList.add(new tasksList((String) document.get("name"), color, document.getId(),"subjects/"+subjectid+"/"+subjectname+"/"));
                }
                Log.d("testings", tasksListList.toString());
                initRecyclerView();
            } else {
                Log.d("testings", "Error getting documents: ", task.getException());
            }
        });
    }
}