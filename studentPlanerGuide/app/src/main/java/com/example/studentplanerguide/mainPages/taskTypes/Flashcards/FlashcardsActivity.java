package com.example.studentplanerguide.mainPages.taskTypes.Flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.stats.statsActivity;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;
import com.example.studentplanerguide.mainPages.taskListing.taskListerActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FlashcardsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
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
