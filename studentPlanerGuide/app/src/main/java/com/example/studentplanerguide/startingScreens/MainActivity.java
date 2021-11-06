package com.example.studentplanerguide.startingScreens;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
        videoView = findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://"+ getPackageName() +"/"+ R.raw.splashscreen);

        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(mp -> {
            if(isFinishing())
                return;

            startActivity(new Intent(MainActivity.this, HomescreenActivity.class));
            finish();
        });
        videoView.start();
    }
}