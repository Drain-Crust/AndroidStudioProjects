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
import com.example.studentplanerguide.adapters.RecyclerViewSubjectTopicDatesAdapter;
import com.example.studentplanerguide.adapters.RecyclerViewTopicsAdapter;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;
import com.example.studentplanerguide.mainPages.testDates.taskListerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubjectTopicDates extends AppCompatActivity {

    private RecyclerViewSubjectTopicDatesAdapter taskAdapter;
    private RecyclerView recyclerViewTasks;
    private List<tasksList> tasksListList;
    BottomNavigationView bottomNavigationView;

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();

    private Intent information;
    private TextView textView;
    String subjectname;
    String subjectid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_topic_dates);

        recyclerViewTasks = findViewById(R.id.calenderRecyclerView);
        textView = findViewById(R.id.skillsName);

        information = getIntent();
        subjectname = information.getStringExtra(RecyclerViewTopicsAdapter.EXTRA_NAME);
        subjectid = information.getStringExtra(RecyclerViewTopicsAdapter.EXTRA_ID);
        textView.setText(subjectname);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.taskListOption);
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
                case R.id.taskListOption:
                    startActivity(new Intent(this, taskListerActivity.class));
                    finish();
                    break;
            }
            return true;
        });

        initData();
    }

    private void initRecyclerView() {
        taskAdapter = new RecyclerViewSubjectTopicDatesAdapter(this, tasksListList);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        tasksListList = new ArrayList<>();
        firebasefirestore.collection("subjects/" + subjectid + "/" + subjectname).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                    tasksListList.add(new tasksList((String) document.get("name"), "", document.getId(), ""));
                }
                Log.d("testingings", tasksListList.toString());
                initRecyclerView();
            } else {
                Log.d("testings", "Error getting documents: ", task.getException());
            }
        });
    }
}