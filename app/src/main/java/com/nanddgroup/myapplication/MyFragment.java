package com.nanddgroup.myapplication;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dimuch on 17.07.2016.
 */
public class MyFragment extends ListFragment {

    MessageAdapter messageAdapter;
    ArrayList<Message> alMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, null);
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