package com.example.studentplanerguide;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.studentplanerguide.Data.subjectList;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Constants extends Application {

    private List<subjectList> subjectList;
    Map<Boolean, List<subjectList>> values = null;

    private static final String KEY_TITLE = "name";
    private static final String KEY_IMAGE = "image";
    private final FirebaseFirestore firebasefirestore = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReference();
    private static final String TAG = "testing";

    int z = 0;
    Context CONTEXT;
    public int size;

    CollectionReference collectionReference = firebasefirestore.collection("subjects");
    private Object Map;

    public Constants(Context context) {
        this.CONTEXT = context;
    }



    public void numberOfDocuments(){
        firebasefirestore.collection("subjects").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d("TAG", Objects.requireNonNull(task.getResult()).size() + "");
                numberofdocuments(task.getResult().size());
                if (values == null){
                    initData();
                }else{
                    return Values();
                }

            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
    }

    public Map<Boolean, List<subjectList>> Values(){
        return values;
    }

    public void numberofdocuments(int number){
        size = number;
    }

    private void initData() {
        subjectList = new ArrayList<>();
        for (int i = 0 ; i< size;i++){
            z = i;
            collectionReference.document("subject_0"+ (i+1)).get()
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
                                    values = new HashMap<>();
                                    values.put(true, subjectList);
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
