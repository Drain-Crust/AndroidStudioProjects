package com.example.studentplanerguide.mainPages.stats;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;
import com.example.studentplanerguide.mainPages.testDates.taskListerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class statsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView imageView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        imageView = findViewById(R.id.settings);
        imageView.setOnClickListener(v -> {
            startActivity(new Intent(statsActivity.this, LoginActivity.class));
            finish();
        });

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.statsOption);
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