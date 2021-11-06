package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;
import com.example.studentplanerguide.mainPages.HomescreenActivity;
import com.example.studentplanerguide.mainPages.MainActivity;
import com.example.studentplanerguide.mainPages.SubjectTopicsActivity;

import java.util.List;

public class RecyclerViewSubjectsAdapter extends RecyclerView.Adapter<RecyclerViewSubjectsAdapter.viewHolder> {

    private final List<subjectList> SUBJECTLISTLIST;
    private final Context CONTEXT;

    public RecyclerViewSubjectsAdapter(Context context, List<subjectList> subjectListList) {
        this.CONTEXT = context;
        this.SUBJECTLISTLIST = subjectListList;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }

    @NonNull
    @Override
    public RecyclerViewSubjectsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewSubjectsAdapter.viewHolder holder, int position) {
        subjectList subjectCurrent = SUBJECTLISTLIST.get(position);
        holder.textView.setText(subjectCurrent.getName());
        Glide.with(CONTEXT)
                .load(subjectCurrent.getImageUrl())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(v -> CONTEXT.startActivity(new Intent(CONTEXT, SubjectTopicsActivity.class)));
    }

    @Override
    public int getItemCount() {
        return SUBJECTLISTLIST.size();
    }
}
