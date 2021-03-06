package com.example.devilshot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MovieData> sample;

    public MyAdapter(Context context, ArrayList<MovieData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public MovieData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        String content =sample.get(position).stars +" "+sample.get(position).category
                                                   +" "+sample.get(position).old
                                                   +" "+sample.get(position).showTimes ;
        View view = mLayoutInflater.inflate(R.layout.listview_custom, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.poster);
        TextView movieName = (TextView)view.findViewById(R.id.movieName);
        TextView grade = (TextView)view.findViewById(R.id.grade);

        GlideApp.with(mContext).load(sample.get(position).imgUrl).into(imageView);
//        imageView.setImageResource(sample.get(position).);
        movieName.setText(sample.get(position).getTittle());
        grade.setText(content);

        return view;
    }
}
