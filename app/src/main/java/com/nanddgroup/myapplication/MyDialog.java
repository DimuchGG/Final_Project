package com.nanddgroup.myapplication;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nanddgroup.myapplication.socket.Client;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dimuch on 27.07.2016.
 */
public class MyDialog extends DialogFragment {
    @BindView(R.id.etPort) EditText etPort;
    @BindView(R.id.etIP) EditText etIP;
    @BindView(R.id.bConnect) Button bConnect;
    @BindView(R.id.bBack) Button bBack;

    public static MyFragment myFragment;
    MyDialog myDialog;

    public MyDialog() {
        myDialog = this;
        myFragment = new MyFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Connect to server!");
        View view = inflater.inflate(R.layout.dialog, null);
        ButterKnife.bind(this, view);

        bConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPort.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Enter Port",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if (etIP.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Enter IP address",
                            Toast.LENGTH_LONG).show();
                    return;
                }

//                msgLog = "";
//                chatMsg.setText(msgLog);
//                loginPanel.setVisibility(View.GONE);
//                chatPanel.setVisibility(View.VISIBLE);

//                Log.wtf("my", "test");

                getFragmentManager().beginTransaction()
                        .replace(R.id.contentMain, myFragment)
                        .commit();

                MainActivity.client = new Client(getActivity(),
                        MainActivity.myProfile,
                        etIP.getText().toString(),
                        Integer.valueOf(etPort.getText().toString()));
                MainActivity.client.start();

                myDialog.dismiss();
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        return view;
    }

}
