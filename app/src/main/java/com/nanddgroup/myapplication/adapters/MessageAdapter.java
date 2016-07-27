package com.nanddgroup.myapplication.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanddgroup.myapplication.MainActivity;
import com.nanddgroup.myapplication.R;
import com.nanddgroup.myapplication.item_list.Message;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageAdapter extends ArrayAdapter<Message> {
  @BindView(R.id.customLayout)  RelativeLayout customLayout;
  @BindView(R.id.myLayout) RelativeLayout myLayout;
  @BindView(R.id.ivMe) ImageView ivMe;
  @BindView(R.id.ivFriend) ImageView ivFriend;
  @BindView(R.id.tvMessageMe) TextView tvMessageMe;
  @BindView(R.id.tvMessageFriend) TextView tvMessageFriend;
  @BindView(R.id.tvTimeMe) TextView tvTimeMe;
  @BindView(R.id.tvTimeFriend) TextView tvTimeFriend;

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

      view = lInflater.inflate(R.layout.custom_message, parent, false);

    } else {
      view = convertView;
    }
    ButterKnife.bind(this, view);

    if (alMessage.get(position).isItIsMe()) {
      customLayout.setVisibility(View.GONE);
      myLayout.setVisibility(View.VISIBLE);

      ivMe.setImageResource(alMessage.get(position).getImageID());
      tvMessageMe.setText(alMessage.get(position).getMessage());
      tvTimeMe.setText(alMessage.get(position).getTime());
    } else {
      customLayout.setVisibility(View.VISIBLE);
      myLayout.setVisibility(View.GONE);

      ivFriend.setImageResource(alMessage.get(position).getImageID());
      tvMessageFriend.setText(alMessage.get(position).getMessage());
      tvTimeFriend.setText(alMessage.get(position).getTime());
    }

    return view;
  }
}