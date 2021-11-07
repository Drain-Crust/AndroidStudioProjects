package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;

import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.viewHolder>{

    private Context CONTEXT;
    private List<subjectList> subjectListList;


    public CalenderAdapter(Context context, List<subjectList> subjectListList) {
        this.CONTEXT = context;
        this.subjectListList = subjectListList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return subjectListList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ConstraintLayout layout;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            layout = itemView.findViewById(R.id.layouts);
        }
    }
}
