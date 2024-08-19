package com.example.a1.Expense;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a1.Models.Category;
import com.example.a1.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private String[] mdata;
    private int[] image;

    public GridAdapter(Context context, String[] mdata, int[] image) {
        this.context = context;
        this.mdata = mdata;
        this.image = image;
    }


    @Override
    public int getCount() {
        return mdata.length;
    }

    @Override
    public Object getItem(int position) {
        return mdata[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView;
        ImageButton button;
        if(convertView == null) {
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(inflater != null) {
                convertView = inflater.inflate(R.layout.grid_item,null);
                textView = convertView.findViewById(R.id.tv_option);
                button = convertView.findViewById(R.id.ib_option);
            } else {
                return null;
            }
        } else {
            textView = convertView.findViewById(R.id.tv_option);
            button = convertView.findViewById(R.id.ib_option);
        }
        textView.setText(mdata[position]);
        button.setImageResource(image[position]);
        return convertView;
    }
}
