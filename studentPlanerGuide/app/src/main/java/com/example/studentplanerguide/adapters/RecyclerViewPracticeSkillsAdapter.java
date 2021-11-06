package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.skillsList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.subjects.PracticeSkillsActivity;

import java.util.List;

public class RecyclerViewPracticeSkillsAdapter extends RecyclerView.Adapter<RecyclerViewPracticeSkillsAdapter.viewHolder> {

    private List<skillsList> skillsListList;
    private final Context CONTEXT;
    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_LOCATION = "location";

    public RecyclerViewPracticeSkillsAdapter(Context context, List<skillsList> skillsListList) {
        this.CONTEXT = context;
        this.skillsListList = skillsListList;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView skillLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.taskSkill);
            skillLayout = itemView.findViewById(R.id.skillLayout);
        }
    }

    @NonNull
    @Override
    public RecyclerViewPracticeSkillsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPracticeSkillsAdapter.viewHolder holder, int position) {
        skillsList skillCurrent = skillsListList.get(position);
        holder.textView.setText(skillCurrent.getmName());
        holder.skillLayout.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return skillsListList.size();
    }
}
