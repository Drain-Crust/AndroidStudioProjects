package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "package com.example.study_application";
    private static final String EXTRA_PASSWORD = "pass";
    private static final String EXTRA_USERNAME = "user";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText Password;
    EditText Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);


        Button SignIn = findViewById(R.id.SignIn);
        SignIn.setOnClickListener(v -> signIn());
    }

    private void signIn(){
        System.out.println(Password.toString());
        Intent toHomeScreen = new Intent(this, HomeScreen.class);
        toHomeScreen.putExtra(EXTRA_PASSWORD,Password.getText().toString());
        toHomeScreen.putExtra(EXTRA_USERNAME,Username.getText().toString());
        startActivity(toHomeScreen);
    }
}