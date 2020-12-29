package com.example.expensetracker.TabFragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expensetracker.R;


public class SpinnerAdapter extends BaseAdapter {

    Context context;
    int images[];
    String[] fruit;
    LayoutInflater inflter;

    public SpinnerAdapter (Context applicationContext, int[] flags, String[] fruit) {

        this.context = applicationContext;
        this.images = flags;
        this.fruit = fruit;
        inflter = (LayoutInflater.from(applicationContext));
    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.simple_spinner_dropdown, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
       // TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(images[i]);
      //  names.setText(fruit[i]);
        return view;
    }
}