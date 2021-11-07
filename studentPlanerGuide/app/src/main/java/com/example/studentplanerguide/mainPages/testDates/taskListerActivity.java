package com.example.studentplanerguide.mainPages.testDates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.example.studentplanerguide.mainPages.quizer.reminderActivity;
import com.example.studentplanerguide.mainPages.stats.statsActivity;
import com.example.studentplanerguide.mainPages.subjects.HomescreenActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class taskListerActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private List<subjectList> subjectListLists;


    RecyclerView recyclerSubjectView;
    RecyclerViewSubjectsAdapter subjectAdapter;
    EditText searchBars;

    public int size;
    int z = 0;
    private static final String KEY_TITLE = "name";
    private static final String KEY_IMAGE = "image";
    private static final String TAG = "testing";

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();
    CollectionReference collectionReference = firebasefirestore.collection("subjects");

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReference();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_lister);

        recyclerSubjectView = findViewById(R.id.diffSubjects);
        searchBars = findViewById(R.id.searchBars);

        numberOfDocuments();

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.taskListOption);
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
        subjectAdapter = new RecyclerViewSubjectsAdapter(this, subjectListLists);
        recyclerSubjectView.setHasFixedSize(true);
        recyclerSubjectView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerSubjectView.setAdapter(subjectAdapter);
    }

    public void numberOfDocuments(){
        firebasefirestore.collection("subjects").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d("TAG", Objects.requireNonNull(task.getResult()).size() + "");
                numberofdocuments(task.getResult().size());
                initData();
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });

    }

    public void numberofdocuments(int number){
        size = number;
    }

    private void initData() {
        subjectListLists = new ArrayList<>();
        for (int i = 0 ; i< size;i++){
            z = i;
            collectionReference.document("subject_0"+ (i+1)).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            String name = documentSnapshot.getString(KEY_TITLE);
                            String image = documentSnapshot.getString(KEY_IMAGE);
                            String ids = documentSnapshot.getId();

                            assert image != null;
                            storageReference.child(image).getDownloadUrl().addOnSuccessListener(uri -> {
                                String url = uri.toString();
                                subjectListLists.add(new subjectList(ids, name, url));
                                Log.d("TAG", z +" "+size + "");
                                if(z == size-1){
                                    initRecyclerView();
                                }
                            }).addOnFailureListener(exception -> Toast.makeText(this, "Image Error!", Toast.LENGTH_SHORT).show());
                        } else {
                            Toast.makeText(this, "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(e -> Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show());
        }
    }
}