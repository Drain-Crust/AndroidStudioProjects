package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.tasksList;
import com.example.studentplanerguide.Data.DateTextUpdater;
import com.example.studentplanerguide.R;

import java.util.List;

public class RecyclerViewSubjectTopicDatesAdapter extends RecyclerView.Adapter<RecyclerViewSubjectTopicDatesAdapter.viewHolder> {
    private Context CONTEXT;
    private List<tasksList> tasksListList;

    public RecyclerViewSubjectTopicDatesAdapter(Context context, List<tasksList> tasksListList){
        this.CONTEXT = context;
        this.tasksListList = tasksListList;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public EditText editText;
        public CardView layout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.taskSkill);
            editText = itemView.findViewById(R.id.dateGiven);
            layout = itemView.findViewById(R.id.skillLayout);
        }
    }

    @NonNull
    @Override
    public RecyclerViewSubjectTopicDatesAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_date_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewSubjectTopicDatesAdapter.viewHolder holder, int position) {
        tasksList subjectCurrent = tasksListList.get(position);
        holder.textView.setText(subjectCurrent.getmName());
        holder.editText.addTextChangedListener(new DateTextUpdater());
    }

    @Override
    public int getItemCount() {
        return tasksListList.size();
    }
}
