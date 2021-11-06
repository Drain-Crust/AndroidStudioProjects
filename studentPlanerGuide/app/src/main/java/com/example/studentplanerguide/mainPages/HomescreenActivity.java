package com.example.studentplanerguide.mainPages;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.adapters.RecyclerViewSubjectsAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomescreenActivity extends AppCompatActivity {

    private static final String TAG = "testing";

    private static final String KEY_TITLE = "name";
    private static final String KEY_IMAGE = "image";

    private List<subjectList> subjectList;
    public int size;
    int z = 0;

    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerSubjectView;
    RecyclerViewSubjectsAdapter subjectAdapter;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReference();

    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        recyclerSubjectView = findViewById(R.id.diffSubjects);

        numberOfDocuments();


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.subjectsOption:
                    System.out.println("hello");
                    break;
                case R.id.rememberingOption:
                    System.out.println("hellos");
                    break;
                case R.id.statsOption:
                    System.out.println("helloss");
                    break;
                case R.id.taskListOption:
                    System.out.println("hellosss");
                    break;
            }
            return true;
        });
    }

    private void initRecyclerView() {
        subjectAdapter = new RecyclerViewSubjectsAdapter(this, subjectList);
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
        subjectList = new ArrayList<>();
        for (int i = 0 ; i< size;i++){
            z = i;
            firebasefirestore.collection("subjects").document("subject_0"+ (i+1)).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            String name = documentSnapshot.getString(KEY_TITLE);
                            String image = documentSnapshot.getString(KEY_IMAGE);

                            assert image != null;
                            storageReference.child(image).getDownloadUrl().addOnSuccessListener(uri -> {
                                String url = uri.toString();
                                subjectList.add(new subjectList(name,url));

                                Log.d("TAG", z +" "+size + "");
                                if(z == size-1){
                                    initRecyclerView();
                                }
                            }).addOnFailureListener(exception -> {
                                Toast.makeText(this, "Image Error!", Toast.LENGTH_SHORT).show();
                            });

                        } else {
                            Toast.makeText(this, "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(e -> {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            });
        }
    }
}