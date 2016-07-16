package com.nanddgroup.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimuch on 16.07.2016.
 */
public class MyAdapter extends ArrayAdapter<Friend> {

    Context ctx;
    ArrayList<Friend> alFriends;

    public MyAdapter(Context context, int resource, ArrayList<Friend> objects1) {
        super(context, resource, objects1);
        this.ctx = context;
        alFriends = objects1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
        View view = null;
        if (convertView == null) {
            LayoutInflater lInflater = (LayoutInflater) ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = lInflater.inflate(R.layout.custom_friend, parent, false);
        } else {
            view = convertView;
        }

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        tvName.setText(alFriends.get(position).getsName());
        ImageView ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
        ivIcon.setImageResource(alFriends.get(position).getImageID());

        return view;
    }
}
