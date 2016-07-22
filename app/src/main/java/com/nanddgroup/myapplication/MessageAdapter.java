package com.nanddgroup.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<Message> {
  Context ctx;
  LayoutInflater lInflater;
  ArrayList<Message> alMessage;


  public MessageAdapter(Context context, int resource, ArrayList<Message> objects) {
    super(context, resource, objects);
    this.ctx = context;
    alMessage = objects;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    View view = null;
    if (convertView == null) {
      LayoutInflater lInflater = (LayoutInflater) ctx
              .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      if (alMessage.get(position).isItIsMe()) {
        view = lInflater.inflate(R.layout.my_custom_message, parent, false);
      } else {
        view = lInflater.inflate(R.layout.custom_message, parent, false);
      }
    } else {
      view = convertView;
    }

//    TextView tvName = (TextView) view.findViewById(R.id.tvName);
//    tvName.setText(alMessage.get(position).getName());

    ImageView ivFriendMessage = (ImageView) view.findViewById(R.id.ivFriendMessage);
    ivFriendMessage.setImageResource(alMessage.get(position).getImageID());

    TextView tvMessage = (TextView) view.findViewById(R.id.tvMessage);
    tvMessage.setText(alMessage.get(position).getMessage());

    TextView tvTime = (TextView) view.findViewById(R.id.tvTime);
    tvTime.setText(alMessage.get(position).getTime());
    return view;
  }
}