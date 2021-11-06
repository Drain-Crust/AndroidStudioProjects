package com.example.studentplanerguide.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.studentplanerguide.Data.subjectList;
import com.example.studentplanerguide.R;

import com.example.studentplanerguide.mainPages.SubjectTopicsActivity;

import java.util.List;

public class RecyclerViewSubjectsAdapter extends RecyclerView.Adapter<RecyclerViewSubjectsAdapter.viewHolder> {

    public static final String EXTRA_NAME = "name";

    private final List<subjectList> SUBJECTLISTLIST;
    private final Context CONTEXT;

    public RecyclerViewSubjectsAdapter(Context context, List<subjectList> subjectListList) {
        this.CONTEXT = context;
        this.SUBJECTLISTLIST = subjectListList;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
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

        holder.imageView.setOnClickListener(v -> {
            Intent toTopicsScreen = new Intent(CONTEXT, SubjectTopicsActivity.class);
            toTopicsScreen.putExtra(EXTRA_NAME, subjectCurrent.getName());

            Pair layout = Pair.create(holder.layout,"shared_layout");
            Pair name = Pair.create(holder.textView,"shared_name");

            ActivityOptionsCompat transitionToNextScreen = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) CONTEXT, layout, name);
            CONTEXT.startActivity(toTopicsScreen, transitionToNextScreen.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return SUBJECTLISTLIST.size();
    }
}
