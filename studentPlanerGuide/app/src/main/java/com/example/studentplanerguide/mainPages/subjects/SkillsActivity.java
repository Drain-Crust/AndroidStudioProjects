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

public class SkillsActivity extends AppCompatActivity {

    private Intent information;
    private TextView textView;
    String subjectname;
    String subjectid;
    String subjectlocation;
    BottomNavigationView bottomNavigationView;

    private List<skillsList> skillsLists;

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();

    private RecyclerView recyclerViewTasks;
    private RecyclerViewSkillsAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        textView = findViewById(R.id.skillsName);
        recyclerViewTasks = findViewById(R.id.tasksRecyclerView);

        information = getIntent();
        subjectname = information.getStringExtra(RecyclerViewTopicsAdapter.EXTRA_NAME);
        subjectid = information.getStringExtra(RecyclerViewTopicsAdapter.EXTRA_ID);
        subjectlocation = information.getStringExtra(RecyclerViewTopicsAdapter.EXTRA_LOCATION);
        textView.setText(subjectname);
        System.out.println(subjectlocation);
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
        taskAdapter = new RecyclerViewSkillsAdapter(this, skillsLists);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        skillsLists = new ArrayList<>();
        firebasefirestore.collection(subjectlocation + "/" + subjectname).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                    skillsLists.add(new skillsList((String) document.get("name"), subjectlocation +"/"+ subjectname + "/", document.getId()));
                }
                Log.d("testingings", skillsLists.toString());
                initRecyclerView();
            } else {
                Log.d("testings", "Error getting documents: ", task.getException());
            }
        });
    }
}