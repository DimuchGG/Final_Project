package com.nanddgroup.myapplication;

import android.app.Instrumentation;
import android.app.ListFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.nanddgroup.myapplication.adapters.MessageAdapter;
import com.nanddgroup.myapplication.item_list.Message;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dimuch on 17.07.2016.
 */
public class MyFragment extends ListFragment {
    @BindView(R.id.etMessage) EditText etMessage;
    @BindView(R.id.bSendFriend) Button bSendFriend;
    @BindView(R.id.ivSend) ImageView ivSend;

    MessageAdapter messageAdapter;
    ArrayList<Message> alMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        ButterKnife.bind(this, view);


        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etMessage.getText().toString().equals("")) {
                    updateList(new Message(R.drawable.my_logo,
                            etMessage.getText().toString(), true));
                    etMessage.setText(null);

                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        bSendFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateList(new Message(R.drawable.logo_0,
                        "Friend message", false));
            }
        });

        Log.wtf("my", "test");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        alMessage = new ArrayList<>();
        fillData();
        messageAdapter = new MessageAdapter(getActivity(),
                R.layout.activity_main, alMessage);
        setListAdapter(messageAdapter);
    }

    public void updateList(Message message) {

        alMessage.add(message);
        messageAdapter = new MessageAdapter(getActivity(),
                R.layout.activity_main, alMessage);
        setListAdapter(messageAdapter);
    }

    private void fillData() {
        for (int i = 0; i < 2; i++) {
//            alMessage.add(new Message("Vasya_ ", "Hello!"));
        }
    }
}