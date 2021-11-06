package com.example.studentplanerguide.mainPages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.example.studentplanerguide.adapters.RecyclerViewTopicsAdapter;

import java.util.ArrayList;
import java.util.List;

public class SubjectTopicsActivity extends AppCompatActivity {

    private Intent information;
    private TextView textView;

    private List<subjectList> subjectListList;

    private RecyclerView recyclerViewTasks;
    private RecyclerViewTopicsAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_topics);

        textView = findViewById(R.id.subjectName);

        information = getIntent();
        String subjectname = information.getStringExtra(RecyclerViewSubjectsAdapter.EXTRA_NAME);

        textView.setText(subjectname);

        initRecyclerView();
        initData();

    }

    private void initRecyclerView() {
        taskAdapter = new RecyclerViewTopicsAdapter(this, subjectListList);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void initData() {
        subjectListList = new ArrayList<>();

        // adds the tasks into an array
        for (int i = 1; i < fileDataArray.length; i++){

        }
    }
}