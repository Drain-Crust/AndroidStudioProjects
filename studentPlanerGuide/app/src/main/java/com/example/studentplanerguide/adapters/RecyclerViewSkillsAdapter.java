package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.skillsList;
import com.example.studentplanerguide.Data.tasksList;
import com.example.studentplanerguide.R;

import java.util.List;

public class RecyclerViewSkillsAdapter extends RecyclerView.Adapter<RecyclerViewSkillsAdapter.viewHolder> {

    private List<skillsList> skillsListList;
    private final Context CONTEXT;
    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_NAME = "name";

    public RecyclerViewSkillsAdapter(Context context, List<skillsList> skillsListList){
        this.CONTEXT = context;
        this.skillsListList = skillsListList;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    @NonNull
    @Override
    public RecyclerViewSkillsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewSkillsAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return skillsListList.size();
    }
}
