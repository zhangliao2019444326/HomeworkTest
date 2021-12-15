package com.example.homeworktest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homeworktest.R;
import com.example.homeworktest.entity.Me;

import java.util.List;

public class MeAdapter extends ArrayAdapter<Me> {
    private int resourseId;
    private  static final String TAG="MeAdapter";
    private List<Me> list;
    //初始化
    public MeAdapter(@NonNull Context context, int resource,List<Me> objiects) {
        super(context, resource,objiects);
        resourseId=resource;
    }
    //设置数据

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Me me =getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        ImageView fruitImage=view.findViewById(R.id.me_conten_img);
        TextView fruitName=view.findViewById(R.id.me_conten_txt);
        fruitImage.setImageResource(me.getImageId());
        fruitName.setText(me.getName());
        return  view;
    }
}
