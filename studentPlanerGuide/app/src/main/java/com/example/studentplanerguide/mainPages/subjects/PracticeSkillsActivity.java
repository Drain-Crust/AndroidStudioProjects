package com.example.studentplanerguide.mainPages.subjects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.studentplanerguide.Data.practiceSkillsList;
import com.example.studentplanerguide.Data.skillsList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewPracticeSkillsAdapter;
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

public class PracticeSkillsActivity extends AppCompatActivity {

    private Intent information;
    private TextView textView;
    String subjectname;
    String subjectid;
    String subjectlocation;
    BottomNavigationView bottomNavigationView;

    private List<practiceSkillsList> practiceSkillsListList;

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();

    private RecyclerView recyclerViewTasks;
    private RecyclerViewPracticeSkillsAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_skills);

        textView = findViewById(R.id.skillsPracticeName);
        recyclerViewTasks = findViewById(R.id.practiceTasksRecyclerView);

        information = getIntent();
        subjectname = information.getStringExtra(RecyclerViewSkillsAdapter.EXTRA_NAME);
        subjectid = information.getStringExtra(RecyclerViewSkillsAdapter.EXTRA_ID);
        subjectlocation = information.getStringExtra(RecyclerViewSkillsAdapter.EXTRA_LOCATION);
        textView.setText(subjectname);
        System.out.println(subjectlocation + "/" + subjectname);
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
        taskAdapter = new RecyclerViewPracticeSkillsAdapter(this, practiceSkillsListList);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        practiceSkillsListList = new ArrayList<>();
        firebasefirestore.collection(subjectlocation + "/" + subjectname).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                    practiceSkillsListList.add(new practiceSkillsList((String) document.get("name"), document.getId(), subjectlocation +"/"+ subjectname + "/", (String) document.get("url")));
                }
                Log.d("testingingings", practiceSkillsListList.toString());
                initRecyclerView();
            } else {
                Log.d("testings", "Error getting documents: ", task.getException());
            }
        });
    }
}