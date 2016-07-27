package com.nanddgroup.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanddgroup.myapplication.R;
import com.nanddgroup.myapplication.item_list.Friend;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dimuch on 16.07.2016.
 */
public class FriendAdapter extends ArrayAdapter<Friend> {
    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.ivIcon) ImageView ivIcon;

    Context ctx;
    ArrayList<Friend> alFriends;

    public FriendAdapter(Context context, int resource, ArrayList<Friend> objects1) {
        super(context, resource, objects1);
        this.ctx = context;
        alFriends = objects1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        if (convertView == null) {
            LayoutInflater lInflater = (LayoutInflater) ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = lInflater.inflate(R.layout.custom_friend, parent, false);
        } else {
            view = convertView;
        }
        ButterKnife.bind(this, view);

        tvName.setText(alFriends.get(position).getsName());
        ivIcon.setImageResource(alFriends.get(position).getImageID());

        return view;
    }
}
