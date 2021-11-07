package com.example.studentplanerguide.mainPages.taskTypes.Questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.stats.statsActivity;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;
import com.example.studentplanerguide.mainPages.testDates.taskListerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class QuestionsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

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
}