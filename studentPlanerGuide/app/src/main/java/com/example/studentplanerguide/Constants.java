package com.example.studentplanerguide;

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


    Map<Boolean, List<subjectList>> values = null;




    int y = 0;
    boolean x = true;
    Context CONTEXT;



    private Object Map;

    public Constants(Context context) {
        this.CONTEXT = context;
    }





    public void doRequiredOperation(String msg){
        if(msg.equals("Success")){
            y++;
        }

    }




}
