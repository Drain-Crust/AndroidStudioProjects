package com.example.studentplanerguide.adapters;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageChangeAdapter extends PagerAdapter {

    Context context;
    int[] images = {

    };
    int[] titles = {

    };
    int[] descriptions = {

    };

    public ImageChangeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
