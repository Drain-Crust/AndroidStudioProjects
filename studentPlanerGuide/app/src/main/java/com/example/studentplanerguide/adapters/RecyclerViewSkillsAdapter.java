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
import com.example.studentplanerguide.mainPages.subjects.PracticeSkillsActivity;
import com.example.studentplanerguide.R;

import java.util.List;

public class RecyclerViewSkillsAdapter extends RecyclerView.Adapter<RecyclerViewSkillsAdapter.viewHolder> {

    private List<skillsList> skillsListList;
    private final Context CONTEXT;
    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_LOCATION = "location";

    public RecyclerViewSkillsAdapter(Context context, List<skillsList> skillsListList) {
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
    public RecyclerViewSkillsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewSkillsAdapter.viewHolder holder, int position) {
        skillsList skillCurrent = skillsListList.get(position);
        holder.textView.setText(skillCurrent.getmName());
        holder.skillLayout.setOnClickListener(v -> {
            Intent toPracticeSkill = new Intent(CONTEXT, PracticeSkillsActivity.class);
            toPracticeSkill.putExtra(EXTRA_ID, skillCurrent.getmIds());
            toPracticeSkill.putExtra(EXTRA_NAME, skillCurrent.getmName());
            toPracticeSkill.putExtra(EXTRA_LOCATION, skillCurrent.getmLocation()+skillCurrent.getmIds());
            CONTEXT.startActivity(toPracticeSkill);
        });
    }

    @Override
    public int getItemCount() {
        return skillsListList.size();
    }
}
