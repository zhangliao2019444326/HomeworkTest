package com.example.homeworktest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
import java.util.concurrent.Flow;

public class MainHeaderAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> images;

    public MainHeaderAdapter(Context context, List<ImageView> images) {
        this.context=context;
        this.images=images;
    }

    @Override
    public int getCount() {
        return images!=null?images.size():0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(images.get(position));
    }
}
