package com.example.studentplanerguide.mainPages.subjects;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.skillsList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSkillsAdapter;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SkillsActivity extends AppCompatActivity {

    private Intent information;
    private TextView textView;
    String subjectname;
    String subjectid;

    private List<skillsList> skillsLists;

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();
    CollectionReference collectionReference = firebasefirestore.collection("subjects");

    private RecyclerView recyclerViewTasks;
    private RecyclerViewSkillsAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        textView = findViewById(R.id.skillsName);
        recyclerViewTasks = findViewById(R.id.tasksRecyclerView);

        information = getIntent();
        subjectname = information.getStringExtra(RecyclerViewSubjectsAdapter.EXTRA_NAME);
        subjectid = information.getStringExtra(RecyclerViewSubjectsAdapter.EXTRA_ID);
        textView.setText(subjectname);
        initData();
    }

    private void initRecyclerView() {
        taskAdapter = new RecyclerViewSkillsAdapter(this, skillsLists);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        skillsLists = new ArrayList<>();
        collectionReference.document(subjectid).collection(subjectname).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                    skillsLists.add(new skillsList((String) document.get("name"), document.getId()));
                }
                Log.d("testingings", skillsLists.toString());
                initRecyclerView();
            } else {
                Log.d("testings", "Error getting documents: ", task.getException());
            }
        });
    }
}