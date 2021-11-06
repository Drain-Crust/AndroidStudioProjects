package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.tasksList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.subjects.SkillsActivity;

import java.util.List;

public class RecyclerViewTopicsAdapter extends RecyclerView.Adapter<RecyclerViewTopicsAdapter.viewHolder> {

    private List<tasksList> tasksListList;
    private final Context CONTEXT;
    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_LOCATION = "location";

    public RecyclerViewTopicsAdapter(Context context, List<tasksList> tasksListList){
        this.CONTEXT = context;
        this.tasksListList = tasksListList;
    }

    @Override
    public int getItemCount() {
        return tasksListList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public CardView layout;
        public viewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.topicCardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.subjectTopicName);

        }
    }


    @NonNull
    @Override
    public RecyclerViewTopicsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTopicsAdapter.viewHolder holder, int position) {
        tasksList tasksCurrent = tasksListList.get(position);
        holder.textView.setText(tasksCurrent.getmName());
        holder.layout.setOnClickListener(v -> {
            Intent toSkills = new Intent(CONTEXT, SkillsActivity.class);
            toSkills.putExtra(EXTRA_ID, tasksCurrent.getmIds());
            toSkills.putExtra(EXTRA_NAME, tasksCurrent.getmName());
            toSkills.putExtra(EXTRA_LOCATION, tasksCurrent.getmLocation()+tasksCurrent.getmIds());
            CONTEXT.startActivity(toSkills);
        });
    }
}
