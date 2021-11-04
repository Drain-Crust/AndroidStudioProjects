package com.example.studyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference tasks = db.collection("subjects").document("subject_01").collection("skills");

    private static final String KEY_NAME = "name";

    private static final int DATA_REQUEST = 1;
    private ListView listView;
    private List<String> mData;
    TextView usern;
    TextView passw;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        listView = findViewById(R.id.listView);
        usern = findViewById(R.id.usern);
        passw = findViewById(R.id.passw);

        Intent information = getIntent();

        ArrayList<String> arrayList = new ArrayList<>();

        String Username = information.getStringExtra("user");
        String Password = information.getStringExtra("pass");

        usern.setText(Username);
        passw.setText(Password);


    }

    public void loadData(){
        for(int i =0;i<2;i++){
            tasks.document("task_"+i+1).get().addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists()){
                    String name = documentSnapshot.getString(KEY_NAME);
                    System.out.print("heloooooooooooooooooooooooooo");
                    mData.add(name);
                } else {
                    Toast.makeText(HomeScreen.this,"document does not exist",Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(e -> {

            });
        }

    }
}
